package Lecture18_FileHandling;
import java.io.*;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.Scanner;

public class TestFiles {
    public static class Product
    {
        int product_id;
        String product_name;
        double product_price;

        public Product() {
            super();
        }

        public Product(int product_id, String product_name, double product_price) {
            this.product_id = product_id;
            this.product_name = product_name;
            this.product_price = product_price;
        }

    }
//    public static void main(String[] args) {
//        String filePath = "F:/temp.txt";
//        String dataToAppend = "This is the data to append.";
//
//        try (FileWriter fileWriter = new FileWriter(filePath, true)) { // Enabling append mode
//            fileWriter.write(dataToAppend);
//
//            fileWriter.write(System.lineSeparator()); // Adding a newline character
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


//        public static void main(String[] args) {
//            try (FileReader reader = new FileReader("F:/temp.txt")) {
//                int character;
//
//                while ((character = reader.read()) != -1) {
//                    System.out.print((char) character );
//
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }


//
//    int x;

    public static void main(String[] args) {
        int x= 10;
        System.out.println(String.format(":%d", x));
//        Formatter.format("%d", x);
        File f = new File("F:/temp.txt");
        if(!f.exists())
        {
            try {
                boolean res = f.createNewFile();
                if(res)
                    System.out.println("A new file created with name temp.txt.");
                else
                    throw new IOException("Could not create file.");

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        try ( Formatter fTemp = new Formatter(f);
              Scanner inputScanner = new Scanner(System.in);) // try with resources
        {



            System.out.println("Enter product details: ");
            System.out.println("(id, name, price): ");
            while(inputScanner.hasNext())
            {
                int id = inputScanner.nextInt();
                String name = inputScanner.next(); // single-word input only
                double price = inputScanner.nextDouble();

                Product p = new Product(id, name, price);

                fTemp.format("%d\t%s\t%f\n", p.product_id, p.product_name, p.product_price);

                System.out.println("(id, name, price): ");
            }

        }
        catch(FormatterClosedException fce)
        {
            System.out.println(fce.getMessage());
        }
        catch(SecurityException | FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

    }
//    public void testMethod()
//    {
//        Product p = new Product(1, ",", 3);
//
//    }
}
