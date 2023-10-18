package Demo_10_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Demo_Project_Lect10 {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Doctor> doctors = new ArrayList<>();
    private static final ArrayList<Patient> patients = new ArrayList<>();
    private static final ArrayList<Appointment> appointments = new ArrayList<>();
    private static final ArrayList<Department> departments = new ArrayList<>();

    private static final ArrayList<Ward> wards = new ArrayList<>();  // To manage all the wards


    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Register Demo_10.Doctor");
            System.out.println("2. Register Demo_10.Patient");
            System.out.println("3. Create Demo_10.Department");
            System.out.println("4. Assign Demo_10.Doctor to Demo_10.Department");
            System.out.println("5. Add Demo_10.Doctor Availability");
            System.out.println("6. Schedule Demo_10.Appointment");
            System.out.println("7. Add Notes to Demo_10.Appointment");
            System.out.println("8. View Appointments");
            System.out.println("9. Admit Demo_10.Patient");
            System.out.println("10. Discharge Demo_10.Patient");
            System.out.println("11. View Demo_10.Bed Occupancy in Wards");
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
                case 9:
                    admitPatient();
                    break;
                case 10:
                    dischargePatient();
                    break;
                case 11:
                    viewBedOccupancy();
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
        System.out.print("Enter Demo_10.Doctor's Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Demo_10.Doctor's Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Demo_10.Doctor's Specialization: ");
        String specialization = scanner.next();
        Doctor doctor = new Doctor(name, age, specialization);
        doctors.add(doctor);
        System.out.println("Demo_10.Doctor Registered Successfully with ID: " + doctor.getDoctorId());
    }

    private static void registerPatient() {
        System.out.print("Enter Demo_10.Patient's Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Demo_10.Patient's Age: ");
        int age = scanner.nextInt();
        Patient patient = new Patient(name, age, "");
        patients.add(patient);
        System.out.println("Demo_10.Patient Registered Successfully with ID: " + patient.getPatientId());
    }

    private static void createDepartment() {
        System.out.print("Enter Demo_10.Department Name: ");
        String name = scanner.nextLine();
        Department department = new Department(name);
        departments.add(department);
        System.out.println("Demo_10.Department Created Successfully!");
    }

    private static void assignDoctorToDepartment() {
        // Display available departments
        System.out.println("Available Departments:");
        for (int i = 0; i < departments.size(); i++) {
            System.out.println((i + 1) + ". " + departments.get(i).getName());
        }
        System.out.print("Select Demo_10.Department (by number): ");
        int deptChoice = scanner.nextInt();
        Department selectedDept = departments.get(deptChoice - 1);

        // Display available doctors
        System.out.println("Available Doctors:");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". " + doctors.get(i).getName());
        }
        System.out.print("Select Demo_10.Doctor to assign (by number): ");
        int docChoice = scanner.nextInt();
        Doctor selectedDoc = doctors.get(docChoice - 1);

        selectedDept.addDoctor(selectedDoc);
        System.out.println("Demo_10.Doctor Assigned to Demo_10.Department Successfully!");
    }

    private static void addDoctorAvailability() {
        // Display available doctors
        System.out.println("Available Doctors:");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". " + doctors.get(i).getName());
        }
        System.out.print("Select Demo_10.Doctor (by number): ");
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
        System.out.print("Select Demo_10.Doctor (by number): ");
        int docChoice = scanner.nextInt();
        Doctor selectedDoc = doctors.get(docChoice - 1);

        // Display available patients
        System.out.println("Available Patients:");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ". " + patients.get(i).getName());
        }
        System.out.print("Select Demo_10.Patient (by number): ");
        int patChoice = scanner.nextInt();
        Patient selectedPatient = patients.get(patChoice - 1);

        System.out.print("Enter Demo_10.Appointment Date (e.g., 12-Oct-2023): ");
        String date = scanner.next();

        Appointment appointment = new Appointment(selectedPatient, selectedDoc, date);
        appointments.add(appointment);
        System.out.println("Demo_10.Appointment Scheduled Successfully!");
    }

    private static void addNotesToAppointment() {
        // Display available appointments
        System.out.println("Available Appointments:");
        for (int i = 0; i < appointments.size(); i++) {
            System.out.println((i + 1) + ". " + appointments.get(i).getPatient().getName() + " with " + appointments.get(i).getDoctor().getName() + " on " + appointments.get(i).getAppointmentDate());
        }
        System.out.print("Select Demo_10.Appointment (by number) to add notes: ");
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

    private static void admitPatient() {
        // Display available patients
        System.out.println("Available Patients:");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ". " + patients.get(i).getName());
        }
        System.out.print("Select Demo_10.Patient (by number) for admission: ");
        int patChoice = scanner.nextInt();
        Patient selectedPatient = patients.get(patChoice - 1);

        // Display available wards
        System.out.println("Available Wards:");
        for (int i = 0; i < wards.size(); i++) {
            System.out.println((i + 1) + ". " + wards.get(i).getWardName());
        }
        System.out.print("Select Demo_10.Ward (by number): ");
        int wardChoice = scanner.nextInt();
        Ward selectedWard = wards.get(wardChoice - 1);

        Bed availableBed = selectedWard.findAvailableBed();
        if (availableBed != null) {
            selectedPatient.setAssignedBed(availableBed);
            availableBed.occupyBed();
            System.out.println("Demo_10.Patient admitted successfully and assigned Demo_10.Bed No: " + availableBed.getBedNumber());
        } else {
            System.out.println("Sorry, no available bed in the selected ward.");
        }
    }

    private static void dischargePatient() {
        System.out.print("Enter Demo_10.Patient ID for discharge: ");
        int patientId = scanner.nextInt();
        Patient patientToDischarge = null;
        for (Patient patient : patients) {
            if (patient.getPatientId() == patientId) {
                patientToDischarge = patient;
                break;
            }
        }

        if (patientToDischarge != null && patientToDischarge.getAssignedBed() != null) {
            patientToDischarge.releaseBed();
            System.out.println("Demo_10.Patient discharged and bed released successfully.");
        } else {
            System.out.println("Demo_10.Patient not found or not currently admitted.");
        }
    }

    private static void viewBedOccupancy() {
        System.out.println("Demo_10.Bed Occupancy in Wards:");
        for (Ward ward : wards) {
            System.out.println("Demo_10.Ward: " + ward.getWardName());
            Bed[][] beds = ward.getBeds();
            for (int i = 0; i < beds.length; i++) {
                for (int j = 0; j < beds[i].length; j++) {
                    String status = beds[i][j].isOccupied() ? "Occupied" : "Available";
                    System.out.print("Room " + (i + 1) + ", Demo_10.Bed " + beds[i][j].getBedNumber() + ": " + status + " | ");
                }
                System.out.println();
            }
        }
    }

}


