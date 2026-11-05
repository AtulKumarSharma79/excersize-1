# Exercise 1: FizzBuzz Unit Testing
 
## Problem Statement
 
This project contains a "FizzBuzz" implementation.
 
The method `fizzBuzz(int n)` returns a `List<String>` with one entry for each number from 1 to `n`, in order. Each entry is decided as follows:
 
| If the number is...                        | The entry is                    |
|--------------------------------------------|---------------------------------|
| divisible by both 3 and 5 (e.g 15) | `"FizzBuzz"`                    |
| divisible by 3 only                        | `"Fizz"`                        |
| divisible by 5 only                        | `"Buzz"`                        |
| none of the above                          | the number itself, as a string  |
 
**Input:** an integer `n`.
 
**Output:** a `List<String>` with `n` entries, in order from 1 to `n`.
 
**Example:** `fizzBuzz(15)` returns
`["1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"]`
 
## Your Task
 
Write unit tests in `FizzBuzzTest.java` to verify the behaviour of the `fizzBuzz()` method.
 
Requirements:
 
- Aim for **100% code coverage** of `fizzBuzz()`.
- Write only **meaningful** unit tests. Each test should check a specific behaviour with a clear assertion. Avoid tests that only run the code to raise the coverage number without checking the result.
 
## What to Submit
 
- Your completed `FizzBuzzTest.java`.
- Screenshots of the coverage report showing your coverage.