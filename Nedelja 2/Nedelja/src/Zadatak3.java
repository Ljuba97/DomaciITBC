import java.util.Scanner;

public class Zadatak3 {
    public static double[] sortArray(double[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length; j++) {
                if (x[j] > x[j + 1]) {
                    double pom = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = pom;
                }
                if (j == x.length - 2)
                    break;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] numbers = new double[n];

        for (int i = 0; i < n; i++)
            numbers[i] = sc.nextDouble();

        for (int i = 0; i < n; i++)
            System.out.print(sortArray(numbers)[i] + " ");
    }
}
