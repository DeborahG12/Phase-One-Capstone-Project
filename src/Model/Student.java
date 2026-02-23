package Model;

import java.util.HashMap;
import java.util.Map;

public abstract class Student extends Person {

    private String studentID;
    private double gpa;
    private String department;

    private Map<Course, Double> enrolledCourses = new HashMap<>();

    public Student(String name, String email, String studentID, String department) {
        super(name, email);
        this.studentID = studentID;
        this.department = department;
    }

    public String getStudentID() { return studentID; }
    public double getGpa() { return gpa; }
    public String getDepartment() { return department; }

    public void setGpa(double gpa) { this.gpa = gpa; }

    public Map<Course, Double> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void addCourse(Course course) {
        enrolledCourses.put(course, 0.0);
    }

    public abstract double calculateTuition();
}