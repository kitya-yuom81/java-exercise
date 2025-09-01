package ifSwitch.atm.util;



import java.math.BigDecimal;
import java.util.Scanner;

public final class Input {
    private static final Scanner SC = new Scanner(System.in);

    private Input() {}

    public static String line(String prompt) {
        System.out.print(prompt);
        return SC.nextLine().trim();
    }

    public static int intChoice(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String s = SC.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v < min || v > max) {
                    System.out.printf("Enter a number %d–%d.%n", min, max);
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    public static BigDecimal money(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = SC.nextLine().trim();
            try {
                BigDecimal v = new BigDecimal(s);
                if (v.compareTo(BigDecimal.ZERO) <= 0) {
                    System.out.println("Amount must be > 0.");
                    continue;
                }
                return v.setScale(2, BigDecimal.ROUND_HALF_UP);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid amount (e.g., 100.00).");
            }
        }
    }
}
