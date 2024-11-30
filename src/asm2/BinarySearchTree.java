package asm2;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private TreeNode root;

    public void insert(Student student) {
        root = insertRec(root, student);
    }

    private TreeNode insertRec(TreeNode root, Student student) {
        if (root == null) {
            root = new TreeNode(student);
            return root;
        }
        if (student.getId().compareTo(root.student.getId()) < 0) {
            root.left = insertRec(root.left, student);
        } else if (student.getId().compareTo(root.student.getId()) > 0) {
            root.right = insertRec(root.right, student);
        }
        return root;
    }

    public Student search(String id) {
        return searchRec(root, id);
    }

    private Student searchRec(TreeNode root, String id) {
        if (root == null) {
            return null;
        }
        if (id.equals(root.student.getId())) {
            return root.student;
        }
        if (id.compareTo(root.student.getId()) < 0) {
            return searchRec(root.left, id);
        }
        return searchRec(root.right, id);
    }

    public void inOrderTraversal() {
        inOrderRec(root);
    }

    private void inOrderRec(TreeNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.student);
            inOrderRec(root.right);
        }
    }

    public List<Student> getStudentsSortedByMarks() {
        List<Student> students = new ArrayList<>();
        collectStudents(root, students);
        students.sort((s1, s2) -> Double.compare(s1.getMark(), s2.getMark()));
        return students;
    }

    private void collectStudents(TreeNode node, List<Student> students) {
        if (node != null) {
            collectStudents(node.left, students);
            students.add(node.student);
            collectStudents(node.right, students);
        }
    }

    public void evaluateByRank() {
        System.out.println("Fail:");
        inOrderTraversalByRank(root, "Fail");
        System.out.println("\nAverage:");
        inOrderTraversalByRank(root, "Average");
        System.out.println("\nGood:");
        inOrderTraversalByRank(root, "Good");
        System.out.println("\nVery Good:");
        inOrderTraversalByRank(root, "Very Good");
        System.out.println("\nExcellent:");
        inOrderTraversalByRank(root, "Excellent");
    }

    private void inOrderTraversalByRank(TreeNode node, String rank) {
        if (node != null) {
            inOrderTraversalByRank(node.left, rank);
            if (node.student.getRank().equals(rank)) {
                System.out.println(node.student);
            }
            inOrderTraversalByRank(node.right, rank);
        }
    }
}
