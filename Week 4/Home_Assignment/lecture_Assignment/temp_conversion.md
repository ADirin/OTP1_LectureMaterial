# JUnit Testing in IntelliJ: Lecture Exercise
## Objective
Learn how to create and run unit tests using JUnit in IntelliJ IDEA by testing a TemperatureConverter class that converts temperatures between Fahrenheit and Celsius.

### Setup
#### Step 1: Create the Project
1. Open IntelliJ IDEA.
2. Create a New Project:
- Go to File > New > Project.
- Select Java as the project type.
- Name your project (e.g., TemperatureConverterExercise) and set the location.
- Click Finish to create the project.

#### Step 2: Create the TemperatureConverter Class
1. Create a new Java class:

- Right-click on the src directory and select New > Java Class.
- Name the class TemperatureConverter.
2. Implement the TemperatureConverter Class:

- Copy the following code into your TemperatureConverter class:
```java

public class TemperatureConverter {

    /**
     * Converts Fahrenheit to Celsius.
     *
     * @param fahrenheit The temperature in Fahrenheit.
     * @return The temperature in Celsius.
     */
    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    /**
     * Converts Celsius to Fahrenheit.
     *
     * @param celsius The temperature in Celsius.
     * @return The temperature in Fahrenheit.
     */
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    /**
     * Checks if the given Celsius temperature is extreme.
     *
     * @param celsius The temperature in Celsius.
     * @return True if the temperature is below -40 or above 50, otherwise false.
     */
    public boolean isExtremeTemperature(double celsius) {
        return celsius < -40 || celsius > 50;
    }
}

```
## Writing JUnit Tests
#### Step 3: Set Up JUnit in Your Project
1. Add JUnit dependency:
- Right-click on your project and select Add Framework Support.
- Select JUnit and click OK.
- Ensure that JUnit 4 is selected and that it's added as a dependency.
2. Step 4: Create the Test Class
1. Generate a test class:
- Right-click on the TemperatureConverter class file.
- Select Go to > Test or Generate > Test.
- Choose to create a new test class and name it TemperatureConverterTest.
- Select JUnit4 as the testing framework.
#### Step 5: Write Unit Tests
1. Initialize the Test Class:

- Add the following setup code to the TemperatureConverterTest class:

2. Write Test Methods:

- Add the following test methods to the TemperatureConverterTest class:

``` java
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TemperatureConverterTest {

    private TemperatureConverter converter;

    @Before
    public void setUp() {
        converter = new TemperatureConverter();
    }
}
@Test
public void testFahrenheitToCelsius() {
    assertEquals(0, converter.fahrenheitToCelsius(32), 0.01);
    assertEquals(100, converter.fahrenheitToCelsius(212), 0.01);
    assertEquals(-40, converter.fahrenheitToCelsius(-40), 0.01);
}

@Test
public void testCelsiusToFahrenheit() {
    assertEquals(32, converter.celsiusToFahrenheit(0), 0.01);
    assertEquals(212, converter.celsiusToFahrenheit(100), 0.01);
    assertEquals(-40, converter.celsiusToFahrenheit(-40), 0.01);
}

@Test
public void testIsExtremeTemperature() {
    assertTrue(converter.isExtremeTemperature(-50));
    assertFalse(converter.isExtremeTemperature(20));
    assertTrue(converter.isExtremeTemperature(60));
}


```
### Explanation of Test Methods:

- testFahrenheitToCelsius(): Tests the conversion from Fahrenheit to Celsius for common, extreme, and edge cases.
- testCelsiusToFahrenheit(): Tests the conversion from Celsius to Fahrenheit similarly.
- testIsExtremeTemperature(): Verifies whether the method correctly identifies extreme temperatures.
#### Step 6: Running the Tests
1. Run Tests:
- Right-click on the TemperatureConverterTest class and select Run 'TemperatureConverterTest'.
- Observe the results in the Run window. All tests should pass if the implementation is correct.
