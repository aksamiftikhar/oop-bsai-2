package BinaryFileHandling;
import java.io.*;

public class BinaryFileHandlingDemo {

    public static void main(String[] args) {
        // Specify the file path
        String filePath = "F:/binary_data.dat";

        // Write binary data to the file
        writeBinaryData(filePath);

        // Read binary data from the file
        readBinaryData(filePath);
    }

    private static void writeBinaryData(String filePath) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filePath))) {
            // Write various data types to the binary file
            dataOutputStream.writeInt(97);
            FileOutputStream fos = new FileOutputStream(filePath);
            int[] xArr = new int[5];

            dataOutputStream.writeDouble(3.14);
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeUTF("Binary File Handling");

            System.out.println("Binary data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readBinaryData(String filePath) {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filePath))) {
            // Read data from the binary file
            int intValue = dataInputStream.readInt();
            double doubleValue = dataInputStream.readDouble();
            boolean booleanValue = dataInputStream.readBoolean();
            String stringValue = dataInputStream.readUTF();

            // Display the read values
            System.out.println("Read Int: " + intValue);
            System.out.println("Read Double: " + doubleValue);
            System.out.println("Read Boolean: " + booleanValue);
            System.out.println("Read String: " + stringValue);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
