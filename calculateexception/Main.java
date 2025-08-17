package calculateexception;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try {
            int result = calculator.divide(10, 2);
            System.out.println("Result:" + result);

        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException");
        }
        System.out.println("Program continue");
    }
}
