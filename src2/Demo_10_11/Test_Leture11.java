package Demo_10_11;

public class Test_Leture11 {

    public static void main(String[] args) {
        System.out.println("Testing Doctor Class...");

        // Testing static initialization block
        System.out.println("Allowed specializations: " + Doctor.getAllowedSpecializations());

        // Testing non-static initialization block and default specialization
        System.out.println("\nCreating a doctor without specifying specialization:");
        Doctor doc1 = new Doctor("Dr. Smith", 45);
        System.out.println("Doctor Name: " + doc1.getName());
        System.out.println("Specialization: " + doc1.getSpecialization());

        // Testing setSpecialization with valid specialization
        System.out.println("\nCreating a doctor with valid specialization 'Cardiology':");
        Doctor doc2 = new Doctor("Dr. Williams", 50, "Cardiology");
        System.out.println("Doctor Name: " + doc2.getName());
        System.out.println("Specialization: " + doc2.getSpecialization());

        // Testing setSpecialization with invalid specialization
        System.out.println("\nCreating a doctor with invalid specialization 'Dentistry':");
        Doctor doc3 = new Doctor("Dr. Johnson", 40, "Dentistry");
        System.out.println("Doctor Name: " + doc3.getName());
        System.out.println("Specialization: " + doc3.getSpecialization());
    }
}

