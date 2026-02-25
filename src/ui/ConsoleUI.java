package ui;


import Service.UniversityManager;
import java.util.ArrayList;
import java.util.Scanner;
import Model.*;
import java.util.Optional;


        public class ConsoleUI {
            private ArrayList<Student> students = new ArrayList<>();
            private Scanner scanner = new Scanner(System.in);

            public void start() {

                while (true) {

                    System.out.println("\n1. Register Student");
                    System.out.println("2. View Top Student");
                    System.out.println("3. Exit");
                    System.out.print("Enter your choice: ");

                    String input = scanner.nextLine();

                    if (input.isEmpty()) {
                        System.out.println("Please enter a number.");
                        continue;
                    }

                    int choice;

                    try {
                        choice = Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Enter a number.");
                        continue;
                    }

                    switch (choice) {

                        case 1:
                            registerStudent();
                            break;

                        case 2:
                            viewTopStudent();
                            break;

                        case 3:
                            System.out.println("Exiting...");
                            return;

                        default:
                            System.out.println("Invalid choice.");
                    }
                }
            }

            private void registerStudent() {

                System.out.print("Enter student name: ");
                String name = scanner.nextLine();

                System.out.print("Enter student email: ");
                String email = scanner.nextLine();

                System.out.print("Enter student ID: ");
                String studentID = scanner.nextLine();

                System.out.print("Enter student department: ");
                String department = scanner.nextLine();

                System.out.print("Enter student GPA: ");
                double gpa = Double.parseDouble(scanner.nextLine());

                // Anonymous subclass used since Student is abstract
                Student student = new Student(name, email, studentID, department) {
                    @Override
                    public double calculateTuition() {
                        return 0.0;
                    }
                };

                student.setGpa(gpa);
                students.add(student);  // ← was missing, student was never saved

                System.out.println("Student registered successfully!");
            }

            private void viewTopStudent() {

                if (students.isEmpty()) {
                    System.out.println("No students registered yet.");
                    return;
                }

                Student topStudent = students.get(0);

                for (Student s : students) {
                    if (s.getGpa() > topStudent.getGpa()) {  // ← getMark() → getGpa()
                        topStudent = s;
                    }
                }

                System.out.println("\nTop Student:");
                System.out.println(topStudent);
            }
        }

