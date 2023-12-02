package BinaryFileHandling;

import java.nio.ByteBuffer;

public class IntegerArrayToByteArray {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};

        ByteBuffer byteBuffer = ByteBuffer.allocate(intArray.length * 4); // 4 bytes per integer
        for (int value : intArray) {
            byteBuffer.putInt(value);
        }

        byte[] byteArray = byteBuffer.array();

        // Now 'byteArray' contains the byte representation of 'intArray'
    }
}
