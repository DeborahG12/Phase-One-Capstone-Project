package Service;


import Model.Course;
import Model.Student;
import Exception.*;

import java.util.*;

public class UniversityManager {

    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public void registerStudent(Student student) {
        students.add(student);
    }

    public void createCourse(Course course) {
        courses.add(course);
    }

    public void enrollStudentInCourse(Student student, Course course)
            throws CourseFullException, StudentAlreadyEnrolledException {

        if (course.isFull()) {
            throw new CourseFullException("Course is full!");
        }

        if (student.getEnrolledCourses().containsKey(course)) {
            throw new StudentAlreadyEnrolledException("Student already enrolled!");
        }

        course.addStudent(student);
        student.addCourse(course);
    }

    public double calculateDepartmentAverageGPA(String department) {
        return students.stream()
                .filter(s -> s.getDepartment().equalsIgnoreCase(department))
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);
    }

    public Optional<Student> getTopStudent() {
        return students.stream()
                .max(Comparator.comparingDouble(Student::getGpa));
    }

    public List<Student> getStudents() { return students; }
    public List<Course> getCourses() { return courses; }
}
