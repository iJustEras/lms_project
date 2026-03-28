package lms_project.user_services;

import java.util.*;

import lms_project.course_services.Course;
import lms_project.users.AppUser;
import lms_project.users.Instructor;
import lms_project.users.Student;

public class UserCourseStorage {
    private static UserCourseStorage instance;
    private Map<AppUser, List<Course>> userCourses = new HashMap<>();

    public static UserCourseStorage getInstance() {
        if (instance == null) {
            instance = new UserCourseStorage();
        }

        return instance;
    }

    public void addCourse(AppUser user, Course course) {
        userCourses.computeIfAbsent(user, k -> new ArrayList<>()).add(course);
    }

    public List<Course> getUserCourses(AppUser user) {
        return userCourses.getOrDefault(user, new ArrayList<>());
    }
}
