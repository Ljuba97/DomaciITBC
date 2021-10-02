public class Zadatak2 {
    public static String caeserEncryption(String text, int key) {
        String code = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            c = (char) (((int) c + key) % 128);
            code = code.concat(String.valueOf(c));
        }
        return code;
    }

    public static String caeserDecryption(String code, int key) {
        String text = "";
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            if ((int) c - key < 0)
                c = (char) (128 - Math.abs((int) c - key));
            else
                c = (char) ((int) c - key);
            text = text.concat(String.valueOf(c));
        }
        return text;
    }

    public static void main(String[] args) {
        String s = ">]aOZXWm[Wm\\OmaZOQYm^`WdOb\\cm^]`cYc(m8OdO\":gTS";

        for (int i = 0; i <= 100; i++) {
            System.out.println("Encryption: " + i + " result: " + caeserEncryption(s, i));
            System.out.println("Decryption: " + i + " result:  " + caeserDecryption(s, i));
            System.out.println("----------------------");
        }
    }
}
