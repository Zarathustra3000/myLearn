package clientele;

import java.math.BigDecimal;

public abstract class Client {

    protected BigDecimal account = BigDecimal.valueOf(0);
    protected BigDecimal amountAndPercent;

    public void refill(double amount) {

        account = account.add(BigDecimal.valueOf(amount));
        System.out.println("Entrance : " + amount + " rub");

    }

    public void withdrawal(double amount) {

        if (account.compareTo(BigDecimal.valueOf(amount)) > 0) {
            account = account.subtract(BigDecimal.valueOf(amount));
            System.out.println("Withdrawal: " + amount + " rub");
        } else {
            System.out.println("Operation is not possible");
        }

    }

    public String balance() {

        return "Balance: " + account + " rub";

    }

}
