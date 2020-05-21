package core;

import com.fasterxml.jackson.annotation.*;
import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"line", "name"})
public class Station implements Comparable<Station>
{
    private Line line;
    private String name;
    private List<Station> nameConnections;

    public Station(String name, Line line)
    {
        this.name = name;
        this.line = line;
        this.nameConnections = new ArrayList<>();
    }

    public void setNameConnections(List<Station> nameConnections) {
        this.nameConnections = nameConnections;
    }

    @JsonIgnore
    public List<Station> getNameConnections() {
        return nameConnections;
    }

    @JsonIgnore
    public Line getLine()
    {
        return line;
    }

    @JsonGetter("line")
    public String getNumberLine() {
        return line.getNumber();
    }

    public String getName()
    {
        return name;
    }

    @Override
    public int compareTo(Station station)
    {
        int lineComparison = line.compareTo(station.getLine());
        if(lineComparison != 0) {
            return lineComparison;
        }
        return name.compareToIgnoreCase(station.getName());
    }

    @Override
    public boolean equals(Object obj)
    {
        return compareTo((Station) obj) == 0;
    }

    @Override
    public String toString()
    {
        return name;
    }
}