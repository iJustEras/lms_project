package lms_project.content;

import javax.swing.JOptionPane;

public class Material implements IContent {
    private String title;

    public Material(String title) {
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
            "Study material: " + title,
            "Material",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
