package lms_project.users;

public class Student extends AppUser {

    public Student(String username) {
        super(username, "STUDENT");
    }

    // student-specific behavior later
}
