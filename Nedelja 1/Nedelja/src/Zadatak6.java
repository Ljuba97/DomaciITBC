import java.util.Scanner;

public class Zadatak6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input:");

        int n = sc.nextInt();

        System.out.println("Output:");

        String middle = "";

        for (int i = n; i > 0; i--) {
            String leftRight = "";

            for (int j = 0; j < i; j++) {
                leftRight += " ";
            }

            System.out.print(leftRight);
            middle += "* ";
            System.out.print(middle);
            System.out.println(leftRight);
        }
    }
}
