
public class Cat
{
    private double originWeight;
    private double weight;

    private final double MIN_WEIGHT = 1000.;
    private final double MAX_WEIGHT = 9000.;
    private final int EYES = 2;

    private double amountFood;
    private static int count;
    private CatColor catColor;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count++;
    }

    public Cat(double weight){
        this();
        this.weight = weight;
        count++;
    }

    public Cat(Cat cat){
        this();
        this.weight = cat.weight;
        count++;
    }

    public void meow()
    {
        if(isAlife()) {
            weight = weight - 1;
            System.out.println("Meow");
        }
    }

    public void feed(Double amount)
    {
        if (isAlife()) {
            weight = weight + amount;
            amountFood += amount;
        } else if(weight > MAX_WEIGHT){
            count--;
        } else {
            System.out.println("DEAD");
        }
    }

    public void drink(Double amount)
    {
        if (isAlife()) {
            weight = weight + amount;
        }
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < MIN_WEIGHT) {
            return "Dead";
        }
        else if(weight > MAX_WEIGHT) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }

    public double foodAmount(){
        return amountFood;
    }

    public void pee(){
        if (isAlife()) {
            weight -= 3;
            System.out.println("PEE!!");
        }
    }

    public static int getCount(){
        return count;
    }

    public boolean isAlife(){
        if(weight < MAX_WEIGHT && weight > MIN_WEIGHT){
            return true;
        } else {
            return false;
        }
    }

    public void setCatColor(CatColor color){
        this.catColor = color;
    }

    public CatColor getCatColor(){
        return catColor;
    }
}