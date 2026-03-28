package lms_project.users;

import lms_project.user_services.UserNotification;

public abstract class AppUser {
    private String username;
    private String role;

    public AppUser(String username, String role) {
        this.username = username;
        this.role = role;
        UserNotification.getInstance().registerUser(this);
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
}
