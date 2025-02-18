import java.util.*;

// Patient class to store and display patient details
class Patient {
    int id;           // Patient ID
    String name;      // Patient's name
    int age;          // Patient's age
    String disease;   // Patient's disease

    // Constructor to initialize Patient object with given details
    public Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    // Method to display Patient details
    public void displayPatient() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Disease: " + disease);
    }
}

// Doctor class to store and display doctor details
class Doctor {
    int id;               // Doctor ID
    String name;          // Doctor's name
    String specialization; // Doctor's specialization

    // Constructor to initialize Doctor object with given details
    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    // Method to display Doctor details
    public void displayDoctor() {
        System.out.println("ID: " + id + ", Name: " + name + ", Specialization: " + specialization);
    }
}

// Appointment class to store and display appointment details
class Appointment {
    int patientId;  // Patient's ID
    int doctorId;   // Doctor's ID
    String Month;   // Appointment month
    int date;       // Appointment date

    // Constructor to initialize Appointment object with given details
    public Appointment(int patientId, int doctorId, String Month, int date) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.Month = Month;
        this.date = date;
    }

    // Method to display Appointment details
    public void displayAppointment() {
        System.out.println("Patient ID: " + patientId + " | Doctor ID: " + doctorId + " | Month: " + Month + " | Date: " + date);
    }
}

// Main class for the Hospital Management System
public class HospitalManagementSystem {
    // Lists to store Patients, Doctors, and Appointments
    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();
    
    // Scanner for user input
    static Scanner sc = new Scanner(System.in);

    // Array for predefined specializations
    static final String[] SPECIALIZATIONS = {
        "Cardiologist", "Neurologist", "Dermatologist", "Pediatrician", "Oncologist", 
        "Orthopedic", "Psychiatrist", "ENT Specialist", "Gynecologist", "General Physician"
    };

    // Main method to display the menu and handle user inputs
    public static void main(String[] args) {
        while (true) {
            // Displaying menu options for the user
            System.out.println("\nHospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Patients");
            System.out.println("5. View Doctors");
            System.out.println("6. View Appointments");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            // Get valid integer input from the user
            int choice = getValidInteger();

            // Switch case to perform actions based on the user's choice
            switch (choice) {
                case 1:
                    addPatient(); // Add new patient
                    break;
                case 2:
                    addDoctor(); // Add new doctor
                    break;
                case 3:
                    scheduleAppointment(); // Schedule appointment
                    break;
                case 4:
                    viewPatients(); // View list of patients
                    break;
                case 5:
                    viewDoctors(); // View list of doctors
                    break;
                case 6:
                    viewAppointments(); // View list of appointments
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // Method to add a new patient
    public static void addPatient() {
        // Get patient details from the user
        System.out.print("Enter Patient ID: ");
        int id = getValidInteger();

        System.out.print("Enter Name (Only letters & spaces): ");
        String name = getValidString();

        System.out.print("Enter Age (1-122): ");
        int age = getValidAge();

        System.out.print("Enter Disease (Only letters & spaces): ");
        String disease = getValidDisease();

        // Add the new patient to the patients list
        patients.add(new Patient(id, name, age, disease));
        System.out.println("Patient added successfully!");
    }

    // Method to add a new doctor
    public static void addDoctor() {
        // Get doctor details from the user
        System.out.print("Enter Doctor ID: ");
        int id = getValidInteger();

        System.out.print("Enter Name (Only letters & spaces): ");
        String name = getValidString();

        // Display available specializations
        System.out.println("Select Specialization:");
        for (int i = 0; i < SPECIALIZATIONS.length; i++) {
            System.out.println((i + 1) + ". " + SPECIALIZATIONS[i]);
        }
        System.out.print("Enter choice (1-" + SPECIALIZATIONS.length + "): ");
        String specialization = getValidSpecialization();

        // Add the new doctor to the doctors list
        doctors.add(new Doctor(id, name, specialization));
        System.out.println("Doctor added successfully!");
    }

    // Method to schedule an appointment
    public static void scheduleAppointment() {
        // Get patient ID from the user
        System.out.print("Enter Patient ID: ");
        int patientId = getValidInteger();

        // Check if the patient exists
        if (!isPatientExists(patientId)) {
            System.out.println("Error: Patient ID not found!");
            return;
        }

        // Get doctor ID from the user
        System.out.print("Enter Doctor ID: ");
        int doctorId = getValidInteger();

        // Check if the doctor exists
        if (!isDoctorExists(doctorId)) {
            System.out.println("Error: Doctor ID not found!");
            return;
        }

        // Get the appointment month and date
        System.out.println("Enter Appointment Month: ");
        String Month = getValidString();

        System.out.println("Enter Appointment Date");
        int date = getValidInteger();

        // Add the appointment to the appointments list
        appointments.add(new Appointment(patientId, doctorId, Month, date));
        System.out.println("Appointment scheduled successfully!");
    }

    // Method to view all patients
    public static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients available.");
        } else {
            System.out.println("\nList of Patients:");
            for (Patient p : patients) {
                p.displayPatient(); // Display each patient's details
            }
        }
    }

    // Method to view all doctors
    public static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
        } else {
            System.out.println("\nList of Doctors:");
            for (Doctor d : doctors) {
                d.displayDoctor(); // Display each doctor's details
            }
        }
    }

    // Method to view all appointments
    public static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments available.");
        } else {
            System.out.println("\nList of Appointments:");
            for (Appointment a : appointments) {
                a.displayAppointment(); // Display each appointment's details
            }
        }
    }

    // Method to get a valid integer input from the user
    public static int getValidInteger() {
        while (true) {
            try {
                int num = sc.nextInt();
                sc.nextLine();
                return num; // Return the valid integer
            } catch (InputMismatchException e) {
                System.out.print("Invalid input! Enter a valid number: ");
                sc.nextLine(); // Clear invalid input
            }
        }
    }

    // Method to get a valid age input (1-122)
    public static int getValidAge() {
        while (true) {
            int age = getValidInteger();
            if (age >= 1 && age <= 122) {
                return age; // Return valid age
            }
            System.out.print("Invalid age! Enter a valid age (1-122): ");
        }
    }

    // Method to get a valid string input (only letters & spaces)
    public static String getValidString() {
        while (true) {
            String input = sc.nextLine().trim();
            if (!input.isEmpty() && input.matches("^[a-zA-Z ]+$")) {
                return input; // Return valid string
            }
            System.out.print("Invalid input! Enter only letters and spaces: ");
        }
    }

    // Method to get a valid disease input (only letters & spaces)
    public static String getValidDisease() {
        while (true) {
            String input = sc.nextLine().trim();
            if (!input.isEmpty() && input.matches("^[a-zA-Z ]+$")) {
                return input; // Return valid disease
            }
            System.out.print("Invalid disease! Enter only letters and spaces: ");
        }
    }

    // Method to get a valid specialization from the predefined list
    public static String getValidSpecialization() {
        while (true) {
            int choice = getValidInteger();
            if (choice >= 1 && choice <= SPECIALIZATIONS.length) {
                return SPECIALIZATIONS[choice - 1]; // Return valid specialization
            }
            System.out.print("Invalid choice! Select a valid specialization (1-" + SPECIALIZATIONS.length + "): ");
        }
    }

    // Method to check if a patient exists based on ID
    public static boolean isPatientExists(int id) {
        return patients.stream().anyMatch(p -> p.id == id); // Return true if patient exists
    }

    // Method to check if a doctor exists based on ID
    public static boolean isDoctorExists(int id) {
        return doctors.stream().anyMatch(d -> d.id == id); // Return true if doctor exists
    }
}
