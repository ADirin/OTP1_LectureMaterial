# Dice Roll Application with Jenkins and GitHub Integration
This guide will walk you through creating a simple Java Maven project, pushing it to GitHub, and using Jenkins to automate unit tests and generate coverage reports.

## Step 1: Create a Maven Project in IntelliJ

1. Create a new Maven Project:
- Navigate to File -> New -> Project.
- Select Maven and check Create from archetype (if needed).
- Click Next, then specify the GroupId (e.g., com.example) and ArtifactId (e.g., dice-roll-app).
- Set the project location and click Finish.

2. Modify the pom.xml file to include dependencies for JUnit and Jacoco for test coverage:

```xml

<dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.jacoco</groupId>
            <artifactId>jacoco-maven-plugin</artifactId>
            <version>0.8.7</version>
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
    </plugins>
</build>



```
3. Write the Dice Roll Application:

Create a new class DiceRoll.java in src/main/java/com/example/:

```java
package com.example;

import java.util.Random;
import java.util.Scanner;

public class DiceRoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many dice would you like to roll? ");
        int numberOfDice = scanner.nextInt();
        int sum = rollDice(numberOfDice);
        System.out.println("The total sum of the dice rolls is: " + sum);
        scanner.close();
    }

    public static int rollDice(int numberOfDice) {
        Random random = new Random();
        int sum = 0;
        for (int i = 1; i <= numberOfDice; i++) {
            int roll = random.nextInt(6) + 1;
            sum += roll;
        }
        return sum;
    }
}


```
## Step 2: Write Unit Test
1. Create a Unit Test for the DiceRoll class in src/test/java/com/example/:

```java
package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class DiceRollTest {

    @Test
    public void testRollDice() {
        int sum = DiceRoll.rollDice(3);
        assertTrue(sum >= 3 && sum <= 18);  // Minimum sum is 3 and max is 18 for 3 dice
    }
}


```

2. Run the Tests:

- Right-click the project folder in IntelliJ and select Run -> All Tests. Ensure all tests pass.

## Step 3 Create a GitHub repository:

Go to GitHub, create a new repository (e.g., dice-roll-app), and copy the repository URL.

## Step 4. Push the Project to GitHub



## Step 4: Set Up Jenkins to Test and Report Coverage

### 2. Create Jenkins Job
1. Create a new job:

- Go to Jenkins Dashboard, click New Item, and name it (e.g., Dice Roll App).
- Choose Pipeline and click OK.
2. Configure Jenkins Pipeline:

- In the job configuration, go to the Pipeline section.
- Select Pipeline script from SCM.
- Choose Git and paste your GitHub repository URL (e.g., https://github.com/yourusername/dice-roll-app.git).
- If needed, add Jenkins credentials for private repositories.


## 3. Write Jenkins Pipeline Script
1. Create a Jenkinsfile in the root of your GitHub repository:
```groovy
pipeline {
    agent any
    tools {
        maven 'Maven3'  // Ensure Maven is installed
        jdk 'JDK11'     // Ensure JDK is installed
    }
    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/yourusername/dice-roll-app.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('Run Unit Tests') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'  // Capture test reports
                }
            }
        }
        stage('Code Coverage Report') {
            steps {
                bat 'mvn jacoco:report'
            }
            post {
                always {
                    jacoco execPattern: 'target/jacoco.exec'
                }
            }
        }
    }
}



```

2. You can write the jenkins file in the github repo "" follow the lecture how to do



## Step 5: Run Jenkins Build
1. Run the Build:

- In Jenkins, go to your job (e.g., Dice Roll App) and click Build Now.
- Jenkins will automatically check out the code, build the project, run tests, and generate coverage reports.

2. View Results:

- After the build completes, view the Test Results and Code Coverage by clicking on the respective JUnit or Jacoco results.

## Step 6 Submission
Screenshot of the JACACO report by jenkins where your name is written








