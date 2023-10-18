package Lecture_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Demo_Project_Lect13 {
    public static void main(String[] args) {
        Patient p = new Patient(100, "ali", 50);
    }
    // Person Class
class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

// Doctor Specialization Enum
enum Specialization {
    CARDIOLOGY, NEUROLOGY, ORTHOPEDICS, PEDIATRICS;
}

 class Patient extends Person {

    private static int counter = 0;  // static field to generate unique patient IDs
    private final int patientId;  // final since ID shouldn't change

    private String medicalHistory;

    private Bed assignedBed;


    public Patient(int patientId, String name, int age) {
        super(name, age); // Using 'super' to call the parent constructor
        this.patientId = ++counter;
    }

    @Override
    public String toString() {
        return super.toString() + ", Patient ID: " + patientId;
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
