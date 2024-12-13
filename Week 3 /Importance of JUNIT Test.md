
# Importance of Unit Testing


![Unit Test](/Images/UNITTEST.gif)



## Introduction

In software development, unit testing is a crucial practice aimed at verifying that individual units or components of the code function correctly. These units are typically small and isolated, such as functions or methods. Unit testing ensures that each unit behaves as expected, helping to detect and prevent bugs early in the development process.

## Why Unit Testing?

### 1. Early Detection of Bugs

Unit tests allow developers to catch bugs at an early stage of development. By testing individual units in isolation, developers can identify and fix issues before they escalate into larger problems.

### 2. Facilitates Refactoring

Unit tests provide a safety net when refactoring code. Developers can confidently modify code knowing that if they inadvertently break existing functionality, the unit tests will catch it.

### 3. Improves Code Quality

Writing unit tests encourages developers to write modular and loosely-coupled code. This improves code quality, making it easier to maintain and extend in the future.

### 4. Documentation and Examples

Unit tests serve as documentation for how the code should behave. They also serve as examples for other developers, demonstrating how to use and interact with various components of the codebase.

# JUnit Setup in IntelliJ IDEA

IntelliJ IDEA provides a streamlined way to set up and run JUnit tests. Follow these steps to configure JUnit in your IntelliJ IDEA project:

## Option I
1. **Open IntelliJ IDEA**:
   - Launch IntelliJ IDEA and open your project.

2. **Open Project Structure**:
   - Navigate to `File` > `Project Structure` (or press `Ctrl + Alt + Shift + S` on Windows/Linux, or `Cmd + ;` on macOS).

3. **Add JUnit Dependency**:

   - **For Maven Projects**:
     1. Select `Modules` from the left-hand menu.
     2. Choose the module where you want to add the dependency.
     3. Go to the `Dependencies` tab.
     4. Click the `+` icon and select `Library`.
     5. Choose `From Maven` and search for `junit:junit:4.13.2` (for JUnit 4) or `org.junit.jupiter:junit-jupiter-api:5.8.2` (for JUnit 5).
     6. Select the appropriate version and click `OK`.

   - **For Gradle Projects**:
     1. Select `Modules` from the left-hand menu.
     2. Choose the module where you want to add the dependency.
     3. Go to the `Dependencies` tab.
     4. Click the `+` icon and select `Library`.
     5. Choose `From Maven` and search for `org.junit.jupiter:junit-jupiter-api:5.8.2` (for JUnit 5).
     6. Select the appropriate version and click `OK`.

4. **Apply Changes**:
   - Click `Apply` and `OK` to save the changes and close the Project Structure window.

## Option II

## 1. **Create a New Project or Open an Existing Project**

- **New Project**: Open IntelliJ IDEA and create a new Java project.
- **Existing Project**: Open your existing project where you want to add JUnit tests.

## 2. **Add JUnit Dependency**

### For Maven Projects

1. **Open `pom.xml`**: Navigate to the `pom.xml` file in your project.
2. **Add JUnit Dependency**: Insert the following dependencies inside the `<dependencies>` section:

    ```xml
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.8.2</version> <!-- or the latest version -->
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>5.8.2</version> <!-- or the latest version -->
        <scope>test</scope>
    </dependency>
    ```

3. **Refresh Maven**: Click the `Reload` button in the Maven tool window to update the project.

### For Gradle Projects

1. **Open `build.gradle`**: Navigate to the `build.gradle` file in your project.
2. **Add JUnit Dependency**: Add the following to the `dependencies` section:

    ```groovy
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.2' // or the latest version
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.2' // or the latest version
    ```

3. **Sync Gradle**: Click the `Sync Now` button that appears or use the Gradle tool window to refresh the project.

## 3. **Create a Test Class**

1. **Navigate to the Class**: Open the Java class you want to test or create a new one.
2. **Generate Test Class**:
    - Right-click on the class or method you want to test.
    - Select `Generate` (or press `Alt + Insert` on Windows/Linux or `Cmd + N` on macOS).
    - Choose `Test...` from the dropdown.
    - In the dialog, select the test framework (JUnit 5), and configure the test class or methods as needed.
    - Click `OK` to generate the test class.

## 4. **Write Test Methods**

In the generated test class, add your test methods. Ensure that the test methods are annotated with `@Test` from JUnit 5.

### Example

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTests {

    @Test
    public void testAddition() {
        assertEquals(2, 1 + 1);
    }
}
## 5. Run Tests
1. Run Individual Tests:

