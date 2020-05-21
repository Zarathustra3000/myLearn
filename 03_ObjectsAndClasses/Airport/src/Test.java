import com.skillbox.airport.Airport;

public class Test {
    public static void main(String[] args) {
        System.out.println(Airport.getInstance().getAllAircrafts());
        System.out.println(Airport.getInstance().getAllAircrafts().size());
    }
}
