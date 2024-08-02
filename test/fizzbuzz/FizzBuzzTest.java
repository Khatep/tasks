package fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {
    @Test
    public void testFizzBuzzWithValueDividedOnlyThree() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        Assertions.assertArrayEquals(fizzBuzz.fizzBuzz(3), "Fizz".getBytes());
    }

    @Test
    public void testFizzBuzzWithValueDividedOnlyFive() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        Assertions.assertArrayEquals(fizzBuzz.fizzBuzz(5), "Buzz".getBytes());
    }

    @Test
    public void testFizzBuzzWithValueDividedThreeAndFive() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        Assertions.assertArrayEquals(fizzBuzz.fizzBuzz(15), "FizzBuzz".getBytes());
    }

    @Test
    public void testFizzBuzzWithExceptionValue() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        Assertions.assertThrows(IllegalArgumentException.class, () -> fizzBuzz.fizzBuzz(11));
    }
}