import java.util.Scanner;

public class Zadatak3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input:");

        double price = sc.nextDouble();
        double sum = 0;
        double average = 0;
        int i = 0;

        while (price != 0) {
            if (price > 0) {
                sum += price;
                i++;
            }
            price = sc.nextDouble();
        }

        if (sum != 0) {
            average = sum / i;
            System.out.println("Output:\n" + average);
        }
        else {
            System.out.println("Output:\n" + 0);
        }

    }
}
