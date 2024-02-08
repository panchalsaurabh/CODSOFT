
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Take marks obtained (out of 100) in each subject.
        System.out.println("Student Grade Calculator");
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        int totalMarks = 0;

        // Calculate Total Marks: Sum up the marks obtained in all subjects.
        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.print("Enter marks for Subject " + i + ": ");
            int marks = scanner.nextInt();

            // Validate that the entered marks are within the valid range (0-100).
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Marks should be between 0 and 100. Please try again.");
                i--; // Decrement the counter to re-enter marks for the same subject.
                continue;
            }

            totalMarks += marks;
        }

        // Calculate Average Percentage: Divide the total marks by the total number of subjects.
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // Grade Calculation: Assign grades based on the average percentage achieved.
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display Results: Show the total marks, average percentage, and the corresponding grade to the user.
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}

