# Introduction to Jenkins

[![Jenkins Need You](https://img.youtube.com/vi/txMyeqPDuqk/0.jpg)](https://www.youtube.com/watch?v=txMyeqPDuqk)


## What is Jenkins?

Jenkins is an open-source automation server used to automate various tasks related to building, testing, and deploying software. It allows developers to continuously integrate and deliver code changes, facilitating collaboration and speeding up the software development process.

## Why Use Jenkins?

### 1. Continuous Integration

Jenkins promotes the practice of continuous integration (CI), where developers frequently merge their code changes into a shared repository. Jenkins automates the process of building and testing these changes, providing rapid feedback to developers and helping to identify issues early in the development cycle.

### 2. Automated Testing

Jenkins integrates with various testing frameworks, allowing developers to automate the execution of unit tests, integration tests, and other types of tests. This ensures that code changes do not introduce regressions and maintain code quality.

### 3. Continuous Deployment

With Jenkins, developers can automate the deployment of applications to various environments, such as development, staging, and production. This streamlines the deployment process and reduces the risk of manual errors.

### 4. Extensibility

Jenkins offers a wide range of plugins that extend its functionality, allowing users to integrate with other tools and technologies seamlessly. This flexibility makes Jenkins suitable for a variety of software development workflows and environments.

> **figure ilustrate the use of Jenkins*
 ![How ro use Jenkins](/Images/Jenkins.gif)

## How to Use Jenkins

### Step 1: Installation

1. Download Jenkins from the official website: [https://www.jenkins.io/download/](https://www.jenkins.io/download/).

2. Follow the installation instructions for your operating system.

### Step 2: Configuration

1. Once Jenkins is installed, access it through your web browser by navigating to `http://localhost:8080` (default port).

2. Follow the setup wizard to complete the initial configuration, including setting up an admin user and installing recommended plugins.

### Step 3: Create a New Jenkins Job

1. Click on "New Item" on the Jenkins dashboard to create a new job.

2. Enter a name for your job and choose the type of project (freestyle project, pipeline, etc.).

3. Configure the job settings, including source code management, build triggers, and build steps.

### Step 4: Build and Test Your Project

1. Configure your build steps to execute tasks such as compiling code, running tests, and packaging artifacts.

2. Run the job manually or configure it to run automatically based on triggers, such as code commits or scheduled builds.

### Step 5: Monitor Build Results

1. Jenkins provides detailed build logs and reports, allowing you to monitor the progress and outcome of each build.

2. Use the built-in dashboard and plugins to visualize build trends, test results, and other metrics.

## Creating a Java Application in IntelliJ IDEA

### Step 1: Install IntelliJ IDEA

````mermaid
graph LR
    A[Developer Pushes Code to GitHub] -->|Push Event| B[GitHub Repository]
    B -->|Webhook Trigger| C[Jenkins CI Server]
    C --> D[Checkout Source Code from GitHub]
    D --> E[Build Maven Project]
    E -->|mvn clean install| F[Run Unit Tests]
    F --> G[Generate Test Reports]
    G --> H[Store Results and Logs]
    H --> I[Notify Developers via Email/Slack]
    F -->|Tests Passed| J[Deploy to Staging]
    F -->|Tests Failed| K[Notify Developers of Failure]

    subgraph GitHub
        B
    end

    subgraph Jenkins CI/CD
        C --> D --> E --> F --> G --> H --> I
        F --> J
        F --> K
    end


````

1. Download IntelliJ IDEA from the official website: [https://www.jetbrains.com/idea/download/](https://www.jetbrains.com/idea/download/).

2. Follow the installation instructions for your operating system.

### Step 2: Create a New Java Project

1. Open IntelliJ IDEA and select "Create New Project" from the welcome screen.

2. Choose "Java" from the left-hand menu and click "Next."

3. Fill in the project name and location, then click "Finish" to create the project.

### Step 3: Write Java Code

1. Create a new Java class by right-clicking on the `src` folder and selecting "New -> Java Class".

2. Write your Java code in the newly created class file.

### Step 4: Build and Run the Application

1. Build the project by selecting "Build -> Build Project" from the IntelliJ IDEA menu.

2. Run the application by right-clicking on the main class file and selecting "Run <classname>".

## Conclusion

Jenkins is a powerful automation server that enables continuous integration, testing, and deployment of software. By incorporating Jenkins into your development workflow and using tools like IntelliJ IDEA for application development, you can streamline the development process, improve code quality, and accelerate software delivery.

# Using Jenkins with the Calculator Class

In this example, we will set up Jenkins to build and test the `Calculator` class created earlier.

## Step 1: Set Up Jenkins

1. Access Jenkins through your web browser by navigating to `http://localhost:8080` (default port).

2. Follow the setup wizard to complete the initial configuration, including setting up an admin user and installing recommended plugins.

## Step 2: Create a New Jenkins Job

1. Click on "New Item" on the Jenkins dashboard to create a new job.

2. Enter a name for your job (e.g., `Calculator-Test`) and choose "Freestyle project".

3. Click "OK" to create the job.

## Step 3: Configure the Jenkins Job

1. In the job configuration page, go to the "Source Code Management" section.

2. Choose your version control system (e.g., Git) and enter the repository URL.

3. Optionally, configure branch specifier and credentials if needed.

4. In the "Build" section, click on "Add build step" and choose "Execute shell" (or "Execute Windows batch command" for Windows).

5. In the command box, enter the following Maven command to compile the `Calculator` class and run unit tests:

    ```bash
    mvn clean test
    ```

   This command will clean the project, compile the source code, and execute unit tests using Maven.

6. Optionally, configure post-build actions such as email notifications or publishing test results.

7. Click "Save" to save the job configuration.

## Step 4: Run the Jenkins Job

1. On the Jenkins dashboard, click on the name of the job you created (`Calculator-Test`).

2. Click on "Build Now" to manually trigger a build.

3. Jenkins will execute the job, cloning the repository, compiling the code, and running unit tests.

4. Monitor the build progress and check the build console output for any errors.

## Step 5: View Build Results

1. After the build completes, Jenkins will display the build result on the job dashboard.

2. Green indicates a successful build, while red indicates a failed build.

3. Click on the build number to view detailed build information, including console output and test reports.

## Conclusion

In this example, we demonstrated how to set up Jenkins to build and test the `Calculator` class using a simple Jenkins job configuration. By integrating Jenkins into your development workflow, you can automate the build and testing process, ensuring code quality and reliability.
