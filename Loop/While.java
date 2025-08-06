package Loop;

import java.util.Random;
import java.util.Scanner;

public class While {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int target = random.nextInt(100) + 1;
        int guess = 0;
        int attempts = 0;

        System.out.println("Guess the number between 1 and 100");
        while (guess != target) {
            System.out.println("Enter ur guess: ");
            guess = sc.nextInt();
            attempts++;
            if (guess < target) {
                System.out.println("Your guess is too low!");
            }
            else if (guess > target) {
                System.out.println("Your guess is too high!");
            } else {
                System.out.println("Your guess is correct!");
            }
        }
        sc.close();
    }
}