- Right-click on the test method or class.
- Select Run 'MyTests' to execute the selected test or test class.
2. Run All Tests:

- Open the Run menu and select Run All Tests.
- Alternatively, use the Run button in the top right corner of the editor.
## 6. View Test Results
- After running the tests, the test results will appear in the Run tool window at the bottom of the IntelliJ IDEA window.
- You can view the results, including passed and failed tests, and examine detailed reports.
## Summary
1. Add JUnit Dependency: Include JUnit in your Maven or Gradle configuration.
2. Create and Write Tests: Generate test classes and methods using IntelliJ IDEA’s built-in tools.
3. Run and View Tests: Execute tests and review results in the IDE.

````
__________________________________

## Example Application: Calculator

Let's consider a simple example application: a calculator that performs basic arithmetic operations (addition, subtraction, multiplication, division).

### Demonstration: Unit Testing in IntelliJ IDEA

### Step 1: Create a New Java Project

1. Open IntelliJ IDEA and select "Create New Project" from the welcome screen.

2. Choose "Java" from the left-hand menu and click "Next."

3. Fill in the project name and location, then click "Finish" to create the project.

### Step 2: Write the Calculator Class

Create a new Java class named `Calculator` with methods for addition, subtraction, multiplication, and division.

```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
}

### Step 3: Write Unit Tests
Create a new Java class named CalculatorTest for unit tests.

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    public void testSubtraction() {
        assertEquals(1, calculator.subtract(3, 2));
    }

    @Test
    public void testMultiplication() {
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    public void testDivision() {
        assertEquals(2, calculator.divide(6, 3));
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(6, 0));
    }
}
````
### Step 4: Run Unit Tests
Right-click on the CalculatorTest class and select "Run 'CalculatorTest'".

IntelliJ IDEA will execute the unit tests and display the results in the "Run" tool window.

Green checkmarks indicate successful tests, while red crosses indicate failures.

---------------------------------
# Test-Driven Development (TDD) Process

In Test-Driven Development (TDD), the process is often summarized by the three steps: **Red, Green, Refactor**. Here's what each of these steps involves:

## Red

1. **Write a Test**: Start by writing a unit test for the new functionality you want to add. Since the functionality hasn't been implemented yet, this test will fail.
2. **Run the Test and Fail**: After writing the test, run it to ensure that it fails. This confirms that the test is working correctly and that the functionality isn't accidentally already in place.
3. **Why Red?**: The term "Red" comes from many IDEs and testing tools that show failing tests in red, indicating that the code does not yet meet the desired requirements.

## Green

1. **Implement the Code**: Write the minimal amount of code necessary to make the failing test pass. The goal here is not to write perfect code, but just enough to satisfy the test.
2. **Run the Test and Pass**: After implementing the code, run the test again. If it passes, you’ve confirmed that the implementation works as expected.
3. **Why Green?**: The term "Green" refers to the green color that testing tools often use to indicate that all tests have passed.

## Refactor

1. **Clean Up the Code**: With the test now passing, review and improve the codebase. This might involve removing duplication, simplifying complex logic, improving naming, and adhering to coding standards.
2. **Run the Tests Again**: After refactoring, run all the tests to ensure that your changes haven't broken any functionality. All tests should still pass.
3. **Why Refactor?**: This step ensures that the code is not only functional but also clean, maintainable, and scalable. Refactoring helps in maintaining a high-quality codebase as the software evolves.



# Test-Driven Development (TDD) with Java:  (Example)

## Objective
Understand the principles of Test-Driven Development (TDD) and apply them by incrementally building a `TemperatureConverter` class using JUnit tests in IntelliJ IDEA.

## Introduction to TDD
Test-Driven Development (TDD) is a software development process in which you write tests for a new feature before implementing the feature itself. The TDD cycle typically involves the following steps:

1. **Write a Test**: Start by writing a test that defines a function or improvements of a function.
2. **Run the Test and Fail**: The test should fail initially because the function is not implemented yet.
3. **Implement the Function**: Write the minimum amount of code required to pass the test.
4. **Run the Test and Pass**: Ensure the test now passes with the implementation.
5. **Refactor**: Clean up the code while ensuring the test still passes.
6. **Repeat**: Continue the cycle for each new functionality.

## Step-by-Step TDD Example: Temperature Conversion

### Step 1: Set Up the Project in IntelliJ IDEA
1. **Create a New Project**:
   - Open IntelliJ IDEA.
   - Go to `File > New > Project`.
   - Choose `Java` as the project type.
   - Name the project `TemperatureConverterTDD` and set the location.
   - Click `Finish`.

### Step 2: Write the First Test
Start by writing a simple test to convert Fahrenheit to Celsius.

1. **Create the Test Class**:
   - Right-click on the `src` directory and select `New > Java Class`.
   - Name the class `TemperatureConverterTest`.
   - Add the following code to the test class:

   ```java
   import org.junit.Test;
   import static org.junit.Assert.*;

   public class TemperatureConverterTest {

       @Test
       public void testFahrenheitToCelsius() {
           TemperatureConverter converter = new TemperatureConverter();
           assertEquals(0, converter.fahrenheitToCelsius(32), 0.01);
       }
   }
