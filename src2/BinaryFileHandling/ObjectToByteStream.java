package BinaryFileHandling;

import java.io.*;

public class ObjectToByteStream {

    public static byte[] convertToBytes(Object object) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(bos)) {
            out.writeObject(object);
            return bos.toByteArray();
        }
    }

    public static void writeToFile(Object object)
            throws IOException {
        try (FileOutputStream bos = new FileOutputStream("F:/clients.dat");
             ObjectOutputStream out = new ObjectOutputStream(bos)) {
            out.writeObject(object);
            System.out.println("Object written to file");
        }
    }
    public static MyObject readFromFile(String filePath)
            throws IOException, ClassNotFoundException {
        try (FileInputStream bos = new FileInputStream(filePath);
             ObjectInputStream in = new ObjectInputStream(bos)) {
            return (MyObject) in.readObject();
        }
    }
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        myObject.x=1000;
        myObject.ch='a';
        myObject.y=20;

// Set properties of myObject, if necessary
        try {
            byte[] bytes = convertToBytes(myObject);
            for(byte b: bytes)
                System.out.println(b);
            // Use the byte array as needed
            writeToFile(myObject);
            MyObject myO2 = new MyObject() ;
            myO2.x = 5000;
            writeToFile(myO2);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }

//        try {
//            MyObject my_o = readFromFile("F:/clients.dat");
//            System.out.println(my_o.x + ":" + my_o.y);
//            System.out.println(my_o.ch);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }

    }

}



class MyObject implements Serializable {
    // class fields, constructors, methods...
    int x;
    char ch;
    int y;
}
