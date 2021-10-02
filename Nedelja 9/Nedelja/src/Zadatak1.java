import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Zadatak1 {
    private static int[] zeroToLastPosition(int[] a){
        int[] x = new int[a.length];
        int index = 0;
        for (int i = 0; i < x.length; i++) {
            if (a[i] != 0){
                x[index] = a[i];
                index++;
            }
        }
        return x;
    }

    private static int[] generateArray() {
        Random r = new Random();
        int[] arr = new int[r.nextInt(50)];
        for (int i = 0; i < arr.length; i++)
            arr[i] = r.nextInt(10);
        return arr;
    }

    private static void generateFileTests() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Tests.txt"));
            for (int i = 0; i < 1000; i++) {
                int[] arr = generateArray();
                String tmp1 = Arrays.toString(zeroToLastPosition(arr)).replace("[", "").replace("]", "");
                String tmp2 = Arrays.toString(arr).replace("[", "").replace("]", "");
                String str = "assertEquals(new int[]{" + tmp1 + "}, zeroToLastPosition(new int[]{" + tmp2 + "})";
                writer.write(str);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        generateFileTests();
    }
}
