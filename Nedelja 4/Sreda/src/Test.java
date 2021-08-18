import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Karatisti k = new Karatisti("Jovan", 12, "2Kyu", new String[]{"Fire", "Water", "Earth", "Air"});
        Karatisti k1 = new Karatisti("Marko", 16, "1Dan", new String[]{"Fire", "Water", "Earth", "Air", "Lightning", "Lava", "Ice"});

        System.out.println(k.getIme() + " " + k.getGodine() + " " + k.getRang() + " " + Arrays.toString(k.getKata()));
        k.napadni(2);
        k.vatreniNapad();
        k.log();
        k1.log();
    }
}
