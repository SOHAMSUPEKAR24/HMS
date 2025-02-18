import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

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
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton addPatientButton = new JButton("Add Patient");
        JButton addDoctorButton = new JButton("Add Doctor");
        JButton scheduleAppointmentButton = new JButton("Schedule Appointment");
        JButton viewPatientsButton = new JButton("View Patients");
        JButton viewDoctorsButton = new JButton("View Doctors");
        JButton viewAppointmentsButton = new JButton("View Appointments");

        

        Font buttonFont = new Font("Arial", Font.ITALIC, 14); 
        addPatientButton.setFont(buttonFont);
        addDoctorButton.setFont(buttonFont);
        scheduleAppointmentButton.setFont(buttonFont);
        viewPatientsButton.setFont(buttonFont);
        viewDoctorsButton.setFont(buttonFont);
        viewAppointmentsButton.setFont(buttonFont);

        panel.add(addPatientButton);
        panel.add(addDoctorButton);
        panel.add(scheduleAppointmentButton);
        panel.add(viewPatientsButton);
        panel.add(viewDoctorsButton);
        panel.add(viewAppointmentsButton);

        frame.add(panel);
        frame.setVisible(true);

        addPatientButton.addActionListener(e -> addPatient());
        addDoctorButton.addActionListener(e -> addDoctor());
        scheduleAppointmentButton.addActionListener(e -> scheduleAppointment());
        viewPatientsButton.addActionListener(e -> JOptionPane.showMessageDialog(null, patients));
        viewDoctorsButton.addActionListener(e -> JOptionPane.showMessageDialog(null, doctors));
        viewAppointmentsButton.addActionListener(e -> JOptionPane.showMessageDialog(null, appointments));
    }

    private static void addPatient() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));
            String name = JOptionPane.showInputDialog("Enter Name:");
            int age = Integer.parseInt(JOptionPane.showInputDialog("Enter Age:"));
            String disease = JOptionPane.showInputDialog("Enter Disease:");
            if (name == null || disease == null || name.trim().isEmpty() || disease.trim().isEmpty()) {
                throw new IllegalArgumentException("Fields cannot be empty.");
            }
            patients.add(new Patient(id, name, age, disease));
            JOptionPane.showMessageDialog(null, "Patient added successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void addDoctor() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Doctor ID:"));
            String name = JOptionPane.showInputDialog("Enter Name:");
            String specialization = JOptionPane.showInputDialog("Enter Specialization:");
            if (name == null || specialization == null || name.trim().isEmpty() || specialization.trim().isEmpty()) {
                throw new IllegalArgumentException("Fields cannot be empty.");
            }
            doctors.add(new Doctor(id, name, specialization));
            JOptionPane.showMessageDialog(null, "Doctor added successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void scheduleAppointment() {
        try {
            int patientId = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));
            int doctorId = Integer.parseInt(JOptionPane.showInputDialog("Enter Doctor ID:"));
            String date = JOptionPane.showInputDialog("Enter Appointment Date (YYYY-MM-DD):");
            if (date == null || date.trim().isEmpty()) {
                throw new IllegalArgumentException("Date cannot be empty.");
            }
            appointments.add(new Appointment(patientId, doctorId, date));
            JOptionPane.showMessageDialog(null, "Appointment scheduled successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}