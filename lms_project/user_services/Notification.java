package lms_project.user_services;

public class Notification {

    private final String message;
    private boolean read;

    public Notification(String message) {
        this.message = message;
        this.read = false;
    }

    public String getMessage() {
        return message;
    }

    public boolean isRead() {
        return read;
    }

    public void markAsRead() {
        this.read = true;
    }
}
