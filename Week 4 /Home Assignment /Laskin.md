# Unit 5- Testing

## Objective:
The objective of this assignment is to familiarize yourself with Eclipse's JUnit 5 testing environment and determine test coverage.

## Steps:
1. **Create Maven Project:**
   - Create a Maven project and add the necessary specifications for testing to the `pom.xml` file.

2. **Import Code:**
   - Unzip the file [laskin.zip](https://users.metropolia.fi/~amirdi/OTP1/Laskin5.zip).
   - Drag and drop the extracted codes (`src`, `test`) into your project.
   - If special characters are not displayed correctly, change the character encoding at the Eclipse Workspace level:
     - Select `Window` | `Preferences` | `General` | `Workspace`.
     - Set `Text file encoding` to `UTF-8`.

### PART 1 OF THE TASK: Coverage

> Important to note that you need to add proper reporting plugins, e.g., JACOCO in POM.XML, here is an example of such POM.XML file, make sure that you have the
right jdk and pluging versions.
 ```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>UnitTest</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.release>21</maven.compiler.release>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.10.2</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <release>21</release>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <version>0.8.9</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>prepare-agent</goal>
                        </goals>
                    </execution>
                    <execution>
                        <id>report</id>
                        <goals>
                            <goal>report</goal>
                        </goals>
                        <phase>verify</phase>
                    </execution>
                </executions>
                <configuration>
                    <excludes>
                        <exclude>sun/util/resources/**</exclude>
                        <exclude>sun/text/resources/**</exclude>
                        <exclude>sun/util/cldr/**</exclude>
                        <exclude>sun/util/resources/provider/LocaleDataProvider</exclude>
                        <exclude>sun/text/resources/cldr/ext/FormatData_fi</exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>


```

3. **Run Application and Tests:**
   - first Verify  that there are no errors in the implementation (code)/.
   - Run the JUnit tests:
     - Right-click on the project name in the Project Explorer.
     - Select `Run As` | `JUnit Test`.
   - Some tests will pass while others will not.

4. **Determine Test Coverage:**
   - Run a coverage analysis:
     - Right-click on the project name in the Package Explorer.
     - From the `Coverage As` menu, choose either "1 Java Application" or "2 JUnit Test".
   - The coverage summary appears on the `Coverage` tab at the bottom of the screen.
   - An alternative approach is to run MVN CLEAN Test

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
- Add the HTML file (the whole site folder) into your metropolia HTML folder.
- Attach a screenshot of the test results along with you public HTML link to Moodle week4 home assignment folder.
