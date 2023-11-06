import java.util.ArrayList;
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

        String str1 = new String("Java");
        String str2 = new String("Java");
        System.out.println(str1 == str2);



    }
}

class A
{
    int x;
}
class B extends A
{
    int y;
}
class C
{
    int z;
}