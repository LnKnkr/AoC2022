import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDay6 {

    @Test
    public void TestPacketStartIsDetectedReturnsTrue() {
        boolean got = day6.isStartOf("abcd".toCharArray(), 0, day6.packetStartLength);
        Assertions.assertTrue(got);

        got = day6.isStartOf("bvwbjplbgvbhsrlpgdmjqwftvncz".toCharArray(), 1, day6.packetStartLength);
        Assertions.assertTrue(got);
    }

    @Test
    public void TestStringIsNotPacketStartReturnsFalse() {
        boolean got = day6.isStartOf("abca".toCharArray(), 7, day6.packetStartLength);
        Assertions.assertFalse(got);

        got = day6.isStartOf("bvwbjplbgvbhsrlpgdmjqwftvncz".toCharArray(), 7, day6.packetStartLength);
        Assertions.assertFalse(got);
    }

    @Test
    public void TestExample1ReturnsRightIndexOfPacketStart() {
        int got = day6.getStartOfPacket("bvwbjplbgvbhsrlpgdmjqwftvncz".toCharArray());
        Assertions.assertEquals(got, 5);

        got = day6.getStartOfPacket("nppdvjthqldpwncqszvftbrmjlhg".toCharArray());
        Assertions.assertEquals(got, 6);

        got = day6.getStartOfPacket("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg".toCharArray());
        Assertions.assertEquals(got, 10);

        got = day6.getStartOfPacket("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw".toCharArray());
        Assertions.assertEquals(got, 11);
    }

    @Test
    public void TestMessageStartReturnTrue() {
        boolean got = day6.isStartOf("mjqjpqmgbljsphdztnvjfqwrcgsmlb".toCharArray(), 5, day6.messageStartLength);
        Assertions.assertTrue(got);

        got = day6.isStartOf("bvwbjplbgvbhsrlpgdmjqwftvncz".toCharArray(), 9, day6.messageStartLength);
        Assertions.assertTrue(got);

        got = day6.isStartOf("nppdvjthqldpwncqszvftbrmjlhg".toCharArray(), 9, day6.messageStartLength);
        Assertions.assertTrue(got);

        got = day6.isStartOf("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg".toCharArray(), 15, day6.messageStartLength);
        Assertions.assertTrue(got);

        got = day6.isStartOf("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw".toCharArray(), 12, day6.messageStartLength);
        Assertions.assertTrue(got);
    }

    @Test
    public void TestExampleReturnCorrectMessageStartIndex() {
        int got = day6.getStartOfMessage("mjqjpqmgbljsphdztnvjfqwrcgsmlb".toCharArray());
        Assertions.assertEquals(got, 19);

        got = day6.getStartOfMessage("bvwbjplbgvbhsrlpgdmjqwftvncz".toCharArray());
        Assertions.assertEquals(got, 23);

        got = day6.getStartOfMessage("nppdvjthqldpwncqszvftbrmjlhg".toCharArray());
        Assertions.assertEquals(got, 23);

        got = day6.getStartOfMessage("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg".toCharArray());
        Assertions.assertEquals(got, 29);

        got = day6.getStartOfMessage("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw".toCharArray());
        Assertions.assertEquals(got, 26);
    }
}
