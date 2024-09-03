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
