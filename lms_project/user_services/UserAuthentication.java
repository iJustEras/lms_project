package lms_project.user_services;

import lms_project.users.*;

import java.util.HashMap;

public class UserAuthentication {
    private static UserAuthentication instance;

    public static UserAuthentication getInstance() {
        if (instance == null) {
            instance = new UserAuthentication();
        } 

        return instance;
    }

    public AppUser authenticate(String username, String password) {
        if (password.equals(UserStorage.getInstance().getPassword(username))) {
            return UserStorage.getInstance().getUser(username);
        } else {
            return null;
        }
    }
}
