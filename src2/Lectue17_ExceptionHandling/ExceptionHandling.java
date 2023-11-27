package Lectue17_ExceptionHandling;


import Lecture18_FileHandling.TestFiles;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class ExceptionHandling{
    public static void main(String[] args) {
        String pass = "P@ssword!23";

        if(pass.contains("@!"))
            System.out.println("password is valid");
        else
            System.out.println("password is invalid");
        testException.testMethod(5);
        try {
            testException.testNPE(null);
        }
        catch(ArithmeticException ae)
        {
            System.out.println("never reach here");
        }
        catch (NullPointerException npe)
        {

            System.out.println("Null pointer exception handled");
        }
    }
    public static void doit()  throws ArrayIndexOutOfBoundsException, ArithmeticException
    {

    }
    class testException extends Exception
    {
        public int x;
        public static void testMethod(int x) throws ArithmeticException
        {
            try {
                System.out.println("test method");
            }
            catch(Exception e)
            {
                System.out.println("exception handled right in the method.");
            }
        }
        public static void testNPE(testException te) throws NullPointerException
        {
            te.x = 100;

        }
    }
}
