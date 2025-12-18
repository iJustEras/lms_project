package lms_project.course_services;

import lms_project.interfaces.*;
import lms_project.user_services.*;
import lms_project.users.*;

import java.util.*;

public class CourseStorage {
    private static final List<Course> coursesList = new ArrayList<>();

    public static List<Course> getCoursesList() {
        return coursesList;
    }
}

