package fizzbuzz;

public class FizzBuzz {
    public byte[] fizzBuzz(int value) {
        if (value % 3 == 0 && value % 5 == 0) {
            return "FizzBuzz".getBytes();
        } else if (value % 3 == 0) {
            return "Fizz".getBytes();
        } else if (value % 5 == 0) {
            return "Buzz".getBytes();
        } else {
            throw new IllegalArgumentException();
        }
    }
}