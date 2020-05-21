import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Loader {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, String> mapName = new TreeMap<>();

        while (true) {
            System.out.println("Input: ");
            String command = reader.readLine().trim();
            commands(mapName, command);

        }

    }

    public static void commands(TreeMap<String, String> phoneBook, String command) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = "";
        String name = "";
        if (checkNameOrNumber(command)) {
            if (command.equals("list")) {
                printList(phoneBook);
            } else if(phoneBook.containsKey(command)) {
                for (Map.Entry entry: phoneBook.entrySet()) {
                    if (entry.getKey().equals(command)) {
                        System.out.println("\nName: " + entry.getKey() + "\nNumber: " + entry.getValue());
                    }
                }
            } else {
                System.out.println("Input number please:");
                number = reader.readLine();
                phoneBook.put(command, number);
            }
        } else if (checkNumberOrName(command)) {

                if (phoneBook.containsValue(command)) {
                    for (Map.Entry entry: phoneBook.entrySet()) {
                        if (entry.getValue().equals(command)){
                            System.out.println("\nName: " + entry.getKey() + "\nNumber: " + entry.getValue());
                        }
                    }
                } else {
                    System.out.println("Input name please:");
                    name = reader.readLine();
                    phoneBook.put(name, command);
                }

        } else {
            System.out.println("Error");
        }
    }

    public static boolean checkNameOrNumber(String NameOrNumber) {
        if (Pattern.matches("[\\D]+", NameOrNumber)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkNumberOrName(String NumberOrName) {
        if (Pattern.matches("[+]?[^\\D]+", NumberOrName)) {
            return true;
        } else {
            return false;
        }
    }

    public static void printList(TreeMap<String, String> map){
        System.out.println("Contact:");
        for (Map.Entry entry: map.entrySet()) {
            System.out.println("Name: " + entry.getKey() + "\nNumber Phone: " + entry.getValue() + "\n");
        }
    }

}
