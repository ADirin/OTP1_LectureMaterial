# Lecture Assignment
## Assignment: Unit Testing and Code Coverage with JaCoCo

**Objective**
In this assignment, you will:

1. Create a Java class and corresponding unit tests.
2. Configure JaCoCo to generate a code coverage report.
3. Add the JaCoCo report to a public HTML folder.
4. Submit a link to the public HTML report in **OMA**.

**Problem Description** 

"I need a Java class that models a simple book library. 
The class should allow adding a book, removing a book, and listing all books. I also need JUnit tests to verify these operations. 
Can you help me generate the code for this class and the tests?"


````mermaid
classDiagram
    class Library {
        - List<String> books
        + addBook(book: String): void
        + removeBook(book: String): void
        + listBooks(): List<String>
    }

````
## Sample UnitTest
````java
import static junit.framework.Assert.assertEquals;

public class AppTest {

    @org.junit.jupiter.api.Test
    public void testAddAndListBooks() {
        App library = new App();
        library.addBook("The Great Gatsby");
        List<String> books = library.listBooks();
        assertEquals(1, books.size(), "There should be 1 book in the library");
        assertEquals("The Great Gatsby", books.get(0), "The Great Gatsby");
    }

    @Test
    public void testRemoveBook() {
        App library = new App();
        library.addBook("1984");
        library.removeBook("1984");
        List<String> books = library.listBooks();
        assertEquals(0, books.size(), "There should be no books in the library");
    }
}

````
##Sample Jacoco blugin## 
````xml
 <build>
    <plugins>
      <!-- JaCoCo plugin for code coverage -->
      <plugin>
        <groupId>org.jacoco</groupId>
        <artifactId>jacoco-maven-plugin</artifactId>
        <version>0.8.8</version>
        <executions>
          <execution>
            <goals>
              <goal>prepare-agent</goal>
            </goals>
          </execution>
          <execution>
            <id>report</id>
            <phase>prepare-package</phase>
            <goals>
              <goal>report</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>

````
## Submision:

- Upload the site into you public html folder and submit the link along with a screenshot of the report in Oma

**Sample report that is expected:**

![Coverage Report](./images/sample.jpg)
