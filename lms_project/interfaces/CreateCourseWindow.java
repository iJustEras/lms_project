package lms_project.interfaces;

import lms_project.course_services.*;
import lms_project.user_services.*;
import lms_project.users.*;
import lms_project.content.*;

import javax.swing.*;
import java.awt.*;

public class CreateCourseWindow extends JFrame {

    private JTextField courseNameField;
    private JTextArea descriptionArea;
    private DefaultListModel<Student> studentListModel;

    public CreateCourseWindow() {
        setTitle("Create Course");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // ---- Course Info ----
        JPanel coursePanel = new JPanel(new GridLayout(4, 1, 5, 5));

        courseNameField = new JTextField();
        descriptionArea = new JTextArea(3, 20);

        coursePanel.add(new JLabel("Course Name:"));
        coursePanel.add(courseNameField);
        coursePanel.add(new JLabel("Description:"));
        coursePanel.add(new JScrollPane(descriptionArea));

        // ---- Students ----
        JPanel studentPanel = new JPanel(new BorderLayout(5, 5));
        studentListModel = new DefaultListModel<>();
        JList<Student> studentList = new JList<>(studentListModel);

        JButton addStudentButton = new JButton("Add Student");

        addStudentButton.addActionListener(e -> addStudent());

        studentPanel.add(new JLabel("Enrolled Students:"), BorderLayout.NORTH);
        studentPanel.add(new JScrollPane(studentList), BorderLayout.CENTER);
        studentPanel.add(addStudentButton, BorderLayout.SOUTH);

        // ---- Create Button ----
        JButton createButton = new JButton("Create Course");
        createButton.addActionListener(e -> createCourse());

        panel.add(coursePanel, BorderLayout.NORTH);
        panel.add(studentPanel, BorderLayout.CENTER);
        panel.add(createButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    private void addStudent() {
        String username = JOptionPane.showInputDialog(this, "Enter student username:");
        if (username != null && !username.isBlank()) {
            studentListModel.addElement((Student) UserStorage.getUser(username));
        }
    }

    private void createCourse() {
        String name = courseNameField.getText();
        String description = descriptionArea.getText();

        if (name.isBlank()) {
            JOptionPane.showMessageDialog(this, "Course name is required");
            return;
        }

        Course course = CourseManager.createCourse(name, description);

        //Enroll students
        for (int i = 0; i < studentListModel.size(); i++) {
            CourseManager.enrollStudent(studentListModel.get(i), course);
        }

        JOptionPane.showMessageDialog(this, "Course created successfully!");
        dispose();
    }
}
