import core.Line;
import core.Station;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest {

    private final double EPS = 1e-9;

    private static List<Station> route;
    private static List<Station> connection;
    private static List<Station> connectionTwo;
    private static StationIndex stationIndex;
    private static RouteCalculator routeCalculator;

    @BeforeClass
    public static void createDataForRouteCalculator() throws Exception {

        route = new ArrayList<>();
        connection = new ArrayList<>();
        connectionTwo = new ArrayList<>();
        stationIndex = new StationIndex();
        routeCalculator = new RouteCalculator(stationIndex);

        Line line1 = new Line(1,"one");
        Line line2 = new Line(2,"two");
        Line line3 = new Line(3,"three");

        // name station = station + NumbersStation + Line + NumbersLine + ?connection
        route.add(new Station("st1l1",line1)); //0

        route.add(new Station("st2l1c",line1)); //1
        route.add(new Station("st1l2c",line2)); //2

        route.add(new Station("st2l2c",line2)); //3
        route.add(new Station("st3l2",line2)); //4

        route.add(new Station("st1l3c",line3)); //5
        route.add(new Station("st2l3",line3));  //6

        connection.add(route.get(1));
        connection.add(route.get(2));

        connectionTwo.add(route.get(3));
        connectionTwo.add(route.get(5));

        line1.addStation(route.get(0));
        line1.addStation(route.get(1));
        line2.addStation(route.get(2));
        line2.addStation(route.get(3));
        line2.addStation(route.get(4));
        line3.addStation(route.get(5));
        line3.addStation(route.get(6));

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        stationIndex.addStation(route.get(0));
        stationIndex.addStation(route.get(1));
        stationIndex.addStation(route.get(2));
        stationIndex.addStation(route.get(3));
        stationIndex.addStation(route.get(4));
        stationIndex.addStation(route.get(5));
        stationIndex.addStation(route.get(6));

        stationIndex.addConnection(connection);
        stationIndex.addConnection(connectionTwo);
    }

    @Test
    public void testCalculateDuration() throws Exception {

        List<Station> actualRoute = routeCalculator.getShortestRoute(route.get(0), route.get(6));
        double actual = routeCalculator.calculateDuration(actualRoute);
        double expected = 9.5;

        Assert.assertEquals(expected,actual, EPS);
    }

    @Test
    public void shouldReturnShortestRouteWhenStationsOnOneLine() {

        int actual = routeCalculator.getShortestRoute(route.get(0), route.get(1)).size();
        int expected = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnShortestRouteWithOneConnect() {

        int actual = routeCalculator.getShortestRoute(route.get(0), route.get(3)).size();
        int expected = 4;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnShortestRouteWithTwoConnect() {

        int actual = routeCalculator.getShortestRoute(route.get(0), route.get(6)).size();
        int expected = 6;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addingNullRouteCalculate() {

        List<Station> actual = routeCalculator.getShortestRoute(null, route.get(3));
        List<Station> expected = null;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sequenceStation() {

        List<Station> actualList = routeCalculator.getShortestRoute(route.get(0), route.get(6));
        List<Station> expectedList = new ArrayList<>(route);
        /*
        тут удаляем из списка 4 станцию так как она является конечной второй линии и не попадет в actualList
         */
        expectedList.remove(4);

        for (int i = 0; i < actualList.size(); i++) {
            Station actual = actualList.get(i);
            Station expected = expectedList.get(i);
            Assert.assertEquals(expected, actual);
        }
    }

}
