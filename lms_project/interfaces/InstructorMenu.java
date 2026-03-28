package lms_project.interfaces;

import lms_project.course_services.*;
import lms_project.user_services.*;
import lms_project.users.*;

import javax.swing.*;
import java.awt.*;

public class InstructorMenu extends JFrame {

    public InstructorMenu() {
        AppUser user = UserSession.getInstance().getCurrentUser();

        setTitle("Instructor Dashboard");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // ---- TOP PANEL (User info + Logout) ----
        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel userLabel = new JLabel("Logged in as: " + user.getUsername());
        JButton logoutButton = new JButton("Logout");

        logoutButton.addActionListener(e -> logout());

        topPanel.add(userLabel, BorderLayout.WEST);
        topPanel.add(logoutButton, BorderLayout.EAST);

        // ---- CENTER PANEL (Actions) ----
        JPanel centerPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JButton createCourse = new JButton("Create Course");
        JButton viewCourses = new JButton("View Courses");

        createCourse.addActionListener(e -> new CreateCourseWindow());
        viewCourses.addActionListener(e -> new ViewCoursesWindow());

        centerPanel.add(createCourse);
        centerPanel.add(viewCourses);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        add(mainPanel);
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
