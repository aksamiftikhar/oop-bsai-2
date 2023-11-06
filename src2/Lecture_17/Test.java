package Lecture_17;


public class Test {
    public static void main(String[] args) {
        B.staticMethod1();
        A a1 = new B();
//        D d1 = new D();
//        a1.doit();
    }
}
interface I1
{
    void doit();
    void doitnow();
    final int SOME_CONSTANT=10;
}
abstract class D implements I1
{
    @Override
    public void doit()
    {
        System.out.println("I1.doit implementation");
    }
}
class E extends  D
{
    @Override
    public void doitnow()
    {

    }
}
class A
{
    final public void doit2()
    {
        System.out.println("A");
    }
    public static void staticMethod1()
    {

    }
}
class B extends A
{

}