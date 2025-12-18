package lms_project.course_services;

import lms_project.content.IContent;
import lms_project.user_services.Notification;
import lms_project.user_services.UserCourseStorage;
import lms_project.user_services.UserNotification;
import lms_project.user_services.UserSession;
import lms_project.users.Instructor;
import lms_project.users.Student;

public class CourseManager {
    private static CourseManager instance;
    private static int id = 0;

    public static CourseManager getInstance() {
        if (instance == null) {
            instance = new CourseManager();
        }

        return instance;
    }

    public Course createCourse(String courseName, String courseDescription) {
        Instructor courseInstructor = (Instructor) UserSession.getInstance().getCurrentUser();

        //Create new course
        Course newCourse = new Course(id, courseName, courseDescription, courseInstructor);
        id++;

        //Add Course to overall courses list
        addCourseToList(newCourse);

        //Update instructors course info
        UserCourseStorage.getInstance().addCourse(courseInstructor, newCourse);

        return newCourse;
    }

    public void enrollStudent(Student student, Course course) {
        //Add student to the enrolled students list
        course.getEnrolledStudents().add(student);

        //Update students course info
        UserCourseStorage.getInstance().addCourse(student, course);
    }

    public Course getCourseById(int id) {
        return CourseStorage.getInstance().getCoursesList().get(id);
    }

    public void addContent(Course course, IContent content) {
        course.getContents().add(content);

        Notification notification = new Notification(
            "New " + content.getClass().getSimpleName().replace("Content", "") +
            " added to \"" + course.getCourseName() + "\": " +
            content.getTitle()
        );

        notifyObservers(course, notification);
    }

    public void notifyObservers(Course course, Notification notification) {
        for (Student student : course.getEnrolledStudents()) {
            UserNotification.getInstance().notifyUser(student, notification);
        }
    }

    private void addCourseToList(Course course) {
        CourseStorage.getInstance().getCoursesList().add(course);
    }
}
