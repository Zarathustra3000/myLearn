public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;

        System.out.println(sumDigits(65));

    }

    public static Integer sumDigits(Integer number)
    {
        //@TODO: write code here
        int sum = 0;
        String str = number.toString();

        for (int i = 0; i < str.length(); i++) {
            sum += Integer.parseInt(String.valueOf(str.charAt(i)));
        }

/*
        *task
 */
//        for (int i = 0; i < str.length(); i++) {
//            char ch = str.charAt(i);
//            int i1 = Character.getNumericValue(ch);
//            sum += i1;
//        }

        return sum;
    }
}
