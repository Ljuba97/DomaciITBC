package skup.zadaci;

import java.util.*;

public class Zadaci {


    /*
    * 1. Zajednicki elementi
    * Za dva zadata niza bojeva vratiti niz onih brojeva koji se nalaze i u jednom i u drugom nizu.
    *
    * NPR:
    * [1, 2, 3, 4, 5], [2, 4, 6, 8, 10] -> [2, 4]
    * */

    public static ArrayList<Integer> intersection(ArrayList<Integer> a, ArrayList<Integer> b){
        ArrayList<Integer> c = new ArrayList<>();
        if (a == null || b == null)
            return null;
        TreeSet<Integer> set = new TreeSet<>(a);
        for (int x : b) {
            if (!set.add(x))
                c.add(x);
        }
        if (c.size() == 0)
            return null;
        return c;
    }

    /*
    * 2. Svi elementi
    * Za dva zadata niza brojeva vratiti niz svih brojeva iz oba niza bez ponavljanja.
    * */

    public static ArrayList<Integer> union(ArrayList<Integer> a, ArrayList<Integer> b){
        TreeSet<Integer> set = new TreeSet<>();
        if (a != null)
            set.addAll(a);
        if (b != null)
            set.addAll(b);
        if (set.size() == 0)
            return null;
        return new ArrayList<>(set);
    }

    /*
    * 3. Razlika
    * Za dva zadata niza brojeva vratiti niz onih brojeva koji se nalaze u prvom
    * ali ne i u drugom nizu, bez ponavljanja.
    * */

    public static ArrayList<Integer> razlika(ArrayList<Integer> a, ArrayList<Integer> b) {
        TreeSet<Integer> set = new TreeSet<>(b);
        ArrayList<Integer> c = new ArrayList<>();
        for (int x : a) {
            if (set.add(x))
                c.add(x);
        }
        return c;
    }

    /*
     * 4. Napisati funkciju koja broji koliko ima duplikata u zadatom nizu.
     *
     * [1, 2, 3, 4, 4, 2, 3, 5, 6] -> 3
     * [1, 2, 3] -> 0
     * [5, 5, 5, 5, 5, 6] -> 4
     * */

    public static int ponavljanjeBroj(int[] arr){
        TreeSet<Integer> set = new TreeSet<>();
        for (int x : arr)
            set.add(x);
        return arr.length - set.size();
    }

    /*
     * 5. Provera permutacije
     * Za dva zadata niza brojeva proveriti da li moze da se jedan dobije od drugog.
     * Brojevi u nizu se ne ponavljaju
     *
     * NPR:
     * [1, 2, 221, 101], [101, 2, 221, 1] -> da
     * [1, 2, 3], [3, 1, 2, 4] -> ne
     * */

    public static boolean permutacija(ArrayList<Integer> p1, ArrayList<Integer> p2){
        TreeSet<Integer> set1 = new TreeSet<>(p1);
        TreeSet<Integer> set2 = new TreeSet<>(p2);
        if (set1.equals(set2))
            return true;
        return false;
    }


    /*
    * 6. Neuparen element
    * Funkciji se prosledjuje niz ciji se svi elementi ponavljaju tacno dva puta,
    * osim jednog koji se ponavlja samo jednom.
    * Vratiti taj element
    *
    * Npr:
    * [1, 1, 2, 3, 3, 4, 4] -> 2
    * */

    public static int neuparen(int[] arr){
        TreeSet<Integer> set = new TreeSet<>();
        for (int x : arr) {
            if (!set.add(x))
                set.remove(x);
        }
        return set.first();
    }


    /*
    * 7. Anagram
    * Funkcija prima 2 String i daje odgovor da/ne u odnosu na to da li je
    * jedan String anagram drugog.
    *
    * NPR:
    * "panta redovno zakasni"
    * "neopravdan izostanak"
    * Da
    * */

    public static boolean anagram(String s1, String s2){
        s1 = s1.replaceAll(" ", "");
        s2 = s2.replaceAll(" ", "");
        TreeSet<Character> set1 = new TreeSet<>();
        ArrayList<Character> arr1 = new ArrayList<>();
        TreeSet<Character> set2 = new TreeSet<>();
        ArrayList<Character> arr2 = new ArrayList<>();

        for (char c : s1.toCharArray()) {
            if (!set1.add(c))
                arr1.add(c);
        }
        for (char c : s2.toCharArray()) {
            if (!set2.add(c))
                arr2.add(c);
        }
        arr1.sort(Comparator.naturalOrder());
        arr2.sort(Comparator.naturalOrder());
        return set1.equals(set2) && arr1.equals(arr2);
    }


}