class Patient {
    private static int counter = 0;  // static field to generate unique patient IDs
    private final int patientId;  // final since ID shouldn't change
    private String name;
    private int age;
    private String medicalHistory;

    private Bed assignedBed;



    public Patient(String name, int age, String medicalHistory) {
        this.patientId = ++counter;  // Increment and assign unique patient ID
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
    }

    // Getters and Setters
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public Bed getAssignedBed() {
        return assignedBed;
    }

    public void setAssignedBed(Bed assignedBed) {
        this.assignedBed = assignedBed;
    }

    public void releaseBed() {
        if (assignedBed != null) {
            assignedBed.releaseBed();
            assignedBed = null;
        }
    }
}

class Doctor {
    private static int counter = 0;  // static field to generate unique doctor IDs
    private final int doctorId ;  // final since ID shouldn't change
    private String name;
    private int age;
    private String specialization;

    private ArrayList<TimeSlot> availableSlots;
    private String department;

    private static ArrayList<String> allowedSpecializations = new ArrayList<>();

    // Static initialization block
    static {
        allowedSpecializations.add("General");
        allowedSpecializations.add("Cardiology");
        allowedSpecializations.add("Neurology");
        allowedSpecializations.add("Orthopedics");
        System.out.println("Static init block: Allowed specializations initialized.");
    }

