package lms_project.content;

import javax.swing.JOptionPane;

public class Assignment implements IContent {
    private String title;

    public Assignment(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void showContent() {
        JOptionPane.showMessageDialog(
            null,
            "Assignment details: " + title,
            "Assignment",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
