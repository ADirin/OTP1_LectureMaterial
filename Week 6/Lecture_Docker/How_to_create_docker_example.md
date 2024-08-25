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


## Step 2: Version Control with GitHub

1. **Initialize a Git repository for your project:**
   - Open a terminal or command prompt and navigate to your project directory:
     ```bash
     cd /path/to/your/project
     ```
   - Initialize a new Git repository:
     ```bash
     git init
     ```
     This command initializes an empty Git repository in your project directory.

2. **Commit your changes and push the project to a GitHub repository:**
   - Add all files in your project directory to the staging area:
     ```bash
     git add .
     ```
     This command stages all changes in the current directory for the next commit.
   - Commit the staged changes with a descriptive commit message:
     ```bash
     git commit -m "Initial commit"
     ```
     Replace "Initial commit" with a meaningful message that describes the changes you've made in this commit.
   - Go to the GitHub website and log in to your account.
   - Click on the "+" icon in the top right corner of the page and select "New repository".
   - Fill in the repository name, description, and other settings as desired.
   - Click on the "Create repository" button to create the repository on GitHub.
   - Copy the HTTPS or SSH URL of your GitHub repository.
   - In your terminal or command prompt, add the GitHub repository as a remote:
     ```bash
     git remote add origin <repository-url>
     ```
     Replace `<repository-url>` with the URL you copied from GitHub.
   - Push your commits to the GitHub repository:
     ```bash
     git push -u origin master
     ```
     This command pushes the commits in your local repository's master branch to the remote repository (GitHub).

## Step 3: Continuous Integration with Jenkins

1. **Set up a Jenkins server.**
2. **Install necessary plugins like GitHub and Docker Pipeline:**
   - In the Jenkins dashboard, navigate to "Manage Jenkins" -> "Manage Plugins" -> "Available" tab.
   - Search for and select the following plugins to install:
     - GitHub Plugin: Integrates Jenkins with GitHub repositories.
     - Docker Pipeline Plugin: Allows Jenkins to use Docker containers as part of the build process.
   - Click "Install without restart" to install the selected plugins.
3. **Create a Jenkins job that monitors the GitHub repository for changes:**
   - Click on "New Item" in the Jenkins dashboard to create a new job.
   - Enter a name for your job (e.g., "Java CI") and select "Freestyle project" or "Pipeline" depending on your preference.
   - Under the "General" tab, specify the GitHub project URL of your repository.
   - Enable "GitHub project" and enter the GitHub project URL.
   - Configure the job to build periodically or trigger builds based on GitHub webhook triggers (recommended for real-time builds).
   - Configure any additional build triggers or parameters as needed.
4. **Configure the Jenkins job to build the Java project using Maven:**
   - If you're using a "Freestyle project":
     - In the "Build" section, add a build step to execute Maven commands.
     - Specify the Maven goals to build your Java project (e.g., clean install).
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
5. **Save your Jenkins job configuration and run a test build to verify the setup.**

Now, Jenkins will monitor your GitHub repository for changes and automatically trigger builds whenever changes are pushed. It will build your Java project using Maven, helping you maintain a continuous integration workflow.


## Step 4: Dockerizing the Application
1. Write a Dockerfile to package your Java application into a Docker image.
2. Build the Docker image locally using Docker commands or Dockerfile instructions.


Here's an example Dockerfile:
# Use an official OpenJDK runtime as a parent image
FROM maven:latest

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container at /usr/src/app
COPY Calculator.jar .

# Run the JAR file
CMD ["java", "-jar", "Calculator.jar"]


**Sampel Docker file
````txt


# Use an official Maven image as a parent image
FROM maven:latest

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file to the container
COPY pom.xml /app/

# Copy the entire project to the container
COPY . /app/

# Package your application
RUN mvn package

# Run the main class (assuming your application has a main class)
CMD ["java", "-jar", "./target/finalDemoApp.jar"]


````
**Sample POM.XML file 
```` xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>org.example</groupId>
  <artifactId>finalDemo_fall2024</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>jar</packaging>

  <name>finalDemo_fall2024</name>
  <url>http://maven.apache.org</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>
  <build>

    <!-- Add this section to change the name of the JAR file -->
    <finalName>finalDemoApp</finalName>

    <plugins>
      <!-- Compiler Plugin for setting the Java version -->
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        <configuration>
          <source>21</source> <!-- or your Java version -->
          <target>21</target> <!-- or your Java version -->
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



  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.13.2</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>


````


## Step 5: Deployment
1. Extend your Jenkins pipeline or job to include deployment steps using Docker commands to deploy the Docker image to a container runtime environment.

Note: 
1. **Main class not found is often solve by configuring the pom source file**
2. **The default jar file generated by Inttelij often very long, set a default jar file name through POM.XML see the sample**
3. **Make sure the docker hub credential match the docker file hub credential and also Jenkins gloable credential.** 
4. **Make sure that you have commited all the changes to github**



