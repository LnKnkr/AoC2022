import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class day3 {

    static Map<Character, Integer> match;

    public static void main(String[] args) throws FileNotFoundException {
        createMatch();
        Scanner scanner = new Scanner(new File("./input.txt")).useDelimiter("\r\n");

        int score = 0;
        while (scanner.hasNext()) {
            score += getScore(scanner.next().trim());
        }
        System.out.printf("Day 3 - Part 1\nThe Sum of all priorities is %d\n", score);

        scanner = new Scanner(new File("./input.txt")).useDelimiter("\r\n");
        score = 0;
        while (scanner.hasNext()) {
            score += getTeamScore(scanner.next().trim(), scanner.next().trim(), scanner.next().trim());
        }
        System.out.printf("Day 3 - Part 2\nThe Sum of all priorities inside a team is %d\n", score);
    }

    public static int getTeamScore(String first, String second, String third) {
        int result = 0;
        char[] charsFirst = first.toCharArray();

        for (char c : charsFirst) {
            if (second.contains(Character.toString(c)) && third.contains(Character.toString(c))) {
                result = match.get(c);
            }
        }

        return result;
    }

    public static int getScore(String in) {
        String firstHalf = in.substring(0, in.length() / 2);
        String secondHalf = in.substring(in.length() / 2);
        char[] charsFirst = firstHalf.toCharArray();

        int result = 0;
        for (char c : charsFirst) {
            if (secondHalf.contains(Character.toString(c))) {
                result = match.get(c);
            }
        }
        return result;
    }

    private static void createMatch() {
        match = new HashMap<>();
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        int count = 0;
        for (char c : chars) {
            count++;
            match.put(c, count);
        }
    }
}
