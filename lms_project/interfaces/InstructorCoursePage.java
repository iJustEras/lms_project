package lms_project.interfaces;

import lms_project.course_services.*;
import lms_project.user_services.*;
import lms_project.users.*;
import lms_project.content.*;

import javax.swing.*;
import java.awt.*;

public class InstructorCoursePage extends JFrame {

    private final Course course;
    private JPanel contentPanel;

    public InstructorCoursePage(Course course) {
        this.course = course;

        setTitle("Course: " + course.getCourseName());
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // ---- TOP PANEL ----
        JLabel courseTitle = new JLabel(course.getCourseName());
        courseTitle.setFont(new Font("Arial", Font.BOLD, 20));
        mainPanel.add(courseTitle, BorderLayout.NORTH);

        // ---- CENTER PANEL (Course contents) ----
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // ---- BOTTOM PANEL ----
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton addContentButton = new JButton("Add Content");
        JButton backButton = new JButton("Back");

        addContentButton.addActionListener(e ->
            new AddContentPage(course, this::refreshContentList).setVisible(true)
        );

        backButton.addActionListener(e -> goBack());

        bottomPanel.add(addContentButton);
        bottomPanel.add(backButton);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
        refreshContentList();
        setVisible(true);
    }

    private void refreshContentList() {
        contentPanel.removeAll();

        if (course.getContents().isEmpty()) {
            contentPanel.add(new JLabel("No content added yet."));
        } else {
            for (IContent content : course.getContents()) {
                JButton contentBtn = new JButton(content.getTitle());
                contentBtn.setAlignmentX(Component.LEFT_ALIGNMENT);

                contentBtn.addActionListener(e -> content.showContent());

                contentPanel.add(contentBtn);
                contentPanel.add(Box.createVerticalStrut(5));
            }
        }

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void goBack() {
        new ViewCoursesWindow();
        dispose();
    }
}
