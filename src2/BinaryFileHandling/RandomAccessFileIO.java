package BinaryFileHandling;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileIO {

        private static final int RECORD_LENGTH = 28; // 4 (ID) + 20 (Name) + 4 (Age)

    public static void writeRecord(RandomAccessFile file, int id, String name, int age) throws IOException {
        file.writeInt(id); // ID: 4 bytes

        // Name: 20 bytes (padding if necessary)
        if (name.length() > 20) {
            name = name.substring(0, 20);
        } else {
            while (name.length() < 20) {
                name += " ";
            }
        }
        file.writeBytes(name);

        file.writeInt(age); // Age: 4 bytes
    }
    public static void readRecord(RandomAccessFile file, int recordNumber) throws IOException {
        file.seek((recordNumber - 1) * RECORD_LENGTH); // Seek to the start of the record

        int id = file.readInt();
        byte[] nameBytes = new byte[20];
        file.readFully(nameBytes);
        String name = new String(nameBytes).trim(); // Trim for removing padding
        int age = file.readInt();

        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
    }



    public static void main(String[] args) {

//        // write records to random acces file
//        try (RandomAccessFile file = new RandomAccessFile("F:/records.dat", "rw")) {
//            writeRecord(file, 1, "Alice", 30);
//            writeRecord(file, 2, "Bob", 25);
//            // Add more records as needed
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        // read records from random access file
//        try (RandomAccessFile file = new RandomAccessFile("F:/records.dat", "r")) {
//            readRecord(file, 2); // Read the record of the second person
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        doSomething(1, "a", new A());
    }
    public static <T extends Comparable<T>> int maximum(T obj1, T obj2)
    {
       return obj1.compareTo(obj2);
    }
    public static <T1, T2> T2 doSomething(T1 arg1, T2 arg2, T1 arg3)
    {
        T1 t_local;

        return arg2;
    }

}
class A
{

}