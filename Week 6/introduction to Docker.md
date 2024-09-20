# Getting Started with Docker: A Comprehensive Guide

## Introduction
Docker has revolutionized the way software is developed, deployed, and managed by providing a lightweight, portable, and efficient solution for containerization. In this learning material, we will explore the fundamentals of Docker, why it's essential, how to install Docker on various platforms, how to effectively use Docker containers, and provide a practical example using Java applications.

> ![How Docker Works](/Images/HoWDockersWorks.gif)


## Table of Contents
1. [Understanding Docker](#1-understanding-docker)
2. [Why Docker?](#2-why-docker)
3. [Installing Docker](#3-installing-docker)
4. [Docker Basics](#4-docker-basics)
5. [Building Docker Images](#5-building-docker-images)
6. [Running Docker Containers](#6-running-docker-containers)
7. [Docker Compose](#7-docker-compose)
8. [Example: Dockerizing a Java Application](#8-example-dockerizing-a-java-application)

## 1. Understanding Docker
Docker is a platform that enables developers to package applications and their dependencies into containers. Containers are lightweight, portable units that ensure consistent application performance across different environments, from development to production.

## 2. Why Docker?
Docker simplifies application deployment by creating a consistent environment, regardless of the host machine. It improves efficiency, speeds up development, reduces compatibility issues, and allows for easier scaling and isolation of apps.

## 3. Installing Docker
Docker installation involves downloading and setting up Docker Engine on your machine. It is available for multiple operating systems, including Linux, Windows, and macOS, with specific installation steps for each platform.


### Installing and Setting Up Docker on Different Operating Systems
[Windows](https://www.docker.com/get-started/)
- Check System Requirements: Ensure your Windows version supports Docker (Windows 10 64-bit: Pro, Enterprise, or Education; or Windows 11).
- Enable WSL 2: Install and enable Windows Subsystem for Linux 2 (WSL 2).
    `wsl --install`
- Download Docker Desktop: Get the Docker Desktop installer from the Docker website.
- Install Docker Desktop: Run the installer and follow the setup instructions.
- Start Docker Desktop: Launch Docker Desktop and complete the initial setup.
- Verify Installation: Open a terminal and run:
    `docker --version`

  
[macOS](https://docs.docker.com/desktop/install/mac-install/)
- Check System Requirements: Ensure your macOS version is 10.15 or newer.
- Download Docker Desktop: Get the Docker Desktop installer from the Docker website.
- Install Docker Desktop: Open the downloaded .dmg file and drag Docker to the Applications folder.
- Start Docker Desktop: Launch Docker from the Applications folder and complete the initial setup.
- Verify Installation: Open a terminal and run:
  `docker --version`
  
[Linux](https://docs.docker.com/engine/install/ubuntu/) 
- Check System Requirements: Ensure your Linux distribution is supported (e.g., Ubuntu, Debian, Fedora, CentOS).
- Update Package Index: Update your package index.
`sudo apt-get update`

__Install Docker Engine:__
`sudo apt-get install docker-ce docker-ce-cli containerd.io`

- Start Docker: Enable and start the Docker service.
`sudo systemctl enable docker`
`sudo systemctl start docker`

- Verify Installation: Run the following command to check Docker version:
`docker --version`

**Post-Installation Steps (All OS)**
- Run Docker Without Sudo (Linux Only):
`sudo usermod -aG docker $USER`

- Test Docker Installation: Run a test container.
`docker run hello-world`




## 4. Docker Basics
- Docker CLI overview: `docker run`, `docker build`, `docker ps`, `docker images`, etc.
- Managing containers: starting, stopping, restarting, removing
- Inspecting container logs and stats

## 5. Building Docker Images
A Docker image is a snapshot of an application and its dependencies. You can create custom images using a Dockerfile, which defines the instructions to install software, configure environments, and set up the application.

## 6. Running Docker Containers
Containers are the running instances of Docker images. This part explains how to start, stop, and manage containers, as well as monitor their performance and logs, ensuring your app runs properly in isolation.

## 7. Docker Compose
Docker Compose allows you to define and manage multi-container applications using a YAML file. It simplifies starting multiple services (e.g., databases, web apps) together, making complex applications easier to orchestrate.


## 8. Example: Dockerizing a Java Application
- This practical example demonstrates how to package a Java application into a Docker container. You’ll create a Dockerfile, build the image, and use Docker to run the application in a containerized environment, illustrating real-world Docker use.
  

-------------------------------------------------------

# Java Development Workflow Example with GitHub, Jenkins, and Docker

## Overview
In this example, we'll illustrate a typical Java development workflow using popular tools like IntelliJ IDEA for development, GitHub for version control, Jenkins for continuous integration (CI), and Docker for containerization.

### Technologies Used:
- **Java**: Programming language used for application development.
- **IntelliJ IDEA**: Integrated Development Environment (IDE) for Java development.
- **GitHub**: Version control platform for hosting Git repositories.
- **Jenkins**: Automation server for continuous integration and continuous delivery (CI/CD).
- **Docker**: Containerization platform for packaging and deploying applications.

## Workflow Steps:

### 1. Setting up the Project
- **IntelliJ IDEA**: Create a new Java project in IntelliJ IDEA. Develop your Java application using IntelliJ's features like code editor, debugger, and built-in version control integration.

### 2. Version Control with GitHub
- **GitHub**: Initialize a Git repository for your project and push your code to GitHub. GitHub provides centralized version control, collaboration features (like pull requests and code reviews), and a remote repository for your project.

### 3. Continuous Integration with Jenkins
- **Jenkins**: Set up a Jenkins server for continuous integration. Configure Jenkins to monitor the GitHub repository for changes. Create a Jenkins pipeline or job that triggers a build process whenever changes are pushed to the GitHub repository.
- **Purpose**: Jenkins automates the build, test, and deployment processes, ensuring that changes are validated and integrated into the project in a timely manner.

### 4. Dockerizing the Application
- **Docker**: Write a Dockerfile to define the environment and dependencies required to run your Java application. Build a Docker image containing your application and its dependencies.
- **Purpose**: Docker containerizes your application, providing consistency in development, testing, and deployment environments. It also simplifies deployment by encapsulating the application and its dependencies into a portable, self-sufficient unit.

### 5. Deployment
- **Jenkins**: Extend your Jenkins pipeline or job to include deployment steps. Use Docker commands to deploy the Docker image to a container runtime environment, such as Docker Swarm or Kubernetes.
- **Purpose**: Jenkins automates the deployment process, ensuring that the latest version of the application is deployed consistently across different environments.

## Conclusion
By integrating tools like IntelliJ IDEA, GitHub, Jenkins, and Docker into your Java development workflow, you can streamline the development process, improve collaboration, automate repetitive tasks, and ensure the reliability and consistency of your software deployments. This example demonstrates the power of using an integrated toolchain to manage the entire software development lifecycle, from coding to deployment.

# How to do
Let's demonstrate how you can integrate a simple Java calculator program (Calculator.java) into the Java development workflow using IntelliJ IDEA, GitHub, Jenkins, and Docker.

## Step 1: Setting up the Project in IntelliJ IDEA
1. Open IntelliJ IDEA and create a new Java project.
2. Create a new Java class named Calculator.
3. Write your calculator logic in the Calculator.java class.

``` java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
        return a / b;
    }
}
```

## Write a test class for the your calculator class

```java

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

   Calculator calculator= new Calculator();

   @Test
    public void multiplyTest(){
       assertEquals(10, calculator.multiply(5,2));
   }

    @Test
    public void subtractTest(){
        assertEquals(3, calculator.subtract(5,2));
    }

    @Test
    public void divideTest(){
        assertEquals(3, calculator.divide(6,2));
    }
}

```



## Step 2: Version Control with GitHub

1. **Initialize a Git repository for your project:**

2. **Commit your changes and push the project to a GitHub repository:**

![GitHub](/Images/GitHUb.JPG)

## Step 3: Continuous Integration with Jenkins

1. **Set up a Jenkins server.**
2. **Install necessary plugins like GitHub and Docker Pipeline:**
   - In the Jenkins dashboard, navigate to "Manage Jenkins" -> "Manage Plugins" -> "Available" tab.
  
   - [plugins](/Images/plugins.JPG)
    
   - Search for and select the following plugins to install:
     - **GitHub Plugin**: Integrates Jenkins with GitHub repositories.
     - **Docker Pipeline Plugin**: Allows Jenkins to use Docker containers as part of the build process.
   - Click "Install without restart" to install the selected plugins.
3. **Create a Jenkins job that monitors the GitHub repository for changes:**
   - Click on "New Item" in the Jenkins dashboard to create a new job.
   - Enter a name for your job (e.g., "Calculator CI") and select "Freestyle project" depending on your preference.
   - Under the "Source Code Management" tab, select git and specify the GitHub project URL of your repository.
   - Enable "GitHub project" and enter the GitHub project URL.

![Git URL](/Images/NewItem.JPG)



   - Configure the job to build periodically or trigger builds based on GitHub webhook triggers (recommended for real-time builds).
   - Configure any additional build triggers or parameters as needed.
   - In the "Build" section, add a build step to execute Maven commands.
   - Specify the Maven goals to build your Java project (e.g., clean install).

   ![Git URL](/Images/mavenSetup.JPG)
   
   
     - If you're using a "Pipeline" job:
     - Write a Jenkinsfile (or use the Pipeline Script) to define the build pipeline stages.
     - Use the checkout step to clone the GitHub repository.
     - Use the sh step to execute Maven commands to build your Java project.
     - Here's an example Jenkinsfile:

       ```groovy
       pipeline {
           agent any
           stages {
               stage('Build') {
                   steps {
                       git 'https://github.com/your-username/your-repository.git'
                       sh 'mvn clean install'
                   }
               }
           }
       }
       ```
     
       *** - if youare using windows instead of sh you have to use bat--> bat 'mvn clean install'
4. **Save your Jenkins job configuration and run a test build to verify the setup.**

Now, Jenkins will monitor your GitHub repository for changes and automatically trigger builds whenever changes are pushed. It will build your Java project using Maven, helping you maintain a continuous integration workflow.

![JACOCO](/Images/JACReport.JPG)

## Step 4: Dockerizing the Application
1. Write a Dockerfile to package your Java application into a Docker image.

![Docker File](/Images/docker.jpg)

   
3. Build the Docker image locally using Docker commands or Dockerfile instructions.
- right click to the Dockerfile and run.

 ![Docker Result](/Images/dockerRes.JPG)

 ![Docker Result](/Images/dockerDesk.JPG)

Here's an example Dockerfile:
# Use an official OpenJDK runtime as a parent image
FROM maven:latest

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container at /usr/src/app
COPY Calculator.jar .

# Run the JAR file
````CMD
CMD["java", "-jar", "Calculator.jar"]

````

**Sample Docker file
````txt

# Use an official Maven image as a parent image
FROM maven:latest

# Set metadata information
LABEL authors="amirdi"

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file to the container
COPY pom.xml /app/

# Copy the entire project to the container
COPY . /app/

# Package your application
RUN mvn package

# Run the main class (assuming your application has a main class)
CMD ["java", "-jar", "target/calculator.jar"]

````
**Sample POM.XML file 
**IF you get class NOT FOUND MAKE SURE THE PATH TO THE CLASS IS CORRECT** 
```
<archive>
   <manifest>
       <mainClass>Calculator</mainClass> <!-- Correct main class -->
   </manifest>
 </archive>

```
### SAMPLE POM: make sure you configure the following POM based on your own class name and other settings on your project 

```` xml
  
<properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <build>
        <finalName>calculator</finalName>
        <plugins>
            <!-- Compiler Plugin for setting the Java version -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.13.0</version>
                <configuration>
                    <source>17</source>
                    <target>17</target>
                </configuration>
            </plugin>

            <!-- JAR Plugin for configuring the manifest file -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <version>3.4.1</version>
                <configuration>
                    <archive>
                        <manifest>
                            <mainClass>Calculator</mainClass> <!-- Correct main class -->
                        </manifest>
                    </archive>
                </configuration>
            </plugin>

            <!-- JaCoCo Plugin for code coverage -->
            <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <version>0.8.12</version>
                <executions>
                    <execution>
                        <id>jacoco-initialize</id>
                        <goals>
                            <goal>prepare-agent</goal>
                        </goals>
                    </execution>
                    <execution>
                        <id>jacoco-report</id>
                        <phase>test</phase>
                        <goals>
                            <goal>report</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

    <dependencies>
        <!-- JUnit for testing -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

````


## Step 5: Deployment
1. Extend your Jenkins pipeline or job to include deployment steps using Docker commands to deploy the Docker image to a container runtime environment.

Note: 
1. **Main class not found is often solve by configuring the pom source file**
2. **The default jar file generated by Inttelij often very long, set a default jar file name through POM.XML see the sample**
3. **Make sure the docker hub credential match the docker file hub credential and also Jenkins gloable credential.** 
4. **Make sure that you have commited all the changes to github**



