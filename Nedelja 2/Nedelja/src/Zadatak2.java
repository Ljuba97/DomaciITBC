import java.util.Scanner;

public class Zadatak2 {
    public static int sum(char[] x) {
        int n = 0;
        for (int i = 0; i < x.length; i++) {
            n += Integer.parseInt((String.valueOf(x[i])));
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String number = sc.nextLine();
        char[] x = number.toCharArray();
        System.out.println(sum(x));
    }
}
