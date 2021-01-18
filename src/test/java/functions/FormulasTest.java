package functions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class FormulasTest {

    List<Double> numbers;

    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(15.2, 17.1, 22.0, 13.0, 15.8, 12.9);
    }

    @Test
    void getMean() {
        assertEquals(16.0, Formulas.getMean(numbers));
    }

    @Test
    void getMedian() {
        assertEquals(15.5, Formulas.getMedian(numbers));
    }

    @Test
    void getMode() {

        List<Double> doubles = Arrays.asList(1d, 2d, 5d, 5d, 5d, 6d);
        List<Double> doubles2 = Arrays.asList(1d, 2d, 5d, 5d, 5d, 6d, 6d, 6d, 6d);
        assertEquals(5d, Formulas.getMode(doubles));
        assertNotEquals(5d, Formulas.getMode(doubles2));
        assertEquals(6d, Formulas.getMode(doubles2));


    }

    @Test
    void getStandardDeviation() {
        List<Double> doubles = Arrays.asList(0.0, 5.6, 8.7, 14.1, 14.1, 15.0, 17.2, 19.2, 19.3, 24.1, 27.7);
        System.out.println("standard deviation: " + Formulas.getStandardDeviation(doubles));

    }

    @Test
    void getVariance() {
        List<Double> doubles = Arrays.asList(0.0, 5.6, 8.7, 14.1, 14.1, 15.0, 17.2, 19.2, 19.3, 24.1, 27.7);
        System.out.println("standard deviation: " + Formulas.getVariance(doubles));
    }

    @Test
    void getZScore() {
        List<Double> doubles = Arrays.asList(7.4, 7.9, 4.1, 8.1, 6.2, 7.1, 7.4, 6.7);
        System.out.println("z score = " + Formulas.getZScore(doubles));
    }

    @Test
    void constructExpressionString() {

        String expected = "y` = 10.0 + 5.0 * x";
        assertEquals(expected, Formulas.constructExpressionString(10.0, 5.0, 1));

    }
}