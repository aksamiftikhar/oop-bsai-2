package Lectue17_ExceptionHandling;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionHandling2 {
    public static void main(String[] args) {
        int marks;
        marks = 102;
//        int new_marks = marks/0;

        try {
            if (marks < 0 || marks > 100) {
                throw new MarksOutOfRangeException(marks);
            }
        }
        catch(MarksOutOfRangeException m)
        {
            System.out.println(m);
        }

        File f = new File("F:/abc.txt");
        try {
            Scanner s = new Scanner(f);
            String line = s.nextLine();
            int x = s.nextInt();
            int y = s.nextInt();

            System.out.println(line);
            System.out.println(x + ", " + y);
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println("Exception file not found");
        }
        catch(Exception e)
        {
            System.out.println("some other Exception ");

        }
    }
}

class MarksOutOfRangeException extends Exception
{
    String error_msg;
    int marks;
    public MarksOutOfRangeException()
    {
        error_msg = "Marks are not within range!";
        this.marks = -1;
    }
    public MarksOutOfRangeException(int marks)
    {
        this.marks = marks;
        error_msg = "Marks are not within range!";
    }
    public String toString()
    {
        return "Error: " + error_msg + "(" + marks + ")";
    }
}