### Explanation:

- The test asserts that 32°F is equivalent to 0°C.
2. **Run the Test:**
- Right-click on the TemperatureConverterTest class and select Run 'TemperatureConverterTest'.
- The test will fail since the TemperatureConverter class doesn't exist yet.

### Step 3: Implement the Functionality
Now that the test is failing, implement the simplest solution to pass the test.

1. Create the TemperatureConverter Class:
- Right-click on the src directory and select New > Java Class.
- Name the class TemperatureConverter.
- Implement the fahrenheitToCelsius method:

```java
public class TemperatureConverter {
    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
````
2. Run the Test Again:

- Run the TemperatureConverterTest class.
- The test should now pass.

### Step 4: Add More Tests
Following TDD, we will now write more tests for other functionalities.

1. Test for Celsius to Fahrenheit:
- Add the following test to the TemperatureConverterTest class:
```java
@Test
public void testCelsiusToFahrenheit() {
    TemperatureConverter converter = new TemperatureConverter();
    assertEquals(32, converter.celsiusToFahrenheit(0), 0.01);
}

```
Explanation:

- This test checks if 0°C is converted to 32°F.
2. Run the Test:
- The test will fail since the celsiusToFahrenheit method is not yet implemented.
3. Implement the Method:
- Add the celsiusToFahrenheit method to the TemperatureConverter class:
```java
public double celsiusToFahrenheit(double celsius) {
    return (celsius * 9 / 5) + 32;
}
```

4. Run the Test Again:

- The test should pass now that the method is implemented.
### Step 5: Add a Test for Edge Cases
1. Test for Extreme Temperatures:
- Add a test method to check for extreme temperatures:
```Java
@Test
public void testIsExtremeTemperature() {
    TemperatureConverter converter = new TemperatureConverter();
    assertTrue(converter.isExtremeTemperature(-50));
    assertFalse(converter.isExtremeTemperature(20));
    assertTrue(converter.isExtremeTemperature(60));
}

```
2. Run the Test:

- The test will fail because the isExtremeTemperature method is not implemented.
3. Implement the Method:
- Add the following method to the TemperatureConverter class:
```java
public boolean isExtremeTemperature(double celsius) {
    return celsius < -40 || celsius > 50;
}
```
4. Run the Test Again:

- All tests should pass, demonstrating the successful implementation of the functionality.
### Step 6: Refactor the Code
1. Review and Clean Up:

- Check if there’s any redundant code or if anything can be optimized.
- Make sure the code is clean and well-organized.
2. Run All Tests:
- After refactoring, run all the tests again to ensure that everything still works as expected.
## Conclusion
This exercise illustrates the power of Test-Driven Development. By writing tests first and implementing only the necessary code to pass those tests, we ensure that our software is reliable, bug-free, and easier to maintain. TDD encourages a disciplined approach to writing code, which helps in building robust and scalable applications.

____________________________________________________________________________________________________________________________________


# Testing Concepts

In software development, **acceptance testing** and **unit testing** are two fundamental types of testing that serve different purposes. Below, we define each concept and provide examples using the `TemperatureConverter` class.

## Unit Testing

**Unit Testing** focuses on testing individual components or methods in isolation to ensure they function correctly. Unit tests are typically written by developers during the coding process and are aimed at validating the correctness of the smallest parts of the codebase.

### Example for `TemperatureConverter` Class

For the `TemperatureConverter` class, unit tests might include:

#### Testing `fahrenheitToCelsius` Method

```java
@Test
public void testFahrenheitToCelsius() {
    TemperatureConverter converter = new TemperatureConverter();
    
    // Test normal case
    assertEquals(0.0, converter.fahrenheitToCelsius(32.0), 0.01);
    
    // Test negative Fahrenheit
    assertEquals(-40.0, converter.fahrenheitToCelsius(-40.0), 0.01);
    
    // Test very high Fahrenheit
    assertEquals(100.0, converter.fahrenheitToCelsius(212.0), 0.01);
}
```

Testing celsiusToFahrenheit Method
```java
@Test
public void testCelsiusToFahrenheit() {
    TemperatureConverter converter = new TemperatureConverter();
    
    // Test normal case
    assertEquals(32.0, converter.celsiusToFahrenheit(0.0), 0.01);
    
    // Test negative Celsius
    assertEquals(-40.0, converter.celsiusToFahrenheit(-40.0), 0.01);
    
    // Test very high Celsius
    assertEquals(212.0, converter.celsiusToFahrenheit(100.0), 0.01);
}


