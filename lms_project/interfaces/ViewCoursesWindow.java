package lms_project.interfaces;

import lms_project.course_services.*;
import lms_project.user_services.*;
import lms_project.users.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ViewCoursesWindow extends JFrame {

    public ViewCoursesWindow() {
        setTitle("My Courses");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        AppUser user = UserSession.getInstance().getCurrentUser();

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        DefaultListModel<Course> courseListModel = new DefaultListModel<>();
        JList<Course> courseList = new JList<>(courseListModel);

        JLabel infoLabel = new JLabel();

        if (user instanceof Instructor instructor) {
            infoLabel.setText("Courses you created:");
            List<Course> courses = UserCourseStorage.getInstance().getUserCourses(instructor);
            courses.forEach(courseListModel::addElement);

            //Make courses clickable
            courseList.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        Course selected = courseList.getSelectedValue();
                        if (selected != null) {
                            new InstructorCoursePage(selected);
                            dispose();
                        }
                    }
                }
            });
        }

        if (user instanceof Student student) {
            infoLabel.setText("Courses you are enrolled in:");
            List<Course> courses = UserCourseStorage.getInstance().getUserCourses(student);
            courses.forEach(courseListModel::addElement);

            courseList.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        Course selected = courseList.getSelectedValue();
                        if (selected != null) {
                            new StudentCoursePage(selected);
                            dispose();
                        }
                    }
                }
            });
        }

        panel.add(infoLabel, BorderLayout.NORTH);
        panel.add(new JScrollPane(courseList), BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }
}


