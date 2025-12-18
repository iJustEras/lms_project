package lms_project.user_services;

import lms_project.users.*;

import java.util.HashMap;

public class UserStorage {
    private static UserStorage instance;
    //username:password
    private HashMap<String, String> passwordsDB = new HashMap<>();

    //username:userObject
    private HashMap<String, AppUser> usersDB = new HashMap<>();

    public static UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
        }

        return instance;
    }

    public void addEntry(AppUser user, String password) {
        usersDB.put(user.getUsername(), user);
        passwordsDB.put(user.getUsername(), password);
    }

    public String getPassword(String username) {
        return passwordsDB.get(username);
    }

    public AppUser getUser(String username) {
        return usersDB.get(username);
    }
}
