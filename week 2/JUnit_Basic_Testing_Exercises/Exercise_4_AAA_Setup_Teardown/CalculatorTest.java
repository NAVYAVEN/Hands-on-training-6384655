import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class CalculatorTest {

    Calculator calc;

    @BeforeEach
    public void setup() {
        calc = new Calculator();
    }

    @AfterEach
    public void teardown() {
        calc = null;
    }

    @Test
    public void testAddition() {
        // Arrange
        int a = 10;
        int b = 5;

        // Act
        int result = calc.add(a, b);

        // Assert
        assertEquals(15, result);
    }

    class Calculator {
        int add(int a, int b) {
            return a + b;
        }
    }
}