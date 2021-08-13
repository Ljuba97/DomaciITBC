import java.util.Scanner;

public class Zadatak2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input:");

        int n = sc.nextInt();

        System.out.println("Output:");

        for (int i = 1; i <= n; i++) {
            System.out.print(i + ":");

            if (i % 3 == 0 && i % 5 == 0)
                System.out.print(" FizzBuzz");
            else if (i % 3 == 0)
                System.out.print(" Fizz");
            else if (i % 5 == 0)
                System.out.print(" Buzz");

            System.out.println();
        }
    }
}
