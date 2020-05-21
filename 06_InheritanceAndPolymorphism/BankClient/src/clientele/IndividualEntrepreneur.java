package clientele;

import java.math.BigDecimal;

public class IndividualEntrepreneur extends Client {
    // ип

    @Override
    public void withdrawal(double amount) {

        if (account.compareTo(BigDecimal.valueOf(amount)) > 0) {

            int sumLimit = 1000;

            if (amount < sumLimit) {
                amountAndPercent = BigDecimal.valueOf(amount).add(BigDecimal.valueOf(amount / 100));
            } else {
                amountAndPercent = BigDecimal.valueOf(amount).add(BigDecimal.valueOf((amount / 100)/2));
            }

            account = account.subtract(amountAndPercent);
            System.out.println("Withdrawal: " + amountAndPercent + " rub");

        } else {
            System.out.println("Operation is not possible");
        }

    }

}
