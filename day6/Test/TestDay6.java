import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class TestDay6 {

    @Test
    public void TestExample1ReturnsRightIndexOfPacketStart() {
        Scanner scanner = new Scanner("bvwbjplbgvbhsrlpgdmjqwftvncz");
        int got = day6.getIndexOfSequence(scanner, day6.packetStartLength);
        Assertions.assertEquals(got, 5);

        scanner = new Scanner("nppdvjthqldpwncqszvftbrmjlhg");
        got = day6.getIndexOfSequence(scanner, day6.packetStartLength);
        Assertions.assertEquals(got, 6);

        scanner = new Scanner("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg");
        got = day6.getIndexOfSequence(scanner, day6.packetStartLength);
        Assertions.assertEquals(got, 10);

        scanner = new Scanner("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw");
        got = day6.getIndexOfSequence(scanner, day6.packetStartLength);
        Assertions.assertEquals(got, 11);
    }

    @Test
    public void TestExampleReturnCorrectMessageStartIndex() {
        Scanner scanner = new Scanner("mjqjpqmgbljsphdztnvjfqwrcgsmlb");
        int got = day6.getIndexOfSequence(scanner, day6.messageStartLength);
        Assertions.assertEquals(got, 19);

        scanner = new Scanner("bvwbjplbgvbhsrlpgdmjqwftvncz");
        got = day6.getIndexOfSequence(scanner, day6.messageStartLength);
        Assertions.assertEquals(got, 23);

        scanner = new Scanner("nppdvjthqldpwncqszvftbrmjlhg");
        got = day6.getIndexOfSequence(scanner, day6.messageStartLength);
        Assertions.assertEquals(got, 23);

        scanner = new Scanner("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg");
        got = day6.getIndexOfSequence(scanner, day6.messageStartLength);
        Assertions.assertEquals(got, 29);

        scanner = new Scanner("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw");
        got = day6.getIndexOfSequence(scanner, day6.messageStartLength);
        Assertions.assertEquals(got, 26);
    }
}
