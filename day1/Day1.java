import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt")).useDelimiter("\r\n\r\n");

        ArrayList<Elve> elves = new ArrayList<>();

        while (scanner.hasNext()) {
            String temp = scanner.next();
            elves.add(new Elve(temp));
        }

        elves.sort(new Comparator<Elve>() {
            @Override
            public int compare(Elve o1, Elve o2) {
                if (o1.totalCalories == o2.totalCalories)
                    return 0;
                return o1.totalCalories < o2.totalCalories ? 1 : -1;
            }
        });

        System.out.printf("Day 1 - part 1\nThe elf with the most calories has %d calories as food", elves.get(0).totalCalories);
        System.out.printf("Day 1 - part 1\nThe elves with the most calories have %d calories as food", Elve.totalOfTopThree(elves));

    }
}
