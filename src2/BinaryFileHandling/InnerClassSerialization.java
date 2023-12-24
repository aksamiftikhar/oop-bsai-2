package BinaryFileHandling;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



class A implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private B innerB; // Include B as a field in A

    public class B implements Serializable {
        private static final long serialVersionUID = 1L;
        private int value;

        public B(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public A(String name, int value) {
        this.name = name;
        this.innerB = new B(value); // Initialize B in A's constructor
    }

    public String getName() {
        return name;
    }

    public B getInnerB() {
        return innerB;
    }
}

public class InnerClassSerialization {

    public static void main(String[] args) {
        List<A> listA = new ArrayList<>();
        A a1 = new A("Object1", 100);
        listA.add(a1);

        A a2 = new A("Object2", 200);
        listA.add(a2);

//        // Serialize ArrayList to a file
//        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("objects.bin"))) {
//            out.writeObject(listA);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // Deserialize ArrayList from the file
        List<A> newListA = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("objects.bin"))) {
            newListA = (List<A>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Display the deserialized data
        if (newListA != null) {
            for (A a : newListA) {
                System.out.println("Name: " + a.getName() + ", B Value: " + a.getInnerB().getValue());
            }
        }
    }
}
