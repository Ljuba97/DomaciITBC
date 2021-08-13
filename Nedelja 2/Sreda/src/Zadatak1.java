import java.util.Scanner;

public class Zadatak1 {
    public static double minOfTwoNumbers(double a, double b) {
        if (a < b)
            return a;
        else
            return b;
    }

    public static double minOfThreeNumbers(double a, double b, double c) {
        return minOfTwoNumbers(minOfTwoNumbers(a, b), c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input:");

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        System.out.println("Output:");

        System.out.println(minOfThreeNumbers(a, b, c));
    }
}
