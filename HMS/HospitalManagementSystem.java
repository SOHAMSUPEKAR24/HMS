import java.util.ArrayList;
import java.util.Scanner;

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
    String date;

    public Appointment(int patientId, int doctorId, String date) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    public void displayAppointment() {
        System.out.println("Patient ID: " + patientId + " | Doctor ID: " + doctorId + " | Date: " + date);
    }
}

public class HospitalManagementSystem {
    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

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
            int choice = sc.nextInt();
            sc.nextLine();

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
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();
        patients.add(new Patient(id, name, age, disease));
        System.out.println("Patient added successfully!");
    }

    public static void addDoctor() {
        System.out.print("Enter Doctor ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = sc.nextLine();
        doctors.add(new Doctor(id, name, specialization));
        System.out.println("Doctor added successfully!");
    }

    public static void scheduleAppointment() {
        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();
        System.out.print("Enter Doctor ID: ");
        int doctorId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String date = sc.nextLine();
        appointments.add(new Appointment(patientId, doctorId, date));
        System.out.println("Appointment scheduled successfully!");
    }

    public static void viewPatients() {
        System.out.println("\nList of Patients:");
        for (Patient p : patients) {
            p.displayPatient();
        }
    }

    public static void viewDoctors() {
        System.out.println("\nList of Doctors:");
        for (Doctor d : doctors) {
            d.displayDoctor();
        }
    }

    public static void viewAppointments() {
        System.out.println("\nList of Appointments:");
        for (Appointment a : appointments) {
            a.displayAppointment();
        }
    }
}
