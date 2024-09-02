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
