package lms_project.user_services;

import java.util.*;

import lms_project.course_services.Course;
import lms_project.users.AppUser;
import lms_project.users.Instructor;
import lms_project.users.Student;

public class UserCourseStorage {
    private static final Map<AppUser, List<Course>> userCourses = new HashMap<>();

    public static void addCourse(AppUser user, Course course) {
        userCourses.computeIfAbsent(user, k -> new ArrayList<>()).add(course);
    }

    public static List<Course> getUserCourses(AppUser user) {
        return userCourses.getOrDefault(user, new ArrayList<>());
    }
}
