import clientele.*;

public class Loader {
    public static void main(String[] args) {

        Client individual = new Individual();

        individual.refill(20);
        individual.withdrawal(5.22);
        individual.withdrawal(40);
        System.out.println(individual.balance());

        System.out.println("------------------");

        Entity entity = new Entity();

        entity.refill(20);
        entity.withdrawal(1);
        entity.withdrawal(30);
        System.out.println(entity.balance());

        System.out.println("------------------");


        IndividualEntrepreneur individualEntrepreneur = new IndividualEntrepreneur();

        individualEntrepreneur.refill(30_000);
        individualEntrepreneur.withdrawal(500);
        individualEntrepreneur.withdrawal(1000);
        System.out.println(individualEntrepreneur.balance());
    }
}