    // Non-static initialization block
    {
        System.out.println("Non-static init block: Doctor object is being created.");
    }


    public Doctor(String name, int age, String specialization) {
        this.doctorId = ++counter;  // Increment and assign unique doctor ID
        this.name = name;
        this.age = age;
        this.availableSlots = new ArrayList<TimeSlot>();
        setSpecialization(specialization);

    }

    public Doctor(String name, int age) {
        this(name, age, "General");  // Default to "General" specialization
        this.name = "ab";
    }

    // Getters and Setters
    public int getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialization() {
        return specialization;
    }

    // Central setter for specialization
    public void setSpecialization(String specialization) {
        if (allowedSpecializations.contains(specialization)) {
            this.specialization = specialization;
        } else {
            System.out.println("Invalid specialization. Setting to 'General'.");
            this.specialization = "General";
        }
    }

    public static ArrayList<String> getAllowedSpecializations() {
        return allowedSpecializations;
    }

    public void addTimeSlot(TimeSlot slot) {
        this.availableSlots.add(slot);
    }

    public ArrayList<TimeSlot> getAvailableSlots() {
        return availableSlots;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}


// Demo_10.TimeSlot Class
class TimeSlot {
    private String startTime;
    private String endTime;

    public TimeSlot(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}

// Demo_10.Department Class
class Department {
    private String name;
    private ArrayList<Doctor> doctors;

    public Department(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
        doctor.setDepartment(this.name);  // Set department for doctor
    }

    // ... (getters and setters)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }
}

class Appointment {
    private static int counter = 0;  // static field to generate unique appointment IDs
    private final int appointmentId;  // final since ID shouldn't change
    private Patient patient;
    private Doctor doctor;
    private String appointmentDate;
    private String[] notes;

    public Appointment(Patient patient, Doctor doctor, String appointmentDate) {
        this.appointmentId = ++counter;  // Increment and assign unique appointment ID
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
    }

    // Getters and Setters
    public int getAppointmentId() {
        return appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    // Add notes to the appointment using variable-length arguments
    public void addNotes(String... newNotes) {
        if (notes == null) {
            notes = newNotes;
        } else {
            int oldLength = notes.length;
            String[] tempNotes = new String[oldLength + newNotes.length];
            System.arraycopy(notes, 0, tempNotes, 0, oldLength);
            System.arraycopy(newNotes, 0, tempNotes, oldLength, newNotes.length);
            notes = tempNotes;
        }
    }

    public boolean hasNote(String note) {
        return Arrays.binarySearch(notes, note) >= 0;
    }
}

 class Bed {
    private int bedNumber;
    private boolean isOccupied;

    public Bed(int bedNumber) {
        this.bedNumber = bedNumber;
        this.isOccupied = false;
    }

    public int getBedNumber() {
        return bedNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void occupyBed() {
        this.isOccupied = true;
    }

    public void releaseBed() {
        this.isOccupied = false;
    }
}

 class Ward {
    private String wardName;
    private Bed[][] beds;

    public Ward(String wardName, int numOfRooms, int bedsPerRoom) {
        this.wardName = wardName;
        this.beds = new Bed[numOfRooms][bedsPerRoom];
        initializeBeds();
    }

     public Bed[][] getBeds() {
         return beds;
     }

     private void initializeBeds() {
        for (int i = 0; i < beds.length; i++) {
            for (int j = 0; j < beds[i].length; j++) {
                beds[i][j] = new Bed((i * beds[i].length) + j + 1); // unique bed numbers
            }
        }
    }

    public Bed findAvailableBed() {
        for (int i = 0; i < beds.length; i++) {
            for (int j = 0; j < beds[i].length; j++) {
                if (!beds[i][j].isOccupied()) {
                    return beds[i][j];
                }
            }
        }
        return null; // No available bed found
    }

    public String getWardName() {
        return wardName;
    }
}
