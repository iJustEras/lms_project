package lms_project.user_services;

import lms_project.users.*;

public class UserSession {
    private static AppUser currentUser;

    public static void login(AppUser user) {
        currentUser = user;
    }

    public static AppUser getCurrentUser() {
        return currentUser;
    }

    public static boolean isLoggedIn() {
        return currentUser != null;
    }

    public static void logout() {
        currentUser = null;
    }
}
