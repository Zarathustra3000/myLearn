import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import static java.util.Calendar.*;

public class Loader {
    public static void main(String[] args) {

        int year = 1993;
        int yearCount = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - E", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();

        while (year <= calendar.get(YEAR)) {
            GregorianCalendar date = new GregorianCalendar(year, JANUARY, 31);

            System.out.println(yearCount + " - " + dateFormat.format(date.getTime()));
            year++;
            yearCount++;
        }
    }
}
