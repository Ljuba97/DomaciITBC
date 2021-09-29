import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Zadatak1 {
    public static void main(String[] args) {
        //Sve brojeve deljive sa 3 uvecati za 2
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        System.out.println(list.stream().filter(x -> x % 3 == 0).map(x -> x + 2).collect(Collectors.toList()));

        //Izbaciti sve brojeve koji su deljivi sa 3 prilikom njihovog dupliranja
        System.out.println(list.stream().map(x -> x * x).filter(x -> x % 3 != 0).collect(Collectors.toList()));

        //Pomnoziti svaki neparan broj sa 2 i izbaciti duplikate
        List<Integer> arr = Arrays.asList(1, 2, 3, 3, 4, 2, 5, 6, 9, 10, 12, 7, 5);
        HashSet<Integer> set = arr.stream().map(x -> x % 2 != 0 ? x * 2 : x).collect(Collectors.toCollection(HashSet::new));
        System.out.println(set);
    }
}
