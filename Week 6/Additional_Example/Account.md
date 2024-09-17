# Docker / Jenkins Assignment: Bank Account Functionality (INDIVIDUAL, Final version)

## Objective

The objective of this assignment is to develop a class to illustrate bank account functionality, create a corresponding JUnit test case to verify its correctness, and deliver a Docker image containing the application.

## Steps

### 1. Create Files

Create two files: `Account.java` and `AccountTest.java`.

### 2. Implement Account Class

Implement the `Account` class in `Account.java`. The `Account` class must include the following methods and member variables:
- A double member variable to hold the current account balance.
- `public Account() {...}`: The default constructor should initialize the balance to 0.0.
- `public void deposit(double amount) {...}`: A deposit method to add money to the account.
- `public double withdraw(double amount) {...}`: A withdraw method that withdraws the given amount from the account. If the amount given can be withdrawn, it should return that amount. If not, it should return 0.0.
- `public double getBalance() {...}`: A method to get the current balance in the account.

### 3. Write Test Cases

Write test cases for the `Account` class in `AccountTest.java`. Test cases should cover various scenarios including depositing money, withdrawing money, and checking balance.

### 4. Execute Test Cases

Execute the test cases and ensure they pass successfully.

## Example Code

### Account.java

```java
public class Account {
    private double balance;

    public Account() {
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            return amount;
        } else {
            return 0.0;
        }
    }

    public double getBalance() {
        return this.balance;
    }
}

```
> Add the main class which helps to test the docker in intelliJ
## MainClass.java
```java
public class MainClass {
    public static void main(String[] args) {
        Account account = new Account();
        account.deposit(100.0);
        System.out.println("Balance after deposit: " + account.getBalance());
        account.withdraw(50.0);
        System.out.println("Balance after withdrawal: " + account.getBalance());
    }
}

```
## AccountTest.java
```java
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {
    private Account account;

    @Before
    public void setUp() {
        account = new Account();
    }

    @Test
    public void testInitialBalance() {
        assertEquals(0.0, account.getBalance(), 0.01);
    }

    @Test
    public void testDeposit() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdraw() {
        account.deposit(100.0);
        double amountWithdrawn = account.withdraw(50.0);
        assertEquals(50.0, amountWithdrawn, 0.01);
        assertEquals(50.0, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        double amountWithdrawn = account.withdraw(50.0);
        assertEquals(0.0, amountWithdrawn, 0.01);
        assertEquals(0.0, account.getBalance(), 0.01);
    }
}

```
## Update the POM.XML

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
        <maven.compiler.release>17</maven.compiler.release>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.hamcrest</groupId>
            <artifactId>hamcrest</artifactId>
            <version>2.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.11.0</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <finalName>testimage</finalName>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <version>3.3.0</version>
                <configuration>
                    <archive>
                        <manifest>
                            <mainClass>MainClass</mainClass>
                        </manifest>
                    </archive>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <release>17</release>
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

## Docker Integration

### Objective

Package the application into a Docker container and automate the build and test process using Jenkins, DockerHub, and GitHub.

### Steps


#### Create a Dockerfile

In the root directory of your project (Intellij project), create a `Dockerfile` with the following content:

```Dockerfile
# Use the OpenJDK 17 JDK Alpine base image
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the compiled JAR file from the target directory
COPY target/*.jar /app/

# Set the command to run your Java application
CMD ["java", "-jar", "/app/testimage.jar"]
```

## Build and Run the Docker Image

```sh
docker build -t unittest-image .
```

## RUN the image

```sh
docker run --rm unittest-image
```

> Step 8: Push to GitHub and Set Up Jenkins
_Push your project to your GitHub repository.
_Set up Jenkins to monitor your GitHub repository and run the pipeline when changes are pushed.


#### Set Up Jenkins

- Install Jenkins on your local machine or server.
- Install the necessary plugins for Java, Git, and Docker integration.

#### Create a Jenkins Pipeline

- Set up a new Jenkins job and configure it as a pipeline.

#### Add Jenkinsfile

Create a `Jenkinsfile` in your repository with the following content:

```groovy
pipeline {
    agent any

    stages {
        stage('Checkout SCM') {
            steps {
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
        
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build('unittest-image')
                }
            }
        }
        
        stage('Run Docker Container') {
            steps {
                script {
                    docker.image('unittest-image').inside('-v C:/Users/amirdi/.jenkins/workspace/assignment6:/workspace -w /workspace') {
                        // Commands to run inside the Docker container
                        sh 'ls'
                        sh 'java -jar /workspace/target/testimage.jar'
                    }
                }
            }
        }
    }
}


```
Run the Pipeline
Trigger the pipeline manually or set it up to trigger on each commit.

## Check the docker desktop
-You should have the unittest-image:latest in your docker desktop

![docker desktop](/Images/image.PNG)

## Resources

- [Jenkins Official Documentation](https://www.jenkins.io/doc/)
- [JUnit Official Documentation](https://junit.org/junit4/)
- [DockerHub](https://hub.docker.com/)


