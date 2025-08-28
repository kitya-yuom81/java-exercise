package ifSwitch;
import java.util.Scanner;

public class DateValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask for input
        System.out.print("Enter day: ");
        int day = sc.nextInt();

        System.out.print("Enter month: ");
        int month = sc.nextInt();

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        boolean isValid = true;
        int daysInMonth = 0;


        switch (month) {
            case 1: case 3: case 5: case 7:
            case 8: case 10: case 12:
                daysInMonth = 31;
                break;

            case 4: case 6: case 9: case 11:
                daysInMonth = 30;
                break;

            case 2:

                if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
                    daysInMonth = 29; // leap year
                } else {
                    daysInMonth = 28;
                }
                break;

            default:
                isValid = false;
        }

        // Check day range
        if (isValid) {
            if (day < 1 || day > daysInMonth) {
                isValid = false;
            }
        }


        if (isValid) {
            System.out.println("Valid date");
        } else {
            System.out.println("Invalid date");
        }
    }
}
