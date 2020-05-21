import java.nio.file.Files;
import java.nio.file.Paths;

public class LoadStaffFromFileVersionThree {

    public static MyAccount loadStaffFromFileVersionThree(String staffFile)
    {
        MyAccount myAccount = new MyAccount();
        try
        {
            Files.lines(Paths.get(staffFile)).filter(a -> !a.contains("Номер счета"))
                    .map(a -> a.split(".*[/|\\\\]")[1].split(",", 3))
                    .forEach(value -> {
                        value[0] = value[0].substring(0, value[0].indexOf(".") - 2).trim();
                        value[2] = value[2].replace("\"","").replace(",",".");

                        double transaction = Double.parseDouble(value[2]);
                        myAccount.addComing(Integer.parseInt(value[1]));

                        if (transaction > 0.0) {
                            myAccount.addOperation(value[0]);
                            myAccount.addTransaction(transaction);
                        }
                    });

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return myAccount;
    }
}
