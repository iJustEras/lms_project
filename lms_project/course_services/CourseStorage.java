package lms_project.course_services;

import lms_project.interfaces.*;
import lms_project.user_services.*;
import lms_project.users.*;

import java.util.*;

public class CourseStorage {
    private static CourseStorage instance;
    private List<Course> coursesList = new ArrayList<>();

    public static CourseStorage getInstance() {
        if (instance == null) {
            instance = new CourseStorage();
        }

        return instance;
    }

    public List<Course> getCoursesList() {
        return coursesList;
    }
}

