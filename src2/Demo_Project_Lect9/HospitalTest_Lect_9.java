package Demo_Project_Lect9;

import java.util.ArrayList;
import java.util.Arrays;

public class HospitalTest_Lect_9 {

    public static void main(String[] args) {
        // 1. Registering Doctors
        Doctor[] doctors = new Doctor[3];
        doctors[0] = new Doctor("Dr. Test", 45, "Cardiologist");
        doctors[1] = new Doctor("Dr. Adams", 40, "Neurologist");
        doctors[2] = new Doctor("Dr. Green", 38, "Orthopedic");

        // 2. Registering Patients
        Patient[] patients = new Patient[2];
        patients[0] = new Patient("John Doe", 30, "Mild allergy to penicillin");
        patients[1] = new Patient("Jane Smith", 25, "No known allergies");

        // 3. Scheduling Appointments
        Appointment[] appointments = new Appointment[2];
        appointments[0] = new Appointment(patients[0], doctors[0], "10-Oct-2023");
        appointments[1] = new Appointment(patients[1], doctors[1], "11-Oct-2023");

        // Print details
        System.out.println("Scheduled Appointments:");
        for (Appointment appointment : appointments) {
            System.out.println(appointment.getPatient().getName() + " has an appointment with " +
                    appointment.getDoctor().getName() + " on " +
                    appointment.getAppointmentDate());
        }

        // 4. Demonstrating the reference nature of array variables
        Patient[] patientCopy = patients;  // This will not create a new array, but rather reference the same array
        patientCopy[0].setName("Johnathan Doe");  // Modifying the patient's name using the copy reference

        // Print details again to see the changes
        System.out.println("\nUpdated Appointments:");
        for (Appointment appointment : appointments) {
            System.out.println(appointment.getPatient().getName() + " has an appointment with " +
                    appointment.getDoctor().getName() + " on " +
                    appointment.getAppointmentDate());
        }
    }
}

class Patient {
    private static int counter = 0;  // static field to generate unique patient IDs
    private final int patientId;  // final since ID shouldn't change
    private String name;
    private int age;
    private String medicalHistory;



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

}

class Doctor {
    private static int counter = 0;  // static field to generate unique doctor IDs
    private final int doctorId;  // final since ID shouldn't change
    private String name;
    private int age;
    private String specialization;

    private ArrayList<TimeSlot> availableSlots;
    private String department;

    public Doctor(String name, int age, String specialization) {
        this.doctorId = ++counter;  // Increment and assign unique doctor ID
        this.name = name;
        this.age = age;
        this.specialization = specialization;
        this.availableSlots = new ArrayList<TimeSlot>();
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

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
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


// TimeSlot Class
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

// Department Class
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
