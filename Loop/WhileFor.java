package Loop;

import java.util.Scanner;


import java.util.Scanner;

public class WhileFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] questions = {
                "What is 5 + 3?",
                "What is 9 - 4?",
                "What is 6 * 2?"
        };

        int[] answers = {8, 5, 12};
        int score = 0;

        System.out.println("🎓 Welcome to the Quiz Game!");
        System.out.println("You have 3 seconds to answer each question (simulated timer).");
        System.out.println("Let's begin!\n");

        // Use a for loop to go through each question
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);

            int timeLeft = 3; // Simulated countdown (no real delay here)
            boolean answered = false;

            // Simulate a timer using a while loop
            while (timeLeft > 0 && !answered) {
                System.out.print("Your answer (you have " + timeLeft + " seconds): ");
                int userAnswer = scanner.nextInt();

                if (userAnswer == answers[i]) {
                    System.out.println("✅ Correct!\n");
                    score++;
                    answered = true;
                } else {
                    System.out.println("❌ Wrong answer, try again quickly!");
                }

                timeLeft--;
            }

            if (!answered) {
                System.out.println("⏱️ Time's up! Moving to the next question.\n");
            }
        }

        System.out.println("🏁 Quiz Over!");
        System.out.println("Your Score: " + score + "/" + questions.length);

        scanner.close();
    }
}
