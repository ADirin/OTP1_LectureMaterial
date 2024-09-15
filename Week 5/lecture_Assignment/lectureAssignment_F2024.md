# IntelliJ Assignment: Java Project with Jenkins Integration for Unit Testing & JaCoCo Report Submission

## Assignment Title: Time Calculator - Calculate Time to Reach a Destination

### Objective:
In this assignment, you will create a simple Java application that calculates the time required to travel from point A to point B at different speeds. You will also write unit tests using JUnit, integrate the project with Jenkins for Continuous Integration (CI), and generate a JaCoCo code coverage report. The final submission will include the project files and a screenshot of the JaCoCo report in Jenkins.

---

## Instructions:

### Part 1: Create a Java Project in IntelliJ

1. **Project Setup**:
   - Open IntelliJ IDEA and create a new **Maven**  project named `TimeCalculator`.
   - Add the necessary dependencies for **JUnit** and **JaCoCo** in your `pom.xml` (for Maven) or `build.gradle` (for Gradle). For Maven, include:

```xml

    <dependencies>
        <!-- JUnit Dependency -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.11.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>5.11.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <!-- JaCoCo Plugin -->
            <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <version>0.8.12</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>prepare-agent</goal>
                        </goals>
                    </execution>
                    <execution>
                        <id>report</id>
                        <phase>test</phase>
                        <goals>
                            <goal>report</goal>
                        </goals>
                    </execution>
                </executions>


            </plugin>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-surefire-plugin</artifactId>
                        <version>3.0.0-M5</version>
                        <configuration>
                            <includes>
                                <include>**/*Test.java</include>
                            </includes>
                        </configuration>
                    </plugin>


        </plugins>



    </build>


</project>
```

2. **Java Class Implementation:**

- Inside the src/main/java folder, create a Java class named TimeCalculator.
- Implement a method double calculateTime(double distance, double speed) in this class. The method should:
  - Take distance (in kilometers) and speed (in kilometers per hour) as input.
  - Return the time (in hours) to reach from point A to point B.
  - If speed is zero or negative, throw an IllegalArgumentException.
```java
public class TimeCalculator {
    public double calculateTime(double distance, double speed) {
        if (speed <= 0) {
            throw new IllegalArgumentException("Speed must be greater than zero.");
        }
        return distance / speed;
    }
}

```
3. **Write Unit Tests:**

- Inside the src/test/java folder, create a test class named TimeCalculatorTest.
- Write unit tests using JUnit to test the calculateTime method. The tests should cover:
  - Normal cases (positive speed and distance).
  - Edge cases (speed = 0, negative speed, very large numbers).

Example test cases:

```java
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TimeCalculatorTest {

    @Test
    public void testCalculateTimeNormalCase() {
        TimeCalculator calculator = new TimeCalculator();
        assertEquals(2.0, calculator.calculateTime(100.0, 50.0), 0.0001);
    }

    @Test
    public void testCalculateTimeZeroSpeed() {
        TimeCalculator calculator = new TimeCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateTime(100, 0);
        });
    }

    @Test
    public void testCalculateTimeNegativeSpeed() {
        TimeCalculator calculator = new TimeCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateTime(100, -10);
        });
    }
}


```
## Part 2: Integrate with Jenkins
1. Set up Jenkins:

- Ensure you have access to a Jenkins server. Install JUnit and JaCoCo plugins on Jenkins if not already installed:
  - JUnit plugin to display test results.
  - JaCoCo plugin to display code coverage reports.

2. Create a Jenkins Pipeline Job:

- In Jenkins, create a new Pipeline job for this project.

3. Jenkinsfile Setup:

- In your project root directory, create a Jenkinsfile. The pipeline should:
  - Pull the project code from your repository (e.g., GitHub).
  - Run the Maven/Gradle build.
  - Run unit tests and generate a JaCoCo report.
  - Publish test results and code coverage metrics.

Example Jenkinsfile for a Maven project:

```groovy

pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://your-repo-url.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Code Coverage') {
            steps {
                jacoco execPattern: '**/target/jacoco.exec'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
            jacoco execPattern: '**/target/jacoco.exec'
        }
    }
}


```
This pipeline does the following:

Pulls the code from the repository.
Builds the project using Maven.
Runs the tests.
Generates the JaCoCo report and publishes the test results and coverage data.

### Part 3: Generate and Submit JaCoCo Report
1. Generate JaCoCo Report:

- After running the Jenkins job, navigate to the JaCoCo report section in Jenkins.
- Take a screenshot of the code coverage report (make sure the report is visible, showing the percentage coverage).

2. Submit the following:

- A screenshot of your JaCoCo report from Jenkins.
- A link to the GitHub repository (or upload the Java project files) where the project can be reviewed.
- The final submission must be done through OMA.


## Bonus Task (Optional):
- Refactor the code to handle different units of measurement for speed and distance (e.g., miles, feet).
- Write additional unit tests for the new functionality.


## Submission Deadline:
- The assignment must be submitted by [17.09.2024] In a folder in Oma.

## Evaluation Criteria:
- Correct implementation of the TimeCalculator class.
- Sufficient coverage of unit tests.
- Successful Jenkins pipeline / freestyle with passing unit tests.
- Screenshot of the JaCoCo report.

