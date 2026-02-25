package Util;

import java.io.*;
import java.util.List;
import Model.Student;

public class FileManager {

    public static void saveStudents(List<Student> students) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"));

        for (Student s : students) {
            writer.write(s.getStudentID() + "," +
                    s.getName() + "," +
                    s.getDepartment() + "," +
                    s.getGpa());
            writer.newLine();
        }

        writer.close();
    }
}
