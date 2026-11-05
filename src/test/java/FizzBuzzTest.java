import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class FizzBuzzTest {

    @Test
    void returnsFizzBuzzSequenceUpTo15() {
        assertEquals(List.of(
            "1", "2", "Fizz", "4", "Buzz",
            "Fizz", "7", "8", "Fizz", "Buzz",
            "11", "Fizz", "13", "14", "FizzBuzz"
        ), FizzBuzz.fizzBuzz(15));
    }
}
