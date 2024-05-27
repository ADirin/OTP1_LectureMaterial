# Unit 5- Testing

## Objective:
The objective of this assignment is to familiarize yourself with Eclipse's JUnit 5 testing environment and determine test coverage.

## Steps:
1. **Create Maven Project:**
   - Create a Maven project and add the necessary specifications for testing to the `pom.xml` file.

2. **Import Code:**
   - Unzip the file [laskinEnglish.zip](laskinEnglish.zip).
   - Drag and drop the extracted codes (`src`, `test`) into your project.
   - If special characters are not displayed correctly, change the character encoding at the Eclipse Workspace level:
     - Select `Window` | `Preferences` | `General` | `Workspace`.
     - Set `Text file encoding` to `UTF-8`.

### PART 1 OF THE TASK: Coverage

> Important to note that you need to add proper reporting plugins, e.g., JACOCO in POM.XML

3. **Run Application and Tests:**
   - Launch `Main.java` and verify from the output that there are errors in the implementation.
   - Run the JUnit tests:
     - Right-click on the project name in the Project Explorer.
     - Select `Run As` | `JUnit Test`.
   - Some tests will pass while others will not.

4. **Determine Test Coverage:**
   - Run a coverage analysis:
     - Right-click on the project name in the Package Explorer.
     - From the `Coverage As` menu, choose either "1 Java Application" or "2 JUnit Test".
   - The coverage summary appears on the `Coverage` tab at the bottom of the screen.

### PART 2 OF THE TASK: JUnit 5

5. **Fix Errors and Enhance Testing:**
   - Correct the intentional errors in the tests.
   - Complete missing parts and methods (including `product()` and `squareroot()`).
   - Ensure comprehensive testing and create additional test methods if necessary.

6. **Parameterized Test:**
   - Refactor the `ExtraTest` class to use parameterized arrays for testing.

7. **Handle Floating-Point Numbers:**
   - Modify the calculator to handle double-precision floating-point numbers.
   - Provide a delta value when comparing floating-point numbers in assert routines.

8. **Regression Testing:**
   - After making changes, conduct regression testing by running the test suite to ensure all tests pass.

9. **Run Tests with Maven:**
   - Run tests with Maven:
     - Right-click on the project name and select `Run As` | `Maven test`.
   - View test results in the `target/surefire-reports` directory.

## Resources:
- [EclEmma plugin](http://www.eclemma.org/)
- [Code coverage](http://en.wikipedia.org/wiki/Code_coverage)
- [Java Code Coverage Tools](http://en.wikipedia.org/wiki/Java_Code_Coverage_Tools)

## Submission:
- Save the coverage report as an HTML page.
- Attach a screenshot of the test results from Maven.
