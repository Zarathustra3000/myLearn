import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Loader {

    private static String dataFile = "src/resources/map.json";
    private static TreeMap<String,List<String>> mapNumberLineAndListStation = new TreeMap<>();
    private static List<String> nameStationsList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Document html = Jsoup.connect("https://clck.ru/MCHxP")
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("http://www.google.com")
                .maxBodySize(0)
                .get();

        ParserWikiMoscowMetro parserWikiMoscowMetro = new ParserWikiMoscowMetro(html);
        parserWikiMoscowMetro.startProcessParsing();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(dataFile), parserWikiMoscowMetro);

        printCountStationsOnLines();


    }

    public static void printCountStationsOnLines() {
        try
        {
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());

            JSONObject stationsObject = (JSONObject) jsonData.get("stations");
            parseStations(stationsObject);

            for (Map.Entry<String,List<String>> pair: mapNumberLineAndListStation.entrySet()) {
                System.out.println("Line number: " + pair.getKey() + " - " + pair.getValue().size() + " stations");
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void parseStations(JSONObject stationsObject)
    {
        stationsObject.keySet().forEach(lineNumberObject ->
        {
            String lineNumber = (String) lineNumberObject;
            JSONArray stationsArray = (JSONArray) stationsObject.get(lineNumberObject);
            stationsArray.forEach(stationObject ->
            {
                String station = (String) stationObject;
                nameStationsList.add(station);
            });
            mapNumberLineAndListStation.put(lineNumber,nameStationsList);
            nameStationsList = new ArrayList<>();
        });
    }

    private static String getJsonFile()
    {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(dataFile));
            lines.forEach(line -> builder.append(line));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}
