import java.util.Scanner;

public class Zadatak4 {
    public static int[] sum(int[] x) {
        int[] n = new int[x.length / 2];
        int j = 0;

        for (int i = 0; i < x.length / 2; i++) {
            n[i] = x[j] + x[j + 1];
            j += 2;
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n % 2 == 0 && n >= 0) {
            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                if (num >= 0)
                    x[i] = num;
                else {
                    i--;
                    System.out.println("You must input positive number!");
                }
            }
            for (int i = 0; i < x.length / 2; i++)
                System.out.print(sum(x)[i] + " ");
        }
        else
            System.out.println("Array size must be even and positive!");
    }
}
