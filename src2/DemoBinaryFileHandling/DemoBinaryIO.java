package DemoBinaryFileHandling;

import java.io.*;

public class DemoBinaryIO {
    public static void main(String[] args) {

//        try(DataOutputStream dos =
//                    new DataOutputStream(new FileOutputStream("D:/temp.txt"));)
//        {
////            dos.writeChar((int)'a');
////            dos.writeByte((int)'a');
//            dos.writeInt((int) 'a');
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try(DataInputStream dis = new DataInputStream(new FileInputStream("D:/temp.txt")))        {
            int x= dis.readInt();
            System.out.println(x);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        try {
//            dos = new DataOutputStream(new FileOutputStream("D:/temp.txt"));
//            try {
//                dos.writeChar((int)'a');
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            finally {
//                if(dos!=null) {
//                    dos.close();
//
//                }
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }
}
