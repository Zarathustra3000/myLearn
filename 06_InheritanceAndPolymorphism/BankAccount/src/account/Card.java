package account;

public class Card extends PaymentAccount {

    public Card(){

    }

    @Override
    public void withdrawal(double amount) {

        double percent = amount / 100;
        int sum = (int) ((amount * 100) + (percent * 100));

        super.withdrawal((double) sum /100);
    }
}
