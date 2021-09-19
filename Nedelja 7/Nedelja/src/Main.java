import rs.itbootcamp.dao.*;
import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.FridgeModel;
import rs.itbootcamp.model.UserModel;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
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

    public static String vigenereEncryption(String text, String key) {
        String code = "";
        for (int i = 0, j = 0; i < text.length(); i++, j++) {
            char c = text.charAt(i);
            char k = key.charAt(j);
            c = (char) (((int) c + (int) k) % 128);
            code = code.concat(String.valueOf(c));
            if (j == key.length() - 1)
                j = -1;
        }
        return code;
    }

    public static String vigenereDecryption(String code, String key) {
        String text = "";
        for (int i = 0, j = 0; i < code.length(); i++, j++) {
            char c = code.charAt(i);
            char k = key.charAt(j);
            if ((int) c - k < 0)
                c = (char) (128 - Math.abs((int) c - k));
            else
                c = (char) ((int) c - k);
            text = text.concat(String.valueOf(c));
            if (j == key.length() - 1)
                j = -1;
        }
        return text;
    }

    static FoodDao fd = new FoodDaoSQL();
    static FridgeDao fridge = new FridgeDaoSQL();
    static MealDao md = new MealDaoSQL();
    static int fridgeId = 1;

    private static void addFoodToFridge(Scanner sc)
    {
        List<FoodModel> foodList = fd.getAllFood();

        int choice = -1;

        while (choice != 0) {
            for (int i = 0; i < foodList.size(); i++)
                System.out.println((i + 1) + ". " + foodList.get(i).getFood_name());
            System.out.println("0. Back");

            choice = sc.nextInt();

            if (choice > 0 && choice <= foodList.size()) {
                System.out.println("How much: (in grams)");
                double mass = sc.nextDouble();
                fd.addToFridge(fridgeId, foodList.get(choice - 1).getFood_id(), mass);
                System.out.println("++");
            }
        }
    }

    private static void removeFoodFromFridge(Scanner sc) {
        int choice = -1;

        while (choice != 0) {
            List<FoodModel> foodList = fd.getAllFood();
            for (int i = 0; i < foodList.size(); i++)
                System.out.println((i + 1) + ". " + foodList.get(i).getFood_name());
            System.out.println("0. Back");

            choice = sc.nextInt();

            if (choice > 0 && choice <= foodList.size()) {
                fd.delete(foodList.get(choice - 1).getFood_id());
                System.out.println("++");
            }
        }
    }

    private static void lookInFridge(Scanner sc) {
        List<FoodModel> foodList = fd.getAllFood();

        int choice = -1;

        while (choice != 0) {
            for (int i = 0; i < foodList.size(); i++)
                System.out.println((i + 1) + ". " + foodList.get(i).getFood_name());
            System.out.println("0. Back");

            choice = sc.nextInt();

            if (choice > 0 && choice <= foodList.size())
                System.out.println(foodList.get(choice - 1));
        }
    }

    private static void fridgeMenu(Scanner sc) {
        int choice = 0;

        do {
            System.out.println("Main menu:");
            System.out.println("---------------");
            System.out.println("1. Add food");
            System.out.println("2. Remove food");
            System.out.println("3. Look in");
            System.out.println("4. Create meal");
            System.out.println("0. Back");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addFoodToFridge(sc);
                case 2 -> removeFoodFromFridge(sc);
                case 3 -> lookInFridge(sc);
                case 4 -> System.out.println("Create meal");
                case 0 -> System.out.println();
                default -> System.out.println("Invalid option");
            }
        }
        while (choice != 0);
    }

    private static List<String> exclude(List<String> list, String s) {
        s = s.toLowerCase();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toLowerCase().contains(s)) {
                list.remove(i);
                i--;
            }
        }
        return list;
    }

    private static List<String> startsWith(List<String> list, String s) {
        s = s.toLowerCase();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).toLowerCase().startsWith(s)) {
                list.remove(i);
                i--;
            }
        }
        return list;
    }

    private static void searchByPages(List<String> list, int itemsPerPage, Scanner sc) {
        int page = 1;
        String s;

        do {
            if (itemsPerPage <= 0)
                break;
            for (int i = itemsPerPage * (page - 1); i < itemsPerPage * page; i++) {
                if (i >= list.size())
                    break;
                System.out.println(i + 1 + ". " + list.get(i));
            }
            System.out.println();
            System.out.println("-exclude s -> [Remove everything that contains specified String]");
            System.out.println("-startsWith s -> [Show those that start with specified String]");
            if (itemsPerPage * page < list.size())
                System.out.println("n -> [Next Page]");

            if (page > 1)
                System.out.println("p -> [Previous Page]");

            System.out.println("b -> [Back]");
            s = sc.next();

            if (s.equals("n") && itemsPerPage * page < list.size())
                page++;
            else if (s.equals("p") && page > 1)
                page--;
            else if (s.equals("-exclude")) {
                if (sc.hasNext()) {
                    s = sc.next();
                    searchByPages(exclude(list, s), itemsPerPage, sc);
                }
            }
            else if (s.equals("-startsWith")) {
                if (sc.hasNext()) {
                    s = sc.next();
                    searchByPages(startsWith(list, s), itemsPerPage, sc);
                }

            }
        }
        while (!s.equals("b"));
    }

    private static void searchMeals(Scanner sc) {
        int choice = 0;

        do {
            System.out.println("Search meals:");
            System.out.println("---------------");
            System.out.println("1. All meals");
            System.out.println("2. Search by name or description");
            System.out.println("0. Back");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter how many items you want per page");
                    int items = sc.nextInt();
                    searchByPages(md.getAllMealNames(), items, sc);
                }
                case 2 -> {
                    System.out.println("Enter text which your meal will contain");
                    sc.skip("[\r\n]+");
                    String s = sc.nextLine();
                    System.out.println("Enter how many items you want per page");
                    int items = sc.nextInt();
                    searchByPages(md.getMealNames(s), items, sc);
                }
                case 0 -> System.out.println();
                default -> System.out.println("Invalid option");
            }
        }
        while (choice != 0);
    }

    private static void mealMenu(Scanner sc) {
        int choice = 0;

        do {
            System.out.println("Main menu:");
            System.out.println("---------------");
            System.out.println("1. Search meal");
            System.out.println("0. Back");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> searchMeals(sc);
                case 0 -> System.out.println();
                default -> System.out.println("Invalid option");
            }
        }
        while (choice != 0);
    }

    private static void mainMenu(Scanner sc) {
        int choice = 0;

        do {
            System.out.println("Main menu:");
            System.out.println("---------------");
            System.out.println("1. My Fridge");
            System.out.println("2. Meals");
            System.out.println("3. All food");
            System.out.println("4. Add new food");
            System.out.println("0. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> fridgeMenu(sc);
                case 2 -> mealMenu(sc);
                case 3 -> System.out.println("All food");
                case 4 -> System.out.println("Add new food");
                case 0 -> System.out.println("Exiting...");
                default -> {
                    System.out.println("Invalid option");
                }
            }
        }
        while (choice != 0);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        mainMenu(sc);
    }
}
