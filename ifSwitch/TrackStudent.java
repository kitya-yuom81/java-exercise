package ifSwitch;

import java.util.Scanner;

public class TrackStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the student");
        int n = sc.nextInt();
        sc.nextLine();

        String topStudent = "";
        int highestScore = -1;
        int totalScore = 0;

        for (int i = 1; i <=n; i++ ) {
            System.out.println("Enter the name of the student" + i + ":");
            String name = sc.nextLine();

            System.out.println("Enter the score of the student" + name + ":");
            int score = sc.nextInt();
            sc.nextLine();
            if (score< 0 || score > 100) {
                System.out.println("Invalid score");
                continue;
            }

            totalScore += score;
            if (score > highestScore) {
                highestScore = score;
                topStudent = name;
            }
            char grade;
            if (score >= 90) {
                grade = 'A';
            }
            else if (score >= 80) {
                grade = 'B';
            }
            else if (score >= 70) {
                grade = 'C';
            }
            else if (score >= 60) {
                grade = 'D';
            }
            else {
                grade = 'F';
            }
            System.out.println(name + " " + grade);

            switch (grade) {
                case 'A':
                    System.out.println("The best");
                    break;
                    case 'B':
                        System.out.println("The good");
                        break;
                        case 'C':
                            System.out.println("not good");
                            break;
                            case 'D':
                                System.out.println("not better");
                                break;
                                case 'F':
                                    System.out.println("you are worst");
                                    break;

            }
            if (score >= 50) {
                System.out.println(name + " has passed.");
            } else {
                System.out.println(name + " has failed.");
            }
            System.out.println();

        }
        double average = (n>0) ? totalScore / n : 0;
        System.out.println("Top student: " + topStudent + "with score:" + highestScore);
        System.out.println("The average score is: " + average);


    }
}
