import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите: Фамилию Имя Отчество: ");
        String fIO = reader.readLine().trim();

        Pattern pattern = Pattern.compile("[а-яА-Я]+");
        Matcher matcher = pattern.matcher(fIO);
        ArrayList<String> listFIO = new ArrayList<>();

        while (matcher.find()) {
            listFIO.add(matcher.group());
        }

        if(listFIO.size() == 3){
            System.out.println("Фамилия: " + listFIO.get(0)
                    + "\nИмя: " +listFIO.get(1)
                    + "\nОтчество: " + listFIO.get(2));
        } else {
            System.out.println("Попробуйте еще раз.");
        }




    }
}
