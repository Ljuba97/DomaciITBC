import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Zadaci {
    public static int secondMin(ArrayList<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > a.get(i + 1)) {
                int tmp = a.get(i);
                a.set(i, a.get(i + 1));
                a.set(i + 1, tmp);
            }

            if (i == a.size() - 2)
                break;
        }

        a.remove(0);

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > a.get(i + 1)) {
                int tmp = a.get(i);
                a.set(i, a.get(i + 1));
                a.set(i + 1, tmp);
            }

            if (i == a.size() - 2)
                break;
        }

        return a.get(0);
    }

    public static int secondMax(ArrayList<Integer> a) {
        for (int j = 0; j < a.size(); j++) {
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i) < a.get(i + 1)) {
                    int tmp = a.get(i);
                    a.set(i, a.get(i + 1));
                    a.set(i + 1, tmp);
                }

                if (i == a.size() - 2)
                    break;
            }
        }

        return a.get(1);
    }

    public static int sumOfAll(int n) {
        int sum = 0;
        String s = Integer.toString(n);
        int[] a = new int [s.length()];

        for (int i = a.length - 1; i >= 0; i--) {
            int tmp = n % 10;
            a[i] = tmp;
            n /= 10;
        }

        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0)
                sum += a[i];
            else
                sum -= a[i];
        }
        return sum;
    }

    public static ArrayList<Integer> elements(ArrayList<Integer> a, ArrayList<Integer> b) {
        int x = 0;
        int i = 0;
        ArrayList<Integer> c = new ArrayList<>();
        if (a.size() > b.size())
            x = a.size();
        else
            x = b.size();
        while (i != x) {
            for (i = 0; i < x; i++) {
                if (i < a.size())
                    c.add(a.get(i));
                if (i < b.size())
                    c.add(b.get(i));
            }
        }
        return c;
    }

    public static boolean isPrime(int n) {
        if (n < 2)
            return false;
        if (n == 2 || n == 3)
            return true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static ArrayList<Integer> primeNumbers(int n) {
        ArrayList<Integer> a = new ArrayList<>();
        int x = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j != 0)
                    x = 1;
                else {
                    x = 0;
                    break;
                }
            }
            if (x == 1 && i != 1)
                a.add(i);
        }
        return a;
    }

    public static ArrayList<Integer> moveElements(ArrayList<Integer> a, int k) {
        for (int i = 0; k > 0; i++, k--) {
            a.add(0, a.get(a.size() - 1));
            a.remove(a.size() - 1);
        }
        return a;
    }

    public static ArrayList<Integer> rotateArray(ArrayList<Integer> a) {
        ArrayList<Integer> b = new ArrayList<>();
        for (int i = a.size() - 1; i >= 0; i--) {
            b.add(a.get(i));
        }
        return b;
    }

    public static ArrayList<Integer> sumTwoHalves(ArrayList<Integer> a) {
        ArrayList<Integer> b = new ArrayList<>();
        for (int i = 0, j = a.size() / 2; j < a.size(); i++, j++) {
            b.add(a.get(i) + a.get(j));
        }
        return b;
    }

    public static boolean isValid(String s) {
        boolean smallL = false;
        int x = 0;
        int count = 0;
        int br = 0;
        boolean bigL = false;
        if (s.length() > 8 && !Character.isDigit(s.charAt(0)) && !isPalindrom(s) && !s.contains(" ")) {
            for (int i = 0; i < s.length(); i++) {
                if (Character.isLowerCase(s.charAt(i)) && !smallL)
                    smallL = true;
                if (Character.isUpperCase(s.charAt(i)) && !bigL)
                    bigL = true;
                if (Character.isDigit(s.charAt(i)))
                    x = 1;
            }
            if (s.charAt(s.length() - 2) < 'e' || s.charAt(s.length() - 2) > 't') {
                if (Character.isLowerCase(s.charAt(s.length() - 1)))
                    return false;
            }
            if (s.length() % 2 != 0) {
                for (int i = 0; i < s.length(); i++) {
                    if (Character.isDigit(s.charAt(i))) {
                        count++;
                        if (s.charAt(i) % 2 == 0)
                            br++;
                    }

                }
                if (count < 3 && br != 2)
                    return false;
            }
            if (smallL && bigL && x == 1)
                return true;
        }
        return false;
    }

    public static boolean isPalindrom(String s) {
        while (s.length() > 1) {
            if (s.charAt(0) == s.charAt(s.length() - 1))
                s = s.substring(1, s.length() - 1);
            else
                return false;
        }
        return true;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(2, 3, 5, 1, 2, -3, 8, 7, 6, 13 ,-4, 1));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(5, 4, 7, 12, 1, 6, 32, 8, 10));
        String s = sc.nextLine();
    }
}
