import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Loader {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> todoList = new ArrayList<>();
        String commandList = "List" +
                "\nAdd" +
                "\nAdd index" +
                "\nEdit index" +
                "\nDelete index" +
                "\nEnd - enter to complete program";

        System.out.println("Input commands\n" + commandList);

        while (true){
            String commandsInput = reader.readLine().trim().toLowerCase();
            if(commandsInput.equals("end")){
                break;
            }
            processingCommands(todoList, commandsInput);
        }
    }

    public static void processingCommands(ArrayList<String> list, String commands){

        String[] arrayCommands = commands.split(" ");
        String textCommand = arrayCommands[0].trim();
        int numberCommand = 0;


        if(arrayCommands.length == 3){
            try {
                String textCase = arrayCommands[2].trim();
                numberCommand = Integer.parseInt(arrayCommands[1].trim());
                    if (textCommand.equals("add") && numberCommand <= list.size()) {
                        list.add(numberCommand, textCase);
                    } else if (textCommand.equals("edit")) {
                        list.set(numberCommand, textCase);
                    } else {
                        System.out.println("Invalid commands.");
                    }
            } catch (NumberFormatException e){
                System.out.println("Error numbers to-do.");
            }

        } else if(arrayCommands.length == 2){

            try {
                numberCommand = Integer.parseInt(arrayCommands[1].trim());
                if (textCommand.equals("delete") && numberCommand <= list.size()){
                    list.remove(numberCommand);
                } else {
                    System.out.println("Invalid commands.");
                }

            } catch (NumberFormatException e){
                if (textCommand.equals("add")){
                    list.add(arrayCommands[1]);
                } else {
                    System.out.println("Invalid commands.");
                }
            }

        } else if (arrayCommands.length == 1){
            if (textCommand.equals("list")){
                System.out.println("\nTo-do list: ");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(i + " - " + list.get(i));
                }
            } else {
                System.out.println("Invalid commands.");
            }

        } else {
            System.out.println("Invalid commands.\n Tru him again.");
        }



    }
}
