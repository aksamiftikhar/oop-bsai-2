package Lecture_16;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test_Comparable {
//
    public static void main(String[] args) {
        ArrayList<Person> pArr = new ArrayList<>();
        Person p3 = new Person("Hafsa", 70);
        Person p4 = new Person("Hassan", 40);
        pArr.add(new Person("Umar", 20));
        pArr.add(new Person("Zubair", 15));
        pArr.add(p3);

        System.out.println(pArr);
        AgeComparator ag1 = new AgeComparator();
        Collections.sort(pArr);
        System.out.println(pArr);

        System.out.println(Collections.binarySearch(pArr, p4));


    }
}

class AgeComparator implements  Comparator<Person>
{
    @Override
    public int compare(Person p1, Person p2)
    {
        return p1.age-p2.age;
    }
}

class Person implements Comparable<Person>
{


    @Override
    public int compareTo(Person p) {
        return name.compareTo(p.getName());
    }

    private String name;
    public int age;
    public Person ()
    {
        name = "No name yet";
    }


    public Person (String initialName)
    {
        name = initialName;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName (String newName)
    {
        name = newName;
    }


    public String getName ()
    {
        return name;
    }


    public void writeOutput ()
    {
        System.out.println ("Name: " + name);
    }


    public boolean hasSameName (Lecture_12.Student_pkg.Person otherPerson)
    {
        return this.name.equalsIgnoreCase (otherPerson.getName());
    }
    public String toString()
    {
        return   getName() + "is " + age + " years old.";
    }
}
class Student extends Person
{

}