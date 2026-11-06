# Workshop: Unit Testing in Java with JUnit 5

## 1. Overview
You are given a small, working Java application (FizzBuzz). **Your job is not to change the application. Your job is to write unit tests for it** that are meaningful and reach **100% line and branch coverage**.

| | |
|---|---|
| **Repository** | https://github.com/meswright/excersize-1 |
| **Branch** | `main` |
| **Language / Build tool** | Java 17+ / Gradle (wrapper included) |
| **Test framework** | JUnit 5 (Jupiter) |
| **Editor** | Visual Studio Code with the Extension Pack for Java |
| **Coverage tool** | VS Code's built-in "Run Test with Coverage" (no build changes needed) |
| **File you will edit** | `src/test/java/FizzBuzzTest.java` |
| **File you must NOT edit** | `src/main/java/FizzBuzz.java` |

## 2. Learning objectives
By the end of this exercise you will be able to:
- Write JUnit 5 tests with clear names and real assertions.
- Use parameterized tests to cover many inputs without duplication.
- Identify and test edge cases and boundary values.
- Capture and verify console output (`System.out`) in a test.
- Measure code coverage in VS Code and understand what it does (and does not) tell you.

## 3. The application under test
`FizzBuzz.java` contains two methods:

```java
public static List<String> fizzBuzz(int n)   // builds the FizzBuzz list for 1..n
public static void main(String[] args)       // prints fizzBuzz(15), one item per line
```

For each number from 1 to `n`, `fizzBuzz` returns:

| Number is... | Output |
|---|---|
| divisible by both 3 and 5 | `"FizzBuzz"` |
| divisible by 3 only | `"Fizz"` |
| divisible by 5 only | `"Buzz"` |
| anything else | the number itself, as a string |

Example: `fizzBuzz(15)` returns
`1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz`

## 4. Prerequisites
- **JDK 17 or newer.** Check with `java -version`.
- **Git.**
- **Internet access** on the first build (Gradle and the libraries are downloaded).
- **Visual Studio Code** with the **Extension Pack for Java** (`vscjava.vscode-java-pack`). It includes the Test Runner for Java extension, which provides test coverage. Use the latest versions of VS Code and the extensions.

## 5. Getting started

```bash
git clone https://github.com/meswright/excersize-1.git
cd excersize-1
.\gradlew.bat run
.\gradlew.bat test
```

On macOS or Linux, use `./gradlew` instead of `.\gradlew.bat`.

`run` should print the FizzBuzz sequence for 1 to 15, and `test` should end in `BUILD SUCCESSFUL`.

### Troubleshooting
| Problem | Fix |
|---|---|
| `Unable to access jarfile ...gradle-wrapper.jar` | The wrapper jar is missing from the clone. Download it from `https://raw.githubusercontent.com/gradle/gradle/v9.7.1/gradle/wrapper/gradle-wrapper.jar` into `gradle/wrapper/`, or run `gradle wrapper` if you have Gradle installed. |
| `Failed to load JUnit Platform ... launcher` | Add `testRuntimeOnly 'org.junit.platform:junit-platform-launcher'` to the `dependencies` block of `build.gradle`. |
| Wrong Java version | Install JDK 17+ and make sure `JAVA_HOME` points to it. |

## 6. Your task
Write JUnit 5 tests in `src/test/java/FizzBuzzTest.java` that reach **100% coverage** of `FizzBuzz.java`, where every test also checks real behavior.

### 6.1 Coverage requirements
- 100% line coverage, and 100% branch coverage where VS Code reports it, measured with VS Code's test coverage feature (see section 7).
- Every branch must be exercised: the `FizzBuzz`, `Fizz`, `Buzz` and plain-number paths, and the loop running zero, one and many times.
- `main` must be covered. Capture `System.out` (for example with `System.setOut`), call `main`, and assert on the printed lines. Restore the original `System.out` afterwards.

### 6.2 Meaningful-test requirements
Coverage alone does not make a test good. A test that calls a method without asserting anything gets no credit.
- Every test must contain assertions on actual values.
- Your tests must fail if the logic is wrong. For example, if the `% 15` check were moved below the `% 3` check, at least one of your tests must fail.
- Cover these scenarios:
  - the basic sequence (`n = 15`)
  - each rule on its own: multiples of 3, of 5, of 15, and plain numbers
  - edge cases: `n = 0`, negative `n`, `n = 1`
  - the size and order of the returned list
  - the printed output of `main`
- Use at least one `@ParameterizedTest`.

### 6.3 Quality requirements
- Clear test names that say what is being checked.
- One behavior per test.
- No duplicated tests.

## 7. Measuring coverage in VS Code
No build changes are needed. VS Code can run your tests and show coverage directly.

1. Open the project folder (`excersize-1`) in VS Code and wait for the Java extensions to finish loading.
2. Open the **Testing** view (the flask icon in the left bar). Your tests appear under `FizzBuzzTest`. If they don't, run **Java: Clean Java Language Server Workspace** from the Command Palette (Ctrl+Shift+P).
3. Run the tests with coverage:
   - hover over `FizzBuzzTest` (or the whole project) in the Testing view and click the **Run Coverage** (shield with play) button, or
   - right-click a test in the editor and choose **Run Test with Coverage**.
4. View the results:
   - the **Test Coverage** panel lists coverage per file, and you need `FizzBuzz.java` to show **100%**
   - open `FizzBuzz.java`: covered lines are shaded green and uncovered lines are shaded red
   - to see the gutter shading again, use the **Toggle Inline Coverage** button in the Testing view

## 8. Run and verify

```bash
.\gradlew.bat test
```

- All tests must pass.
- The test report is at `build/reports/tests/test/index.html`.
- In VS Code, the **Test Coverage** panel must show 100% for `FizzBuzz.java`.

### Hints
- VS Code may report the implicit default constructor (the `public class FizzBuzz` line) as uncovered. A test that calls `new FizzBuzz()` closes that gap.
- JUnit's `@CsvSource` is a compact way to test many number-to-output pairs.
- To test `main`, save `System.out`, replace it with a `PrintStream` backed by a `ByteArrayOutputStream`, call `main`, then restore it in a `finally` block or an `@AfterEach` method.
## 9. Evaluation

| Criterion | Weight |
|---|---|
| 100% coverage of `FizzBuzz.java` shown in VS Code, with all tests passing | 40% |
| Assertions that check real behavior (your tests will be run against deliberately broken versions of `FizzBuzz`, and good tests catch them) | 30% |
| Edge cases and `main` output covered | 20% |
| Readability, naming, no duplication | 10% |

## 10. Rules
- Do not modify `src/main/java/FizzBuzz.java`.
- Do not exclude classes or methods from coverage to reach 100%.
- Do not add assertion-free tests just to raise coverage.

## 11. Submission
Submit your `FizzBuzzTest.java` and a screenshot of the VS Code Test Coverage panel showing 100% for `FizzBuzz.java`. Check with your instructor whether to submit by pull request, by email, or by uploading to the shared folder.

