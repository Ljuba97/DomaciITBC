import java.util.Scanner;

public class Zadatak2 {
    public static int factoriel(int a) {
        int b = a - 1;

        while (b > 0) {
            a *= b;
            b--;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input:");

        int a = sc.nextInt();

        while (a <= 0) {
            System.out.println("You must input a number bigger then 0!");
            a = sc.nextInt();
        }

        System.out.println(factoriel(a));
    }
}
