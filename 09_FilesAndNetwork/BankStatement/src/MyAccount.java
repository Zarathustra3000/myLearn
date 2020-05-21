import java.util.ArrayList;
import java.util.List;

public class MyAccount {

    private int coming;
    private List<Double> transaction = new ArrayList<>();
    private List<String> operation = new ArrayList<>();

    public MyAccount() {
    }

    public void addTransaction(Double transaction) {
        this.transaction.add(transaction);
    }

    public List<Double> getTransaction() {
        return transaction;
    }

    public void addOperation(String operation) {
        this.operation.add(operation);
    }

    public List<String> getOperation() {
        return operation;
    }

    public void addComing(int coming) {
        this.coming += coming;
    }

    public int getComing() {
        return coming;
    }

    public void printMyAccount() {
        System.out.println("Total funds received to the account: " + this.getComing()
                + "\nInvoice expenses: ");
        for (int i = 0; i < this.getOperation().size(); i++) {
            System.out.printf("%-50.50s  %-50.50s%n", this.getOperation().get(i), this.getTransaction().get(i));
        }

    }

}
