package ui;


import Service.UniversityManager;
import java.util.Scanner;

public class ConsoleUI {

    private UniversityManager manager = new UniversityManager();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n1. Register Student");
            System.out.println("2. View Top Student");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter name:");
                    String name = scanner.next();
                    // Continue implementation...
                    break;
                case 2:
                    manager.getTopStudent()
                            .ifPresent(s -> System.out.println("Top: " + s.getName()));
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}