```
Testing isExtremeTemperature Method
````java

@Test
public void testIsExtremeTemperature() {
    TemperatureConverter converter = new TemperatureConverter();
    
    // Test extreme temperatures
    assertTrue(converter.isExtremeTemperature(-41.0));
    assertTrue(converter.isExtremeTemperature(51.0));
    
    // Test non-extreme temperatures
    assertFalse(converter.isExtremeTemperature(0.0));
    assertFalse(converter.isExtremeTemperature(30.0));
}


`````
## Acceptance Testing
**Acceptance Testing** focuses on verifying that the entire system or a specific feature meets the defined requirements and behaves as expected in real-world scenarios. Acceptance tests are usually written from the perspective of the end-user and are often executed after unit tests. They are aimed at ensuring the application meets business needs and user requirements.

### Example for TemperatureConverter Class
For the TemperatureConverter class, acceptance tests might be designed to check how the class integrates into a larger system or how it meets user requirements:

### Test Overall Conversion Accuracy
```java
@Test
public void testOverallConversionAccuracy() {
    TemperatureConverter converter = new TemperatureConverter();
    
    // Test a series of conversions to ensure accuracy
    double fahrenheit = 100.0;
    double celsius = converter.fahrenheitToCelsius(fahrenheit);
    assertEquals(fahrenheit, converter.celsiusToFahrenheit(celsius), 0.01);
}


```
Test Extreme Temperature Handling
```java
@Test
public void testExtremeTemperatureHandling() {
    TemperatureConverter converter = new TemperatureConverter();
    
    // Ensure extreme temperature checking is correct
    assertTrue(converter.isExtremeTemperature(-50.0));
    assertTrue(converter.isExtremeTemperature(60.0));
    assertFalse(converter.isExtremeTemperature(-30.0));
    assertFalse(converter.isExtremeTemperature(40.0));
}
```
## Summary
- Unit Testing: Tests individual methods and components in isolation to ensure they work correctly. It's developer-focused and typically done during the development phase.

- Acceptance Testing: Validates the functionality of the system or feature against user requirements and real-world scenarios. It ensures that the overall system or feature works as intended from an end-user perspective.

------------------------------------------------------

# Introduction to Annotations in Java

Annotations in Java are a powerful feature used to provide metadata about the code. They serve several important purposes:

## 1. Code Clarity and Readability
Annotations make code easier to understand by clearly indicating the purpose of methods, classes, or fields. For example, `@Override` tells the reader that a method is intended to override a method in a superclass.

## 2. Framework and Library Integration
Annotations allow frameworks and libraries to interact with the code in a standardized way. For instance, JUnit uses annotations like `@Test`, `@BeforeEach`, and `@AfterEach` to identify and manage test methods and setup/teardown processes without requiring developers to write boilerplate code.

## 3. Compile-Time Checking
Certain annotations, such as `@Deprecated` or `@SuppressWarnings`, are used to enforce rules or suppress warnings during compilation, helping maintain clean and error-free code.

## 4. Runtime Processing
Some annotations, like those used in Java EE or Spring frameworks, provide instructions that can be processed at runtime. This is often used for configuration, dependency injection, or transaction management.

Overall, annotations streamline development by reducing boilerplate, enhancing code maintainability, and enabling powerful integrations with various tools and frameworks.



# SampleClass

```java
public class SampleClass {
    private String value;

    public SampleClass(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean isValueEqual(SampleClass other) {
        return this.value.equals(other.value);
    }

    public static boolean compareIntegers(int val1, int val2) {
        return val1 < val2;
    }

    public static String[] getArray() {
        return new String[]{"one", "two", "three"};
    }
}





```

The `SampleClass` is a simple Java class that includes methods and fields designed to work with basic string and integer operations. It includes the following methods:

