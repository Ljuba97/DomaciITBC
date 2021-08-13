import java.util.Scanner;

public class Zadatak4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input:");

        int yearA = sc.nextInt();
        int yearB = sc.nextInt();
        int count = 0;

        while (yearA <= 0 || yearB <= 0) {
            System.out.println("You must enter a year that is higher than 0!");
            yearA = sc.nextInt();
            yearB = sc.nextInt();
        }

        for (int i = yearA; i <= yearB; i++) {
            if (i % 4 == 0 && (i % 100 != 0 || i % 400 == 0)) {
                count++;
            }
        }

        System.out.println("Output:\n" + count);
    }
}
