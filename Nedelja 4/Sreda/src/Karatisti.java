import java.util.Arrays;
import java.util.Random;

public class Karatisti {
    private String ime;
    private int godine;
    private String rang;
    private String[] kata;

    public Karatisti(String ime, int godine, String rang, String[] kata) {
        this.ime = ime;

        if (godine > 0)
            this.godine = godine;
        else {
            this.godine = 6;
            System.out.println("Niste ispravno uneli godine! Postavljena podrazumevana (6) || ime: " + this.ime);
        }
        if (Character.isDigit(rang.charAt(0)) && rang.charAt(0) >= '1' && rang.charAt(0) <= '9') {
            if (Character.isDigit(rang.charAt(1)) && rang.charAt(0) == '1' && rang.charAt(1) == '0') {
                if (rang.substring(2).equals("Kyu") || rang.substring(2).equals("Dan"))
                    this.rang = rang;
            }
            else if (rang.substring(1).equals("Kyu") || rang.substring(1).equals("Dan"))
                this.rang = rang;
        }
        else {
            System.out.println("Niste uneli validan rang, tako da je postavljen podrazumevani (10Kyu) za: " + ime);
            this.rang = "10Kyu";
        }
        this.kata = kata;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) {
        if (godine > 0)
            this.godine = godine;
        else {
            this.godine = 1;
            System.out.println("Niste ispravno uneli godine! Postavljena podrazumevana (1) || ime: " + this.ime);
        }
    }

    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }

    public String[] getKata() {
        return kata;
    }

    public void setKata(String[] kata) {
        this.kata = kata;
    }

    public void napadni(int index) {
        System.out.println("Karatista " + ime + " napada sa " + kata[index] + " katom");
    }

    public void vatreniNapad() {
        int x = new Random().nextInt(kata.length);
        System.out.println("Karatista " + ime + " napada sa " + kata[x] + " katom");
    }

    public void log() {
        System.out.println("Karatistia: " + ime + ", " + godine + ", " + rang + " - zna naredne kate " + Arrays.toString(kata));
    }

}
