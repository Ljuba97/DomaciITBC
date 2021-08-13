import java.util.Scanner;

public class Zadatak1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input:");

        String teamA = sc.nextLine();
        String teamB = sc.nextLine();

        int teamAGold = sc.nextInt();
        int teamASilver = sc.nextInt();
        int teamABronze = sc.nextInt();

        int teamBGold = sc.nextInt();
        int teamBSilver = sc.nextInt();
        int teamBBronze = sc.nextInt();

        int teamATotal = teamAGold + teamASilver + teamABronze;
        int teamBTotal = teamBGold + teamBSilver + teamBBronze;

        if (teamATotal > teamBTotal) {
            System.out.println("Output:\n" + teamA);
        }
        else if (teamATotal < teamBTotal) {
            System.out.println("Output:\n" + teamB);
        }
        else if (teamAGold > teamBGold) {
            System.out.println("Output:\n" + teamA);
        }
        else if (teamAGold < teamBGold) {
            System.out.println("Output:\n" + teamB);
        }
        else if (teamASilver > teamBSilver) {
            System.out.println("Output:\n" + teamA);
        }
        else if (teamASilver < teamBSilver) {
            System.out.println("Output:\n" + teamB);
        }
        else if (teamABronze > teamBBronze) {
            System.out.println("Output:\n" + teamA);
        }
        else if (teamABronze < teamBBronze) {
            System.out.println("Output:\n" + teamB);
        }
        else {
            System.out.println("Nereseno");
        }
    }
}
