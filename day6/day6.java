import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day6 {

    public static int packetStartLength = 4;

    public static int messageStartLength = 14;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("./input.txt"));
        char[] c = scanner.next().trim().toCharArray();
        System.out.printf("Day 6 - Part 1\nThe packet start is at %d\n", getStartOfPacket(c));
        System.out.printf("Day 6 - Part 2\nThe packet start is at %d\n", getStartOfMessage(c));
    }

    public static int getStartOfPacket(char[] c) {
        return getStartOf(c, packetStartLength);
    }

    public static int getStartOfMessage(char[] c) {
        return getStartOf(c, messageStartLength);
    }

    public static int getStartOf(char[] c, int length) {
        int score = 0;
        for (int i = 0; i < c.length; i++) {
            if (isStartOf(c, i, length)) {
                score = i + length;
                break;
            }
        }
        return score;
    }

    public static boolean isStartOf(char[] c, int i, int length) {
        if (i > c.length || i + length > c.length) {
            return false;
        }
        for (int j = i; j <= i + length; j++) {
            for (int k = j + 1; k < i + length; k++) {
                if (c[j] == c[k]) {
                    return false;
                }
            }
        }
        return true;
    }
}
