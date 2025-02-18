import java.util.*;

class Patient {
    int id;
    String name;
    int age;
    String disease;

    public Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public void displayPatient() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Disease: " + disease);
    }
}

class Doctor {
    int id;
    String name;
    String specialization;

    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public void displayDoctor() {
        System.out.println("ID: " + id + ", Name: " + name + ", Specialization: " + specialization);
    }
}

class Appointment {
    int patientId;
    int doctorId;
    String Month;
    int date;

    public Appointment(int patientId, int doctorId, String Month, int date) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.Month = Month;
        this.date = date;
    }

    public void displayAppointment() {
        System.out.println("Patient ID: " + patientId + " | Doctor ID: " + doctorId + " | Month: " + Month + " | Date: " + date);
    }
}

public class HospitalManagementSystem {
    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static final String[] SPECIALIZATIONS = {
        "Cardiologist", "Neurologist", "Dermatologist", "Pediatrician", "Oncologist", 
        "Orthopedic", "Psychiatrist", "ENT Specialist", "Gynecologist", "General Physician"
    };

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Patients");
            System.out.println("5. View Doctors");
            System.out.println("6. View Appointments");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = getValidInteger();

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    addDoctor();
                    break;
                case 3:
                    scheduleAppointment();
                    break;
                case 4:
                    viewPatients();
                    break;
                case 5:
                    viewDoctors();
                    break;
                case 6:
                    viewAppointments();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    public static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = getValidInteger();

        System.out.print("Enter Name (Only letters & spaces): ");
        String name = getValidString();

        System.out.print("Enter Age (1-122): ");
        int age = getValidAge();

        System.out.print("Enter Disease (Only letters & spaces): ");
        String disease = getValidDisease();

        patients.add(new Patient(id, name, age, disease));
        System.out.println("Patient added successfully!");
    }

    public static void addDoctor() {
        System.out.print("Enter Doctor ID: ");
        int id = getValidInteger();

        System.out.print("Enter Name (Only letters & spaces): ");
        String name = getValidString();

        System.out.println("Select Specialization:");
        for (int i = 0; i < SPECIALIZATIONS.length; i++) {
            System.out.println((i + 1) + ". " + SPECIALIZATIONS[i]);
        }
        System.out.print("Enter choice (1-" + SPECIALIZATIONS.length + "): ");
        String specialization = getValidSpecialization();

        doctors.add(new Doctor(id, name, specialization));
        System.out.println("Doctor added successfully!");
    }

    public static void scheduleAppointment() {
        System.out.print("Enter Patient ID: ");
        int patientId = getValidInteger();

        if (!isPatientExists(patientId)) {
            System.out.println("Error: Patient ID not found!");
            return;
        }

        System.out.print("Enter Doctor ID: ");
        int doctorId = getValidInteger();

        if (!isDoctorExists(doctorId)) {
            System.out.println("Error: Doctor ID not found!");
            return;
        }

        System.out.println("Enter Appointment Month: ");
        String Month = getValidString();

        System.out.println("Enter Appointment Date");
        int date = getValidInteger();

        appointments.add(new Appointment(patientId, doctorId, Month, date));
        System.out.println("Appointment scheduled successfully!");
    }

    public static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients available.");
        } else {
            System.out.println("\nList of Patients:");
            for (Patient p : patients) {
                p.displayPatient();
            }
        }
    }

    public static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
        } else {
            System.out.println("\nList of Doctors:");
            for (Doctor d : doctors) {
                d.displayDoctor();
            }
        }
    }

    public static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments available.");
        } else {
            System.out.println("\nList of Appointments:");
            for (Appointment a : appointments) {
                a.displayAppointment();
            }
        }
    }

    public static int getValidInteger() {
        while (true) {
            try {
                int num = sc.nextInt();
                sc.nextLine();
                return num;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input! Enter a valid number: ");
                sc.nextLine();
            }
        }
    }

    public static int getValidAge() {
        while (true) {
            int age = getValidInteger();
            if (age >= 1 && age <= 122) {
                return age;
            }
            System.out.print("Invalid age! Enter a valid age (1-122): ");
        }
    }

    public static String getValidString() {
        while (true) {
            String input = sc.nextLine().trim();
            if (!input.isEmpty() && input.matches("^[a-zA-Z ]+$")) {
                return input;
            }
            System.out.print("Invalid input! Enter only letters and spaces: ");
        }
    }
    

    public static String getValidDisease() {
        while (true) {
            String input = sc.nextLine().trim();
            if (!input.isEmpty() && input.matches("^[a-zA-Z ]+$")) {
                return input;
            }
            System.out.print("Invalid disease! Enter only letters and spaces: ");
        }
    }

    public static String getValidSpecialization() {
        while (true) {
            int choice = getValidInteger();
            if (choice >= 1 && choice <= SPECIALIZATIONS.length) {
                return SPECIALIZATIONS[choice - 1];
            }
            System.out.print("Invalid choice! Select a valid specialization (1-" + SPECIALIZATIONS.length + "): ");
        }
    }

    public static boolean isPatientExists(int id) {
        return patients.stream().anyMatch(p -> p.id == id);
    }

    public static boolean isDoctorExists(int id) {
        return doctors.stream().anyMatch(d -> d.id == id);
    }
}
