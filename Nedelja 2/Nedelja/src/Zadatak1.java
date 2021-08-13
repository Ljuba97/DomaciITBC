import java.util.Scanner;

public class Zadatak1 {
    public static void banka(String str) {
        int[] brojBanke = {243, 315, 303, 315, 311};
        int[] brojRacuna = {5320, 3155, 3095, 9134, 3950};
        int[] kontrolniBroj = {35, 13, 93, 39, 46};
        int[] novac = {31250, 9534, 15034, 53024, 153059};

        String bB = "";
        String rR = "";
        String kB = "";

        for (int i = 0; i < str.length(); i ++) {
            if (i >= 0 && i < 3)
                bB += str.charAt(i);
            else if (i > 3 && i < 8)
                rR += str.charAt(i);
            else if (i > 8 && i < 11)
                kB += str.charAt(i);
        }

        for (int i = 0; i < brojBanke.length; i++) {
            if (brojBanke[i] == Integer.parseInt(bB))
                if (brojRacuna[i] == Integer.parseInt(rR))
                    if (kontrolniBroj[i] == Integer.parseInt(kB)) {
                        System.out.println("Novac na racunu: " + novac[i]);
                        return;
                    }
        }

        System.out.println("Broj racuna ne postoji!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int i = 0;

        while (!str.equals("")) {
            if (str.matches("\\d\\d\\d-\\d\\d\\d\\d-\\d\\d")) {
                banka(str);
                str = sc.nextLine();
                i++;
            }
            else {
                System.out.println("Racun nije validan!");
                break;
            }
        }
    }
}
