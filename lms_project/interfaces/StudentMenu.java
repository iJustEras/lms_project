package lms_project.interfaces;

import lms_project.course_services.*;
import lms_project.user_services.*;
import lms_project.users.*;

import javax.swing.*;
import java.awt.*;

public class StudentMenu extends JFrame {

    public StudentMenu() {
        AppUser user = UserSession.getInstance().getCurrentUser();

        setTitle("Student Dashboard");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // ---- TOP PANEL ----
        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel userLabel = new JLabel("Logged in as: " + user.getUsername());
        JButton logoutButton = new JButton("Logout");

        logoutButton.addActionListener(e -> logout());

        topPanel.add(userLabel, BorderLayout.WEST);
        topPanel.add(logoutButton, BorderLayout.EAST);

        // ---- CENTER PANEL ----
        JPanel centerPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JButton viewCourses = new JButton("View Courses");

        viewCourses.addActionListener(e -> new ViewCoursesWindow());

        centerPanel.add(viewCourses);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        add(mainPanel);

        //Notification
        SwingUtilities.invokeLater(() ->
            UserNotification.getInstance().showUnreadNotifications((Student) UserSession.getInstance().getCurrentUser(), this)
        );

        setVisible(true);
    }

    private void showMessage(String action) {
        JOptionPane.showMessageDialog(this, action + " clicked");
    }

    private void logout() {
        UserSession.getInstance().logout();
        new MainMenu();
        dispose();
    }
}
