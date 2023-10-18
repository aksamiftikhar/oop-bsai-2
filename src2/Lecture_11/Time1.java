// Fig. 8.1: Time1.java
// Time1 class declaration maintains the time in 24-hour format.
package Lecture_11;

public class Time1 {
   public static void main(String[] args) {
      System.out.println("Hello");
      Time1 t1 = new Time1();
      Time1 t2 = new Time1();
   }
   public static String TimeZone;
   public static void Test(){}
   static
   {
      TimeZone = "UTC-5";
      Test();
      System.out.println("Time zone has been initialized");
   }

   {
      hour = 10;
      minute = 30;
      second = 1;
      System.out.println("Time has been initialized");
   }
   private int hour; // 0 - 23  
   private int minute; // 0 - 59
   private int second; // 0 - 59
   public Time1()
   {
      System.out.println("constructor called");
   }
   // set a new time value using universal time; throw an
   // exception if the hour, minute or second is invalid
   public void setTime(int hour, int minute, int second) {
      // validate hour, minute and second
      if (hour < 0 || hour >= 24 || minute < 0 || minute >= 60 || 
         second < 0 || second >= 60) {
         this.hour = hour;
         this.minute = minute;
         this.second = second;
      }
   } 

   // convert to String in universal-time format (HH:MM:SS)
   public String toUniversalString() {
//      String s = hour + ":" + minute + ":" + second;
//      return s;
      return String.format("%02d:%02d:%02d", hour, minute, second);
   } 

   // convert to String in standard-time format (H:MM:SS AM or PM)
   public String toString() {
      return String.format("%d:%02d:%02d %s",
         ((hour == 0 || hour == 12) ? 12 : hour % 12),
         minute, second, (hour < 12 ? "AM" : "PM"));  
   } 
} 


/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/