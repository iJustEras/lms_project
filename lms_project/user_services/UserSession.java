package lms_project.user_services;

import lms_project.users.*;

public class UserSession {
    private static UserSession instance;
    private AppUser currentUser;

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }

        return instance;
    }

    public void login(AppUser user) {
        currentUser = user;
    }

    public AppUser getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public void logout() {
        currentUser = null;
    }
}
