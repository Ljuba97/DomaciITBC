import java.util.ArrayList;
import java.util.Scanner;

public class Zadatak29 {
    public static double result(String s) {
        String pom = s.replace("+", " ").replace("*", " ").replace(":", " ");
        String[] str = pom.split(" ");
        double res = 0;
        ArrayList<Character> a = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '*' || s.charAt(i) == ':')
                a.add(s.charAt(i));
        }

        res = Integer.parseInt(str[0]);

        for (int i = 0; i < str.length - 1; i++) {
            if (a.get(i) == '+')
                res += Integer.parseInt(str[i + 1]);
            else if (a.get(i) == '*')
                res *= Integer.parseInt(str[i + 1]);
            else if (a.get(i) == ':')
                res /= Integer.parseInt(str[i + 1]);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        System.out.println(result(s));
    }
}
