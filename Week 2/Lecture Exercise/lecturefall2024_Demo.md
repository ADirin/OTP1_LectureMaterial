# DevOps Lecture Demo: Building and Deploying a Java Application
## Only follow the demo in the class you *DONOT* need to return

(https://github.com/ADirin/OneceAgainDev.git)

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
# How to Run a Jenkins Pipeline from a GitHub `Jenkinsfile`

To run a Jenkins pipeline using a `Jenkinsfile` from GitHub, you need to integrate Jenkins with GitHub and set up a Jenkins job that references the `Jenkinsfile` from your repository. Here's a step-by-step guide:

## Prerequisites:
1. **Jenkins Server**: Make sure Jenkins is installed and running.
2. **GitHub Account**: You must have a GitHub repository with a `Jenkinsfile` in it.
3. **Jenkins GitHub Plugin**: Ensure that the **GitHub Plugin** and the **Pipeline Plugin** are installed in Jenkins.

---

## Steps to Run a Jenkins Pipeline from a GitHub `Jenkinsfile`

### 1. Connect Jenkins to GitHub
- Open Jenkins and go to `Manage Jenkins` > `Manage Plugins`.
- Go to the `Available` tab, search for "GitHub" and install the GitHub plugin.
- Once the plugin is installed, configure GitHub authentication by going to `Manage Jenkins` > `Configure System` and scroll to the `GitHub` section.
- Add a GitHub server with the necessary credentials (usually a personal access token).

### 2. Create a New Jenkins Pipeline Job
- In Jenkins, click on `New Item`.
- Enter a name for your job (e.g., `MyGitHubPipeline`).
- Select **Pipeline** as the project type and click `OK`.

### 3. Configure the Pipeline Job
- In the job configuration page, scroll to the **Pipeline** section.
- Under the **Definition** dropdown, select **Pipeline from SCM**.
- In the **SCM** dropdown, select **Git**.
- In the **Repository URL** field, enter the GitHub repository URL (e.g., `https://github.com/username/repository.git`).
- Under **Credentials**, click on `Add` if you need to enter your GitHub credentials (username/password or personal access token).

    Example:
    ```
    https://github.com/username/repository.git
    ```

### 4. Specify the Branch and Jenkinsfile Location
- Set the **Branch Specifier** to the branch you want to use (e.g., `main` or `master`).
- Set the **Script Path** to `Jenkinsfile` if the file is located at the root of your repository. If the `Jenkinsfile` is in a subdirectory, specify the relative path (e.g., `ci/Jenkinsfile`).

### 5. Save and Build the Job
- After filling in all the required details, click `Save`.
- Now, you can manually trigger the build by clicking `Build Now`, or you can set up triggers like `GitHub Webhooks` to automatically trigger the build on commits.

### 6. Set Up GitHub Webhook (Optional but Recommended)
To automatically trigger Jenkins builds whenever code is pushed to your GitHub repository, set up a webhook:
- Go to your GitHub repository.
- Click on `Settings` > `Webhooks`.
- Click **Add webhook**.
- Set the Payload URL to `http://<your-jenkins-url>/github-webhook/`.
- Set the content type to `application/json`.
- Select the events you want to trigger the webhook (e.g., `push`).
- Save the webhook.

### 7. Monitor the Build
- Once the build is triggered, Jenkins will execute the steps defined in the `Jenkinsfile` in your GitHub repository.
- You can monitor the build progress from the Jenkins job page.

---

## Example `Jenkinsfile`

```groovy
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                // Add your build commands here
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                // Add your test commands here
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                // Add your deploy commands here
            }
        }
    }
}



