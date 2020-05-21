import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader
{
    public static void main(String[] args)
    {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        int allSalary = 0;
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            allSalary += Integer.parseInt(matcher.group());
        }

        System.out.println("Все вместе заработали: " + allSalary);
    }
}