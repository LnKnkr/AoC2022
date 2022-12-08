import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day6 {

    public static int packetStartLength = 4;

    public static int messageStartLength = 14;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("./input.txt"));

        System.out.printf("Day 6 - Part 1\nThe packet start is at %d\n", getIndexOfSequence(scanner, packetStartLength));

        scanner = new Scanner(new File("./input.txt"));
        System.out.printf("Day 6 - Part 2\nThe packet start is at %d\n", getIndexOfSequence(scanner, messageStartLength));

        scanner.close();
    }

    public static int getIndexOfSequence(Scanner sc, int size){
        sc.useDelimiter("");
        ArrayList<Character> current = new ArrayList<>();
        int index = 0;
        while(sc.hasNext()){
            if(current.size() == size){
                break;
            }
            
            Character next = sc.next().trim().charAt(0);
            if(current.contains(next)){
                int i = current.lastIndexOf(next);
                current.subList(0,i+1).clear();
                current.add(next);
            }else{
                current.add(next);
            }
            index++;
        }
        return index;
    }
}
