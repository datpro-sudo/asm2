package Helper;

import asm2.Student;
import asm2.BinarySearchTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readCSV {
    public static void loadStudentsFromCSV(String filePath, BinarySearchTree bst) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] data = line.split(",");
                    if (data.length != 3) {
                        throw new IllegalArgumentException("Invalid data format: " + line);
                    }
                    String id = data[0];
                    String name = data[1];
                    double mark = Double.parseDouble(data[2]);
                    Student student = new Student(id, name, mark);
                    bst.insert(student);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid mark format in line: " + line);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
