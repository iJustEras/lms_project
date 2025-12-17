package lms_project.course_services;

import lms_project.content.IContent;
import lms_project.user_services.Notification;
import lms_project.user_services.UserCourseStorage;
import lms_project.user_services.UserNotification;
import lms_project.user_services.UserSession;
import lms_project.users.Instructor;
import lms_project.users.Student;

public class CourseManager {
    private static int id = 0;

    public static Course createCourse(String courseName, String courseDescription) {
        Instructor courseInstructor = (Instructor) UserSession.getCurrentUser();

        //Create new course
        Course newCourse = new Course(id, courseName, courseDescription, courseInstructor);
        id++;

        //Add Course to overall courses list
        addCourseToList(newCourse);

        //Update instructors course info
        UserCourseStorage.addCourse(courseInstructor, newCourse);

        return newCourse;
    }

    public static void enrollStudent(Student student, Course course) {
        //Add student to the enrolled students list
        course.getEnrolledStudents().add(student);

        //Update students course info
        UserCourseStorage.addCourse(student, course);
    }

    public static Course getCourseById(int id) {
        return CourseStorage.getCoursesList().get(id);
    }

    public static void addContent(Course course, IContent content) {
        course.getContents().add(content);

        Notification notification = new Notification(
            "New " + content.getClass().getSimpleName().replace("Content", "") +
            " added to \"" + course.getCourseName() + "\": " +
            content.getTitle()
        );

        notifyObservers(course, notification);
    }

    public static void notifyObservers(Course course, Notification notification) {
        for (Student student : course.getEnrolledStudents()) {
            UserNotification.notifyUser(student, notification);
        }
    }

    private static void addCourseToList(Course course) {
        CourseStorage.getCoursesList().add(course);
    }
}
