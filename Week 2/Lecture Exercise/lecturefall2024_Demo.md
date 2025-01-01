# DevOps Lecture Demo: Building and Deploying a Java Application

This document serves as a lecture demo for a DevOps session, focusing on building, testing, and deploying a simple Java application using Maven, Docker, and Jenkins. We will explore the entire lifecycle of the application, from code creation to deployment, while emphasizing the principles of continuous integration and continuous deployment (CI/CD).

![DevOps](/Images/lectureExer.JPG)

---

## Introduction

In this demo, we will create a basic Java application that prints "My First Application" to the console. We will also write a unit test for this application using JUnit. Following that, we will build the application using Maven, containerize it with Docker, and set up a Jenkins pipeline to automate the build, test, and deployment processes.

---

## Step 1: Creating the Java Application

We start by creating a simple Java application. Below is the code for our main application class:

```java
package org.example;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("My First Application");
    }
}
```
Next, we create a unit test for our application:

```java
package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    public AppTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testApp() {
        assertTrue(true);
    }
}


```
## Step 2: Building the Application with Maven
We will use Maven as our build tool. Below is the pom.xml configuration for our project:

```java
<project xmlns="http://maven.apache.org/POM/4.0.0" 
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>org.example</groupId>
  <artifactId>OneceAgainDev</artifactId>
  <version>1.0.0</version>
  <packaging>jar</packaging>
  <name>OneceAgainDev</name>
  <url>http://maven.apache.org</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
  </properties>

  <build>
    <finalName>OneceAgainDev</finalName>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        <configuration>
          <source>${maven.compiler.source}</source>
          <target>${maven.compiler.target}</target>
        </configuration>
      </plugin>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-jar-plugin</artifactId>
        <version>3.4.1</version>
        <configuration>
          <archive>
            <manifest>
              <mainClass>org.example.App</mainClass>
            </manifest>
          </archive>
        </configuration>
      </plugin>
    </plugins>
  </build>

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.13.2</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>


```
## Step 3: Containerizing the Application with Docker
Next, we will create a Dockerfile to containerize our application:


```css
FROM openjdk:11

WORKDIR /app

COPY target/OneceAgainDev.jar /app/oneceagaindev.jar

CMD ["java", "-jar", "oneceagaindev.jar"]

```
## Step 4: Setting Up the Jenkins Pipeline
Finally, we will set up a Jenkins pipeline to automate the build, test, and deployment processes. Below is a sample Jenkins pipeline script:

```grovy
pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Build App'
      }
    }
    stage('Test') {
      steps {
        echo 'Test app'
      }
    }
    stage('Deploy') {
      steps {
        echo 'Deploy App'
      }
    }
  }
  post {
    always {
      emailext body: 'Summary', subject: 'Pipeline code status', to: 'amirSilta@gmail.com'
    }
  }
}

```



