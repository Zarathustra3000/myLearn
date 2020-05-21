package account;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PaymentAccount {

    private int account;
    protected final int TENTH = 100;
    protected Calendar calendar = new GregorianCalendar();
    private Date lastPaymentDate;


    public PaymentAccount(){

    }

    /*
    Пополнение счета.
    */
    public void refill(double amount){
        this.account += amount*TENTH;
        lastPaymentDate = calendar.getTime();
        System.out.println("Entrance : " + amount + " rub");
    }

    /*
    Снятие наличных
     */
    public void withdrawal(double amount) {
        if (account <= 0 || amount*TENTH > account){
            System.out.println("Operation is not possible");
        } else {
            account -= amount * TENTH;
            System.out.println("Withdrawal: " + amount + " rub");
        }
    }

    /*
    Проверка баланса
     */
    public String balance(){

        return "Balance: " + ((double)account/100) + " rub";
    }


    public Date getLastPaymentDate() {
        return lastPaymentDate;
    }

    public int getAccount() {
        return account;
    }

}
