package lms_project.content;

import javax.swing.JOptionPane;

public class Quiz implements IContent {
    private String title;

    public Quiz(String title) {
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
            "Quiz content: " + title,
            "Quiz",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
