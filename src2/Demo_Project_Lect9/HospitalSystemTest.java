package Demo_Project_Lect9;
import java.util.Scanner;
import java.util.ArrayList;

public class HospitalSystemTest {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Doctor> doctors = new ArrayList<>();
    private static final ArrayList<Patient> patients = new ArrayList<>();
    private static final ArrayList<Appointment> appointments = new ArrayList<>();
    private static final ArrayList<Department> departments = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Register Doctor");
            System.out.println("2. Register Patient");
            System.out.println("3. Create Department");
            System.out.println("4. Assign Doctor to Department");
            System.out.println("5. Add Doctor Availability");
            System.out.println("6. Schedule Appointment");
            System.out.println("7. Add Notes to Appointment");
            System.out.println("8. View Appointments");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    registerDoctor();
                    break;
                case 2:
                    registerPatient();
                    break;
                case 3:
                    createDepartment();
                    break;
                case 4:
                    assignDoctorToDepartment();
                    break;
                case 5:
                    addDoctorAvailability();
                    break;
                case 6:
                    scheduleAppointment();
                    break;
                case 7:
                    addNotesToAppointment();
                    break;
                case 8:
                    viewAppointments();
                    break;
                case 0:
                    System.out.println("Exiting System...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter again.");
            }
        } while (choice != 0);
    }

    private static void registerDoctor() {
        System.out.print("Enter Doctor's Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Doctor's Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Doctor's Specialization: ");
        String specialization = scanner.next();
        Doctor doctor = new Doctor(name, age, specialization);
        doctors.add(doctor);
        System.out.println("Doctor Registered Successfully with ID: " + doctor.getDoctorId());
    }

    private static void registerPatient() {
        System.out.print("Enter Patient's Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Patient's Age: ");
        int age = scanner.nextInt();
        Patient patient = new Patient(name, age, "");
        patients.add(patient);
        System.out.println("Patient Registered Successfully with ID: " + patient.getPatientId());
    }

    private static void createDepartment() {
        System.out.print("Enter Department Name: ");
        String name = scanner.nextLine();
        Department department = new Department(name);
        departments.add(department);
        System.out.println("Department Created Successfully!");
    }

    private static void assignDoctorToDepartment() {
        // Display available departments
        System.out.println("Available Departments:");
        for (int i = 0; i < departments.size(); i++) {
            System.out.println((i + 1) + ". " + departments.get(i).getName());
        }

        System.out.print("Select Department (by number): ");
        int deptChoice = scanner.nextInt();
        Department selectedDept = departments.get(deptChoice - 1);

        // Display available doctors
        System.out.println("Available Doctors:");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". " + doctors.get(i).getName());
        }
        System.out.print("Select Doctor to assign (by number): ");
        int docChoice = scanner.nextInt();
        Doctor selectedDoc = doctors.get(docChoice - 1);

        selectedDept.addDoctor(selectedDoc);
        System.out.println("Doctor Assigned to Department Successfully!");
    }

    private static void addDoctorAvailability() {
        // Display available doctors
        System.out.println("Available Doctors:");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". " + doctors.get(i).getName());
        }
        System.out.print("Select Doctor (by number): ");
        int docChoice = scanner.nextInt();
        Doctor selectedDoc = doctors.get(docChoice - 1);
        System.out.print("Enter Start Time (e.g., 10:00 AM): ");
        String startTime = scanner.next();
        System.out.print("Enter End Time (e.g., 11:00 AM): ");
        String endTime = scanner.next();
        TimeSlot slot = new TimeSlot(startTime, endTime);
        selectedDoc.addTimeSlot(slot);
        System.out.println("Availability Added Successfully!");
    }

    private static void scheduleAppointment() {
        // Display available doctors
        System.out.println("Available Doctors:");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". " + doctors.get(i).getName());
        }
        System.out.print("Select Doctor (by number): ");
        int docChoice = scanner.nextInt();
        Doctor selectedDoc = doctors.get(docChoice - 1);

        // Display available patients
        System.out.println("Available Patients:");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ". " + patients.get(i).getName());
        }
        System.out.print("Select Patient (by number): ");
        int patChoice = scanner.nextInt();
        Patient selectedPatient = patients.get(patChoice - 1);

        System.out.print("Enter Appointment Date (e.g., 12-Oct-2023): ");
        String date = scanner.next();

        Appointment appointment = new Appointment(selectedPatient, selectedDoc, date);
        appointments.add(appointment);
        System.out.println("Appointment Scheduled Successfully!");
    }

    private static void addNotesToAppointment() {
        // Display available appointments
        System.out.println("Available Appointments:");
        for (int i = 0; i < appointments.size(); i++) {
            System.out.println((i + 1) + ". " + appointments.get(i).getPatient().getName() + " with " + appointments.get(i).getDoctor().getName() + " on " + appointments.get(i).getAppointmentDate());
        }
        System.out.print("Select Appointment (by number) to add notes: ");
        int appChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        Appointment selectedAppointment = appointments.get(appChoice - 1);

        System.out.print("Enter Notes (comma separated): ");
        String[] newNotes = scanner.nextLine().split(",");
        selectedAppointment.addNotes(newNotes);

        System.out.println("Notes Added Successfully!");
    }

    private static void viewAppointments() {
        System.out.println("Scheduled Appointments:");
        for (Appointment appointment : appointments) {
            System.out.println(appointment.getPatient().getName() + " has an appointment with " + appointment.getDoctor().getName() + " on " + appointment.getAppointmentDate());
        }
    }
}
