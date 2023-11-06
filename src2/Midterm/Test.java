package Midterm;

class Parent {
    static {
        System.out.println("Static block in Parent");
    }
    {
        System.out.println("Non-static block in Parent");
    }
    Parent() {
        System.out.println("Default constructor in Parent");
    }
    Parent(int x) {
        System.out.println("Parameterized constructor in Parent: " + x);
    }
    void display() {
        System.out.println(
                "Display method in Parent");
    }
}

class Child extends Parent {
    static {
        System.out.println(
                "Static block in Child");
    }
    {
        System.out.println(
                "Non-static block in Child");
    }
    Child() {
        super(42);
        System.out.println(
                "Default constructor in Child");
    }
    void display() {
        System.out.println(
                "Display method in Child");
    }
}
public class Test {
    public static void main(String[] args){
        Parent p = new Child();
        Parent q = new Parent();
        ((Child) p).display();
        q.display();
    }
}

