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

        Test t = new Test();
        System.out.println(t);

//        System.out.println("Hello");
        System.out.println(average(3, 3.5, 3.2, 1.1));

        // Lecture 9
//        ArrayList<int> al;
        ArrayList<Integer> alInt = new ArrayList<>();
        alInt.add(40); // Auto boxing
        alInt.add(50);
        alInt.add(-10);

        int x = alInt.get(0); //unboxing

        for(int x1: alInt)
            System.out.println(x1);



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