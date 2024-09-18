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

# How to Use Jenkins
## Essential Jenkins settings

###  Installation

1. Download Jenkins from the official website: [https://www.jenkins.io/download/](https://www.jenkins.io/download/).

2. Follow the installation instructions for your operating system.

## 1. Settings  JDK, Maven, and Git in Jenkins

Follow these instructions to configure **JDK**, **Maven**, and **Git** in your Jenkins environment.

## 2. Access Jenkins Dashboard
Once Jenkins is installed:
1. Open your web browser.
2. Go to `http://localhost:8080/` or the appropriate Jenkins server URL.
3. Log in using your admin credentials.


## 3. Set Up JDK in Jenkins

### Step 1: Install JDK
- Download and install the **JDK** (Java Development Kit) from the [official Oracle site](https://www.oracle.com/java/technologies/javase-downloads.html) or [OpenJDK](https://openjdk.java.net/).
- Ensure you have **JDK 8** or later installed.

### Step 2: Configure JDK in Jenkins
1. In the Jenkins dashboard, go to **Manage Jenkins**.
2. Click **Global Tool Configuration**.
3. Scroll down to the **JDK** section.
4. Click **Add JDK**.
    - Uncheck the "Install automatically" option if JDK is already installed on your system.
    - Provide a **Name** for the JDK (e.g., `JDK 11`).
    - Enter the **JAVA_HOME** path for your installed JDK.
5. Click **Save**.

---

## 4. Set Up Maven in Jenkins

### Step 1: Install Maven
- Download and install **Maven** from the [official Maven website](https://maven.apache.org/download.cgi).
- Set up the environment variables:
    - Add Maven's `bin` folder to the `PATH`.
    - Ensure you have **Maven 3.6.0** or later.

### Step 2: Configure Maven in Jenkins
1. In the Jenkins dashboard, go to **Manage Jenkins**.
2. Click **Global Tool Configuration**.
3. Scroll down to the **Maven** section.
4. Click **Add Maven**.
    - Uncheck the "Install automatically" option if Maven is already installed on your system.
    - Provide a **Name** for Maven (e.g., `Maven 3.8.1`).
    - Enter the **Maven Home** directory path where Maven is installed.
5. Click **Save**.

---

## 5. Set Up Git in Jenkins

### Step 1: Install Git
- Download and install **Git** from the [official Git website](https://git-scm.com/downloads).
- Verify the installation by running the following command in your terminal:
    ```bash
    git --version
    ```

### Step 2: Configure Git in Jenkins
1. In the Jenkins dashboard, go to **Manage Jenkins**.
2. Click **Global Tool Configuration**.
3. Scroll down to the **Git** section.
4. Click **Add Git** (if it is not already listed).
    - Jenkins will automatically detect Git if it is installed.
5. Click **Save**.

---

## 6. Verify Configuration

### Step 1: Create a Test Job
1. In the Jenkins dashboard, click **New Item**.
2. Create a **Freestyle Project** or **Pipeline**.
3. Under **Build Environment**, verify if Jenkins recognizes the **JDK**, **Maven**, and **Git** installations.
4. Run a test build to ensure everything is configured correctly.

### Step 2: Check Build Output
1. Click on **Build Now** for the test job.
2. Navigate to **Build History > Console Output**.
3. Check for logs that show the correct versions of **JDK**, **Maven**, and **Git** being used.

---

By following these steps, you will have successfully configured JDK, Maven, and Git in Jenkins, allowing you to run Java-based projects with Maven builds.


------------------------------------------------------------------
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


### Step 1: Create a New Java Project

1. Open IntelliJ IDEA and select "Create New Project" from the welcome screen.

2. Choose "Java" from the left-hand menu and click "Next."

3. Fill in the project name and location, then click "Finish" to create the project.

### Step 2: Write Java Code

1. Create a new Java class by right-clicking on the `src` folder and selecting "New -> Java Class".

2. Write your Java code in the newly created class file.

### Step 3: Build and Run the Application

1. Build the project by selecting "Build -> Build Project" from the IntelliJ IDEA menu.

2. Run the application by right-clicking on the main class file and selecting "Run <classname>".

## Conclusion

Jenkins is a powerful automation server that enables continuous integration, testing, and deployment of software. By incorporating Jenkins into your development workflow and using tools like IntelliJ IDEA for application development, you can streamline the development process, improve code quality, and accelerate software delivery.

