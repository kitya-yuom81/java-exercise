package ifSwitch;

import java.util.Scanner;

public class Exercise {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your score: ");
        int score =  scanner.nextInt();
        char grade;


        if (score< 0 || score> 100) {
            System.out.println("Invalid score");
            return;

        } else if (score >=90) {
            grade = 'A';
        } else if (score >=80) {
            grade = 'B';
        } else if (score >=70) {
            grade = 'C';
        } else if (score >=60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("Your grade is " + grade);
        switch (grade) {
            case 'A':
                System.out.println("Congratulations!");
                break;
            case 'B':
                System.out.println("Good job!");
                break;
            case 'C':
                System.out.println("Decent job!");
                break;
            case 'D':
                System.out.println("Doch ach");
                break;
            case 'F':
                System.out.println("Chkae sot");
                break;
        }
        scanner.close();

    }
}
