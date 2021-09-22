package Stek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Zadaci {
    /*
     * 1. Palacinke
     * Sara pravi palacinke sa dzemom, nutelom i sunkom za svoje drugare.
     * Funkciji se prosledjuje niska sa vrstom palacinke koju je Sara napravila, odvojene novim redom, redom;
     * kao i broj n koji oznacava koliko palacinaka ce pojesti Sarini prijatelji.
     * Ispisati kojim redom ce koje palacinke Sara pojesti posle svojih drugara, ako znamo da ce da pojede sve koje ostanu.
     *
     * NPR:
     * Nutela
     * Sunka
     * Nutela
     * Dzem
     * 2
     * ---------
     * Sunka
     * Nutela
     * */

    public static String palacinke(String s, int n){
        Stack<String> stack = new Stack<>();
        String[] str = s.split("\n");
        for (int i = 0; i < str.length; i++)
            stack.push(str[i]);
        s = "";
        while (!stack.isEmpty()) {
            if (n == 0)
                s = s.concat(stack.pop()).concat("\n");
            else {
                stack.pop();
                n--;
            }
        }
        s = s.trim();
        if (s.equals(""))
            return ":(";
        return s;
    }

    /*
     * 2. Istorija web pregledaca
     * Прегледач веба памти историју посећених сајтова и корисник има могућност да се враћа унатраг на сајтове које је раније посетио.
     * Написати програм који симулира историју прегледача тако што се учитавају адресе посећених сајтова (свака у посебном реду),
     * а када се учита ред у коме пише back прегледач се враћа на последњу посећену страницу.
     * Ако се наредбом back вратимо на почетну страницу, исписати -.
     * Ако се на почетној страници изда наредба back, остаје се на почетној страници.
     * Програм треба да испише све сајтове које је корисник посетио.
     * Улаз: Са стандардног улаза се учитавају веб-адресе, свака у посебној линији, koje се даље уписују у String, свака у посебном реду.
     * Излаз: Вратити String са исписаним сајтовима редом посећиваним.
     * */

    public static String history(String search){
        Stack<String> stack = new Stack<>();
        String[] str = search.split("\n");
        search = "";
        for (int i = 0; i < str.length; i++) {
            if (!str[i].equals("back")) {
                search = search.concat(str[i]).concat("\n");
                stack.push(str[i]);
            }
            else {
                if (!stack.isEmpty())
                    stack.pop();
                if (!stack.isEmpty())
                    search = search.concat(stack.peek().concat("\n"));
                else
                    search = search.concat("-\n");
            }

        }
        search = search.trim();
        return search;
    }

    /*
     * 3. Uparenost zagrada:
     * У изразу учествују следеће врсте заграда (, ), {, }, [ и ].
     * Напиши програм који проверава да ли су у унетом изразу заграде исправно упарене.
     * Улаз: Са стандардног улаза се уноси израз (цео у једном реду, без размака), које се даље уписују у String.
     * Излаз: Boolean.
     * */

    public static boolean uparenost(String s){
        Stack<Character> stack = new Stack<>();
        for (char zagrada : s.toCharArray()) {
            if (zagrada == '(' || zagrada == '[' || zagrada == '{')
                stack.push(zagrada);
            switch (zagrada) {
                case ')':
                    if (stack.peek().equals('('))
                        stack.pop();
                    else
                        return false;
                    break;
                case ']':
                    if (stack.peek().equals('['))
                        stack.pop();
                    else
                        return false;
                    break;
                case '}':
                    if (stack.peek().equals('{'))
                        stack.pop();
                    else
                        return false;
                    break;
                default: break;
            }
        }
        return true;
    }

    /*
     * 4. Uzastopni brojevi
     * Низ се трансформише тако што се сваких 2 узастопних појављивања неког елемента бришу.
     * Напиши програм који одређује садржај низа након исцрпне примене ове трансформације.
     * Улаз:Са стандардног улаза се учитава елементи низа.
     * Излаз: На стандардни излаз исписати елементе резултујућег низа, раздвојене размаком.
     * NPR:
     * 1 1 2 2 2 2 1 3 4 4 5 5 4 4 3 2 1 1 1
     * "1 3 3 2 1"
     * */

    public static String uzastopni(int[] arr){
        Stack<Integer> stack = new Stack<>();
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
            if (i < arr.length - 1 && arr[i + 1] == stack.peek()) {
                stack.pop();
                i++;
            }
            else
                res = res.concat(String.valueOf(stack.peek())).concat(" ");
        }
        res = res.trim();
        return res;
    }

    /*
     * 5. Linijski editor
     * Sa standardnog ulaza se unose niske karaktera koje opisuju neku akciju. Akcije su sledece:
     * iX - korisnike je otkucao karakter X
     * < - korisnik je pritisnuo taster levo
     * > - korisnik je pritisnuo taster desno
     * b - korisnik je pritisnuo taster backspace za brisanje karaktera iza kursora
     * d - korisnik je pritisnuo taster delete za brisanje karaktera ispred kursora
     *
     * Vratiti String dobijen izvrsavanjem svih ackija
     *
     * NPR:    cb
     * iaib<bic>>
     * cb
     *
     * c b
     *
     * Objasnjenje:
     * Tekst     Naredba
     * |         ia
     * a|        ib
     * ab|       <
     * a|b       b
     * |b        ic
     * c|b       >
     * cb|       >
     * cb|
     *
     * */

    public static String console(String input){
        char[] arr = input.toCharArray();
        Stack<Character> stackLeft = new Stack<>();
        Stack<Character> stackRight = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 'i' -> {
                    stackLeft.push(arr[i + 1]);
                    i++;
                }
                case '<' -> {
                    if (!stackLeft.isEmpty())
                        stackRight.push(stackLeft.pop());
                }
                case '>' -> {
                    if (!stackRight.isEmpty())
                        stackLeft.push(stackRight.pop());
                }
                case 'b' -> {
                    if (!stackLeft.isEmpty())
                        stackLeft.pop();
                }
                case 'd' -> {
                    if (!stackRight.isEmpty())
                        stackRight.pop();
                }
            }
        }
        input = "";
        while (!stackLeft.isEmpty())
            stackRight.push(stackLeft.pop());
        while (!stackRight.isEmpty())
            input = input.concat(String.valueOf(stackRight.pop()));

        return input;
    }

    /*
     * 6. Vrednost postfiksnog izraza
     * Са стандардног улаза се учитава постфиксно записан израз
     * који садржи једноцифрене бројеве и операторе +, -, * и / (без размака).
     * Ispisati vrednost izraza
     *
     * NPR:
     * 12+3*
     * 9
     *
     * Objasnjenje:
     * 12+3* -> (1+2)*3 = 3*3 = 9
     * */

    public static int eval(String s){
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c))
                stack.push(Character.getNumericValue(c));
            else {
                if (c == '+')
                    stack.push(stack.pop() + stack.pop());
                else if (c == '*')
                    stack.push(stack.pop() * stack.pop());
                else if (c == '-') {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                }
                else {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                }
            }
        }
        return stack.pop();
    }


    /*
     * 7. Berza
     * Duzina Si cene nekoe hartije ne berzi je definisana kao najveci broj uzastopnih dana,
     * pre datog dana, za koje je cena hartije manja ili jednaka trenutnoj ceni.
     * Za dat niz cena jedne hartije, vratiti niz duzina Si za svaki od tih dana
     *
     * NPR:
     * Cene po danima:      [100, 80, 60, 70, 60, 75, 85]
     * Si duzine po danima: [  1,  1,  1,  2,  1,  4,  6]
     * */
    //
    // 60, 80, 100
    // br = 1
    public static int[] hartije(int... hartija){
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();
        int[] arr = new int[hartija.length];

        for (int i = 0; i < hartija.length; i++) {
            int x = hartija[i];
            int br = 1;
            leftStack.push(x);
            while (!leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
                if (!leftStack.isEmpty() && x >= leftStack.peek())
                    br++;
                else
                    break;
            }
            while (!rightStack.isEmpty())
                leftStack.push(rightStack.pop());
            arr[i] = br;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}