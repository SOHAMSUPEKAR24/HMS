import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Disease: " + disease;
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

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Specialization: " + specialization;
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

    public String toString() {
        return "Patient ID: " + patientId + " | Doctor ID: " + doctorId + " | Date: " + date;
    }
}

public class HospitalManagementSystem {
    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hospital Management System");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(new GridLayout(6, 1));
        
        JButton addPatientButton = new JButton("Add Patient");
        JButton addDoctorButton = new JButton("Add Doctor");
        JButton scheduleAppointmentButton = new JButton("Schedule Appointment");
        JButton viewPatientsButton = new JButton("View Patients");
        JButton viewDoctorsButton = new JButton("View Doctors");
        JButton viewAppointmentsButton = new JButton("View Appointments");

        panel.add(addPatientButton);
        panel.add(addDoctorButton);
        panel.add(scheduleAppointmentButton);
        panel.add(viewPatientsButton);
        panel.add(viewDoctorsButton);
        panel.add(viewAppointmentsButton);
        
        addPatientButton.addActionListener(e -> addPatient());
        addDoctorButton.addActionListener(e -> addDoctor());
        scheduleAppointmentButton.addActionListener(e -> scheduleAppointment());
        viewPatientsButton.addActionListener(e -> JOptionPane.showMessageDialog(null, patients));
        viewDoctorsButton.addActionListener(e -> JOptionPane.showMessageDialog(null, doctors));
        viewAppointmentsButton.addActionListener(e -> JOptionPane.showMessageDialog(null, appointments));
    }

    private static void addPatient() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));
        String name = JOptionPane.showInputDialog("Enter Name:");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter Age:"));
        String disease = JOptionPane.showInputDialog("Enter Disease:");
        patients.add(new Patient(id, name, age, disease));
        JOptionPane.showMessageDialog(null, "Patient added successfully!");
    }

    private static void addDoctor() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Doctor ID:"));
        String name = JOptionPane.showInputDialog("Enter Name:");
        String specialization = JOptionPane.showInputDialog("Enter Specialization:");
        doctors.add(new Doctor(id, name, specialization));
        JOptionPane.showMessageDialog(null, "Doctor added successfully!");
    }

    private static void scheduleAppointment() {
        int patientId = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));
        int doctorId = Integer.parseInt(JOptionPane.showInputDialog("Enter Doctor ID:"));
        String date = JOptionPane.showInputDialog("Enter Appointment Date (YYYY-MM-DD):");
        appointments.add(new Appointment(patientId, doctorId, date));
        JOptionPane.showMessageDialog(null, "Appointment scheduled successfully!");
    }
}
