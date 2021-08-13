import java.util.Scanner;

public class Zadatak1 {
    public static String correct(String s) {
        String correct = s.replace("$", "");
        correct = correct.replace("#", "");
        correct = correct.replace("@", "");
        return correct;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        System.out.println(correct(s));
    }
}
