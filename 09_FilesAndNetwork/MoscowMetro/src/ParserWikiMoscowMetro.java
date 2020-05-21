import core.Line;
import core.Station;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

public class ParserWikiMoscowMetro {
    private List<Station> stationList = new ArrayList<>();

    private TreeMap<String,List<String>> stations = new TreeMap<>();
    private List<List<Station>> connections = new ArrayList<>();
    private TreeSet<Line> lines = new TreeSet<>();

    private Elements infoListElement = new Elements();
    private Document html;

    public ParserWikiMoscowMetro(Document html) {
        this.html = html;

    }
    public void startProcessParsing() {
        parseListDataInfo();
        parseNumberLineAndLine();
        parseStation();
        addStationList();
        addStationConnection();
    }

    public TreeMap<String, List<String>> getStations() {
        return stations;
    }

    public List<List<Station>> getConnections() {
        return connections;
    }

    public TreeSet<Line> getLines() {
        return lines;
    }

    private void parseListDataInfo() {
        Elements listInfo = html.select("table.standard > tbody > tr ");

        for (int i = 0; i < listInfo.size(); i++) {
            String infoString = listInfo.get(i).text();
            if (Character.isDigit(infoString.toCharArray()[0]) && !infoString.contains("14 Московское центральное кольцо")) {
                infoListElement.add(listInfo.get(i));
            } else {

            }
        }
    }

    private void parseNumberLineAndLine() {
        for (Element e : infoListElement) {
            String numberLine = parseNumberLine(e.select("td").get(0).firstElementSibling().text());
            String nameLine = e.select("td > span").attr("title");
            Line line = new Line(numberLine, nameLine);
            if (nameLine.equals("Солнцевская линия")) {
                numberLine = numberLine.split(" ")[0];
                line = new Line(numberLine.split(" ")[0],nameLine);
            }
            lines.add(line);
        }

    }

    private static String parseNumberLine(String numberLine) {
        if (numberLine.length() == 4) {
            return numberLine.substring(0,2);
        } else if (numberLine.length() == 6) {
            return numberLine.substring(1,4);
        } else if (numberLine.length() == 7) {
            return numberLine.substring(0,5);
        } else {
            System.out.println("Invalid number line.\n The information received may be incorrect");
            return null;

        }
    }

    private void parseStation() {
        for (Element element: infoListElement) {
            Station station = createStation(element);
            if(station != null) {
                stationList.add(station);
            }

        }
    }


    private void addStationList() {
        List<String> stationName = new ArrayList<>();
        for (Line line: lines) {
            for (Station station: stationList) {
                if (line.getName().equals(station.getLine().getName())) {
                    stationName.add(station.getName());
                }
            }
            stations.put(line.getNumber(),stationName);
            stationName = new ArrayList<>();
        }
    }

    private Station createStation(Element element) {
        for (Line line: lines) {
            String infoString = element.text();
            if (Character.isDigit(infoString.toCharArray()[0]) && !infoString.contains("14 Московское центральное кольцо")) {
                String nameSt = element.child(1).child(0).text();
                String numberLine = parseNumberLine(element.select("td").get(0).firstElementSibling().text());
                Station station = new Station(nameSt, line);
                if (numberLine.length() == 5) {
                    String[] twoNumberLine = numberLine.split(" ");

                    if (twoNumberLine[0].equals(line.getNumber())) {
                        line.addStation(station);
                        return station;
                    }

                } else if (numberLine.equals(line.getNumber())) {
                    line.addStation(station);
                    return station;

                }

            }
        }
        return null;
    }

    private void addStationConnection() {
        List<Station> stationList;
        for (Element element: infoListElement) {
            stationList = parseStationConnection(element);
            if (stationList.size() != 0) {
                Station qwe = createStation(element);
                stationList.add(qwe);
                connections.add(stationList);
            }
        }
    }

    private List<Station> parseStationConnection(Element elementDataStations) {
        List<Station> stationConnections = new ArrayList<>();

        Elements nameContains = elementDataStations.select("td > span > a");
        for (Element element: nameContains) {

            String getNameContains = element.attr("title");

            if (getNameContains.contains("Переход") || getNameContains.contains("пересадка")) {
                String[] listName = getNameContains.split(" ");
                String nameLines = listName[listName.length-2].substring(0,5);
                for (Line line: lines) {
                    if (line.getName().contains(nameLines)) {
                        stationConnections.add(new Station(parseNameConnections(getNameContains), line));
                        break;
                    }
                }
            }
        }
        return stationConnections;
    }

    private String parseNameConnections(String nameConnections) {

        for (Station station: stationList) {
            if (nameConnections.contains(station.getName())) {
                return station.getName();

            }
        }
        return null;
    }

}
