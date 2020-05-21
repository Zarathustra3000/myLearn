import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.*;


public class Test {
    public static void main(String[] args) {

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR_OF_DAY, 2);

        List<Terminal> l = Airport.getInstance().getTerminals();

        l.stream().map(Terminal::getFlights)
                .flatMap(o -> o.stream().filter(s -> s.getDate().compareTo(date) > 0 && s.getDate().compareTo(cal.getTime()) < 0
                && s.getType().equals(Flight.Type.DEPARTURE)))
                .forEach(System.out::println);
    }
}
