import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public abstract class LoadStaffFromFileVersionTwo {

    public static MyAccount loadStaffFromFileVersionTwo(String staffFile)
    {
        MyAccount myAccount = new MyAccount();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            lines.remove(0);
            for(String line : lines)
            {
                String[] data = dataList(line);
                if (data.length == 3) {
                    double transaction = Double.parseDouble(data[2]);
                    myAccount.addComing(Integer.parseInt(data[1]));

                    if (transaction > 0.0) {
                        myAccount.addOperation(data[0]);
                        myAccount.addTransaction(transaction);
                    }
                } else {
                    System.out.println("Error");
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return myAccount;
    }

    private static String[] dataList(String string) {
        String[] data = string.split(".*[/|\\\\]")[1].split(",",3);

        data[0] = data[0].substring(0, data[0].indexOf(".") - 2).trim();
        data[2] = data[2].replace("\"","").replace(",",".");

        return data;
    }
}
