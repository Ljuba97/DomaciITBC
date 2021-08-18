import java.util.ArrayList;

public class Zadatak10 {
    public static void main(String[] args) {
        int[] a = new int[] {2, 19, -3, 3, 28,5,9};
        ArrayList<Integer> b = array(a);
        System.out.println(b.toString());
    }
    public static ArrayList<Integer> array(int[] a) {
        ArrayList<Integer> b = new ArrayList<>();
        for(int i=0; i<a.length; i++) {
            int simpleNum = primeNumbers(a[i]);
            if(a[i] > simpleNum) {
                b.add(a[i]);
            }
        }
        return b;
    }
    public static int primeNumbers(int num) {
        int newNum = 1;
        boolean isPrime = false;
        for(int i=2; i<num; i++) {
            for(int j=2; j<=i; j++) {
                if(i % j == 0 && i != j) {
                    isPrime = false;
                    break;
                }
                isPrime = true;
            }
            if(isPrime) {
                newNum *= i;
            }
        }
        return newNum;
    }
}
