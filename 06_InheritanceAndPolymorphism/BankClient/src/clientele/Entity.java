package clientele;

import java.math.BigDecimal;

public class Entity extends Client {
    // Юр лицо

    @Override
    public void withdrawal(double amount) {

        amountAndPercent = BigDecimal.valueOf(amount).add(BigDecimal.valueOf(amount/100));

        if (account.compareTo(BigDecimal.valueOf(amount)) > 0) {
            account = account.subtract(amountAndPercent);
            System.out.println("Withdrawal: " + amountAndPercent + " rub");
        } else {
            System.out.println("Operation is not possible");
        }

    }

}
