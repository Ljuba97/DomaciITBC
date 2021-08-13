import java.util.Scanner;

public class Zadatak2 {
    public static String decode(String poruka, String[] kljuc, String[] decode) {
        String[] s = poruka.split(" ");
        String res = "";
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < kljuc.length; j++) {
                if (s[i].equals(kljuc[j]))
                    s[i] = decode[j];
            }
        }
        for (int i = 0; i < s.length; i++)
            res = res.concat(s[i]).concat(" ");
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String poruka = "Jedi #$%^ !@#$!!!@# mali!";
        String[] kljuc = {"#$%^", "!@#$!!!@#"};
        String[] decode = {"pite", "moroncinu"};

        System.out.println(decode(poruka, kljuc, decode));
    }
}
