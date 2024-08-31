# Complex Unit Test Demo in IntelliJ

## 1. Introduction
- **Objective**: Demonstrate advanced unit testing techniques using IntelliJ IDEA.
- **Overview**: We'll cover testing of multiple methods, handling edge cases, mocking dependencies, and using parameterized tests in a more realistic scenario.

## 2. Setting Up the Project
### Create a New Project
1. Open IntelliJ IDEA.
2. Click on "Create New Project."
3. Select "Java" (or another language as required).
4. Name your project (e.g., `TemperatureConverterDemo`) and specify the location.

### Add Dependencies
1. Go to `File > Project Structure`.
2. Under `Modules`, select `Dependencies`.
3. Click on `+ > Library > From Maven`.
4. Search for `junit:junit:4.13.2` and `org.mockito:mockito-core:3.11.2` (or the latest versions).
5. Click `OK` to add them to the project.

## 3. Creating a Complex Class to Test
### Create a `TemperatureConverter` Class
1. In the `src` directory, right-click and select `New > Java Class`.
2. Name the class `TemperatureConverter`.

### Implement the `TemperatureConverter` Class
This class will have methods for converting temperatures between Fahrenheit and Celsius.

```java
public class TemperatureConverter {

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public boolean isExtremeTemperature(double celsius) {
        return celsius < -40 || celsius > 50;
    }
}
```

4. Writing Unit Tests
Create a Test Class
Right-click on the TemperatureConverter class and select Go to > Test.
Choose to create a new test, and select JUnit4 as the testing library.
Name the test class TemperatureConverterTest.
Write Basic Test Cases
Write test cases for converting temperatures, including edge cases and exceptions.
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

````java
public class TemperatureConverterTest {

    private TemperatureConverter converter;

    @Before
    public void setUp() {
        converter = new TemperatureConverter();
    }

    @Test
    public void testFahrenheitToCelsius() {
        double celsius = converter.fahrenheitToCelsius(32);
        assertEquals(0, celsius, 0.01);
    }

    @Test
    public void testCelsiusToFahrenheit() {
        double fahrenheit = converter.celsiusToFahrenheit(0);
        assertEquals(32, fahrenheit, 0.01);
    }

    @Test
    public void testExtremeTemperature() {
        assertTrue(converter.isExtremeTemperature(-50));
        assertFalse(converter.isExtremeTemperature(20));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInput() {
        converter.fahrenheitToCelsius(Double.NaN);
    }
}
````
5. Running the Unit Tests
Run All Tests
Right-click on the TemperatureConverterTest class and select Run 'TemperatureConverterTest'.
IntelliJ will display the results in the Run window.
6. Using Mockito to Mock Dependencies
Add a Mocking Scenario
Let's assume the TemperatureConverter class relies on an external service to fetch the current temperature from a weather API.

Create the WeatherService Interface

````java
public interface WeatherService {
    double getCurrentTemperatureInCelsius();
}


````

Modify the TemperatureConverter Class to use this service:
````java
public class TemperatureConverter {
    private WeatherService weatherService;

    public TemperatureConverter(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public double convertCurrentTemperatureToFahrenheit() {
        double celsius = weatherService.getCurrentTemperatureInCelsius();
        return celsiusToFahrenheit(celsius);
    }

    // Other methods remain unchanged
}

````
Write a Test Case Using Mockito

````java
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TemperatureConverterTest {

    private TemperatureConverter converter;
    private WeatherService weatherService;

    @Before
    public void setUp() {
        weatherService = mock(WeatherService.class);
        when(weatherService.getCurrentTemperatureInCelsius()).thenReturn(25.0);
        converter = new TemperatureConverter(weatherService);
    }

    @Test
    public void testConvertCurrentTemperatureToFahrenheit() {
        double fahrenheit = converter.convertCurrentTemperatureToFahrenheit();
        assertEquals(77, fahrenheit, 0.01);
        verify(weatherService).getCurrentTemperatureInCelsius();
    }
}

````
Explanation
mock(WeatherService.class): Creates a mock object of the WeatherService.
when(weatherService.getCurrentTemperatureInCelsius()).thenReturn(25.0): Defines the behavior of the mock for a specific input.
verify(weatherService): Verifies that the method was called with the expected arguments.
7. Using Parameterized Tests
Add Parameterized Test for Conversion

````java
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ParameterizedTemperatureConverterTest {

    private double celsius;
    private double expectedFahrenheit;

    public ParameterizedTemperatureConverterTest(double celsius, double expectedFahrenheit) {
        this.celsius = celsius;
        this.expectedFahrenheit = expectedFahrenheit;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 32},
                {25, 77},
                {100, 212}
        });
    }

    @Test
    public void testCelsiusToFahrenheit() {
        TemperatureConverter converter = new TemperatureConverter();
        double fahrenheit = converter.celsiusToFahrenheit(celsius);
        assertEquals(expectedFahrenheit, fahrenheit, 0.01);
    }
}

````
Explanation
@RunWith(Parameterized.class): Tells JUnit to run the test with parameterized inputs.
@Parameterized.Parameters: Provides the input data as a collection of arrays.
The test will run multiple times with different Celsius inputs and expected Fahrenheit outputs.

8. Running All Tests Again
Run All Tests
Right-click on the test directory or the entire test package.
Select Run 'All Tests'.
Review the results, ensuring all tests pass.
9. Best Practices
Discuss Advanced Testing Practices
Separation of Concerns: Explain the importance of isolating business logic from external dependencies.
Mocking: Discuss when and why to use mocks to simulate external services.
Edge Cases and Robustness: Highlight the importance of testing for edge cases and potential exceptions.
Parameterized Tests: Show how parameterized tests can reduce code duplication and ensure robustness across a range of inputs.
10. Q&A and Wrap-Up
Q&A
Allow time for questions and clarifications, especially on advanced topics like mocking and parameterized tests.

Wrap-Up
Recap the importance of comprehensive testing and the tools available in IntelliJ IDEA to facilitate this process.

