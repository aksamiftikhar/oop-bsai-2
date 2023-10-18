package Lecture_12.Employee_pkg;

import java.util.ArrayList;

// Fig. 9.5: CommissionEmployeeTest.java
// CommissionEmployee class test program.
public class CommissionEmployeeTest {
   public static void main(String[] args) {
      // instantiate CommissionEmployee object
      CommissionEmployee employee = new CommissionEmployee(
         "Sue", "Jones", "222-22-2222", 10000, .06);       
//      String s = "Empoloyee data: " + employee;
//      System.out.println(s);
////
//      ArrayList<CommissionEmployee> empList = new ArrayList<>();
//      empList.add(employee);
//      empList.add(employee);
//
//      System.out.println(empList);
//
//      ArrayList<Integer> alInt = new ArrayList<>();
//      alInt.add(30);
//      alInt.add(40);
//      System.out.println(alInt);



//      // get commission employee data
//      System.out.println("Employee information obtained by get methods:");
//      System.out.printf("%n%s %s%n", "First name is",
//         employee.getFirstName());
//      System.out.printf("%s %s%n", "Last name is",
//         employee.getLastName());
//      System.out.printf("%s %s%n", "Social security number is",
//         employee.getSocialSecurityNumber());
//      System.out.printf("%s %.2f%n", "Gross sales is",
//         employee.getGrossSales());
//      System.out.printf("%s %.2f%n", "Commission rate is",
//         employee.getCommissionRate());

      employee.setGrossSales(5000);
      employee.setCommissionRate(.1);

      System.out.printf(
         "Updated employee information obtained by toString: " + employee);
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
