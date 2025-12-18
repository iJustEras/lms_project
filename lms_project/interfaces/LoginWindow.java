package lms_project.interfaces;

import lms_project.course_services.*;
import lms_project.user_services.*;
import lms_project.users.*;

import javax.swing.*;
import java.awt.*;

public class LoginWindow extends JFrame {

    public LoginWindow() {
        setTitle("Login");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            //Authentication
            AppUser user = UserAuthentication.getInstance().authenticate(username, password);

            if (user == null) {
                JOptionPane.showMessageDialog(this, "Invalid credentials");
            } else {
                UserSession.getInstance().login(user);
                openRoleMenu(user);
                dispose();
            }
        });

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);

        add(panel);
        setVisible(true);
    }  

    private void openRoleMenu(AppUser user) {
        if (user instanceof Instructor) {
            new InstructorMenu();
        } else if (user instanceof Student) {
            new StudentMenu();
        }
    }   
}

