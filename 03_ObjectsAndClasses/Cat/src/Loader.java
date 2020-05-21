
public class Loader {
    public static void main(String[] args) {

        /*
        Урок 1. Понятие класса и объекта
         */

        Cat cat = new Cat();
        Cat catTwo = new Cat();
        Cat catThree = new Cat();
        Cat catFour = new Cat();
        Cat catFive = new Cat();

        System.out.println(cat.getStatus());
        System.out.println("\nВес созданных кошек:");
        System.out.println("Первый кот: " + cat.getWeight() + "\nВторой кот: " + catTwo.getWeight()
                + "\nТретий кот: " + catThree.getWeight() + "\nЧетвертый кот:" + catFour.getWeight()
                + "\nПятый кот: " + catFive.getWeight());

        cat.feed(3.2);
        catTwo.feed(2.4);

        System.out.println("\nПокормленные коты:");
        System.out.println("Первый кот: " + cat.getWeight() + "\nВторой кот: " + catTwo.getWeight());

        while (true){
            if (catThree.getStatus().equals("Playing") || (catThree.getStatus().equals("Sleeping"))){
                catThree.feed(  catThree.getWeight()/10 + 20.);
            } else if (catThree.getStatus().equals("Exploded")){
                System.out.println("\nЕсли кормить третью кошку без остановок, то получим: ");
                System.out.println(catThree.getStatus());
                break;
            }
        }

        System.out.println("\nЧетвертая кошка начинает мяукать без остановки: ");
        for (int i = 0; i < 10000; i++) {
            if (catFour.getStatus().equals("Playing")){
                catFour.meow();
            } else {
                System.out.println("\nКогда домяукалась: ");
                System.out.println(catFour.getStatus());
                System.out.println(catFour.getWeight());
                break;
            }
        }

       /*
       Урок 2. Метод, параметры, return
        */

        catFive.feed(150.);
        System.out.println("\nКоличество съеденной еды пятым котиком: " + catFive.foodAmount());
        System.out.println("\nКотик пошел в туалеи: ");
        for (int j = 0; j < 3; j++) {
             catFive.pee();
        }
    }

    private static Cat getKitten(){
        Cat kitten = new Cat(1100.);
        return kitten;
    }
}