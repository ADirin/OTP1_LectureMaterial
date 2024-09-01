# Understanding and Applying assertArrayEquals in JUnit
## Objective:
- To deepen your understanding of array comparison in unit tests using JUnit, specifically focusing on the assertArrayEquals method. You will work with both single-dimensional and multi-dimensional arrays.


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