- **`SampleClass(String value)`**: Constructor that initializes the `SampleClass` object with a string value.

- **`String getValue()`**: Returns the value of the string associated with the `SampleClass` instance.

- **`boolean isValueEqual(SampleClass other)`**: Compares the value of the current `SampleClass` instance with another instance to check if they are equal.

- **`static boolean compareIntegers(int val1, int val2)`**: Compares two integers and returns `true` if the first integer is less than the second.

- **`static String[] getArray()`**: Returns an array of strings `{"one", "two", "three"}`.

# SampleClassTest

The `SampleClassTest` is a JUnit 5 test class that tests the functionality of the `SampleClass`. It includes the following:

## Annotations:

- **`@BeforeEach`**: Method to set up test data before each test case.
- **`@AfterEach`**: Method to clean up after each test case.
- **`@Test`**: Annotations marking methods as test cases.

## Test Methods:

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SampleClassTest {

    private SampleClass obj1;
    private SampleClass obj2;
    private SampleClass obj3;
    private int val1;
    private int val2;
    private String[] expectedArray;
    private String[] resultArray;

    @BeforeEach
    void setUp() {
        // Set up objects and values before each test
        obj1 = new SampleClass("abc");
        obj2 = new SampleClass("abc");
        obj3 = null; // Simulate a null object
        val1 = 5;
        val2 = 6;
        expectedArray = SampleClass.getArray();
        resultArray = SampleClass.getArray();
    }

    @AfterEach
    void tearDown() {
        // Clean up resources after each test (if necessary)
        obj1 = null;
        obj2 = null;
        obj3 = null;
        expectedArray = null;
        resultArray = null;
    }

    @Test
    void getValue() {
        assertEquals("abc", obj1.getValue());
        assertEquals("abc", obj2.getValue());
    }

    @Test
    void isValueEqual() {
        assertTrue(obj1.isValueEqual(obj2));
        assertFalse(obj1.isValueEqual(new SampleClass("def")));
    }

    @Test
    void compareIntegers() {
        assertTrue(SampleClass.compareIntegers(val1, val2));
        assertFalse(SampleClass.compareIntegers(val2, val1));
    }

    @Test
    void getArray() {
        assertArrayEquals(expectedArray, resultArray);
        String[] differentArray = {"four", "five", "six"};
        assertNotEquals(differentArray, resultArray);
    }
}

```
- **`void getValue()`**: Tests the `getValue()` method to ensure it returns the correct string value.

- **`void isValueEqual()`**: Tests the `isValueEqual()` method to verify that it correctly determines if two `SampleClass` instances have equal values.

- **`void compareIntegers()`**: Tests the `compareIntegers()` method to ensure it correctly compares two integers.

- **`void getArray()`**: Tests the `getArray()` method to verify that the returned arrays are equal and consistent.

## Test Setup and Cleanup:

- **`setUp()`**: Initializes instances of `SampleClass`, integer values, and arrays before each test case.
- **`tearDown()`**: Resets the test environment after each test to avoid side effects.

This test class ensures that the `SampleClass` works as expected, covering various scenarios such as string comparison, integer comparison, and array equality.

### Another example

```java

/**
 * This class prints the given message on console.
 */
public class MessageUtil {

    private String message;

    // Constructor
    // @param message to be printed
    public MessageUtil(String message) {
        this.message = message;
    }

    // Prints the message
    public String printMessage() {
        System.out.println(message);
        return message;
    }

    // Adds "Hi!" to the message
    public String salutationMessage() {
        message = "Hi!" + message;
        System.out.println(message);
        return message;
    }
}


```

- To better demonstrate the use of @BeforeClass and @AfterClass, I'll modify the MessageUnitTest class to include operations that should be done once before any tests are run and once after all tests are completed.
- These operations might include setting up shared resources (e.g., a database connection, opening a file) and then tearing them down afterward.

```java
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class MessageUnitTest {

    private static String globalMessage;
    private String message;
    private MessageUtil messageUtil;

    // This method is executed once before any of the test methods in the class.
    @BeforeClass
    public static void beforeClass() {
        System.out.println("in before MessageUnitTest class");
        // Simulate setting up a shared resource
        globalMessage = "Starting Test Execution";
        System.out.println("Global Message: " + globalMessage);
    }

    // This method is executed once after all test methods in the class have been run.
    @AfterClass
    public static void afterClass() {
        System.out.println("in after XXX MessageUnitTest class");
        // Simulate tearing down a shared resource
        globalMessage = "Test Execution Completed";
        System.out.println("Global Message: " + globalMessage);
    }

    // This method is executed before each test method.
    @Before
    public void before() {
        System.out.println("in before each test case");
        message = "Robert";
        messageUtil = new MessageUtil(message);
    }

    // This method is executed after each test method.
    @After
    public void after() {
        System.out.println("in after each test case");
    }

    // Test method for printMessage()
    @Test
    public void testPrintMessage() {
        System.out.println("Inside testPrintMessage()");
        assertEquals(message, messageUtil.printMessage());
    }

    // Test method for salutationMessage()
    @Test
    public void testSalutationMessage() {
        System.out.println("Inside testSalutationMessage()");
        String expectedMessage = "Hi!" + message;
        assertEquals(expectedMessage, messageUtil.salutationMessage());
    }
}

