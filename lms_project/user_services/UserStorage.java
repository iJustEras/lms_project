package lms_project.user_services;

import lms_project.users.*;

import java.util.HashMap;

public class UserStorage {
    //username:password
    private static HashMap<String, String> passwordsDB = new HashMap<>();

    //username:userObject
    private static HashMap<String, AppUser> usersDB = new HashMap<>();

    public static void addEntry(AppUser user, String password) {
        usersDB.put(user.getUsername(), user);
        passwordsDB.put(user.getUsername(), password);
    }

    public static String getPassword(String username) {
        return passwordsDB.get(username);
    }

    public static AppUser getUser(String username) {
        return usersDB.get(username);
    }
}
