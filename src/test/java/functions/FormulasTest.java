package functions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void constructExpressionString() {

        String expected = "y` = 10.0 + 5.0 * x";
        assertEquals(expected, Formulas.constructExpressionString(10.0, 5.0, 1));

    }
}