package vectors_question;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VectorsTest {

    @Test
    public void findShortest_VectorsWithDifferentLength_returnShortest() {
        int[][] vectors = {
                new int[]{1, 1, 1},
                new int[]{2, 2, 2},
                new int[]{3, 3, 3}
        };
        int[] shortest = Vectors.findShortest(vectors);
        Assertions.assertArrayEquals(shortest, vectors[0]);
    }

    @Test
    public void findShortest_VectorsWithSameLength_returnShortest() {
        int[][] vectors = {
                new int[]{1, 1, 1},
                new int[]{1, 1, 1},
                new int[]{1, 1, 1}
        };
        int[] shortest = Vectors.findShortest(vectors);
        Assertions.assertArrayEquals(shortest, vectors[0]);
    }
}