```
### @BeforeClass Setup:
### The beforeClass() method simulates setting up a shared resource by initializing a globalMessage string. This string is intended to represent some global state or resource that is needed for all tests.
It prints out "Starting Test Execution," indicating that this setup occurs before any test methods run.

### @AfterClass Teardown:
The afterClass() method simulates cleaning up the shared resource by changing the globalMessage string to "Test Execution Completed." This could represent closing a database connection, saving a file, or any other teardown activity.
It prints out "Test Execution Completed," showing that this teardown occurs only after all test methods have finished.

### @Before and @After:

These annotations are used to reset the message and messageUtil objects before each test and log after each test, ensuring each test case starts with a fresh setup.
### Test Methods:

The actual test methods (testPrintMessage() and testSalutationMessage()) remain the same, focusing on verifying the behavior of MessageUtil.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
## List of Annotations

### Annotations

#### `@BeforeClass`
- **Description:** Runs once before any of the test methods in the class. Used for setting up shared resources that are needed for all tests.
- **Use Case:** Database connection setup, initializing expensive resources.
- **Tags:** `#Setup`, `#Global`

#### `@AfterClass`
- **Description:** Runs once after all the test methods in the class have been executed. Used for cleaning up resources initialized in `@BeforeClass`.
- **Use Case:** Closing database connections, releasing global resources.
- **Tags:** `#Teardown`, `#Global`

#### `@Before`
- **Description:** Runs before each test method. Used for setting up the environment or state before each test.
- **Use Case:** Initializing objects, resetting state before each test.
- **Tags:** `#Setup`, `#TestSpecific`

#### `@After`
- **Description:** Runs after each test method. Used for cleaning up the environment or state after each test.
- **Use Case:** Clearing data, resetting changes made during the test.
- **Tags:** `#Teardown`, `#TestSpecific`

#### `@Test`
- **Description:** Marks a method as a test method. JUnit will execute methods annotated with `@Test` as individual test cases.
- **Use Case:** Verifying specific behavior or functionality.
- **Tags:** `#TestCase`, `#Assertion`

### Assertions

#### `assertEquals(expected, actual)`
- **Description:** Asserts that two values (expected and actual) are equal. If they are not, the test fails.
- **Use Case:** Checking the return value of a method against an expected value.
- **Tags:** `#Validation`, `#EqualityCheck`

#### `assertTrue(condition)`
- **Description:** Asserts that a condition is true. If it is false, the test fails.
- **Use Case:** Ensuring a condition holds true after an operation.
- **Tags:** `#Validation`, `#BooleanCheck`

#### `assertFalse(condition)`
- **Description:** Asserts that a condition is false. If it is true, the test fails.
- **Use Case:** Verifying that a condition does not hold after an operation.
- **Tags:** `#Validation`, `#BooleanCheck`

#### `assertNotNull(object)`
- **Description:** Asserts that an object is not `null`. If it is `null`, the test fails.
- **Use Case:** Checking that an object has been correctly initialized.
- **Tags:** `#Validation`, `#NullCheck`

#### `assertNull(object)`
- **Description:** Asserts that an object is `null`. If it is not `null`, the test fails.
- **Use Case:** Verifying that an object is properly cleared or not initialized.
- **Tags:** `#Validation`, `#NullCheck`

#### `assertSame(expected, actual)`
- **Description:** Asserts that two references point to the same object. If they do not, the test fails.
- **Use Case:** Ensuring that two references are identical.
- **Tags:** `#Validation`, `#ReferenceCheck`

#### `assertNotSame(unexpected, actual)`
- **Description:** Asserts that two references do not point to the same object. If they do, the test fails.
- **Use Case:** Checking that two objects are not the same instance.
- **Tags:** `#Validation`, `#ReferenceCheck`

