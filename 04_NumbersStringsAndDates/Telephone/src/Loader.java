import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine().trim();
        String numberPhone = "";

        Pattern p = Pattern.compile("[^\\D]");
        Matcher m = p.matcher(number);
        while (m.find()){
            numberPhone += m.group();
        }

        numberPhone = numberPhone.substring(1, numberPhone.length());

        if(numberPhone.length() == 10) {

            String numPhone = numberPhone.replaceAll("\\b(\\d{0})(\\d{3})(\\d{3})(\\d{2})(\\d{2})\\b", "+7 $2 $3-$4-$5");
            System.out.println(numPhone);

        } else {
            System.out.println("Попробуй еще раз");
        }
    }
}
