# Under construction,

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


## Step 2: Write Unit Test
1. Create a Unit Test for the DiceRoll class in src/test/java/com/example/:



2. Run the Tests:

- Right-click the project folder in IntelliJ and select Run -> All Tests. Ensure all tests pass.

## Step 3 Create a GitHub repository:

Go to GitHub, create a new repository (e.g., dice-roll-app), and copy the repository URL.

## Step 4. Push the Project to GitHub



2. You can write the jenkins file in the github repo "" follow the lecture how to do



## Step 5: Run Jenkins Build
1. Run the Build:

- In Jenkins, go to your job (e.g., Dice Roll App) and click Build Now.
- Jenkins will automatically check out the code, build the project, run tests, and generate coverage reports.

2. View Results:

- After the build completes, view the Test Results and Code Coverage /Junit  by clicking on the respective JUnit or Jacoco results.

## Step 6 Submission
Screenshot of the JACACO report by jenkins where your name is written








