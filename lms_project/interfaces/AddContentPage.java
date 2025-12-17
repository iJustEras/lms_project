package lms_project.interfaces;

import lms_project.course_services.*;
import lms_project.content.*;
import lms_project.user_services.*;
import lms_project.users.*;

import javax.swing.*;
import java.awt.*;

public class AddContentPage extends JFrame {

    private Course course;
    private JComboBox<String> typeCombo;
    private JTextField titleField;

    public AddContentPage(Course course, Runnable onContentAdded) {
        this.course = course;

        setTitle("Add Course Content");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // -------- Form Panel --------
        JPanel formPanel = new JPanel(new GridLayout(4, 1, 10, 10));

        typeCombo = new JComboBox<>(new String[]{
            "Quiz", "Assignment", "Material"
        });

        titleField = new JTextField();

        formPanel.add(new JLabel("Content Type:"));
        formPanel.add(typeCombo);
        formPanel.add(new JLabel("Title:"));
        formPanel.add(titleField);

        // -------- Buttons --------
        JButton postBtn = new JButton("Post Content");
        JButton cancelBtn = new JButton("Cancel");

        postBtn.addActionListener(e -> {
            createContent(onContentAdded);
        });

        cancelBtn.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(postBtn);
        buttonPanel.add(cancelBtn);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void createContent(Runnable onContentAdded) {
        String type = (String) typeCombo.getSelectedItem();
        String title = titleField.getText();

        if (title == null || title.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Title cannot be empty");
            return;
        }

        // 🔹 Factory usage
        IContent content = ContentFactory.createContent(type, title);

        // 🔹 Shared course state
        CourseManager.addContent(course, content);

        onContentAdded.run(); // refresh instructor page
        dispose();
    }
}
