# JUnit Setup in IntelliJ IDEA

IntelliJ IDEA provides a streamlined way to set up and run JUnit tests. Follow these steps to configure JUnit in your IntelliJ IDEA project:

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
