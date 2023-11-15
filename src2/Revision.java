public class Revision {
    public static void main(String[] args) {
        A1 obj1 = new B1();
        obj1.tempMethod();
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1==s2);
        Integer i1 = 10, i2= 10;
        System.out.println(i1==i2);
        ((B1)obj1).anotherMethod();
        int x = 10;
        int y = new Integer(10);
        System.out.println(x == y);

        A1 obj2 = new C1();
        obj1 = new C1();
        obj1.tempMethod();



    }
}

abstract class A1
{
    public void tempMethod2()
    {

    }
    public abstract void tempMethod();

}

class B1 extends  A1{
    @Override
    public void tempMethod()
    {
        System.out.println("temp method in B1");
    }
    public void anotherMethod()
    {
        System.out.println("another method in B1");
    }
}

class C1 extends B1
{
    @Override
    public void tempMethod()
    {
        System.out.println("temp Method in C1");
    }
    public void tempMethod(int x)
    {

    }
}