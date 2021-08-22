import java.util.Arrays;

public class Niska {
    private char[] chars;

    public Niska() {

    }

    public Niska(char[] chars) {
        this.chars = chars;
    }

    public char[] getChars() {
        return chars;
    }

    public int length() {
        return chars.length;
    }

    public char charAt(int index) {
        return chars[index];
    }

    public boolean equals(Niska n) {
        String s1 = String.valueOf(chars);
        String s2 = String.valueOf(n.getChars());
        return s1.equals(s2);
    }

    public boolean equalsIgnoreCase(Niska n) {
        String s1 = String.valueOf(chars);
        String s2 = String.valueOf(n.getChars());
        return s1.equalsIgnoreCase(s2);
    }

    public Niska concat(Niska n) {
        String s1 = String.valueOf(chars);
        String s2 = String.valueOf(n.getChars());
        return new Niska(s1.concat(s2).toCharArray());
    }

    public Niska subNiska(int index) {
        String s = String.valueOf(chars);
        return new Niska(s.substring(index).toCharArray());
    }

    public Niska subNiska(int startIndex, int endIndex) {
        String s = String.valueOf(chars);
        return new Niska(s.substring(startIndex, endIndex).toCharArray());
    }

    public boolean startsWith(Niska n) {
        String s1 = String.valueOf(chars);
        String s2 = String.valueOf(n.getChars());
        return s1.startsWith(s2);
    }

    public boolean endsWith(Niska n){
        String s1 = String.valueOf(chars);
        String s2 = String.valueOf(n.getChars());
        return s1.endsWith(s2);
    }

    public Niska toLowerCase(){
        String s = String.valueOf(chars);
        return new Niska(s.toLowerCase().toCharArray());
    }

    public Niska toUpperCase(){
        String s = String.valueOf(chars);
        return new Niska(s.toUpperCase().toCharArray());
    }

    public int indexOf(char c){
        String s = String.valueOf(chars);
        return s.indexOf(c);
    }

    public int lastIndexOf(char c){
        String s = String.valueOf(chars);
        return s.lastIndexOf(c);
    }

    public Niska replace(Niska oldNiska, Niska newNiska){
        String s1 = String.valueOf(chars);
        String s2 = String.valueOf(oldNiska.getChars());
        String s3 = String.valueOf(newNiska.getChars());
        return new Niska(s1.replaceAll(s2, s3).toCharArray());
    }

    public boolean contains(char c){
        String s = String.valueOf(chars);
        return s.contains(String.valueOf(c));
    }

    public boolean contains(Niska n){
        String s1 = String.valueOf(chars);
        String s2 = String.valueOf(n.getChars());
        return s1.contains(s2);
    }

    public boolean isEmpty(){
        return String.valueOf(chars).isEmpty();
    }

    public boolean isBlank(){
        return String.valueOf(chars).isBlank();
    }

    public Niska repeat(Niska n){
        String s = String.valueOf(chars);
        int x = Integer.parseInt(String.valueOf(n.getChars()));
        return new Niska(s.repeat(x).toCharArray());
    }

    public Niska trim(){
        return new Niska(String.valueOf(chars).trim().toCharArray());
    }

    @Override
    public String toString() {
        return Arrays.toString(chars);
    }
}
