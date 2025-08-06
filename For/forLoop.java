package For;

import java.util.Scanner;

public class forLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to print its multiplication table : ");
        int num = sc.nextInt();

        System.out.println("\nMultiplication table of " + num + " is : ");
        for(int i = 1; i <= 10; i++){
            int result = num * i;
            System.out.println(num + " x " + i + " = " + result);
        }
        System.out.println("\nMultiplication table of 10 is :");
        for (int table = 1; table <=5; table++){
            System.out.println("\nTable of" + table + " is : ");
            for (int i =1; i <= 10; i++){
                System.out.println(table + " x " + i + " = " + (table*i));
            }
        }
        sc.close();
    }
}
