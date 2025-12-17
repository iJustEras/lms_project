package lms_project.user_services;

import lms_project.users.*;

import java.util.HashMap;

public class UserAuthentication {
    public static AppUser authenticate(String username, String password) {
        if (password.equals(UserStorage.getPassword(username))) {
            return UserStorage.getUser(username);
        } else {
            return null;
        }
    }
}
