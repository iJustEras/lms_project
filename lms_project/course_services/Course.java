package lms_project.course_services;

import lms_project.interfaces.*;
import lms_project.user_services.*;
import lms_project.content.*;
import lms_project.users.*;

import java.util.*;

public class Course {
    private int courseId;
    private String courseName;
    private String description;
    private Instructor courseInstructor;
    private List<Student> enrolledStudents;
    private List<IContent> contents;

    public Course(int id, String courseName, String description, Instructor instructor) {
        this.courseId = id;
        this.courseName = courseName;
        this.description = description;
        courseInstructor = instructor;
        enrolledStudents = new ArrayList<>();
        contents = new ArrayList<>();
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDescription() {
        return description;
    }

    public Instructor getCourseInstructor() {
        return courseInstructor;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public List<IContent> getContents() {
        return contents;
    }
}
