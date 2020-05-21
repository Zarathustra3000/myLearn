import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LoadStaffFromFile {

    public static MyAccount loadStaffFromFile(String staffFile)
    {
        MyAccount myAccount = new MyAccount();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            lines.remove(0);
            for(String line : lines)
            {
                double transaction = extractTransaction(line);
                myAccount.addComing(extractComing(line));

                if (transaction > 0.0) {
                    myAccount.addOperation(extractOperation(line));
                    myAccount.addTransaction(transaction);
                }

            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return myAccount;
    }

    private static String extractOperation(String operation) {
        String newOperation = "";
        if (operation.contains("/")) {
            newOperation = operation.substring(operation.lastIndexOf("/") + 1);
        } else {
            newOperation = operation.substring(operation.lastIndexOf("\\") + 1);
        }
        newOperation = newOperation.substring(0, newOperation.indexOf(".") - 2).trim();
        return newOperation;
    }

    private static int extractComing(String coming){
        String com = coming.substring(coming.lastIndexOf(" "));
        com = com.substring(com.indexOf(",") + 1);
        com = com.substring(0,com.indexOf(","));

        return Integer.parseInt(com);
    }

    private static double extractTransaction(String transaction){
        String newTransaction = transaction.substring(transaction.lastIndexOf(" "));
        if (newTransaction.contains("\"")) {
            newTransaction = newTransaction.substring(newTransaction.indexOf("\"") + 1,newTransaction.lastIndexOf("\""));
            newTransaction = newTransaction.replace(",",".");
        } else {
            newTransaction = newTransaction.substring(newTransaction.indexOf(",") + 1);
            newTransaction = newTransaction.substring(newTransaction.indexOf(",") + 1);
        }
        return Double.parseDouble(newTransaction);
    }
}
