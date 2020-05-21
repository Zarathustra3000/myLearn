import account.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Loader {
    public static void main(String[] args) {

        PaymentAccount paymentAccount = new PaymentAccount();
        System.out.println(paymentAccount.balance());
        paymentAccount.refill(0.3);
        paymentAccount.withdrawal(0.1);
        System.out.println(paymentAccount.balance());
        paymentAccount.withdrawal(0.1);
        System.out.println(paymentAccount.balance());


        System.out.println("-----------");

        DepositoryAccount depositoryAccount = new DepositoryAccount();
        System.out.println(depositoryAccount.balance());
        depositoryAccount.refill(10);
        System.out.println(depositoryAccount.balance());
        depositoryAccount.withdrawal(3);
        System.out.println(depositoryAccount.balance());

        System.out.println("-----------");

        Card card = new Card();
        System.out.println(card.balance());
        card.refill(200000);
        System.out.println(card.balance());
        card.withdrawal(60000);
        System.out.println(card.balance());

    }
}
