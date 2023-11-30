package Files_CRUD_Lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class BatchGrades {
    private String batchName;
    private int startYear, endYear;
    private String[] courses;
    private int[][] marks;

    public BatchGrades(String batchName, int startYear, int endYear,
                       String[] courseName, int[][] marks) {
        this.batchName = batchName;
        this.startYear = startYear;
        this.endYear = endYear;
        this.courses = courseName;
        this.marks = marks;
    }

    public String getBatchName() {
        return batchName;
    }

    public int getStartYear() {
        return startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public String[] getCourses() {
        return courses;
    }

    public int[][] getMarks() {
        return marks;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public void setCourses(String[] courseName) {
        this.courses = courseName;
    }

    public void setMarks(int[][] marks) {
        this.marks = marks;
    }

    public static void main(String[] args) {

        BatchGrades temp = new BatchGrades("SP23-BAI-A",
                2023, 2027, new String[]{"abc", "def"},
                new int[][] {{1, 2, 30}, {3, 2, 1}});
//        BatchGrades bg = GetBatchData();

        writeBatchData(temp, "F:/batch_data.txt");

        Scanner input = new Scanner(System.in);
        System.out.println("Enter course name to delete: ");
        String courseToFind = input.next();

//        SearchCourse(courseToFind, "F:/batch_data.txt");

        deleteCourse(courseToFind, "F:/batch_data.txt");



    }
    public static boolean deleteCourse(String courseToDelete, String fileName)
    {
        int numStudents = 3;
        int numCourses = 3;
        String [] courses = new String[numCourses];

        int[][] courseMarks = new int[numCourses][numStudents];
        Scanner fileInput = null;
        String batchName ; // ignore batch
        int startYear ; // ignore start year
        int endYear ;
        boolean found = false;

        try {
             fileInput = new Scanner(new File(fileName));
             batchName = fileInput.next(); // read batch
             startYear = fileInput.nextInt(); // read start year
             endYear = fileInput.nextInt(); // read end year

            String courseInFile;
            int average = 0;

            int courseNum = 0;
            while(fileInput.hasNext())
            {
                courseInFile = fileInput.next();
                if(!(courseInFile.compareToIgnoreCase(courseToDelete)==0))
                    // course does not match; find marks average
                {
                    courses[courseNum] = courseInFile;
                    System.out.println(courseInFile);
                    for(int j=0;j<numStudents;j++)
                        courseMarks[courseNum][j] = fileInput.nextInt();
                    courseNum++;

                }
                else // course matches; ignore marks
                {
                    String pass;
                    for(int x=0;x<numStudents;x++)
                        pass = fileInput.next();
                    found = true;
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            fileInput.close();
        }
        if(found==true)
        {
            BatchGrades bg = new BatchGrades(batchName, startYear, endYear,
                    courses, courseMarks);
            writeBatchData(bg, "F:/batch_data.txt");
            System.out.println("Record deleted successfully!");
        }
        else {
            System.out.println("There is no registered course with name " + courseToDelete + ".");
            return false;
        }

        return true;

    }
    public static boolean updateCourse( String courseToFind)
    {

        return false;
    }
    public static void writeBatchData(BatchGrades batchData, String fileName)
    {
        try {
            Formatter writer = new Formatter(new File(fileName));


            String batchName;
            int startYear, endYear;

//            System.out.println("Enter batch name, start-year and end-year: ");
            batchName = batchData.getBatchName();
            startYear = batchData.getStartYear();
            endYear = batchData.getEndYear();

            writer.format("%s %s %s\n", batchName, startYear, endYear);

//            System.out.println("Enter number of courses? ");
            String[] courses =  batchData.getCourses();
            int numCourses = courses.length;

            int[][] courseGrades = batchData.getMarks();

            for(int i=0;i<courseGrades.length;i++)
            {
                writer.format("%s ", courses[i]);
                for(int j=0;j<courseGrades[i].length;j++)
                {
                    writer.format("%d ", courseGrades[i][j]);
                }
                writer.format("\n");
            }
            writer.flush();
            System.out.println("All batch data has been written to "+fileName+".");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean SearchCourse( String courseToFind, String fileName)
    {
        int numCourses = 3;
        try {
            Scanner fileInput = new Scanner(new File(fileName));
            String pass = fileInput.next(); // ignore batch
            pass = fileInput.next(); // ignore start year
            pass = fileInput.next(); // ignore end year

            String courseInFile;
            int[] courseMarks = new int[numCourses];
            int average = 0;
            boolean found = false;
            while(fileInput.hasNext())
            {
                courseInFile = fileInput.next();
                if(courseInFile.compareToIgnoreCase(courseToFind)==0) // course match; find marks average
                {
                    for(int i=0;i<numCourses;i++) {
                        courseMarks[i] = fileInput.nextInt();
                        average = average + courseMarks[i];

                    }
                    average = average/numCourses;
                    found = true;
                    break;
                }
                else // course does not match; ignore marks
                {
                    for(int i=0;i<numCourses;i++)
                        pass = fileInput.next();
                }
            }
            if(found==true)
            {
                System.out.println("Course found!");

                System.out.println("Course grades are: ");
                for(int i=0;i<numCourses;i++)
                    System.out.println(courseMarks[i]);

                System.out.println("Course average is: " + average);
            }
            else {
                System.out.println("There is no registered course with name " + courseToFind + ".");
                return false;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public static BatchGrades GetBatchData()
    {
        String batchName;
        int startYear, endYear;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter batch name, start-year and end-year: ");
        batchName = input.next();
        startYear = input.nextInt();
        endYear = input.nextInt();

        System.out.println("Enter number of courses? ");
        int numCourses = input.nextInt();
        String[] courses =  new String[numCourses];

        for(int i=0;i<numCourses;i++)
        {
            System.out.println("Enter course " + (i+1) + " name:");
            courses[i] = input.next();
        }

        System.out.println("Enter number of students? ");
        int numStudents = input.nextInt();
        int[][] courseGrades = new int[numCourses][numStudents];

        for(int i=0;i<courseGrades.length;i++)
        {
            System.out.println("Enter student "+ (i+1) +" ] marks in "+ numCourses +" courses: ");
            for(int j=0;j<courseGrades[i].length;j++)
            {
                courseGrades[i][j] = input.nextInt();
            }
        }

        return new BatchGrades(batchName, startYear, endYear,
                courses, courseGrades);
    }
}
