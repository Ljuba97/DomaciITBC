import java.util.Scanner;

public class Zadatak3 {
    public static void bid (boolean b, int i, double d) {
        if (b == false)
            System.out.println("Boolean");
        if (i > 49)
            System.out.println("Integer");
        if (d > (i * 2))
            System.out.println("Double");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input:");

        boolean b = sc.nextBoolean();
        int i = sc.nextInt();
        double d = sc.nextDouble();
        d = Math.floor(d);

        System.out.println("Output:");

        bid(b, i, d);
    }
}
