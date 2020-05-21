import java.util.HashMap;
import java.util.regex.Pattern;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;
    private String number;
    private String email;
    private String name;

    private String checkNumber(String number) throws NumberException {
        if (Pattern.matches("[+][^\\D]+", number) && number.length() == 12) {
            this.number = number;
        } else {
            throw new IllegalArgumentException("Number invalid");
        }
        return number;
    }

    private String checkEMails(String email) throws EmailException {
        if (Pattern.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b", email)) {
            this.email = email;
        } else {
            throw new EmailException("E-mail invalid");
        }
        return email;
    }

    private String checkName(String name) throws Exception {
        if (Pattern.matches("[\\D]+", name)) {
            this.name = name;
        } else {
            throw new Exception("Name invalid");

        }
        return name;
    }

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        String[] components = data.split("\\s+");
        try {
                name = checkName(components[0] + " " + components[1]);
                number = checkNumber(components[3]);
                email = checkEMails(components[2]);
                storage.put(name, new Customer(name, number, email));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name)
    {
        storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }
}