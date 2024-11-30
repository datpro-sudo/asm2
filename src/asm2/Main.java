package asm2;

import Helper.readCSV;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        // Load students from CSV
        String filePath = "students.csv";
        readCSV.loadStudentsFromCSV(filePath, bst);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add new student");
            System.out.println("2. Search student by ID");
            System.out.println("3. Delete student by ID");
            System.out.println("4. Print student list");
            System.out.println("5. Evaluate students by rank");
            System.out.println("6. Sort students by marks");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number from 1 to 7.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter mark: ");
                    try {
                        double mark = Double.parseDouble(scanner.nextLine());
                        bst.insert(new Student(id, name, mark));
                        System.out.println("Student added!");
                    }
                     catch (NumberFormatException e) {
                     System.out.println("Invalid mark! Please enter a numeric value.");
                }
            }
                case 2 -> {
                    System.out.print("Enter ID to search: ");
                    String id = scanner.nextLine();
                    Student student = bst.search(id);
                    if (student == null) {
                        System.out.println("Student not found!");
                    } else {
                        System.out.println("Student details: " + student);
                    }
                }
                case 3 -> {
                    System.out.print("Enter ID to delete: ");
                    String id = scanner.nextLine();
                    Student student = bst.search(id);
                    if (student == null) {
                        System.out.println("Student not found!");
                    } else {
                        bst.delete(id);
                        System.out.println("Student with ID " + id + " has been deleted.");
                    }
                }
                case 4 -> {
                    System.out.println("Student list:");
                    bst.inOrderTraversal();
                }
                case 5 -> {
                    System.out.println("Evaluate students by rank:");
                    bst.evaluateByRank();
                }
                case 6 -> {
                    System.out.println("Students sorted by marks:");
                    List<Student> sortedStudents = bst.getStudentsSortedByMarks();
                    for (Student student : sortedStudents) {
                        System.out.println(student);
                    }
                }
                case 7 -> {
                    System.out.println("Exiting program.");
                    return;
                }
                default -> System.out.println("Invalid choice! Please select a number from 1 to 7.");
            }
        }
    }
}
    
