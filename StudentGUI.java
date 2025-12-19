import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Student {
    int rollNo;
    String name;
    double grade;

    Student(int r, String n, double g) {
        rollNo = r;
        name = n;
        grade = g;
    }

    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    ArrayList<Student> students = new ArrayList<>();

    void addStudent(Student s) {
        students.add(s);
    }

    Student searchStudent(int roll) {
        for (Student s : students)
            if (s.rollNo == roll)
                return s;
        return null;
    }

    String displayStudents() {
        if (students.isEmpty()) return "No students available.";
        String r = "";
        for (Student s : students) r += s + "\n";
        return r;
    }
}

public class StudentGUI extends JFrame {

    JTextField rollField, nameField, gradeField;
    JTextArea displayArea;
    StudentManagementSystem sms = new StudentManagementSystem();

    StudentGUI() {
        setTitle("Student Management System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(4, 2));

        panel.add(new JLabel("Roll No:"));
        rollField = new JTextField();
        panel.add(rollField);

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Grade:"));
        gradeField = new JTextField();
        panel.add(gradeField);

        JButton addBtn = new JButton("Add Student");
        JButton searchBtn = new JButton("Search Student");

        panel.add(addBtn);
        panel.add(searchBtn);

        add(panel, BorderLayout.NORTH);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        addBtn.addActionListener(e -> addStudent());
        searchBtn.addActionListener(e -> searchStudent());

        setVisible(true);
    }

    void addStudent() {

        String rollText = rollField.getText().trim();
        String name = nameField.getText().trim();
        String gradeText = gradeField.getText().trim();

        // Check empty fields
        if (rollText.isEmpty() || name.isEmpty() || gradeText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required");
            return;
        }

        int roll;
        double grade;

        try {
            roll = Integer.parseInt(rollText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Roll No must be an integer");
            return;
        }

        try {
            grade = Double.parseDouble(gradeText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Grade must be a number");
            return;
        }

        sms.addStudent(new Student(roll, name, grade));

        displayArea.setText(
                "Student Added Successfully!\n\n" +
                sms.displayStudents()
        );

        // Clear fields
        rollField.setText("");
        nameField.setText("");
        gradeField.setText("");
    }


    void searchStudent() {
        try {
            int roll = Integer.parseInt(rollField.getText());
            Student s = sms.searchStudent(roll);

            if (s != null)
                displayArea.setText("Student Found:\n" + s);
            else
                displayArea.setText("Student not found");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Enter valid Roll No");
        }
    }

    public static void main(String[] args) {
        new StudentGUI();
    }
}


