import java.util.Scanner;

public class Zadatak3 {
    public static boolean validate(String password) {
        char c;
        if (password.length() > 8) {
            for (int i = 0; i < password.length(); i++) {
                if (Character.isUpperCase(password.charAt(i)))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String password = sc.nextLine();
        System.out.println(validate(password));
    }
}
