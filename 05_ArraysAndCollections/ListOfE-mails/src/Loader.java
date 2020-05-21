import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class Loader {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> listEmails = new TreeSet<>();
        String commandList = "List" +
                "\nAdd e-mail" +
                "\nEnd - enter to complete program";

        System.out.println("Commands:\n" + commandList + "\n\nInput command:");


        while (true) {
            String commandAndEMail = reader.readLine();
            if (commandAndEMail.equals("end")){
                break;
            }
            commands(listEmails, commandAndEMail);
        }


    }

    public static void commands(TreeSet<String> listEMails, String commandAndMail) {
        String[] listCommandAndMail = commandAndMail.trim().split(" ");
        if (listCommandAndMail.length <= 2) {
            if(listCommandAndMail[0].equals("add")) {
                addEMails(listEMails, listCommandAndMail[1]);
            } else if (listCommandAndMail[0].equals("list")) {
                for (String set: listEMails) {
                    System.out.println(set);
                }

            } else {
                System.out.println("error");
            }
        } else {
            System.out.println("Error.");
        }


    }

    public static void addEMails(TreeSet<String> listEMails, String eMails){
        if (checkEMails(eMails)) {
            listEMails.add(eMails);
        } else {
            System.out.println("Mail error");
        }

    }

    public static boolean checkEMails(String eMails){
        String s ="\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
        if (Pattern.matches(s,eMails)) {
            return true;
        } else {
            return false;
        }
    }
}
