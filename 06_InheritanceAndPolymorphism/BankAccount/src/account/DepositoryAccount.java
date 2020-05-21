package account;

import java.util.Calendar;

public class DepositoryAccount extends PaymentAccount {

    public DepositoryAccount(){

    }

    @Override
    public void withdrawal(double amount){
        super.withdrawal(0);

        int nowMonth = calendar.get(Calendar.MONTH);
        int nowDay = calendar.get(Calendar.DAY_OF_MONTH);
        int thenMonth = getLastPaymentDate().getMonth();
        int thenDay = getLastPaymentDate().getDay();

        if (amount < getAccount() * TENTH){
            if (nowMonth > thenMonth && nowDay >= thenDay) {
                super.withdrawal(amount);
                System.out.println("Withdrawal: " + amount + "rub");
            } else {
                System.out.println("Sorry, the operation is not possible this month");
            }
        } else {
                System.out.println("Operation is not possible");
            }
    }

}
