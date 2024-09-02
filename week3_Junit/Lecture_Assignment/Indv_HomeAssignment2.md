# Understanding Test Driven Development (TDD) and Applying assertArrayEquals in JUnit

## Objective:
- To deepen your understanding of array comparison in unit tests using JUnit, specifically focusing on the assertArrayEquals method. You will work with both single-dimensional and multi-dimensional arrays.

 Based on the following test case your have  to design and develop the actual class that these test cases are prepared.

```java
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayEqualityTest {

    @Test
    public void testSingleDimensionalArrayEquality() {
        int[] a1 = { 2, 3, 5, 7 };
        int[] a2 = { 2, 3, 5, 7 };
        assertArrayEquals("Should be equal", a1, a2);
    }

    @Test
    public void testMultiDimensionalArrayEquality() {
        int[][] a11 = { { 2, 3 }, { 5, 7 }, { 11, 13 } };
        int[][] a12 = { { 2, 3 }, { 5, 7 }, { 11, 13 } };
        assertArrayEquals("Should be equal", a11, a12);
    }
}
```
## Instructions:

### Read and Understand the Code:

#### Single-Dimensional Array Test (`testSingleDimensionalArrayEquality`):
- The code initializes two single-dimensional integer arrays (`a1` and `a2`).
- The `assertArrayEquals` method checks if both arrays are equal.

  **Sample solution:**

  ```java
    public static boolean areArraysEqual(int[] a1, int[] a2) {
        if (a1 == null || a2 == null) {
            return a1 == a2;
        }
        if (a1.length != a2.length) {
            return false;
        }
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }


  ```

  
  

#### Multi-Dimensional Array Test (`testMultiDimensionalArrayEquality`):
- The code initializes two multi-dimensional integer arrays (`a11` and `a12`).
- The `assertArrayEquals` method checks if both two-dimensional arrays are equal.

### Answer the Following Questions:

a. **What does the `assertArrayEquals` method do?**

   - Explain how `assertArrayEquals` works and what it checks when comparing arrays.

b. **What will happen if the arrays `a1` and `a2` are not equal in `testSingleDimensionalArrayEquality`?**

   - Describe the outcome when the arrays do not match and how the test will respond.

c. **How does the `assertArrayEquals` method handle multi-dimensional arrays as seen in `testMultiDimensionalArrayEquality`?**

   - Explain how `assertArrayEquals` compares multi-dimensional arrays and what it means for them to be equal.

### Practical Exercise:

a. **Modify the Existing Tests:**

   - Change one of the arrays in the `testSingleDimensionalArrayEquality` method so that they are not equal.
   - Update the `testMultiDimensionalArrayEquality` method to include an array that is not equal to the other and modify the code to reflect this change.

b. **Write a New Test Method:**

   - Create a new JUnit test method that compares arrays of different types (e.g., `String[]`, `double[]`). Use `assertArrayEquals` to verify their equality.
   - Ensure that your new test method includes appropriate assertions and comments explaining its purpose.

### Submission:

- **As an individual assignment, you are required to:**
  1. **Submit a GitHub repository** containing:
     - The Java code with the modified and new test methods.
     - A short README file answering the questions provided and explaining your modifications.
  2. **Write a Java class** based on the test cases provided in the assignment.



### Due Date:
Please submit your GitHub link by [Insert Due Date Here].

