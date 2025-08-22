import java.lang.*;
import java.util.Scanner;
public class labproject2208 {

    // Inner class Student
    static class Student {
        private int rollNumber;
        private String name;
        private String course;
        private double marks;
        private char grade;

        // Setter methods
        public void setRollNumber(int rollNumber) {
            this.rollNumber = rollNumber;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        public void setMarks(double marks) {
            this.marks = marks;
            this.grade = calculateGrade(marks);  // auto grade
        }

        // Method to calculate grade
        private char calculateGrade(double marks) {
            if (marks >= 90) return 'A';
            else if (marks >= 80) return 'B';
            else if (marks >= 70) return 'C';
            else if (marks >= 60) return 'D';
            else return 'F';
        }

        // Display student details
        public void displayStudent() {
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name : " + name);
            System.out.println("Course : " + course);
            System.out.println("Marks : " + marks);
            System.out.println("Grade : " + grade);
            System.out.println("---------------------------");
        }
    }

    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;

        // input validation for number of students
        while (true) {
            System.out.print("Enter number of students: ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                sc.nextLine(); // consume newline
                break;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // clear invalid input
            }
        }

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));
            Student s = new Student();

            System.out.print("Roll Number: ");
            s.setRollNumber(sc.nextInt());
            sc.nextLine();

            System.out.print("Name: ");
            s.setName(sc.nextLine());

            System.out.print("Course: ");
            s.setCourse(sc.nextLine());

            System.out.print("Marks: ");
            while (!sc.hasNextDouble()) {
                System.out.println(" Invalid input. Please enter numeric marks.");
                sc.nextLine();
                System.out.print("Marks: ");
            }
            s.setMarks(sc.nextDouble());
            sc.nextLine();

            students[i] = s;
            System.out.println(" Student added successfully!");
        }

        // Display all students
        System.out.println("\n--- Student Details ---");
        for (Student s : students) {
            s.displayStudent();
        }

        sc.close();
    }
}
