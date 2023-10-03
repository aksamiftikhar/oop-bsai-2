public class Test {
    public static double average(int x, double ... numbers)
    {
        double total = 0;
        total += x;
        for(double num : numbers)
            total  += num;


        return total/numbers.length;
    }
    public static void main(String[] args) {
//        System.out.println("Hello");
        System.out.println(average(3, 3.5, 3.2, 1.1));
    }
}
