package lms_project.interfaces;

import lms_project.course_services.*;
import lms_project.user_services.*;
import lms_project.users.*;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("LMS - Main Menu");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JButton loginButton = new JButton("Login");
        JButton exitButton = new JButton("Exit");

        loginButton.addActionListener(e -> openLogin());
        exitButton.addActionListener(e -> System.exit(0));

        panel.add(loginButton);
        panel.add(exitButton);

        add(panel);
        setVisible(true);
    }

    private void openLogin() {
        new LoginWindow();
        dispose();
    }

    public static void main(String[] args) {
        //test actors
        Instructor instructor = new Instructor("instructor");
        Student student = new Student("student");

        UserStorage.addEntry(instructor, "123");
        UserStorage.addEntry(student, "123");

        //Run application
        SwingUtilities.invokeLater(MainMenu::new);
    }
}

