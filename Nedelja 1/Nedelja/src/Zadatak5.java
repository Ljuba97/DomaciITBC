import java.util.Scanner;

public class Zadatak5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input:");
        int number = sc.nextInt();
        int sum = 0;

        while (number < 0) {
            System.out.println("You must enter a positive number!");
            number = sc.nextInt();
        }

        while (number != 0) {
            int tmp = number % 10;
            sum += tmp;
            number /= 10;

            if (number == 0) {
                if (sum < 10)
                    break;
                number = sum;
                sum = 0;
            }
        }

        System.out.println("Output:");
        System.out.println(sum);
    }
}
