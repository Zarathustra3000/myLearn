import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class Main
{
    private static String staffFile = "data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";

    public static void main(String[] args) throws ParseException {
        ArrayList<Employee> staff = loadStaffFromFile();
//        Comparator<Employee> comparator = Comparator.comparing(Employee::getSalary)
//                .thenComparing(Employee::getName);
//        staff.sort(comparator);
//        staff.forEach(System.out::println);

        String start = "01.01.2017";
        String stop = "31.12.2017";
        Date startDate = new SimpleDateFormat(dateFormat).parse(start);
        Date stopDate = new SimpleDateFormat(dateFormat).parse(stop);

        staff.stream().filter(s -> s.getWorkStart().compareTo(startDate) > 0 && s.getWorkStart().compareTo(stopDate) < 0)
                .max(Comparator.comparing(Employee::getSalary)).map(Employee::getSalary).ifPresent(System.out::println);

    }

    private static ArrayList<Employee> loadStaffFromFile()
    {
        ArrayList<Employee> staff = new ArrayList<>();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for(String line : lines)
            {
                String[] fragments = line.split("\t");
                if(fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                    fragments[0],
                    Integer.parseInt(fragments[1]),
                    (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}