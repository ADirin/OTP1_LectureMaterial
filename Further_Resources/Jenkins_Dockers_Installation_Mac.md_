# Instructions - Jenkins and Docker

## Jenkins

### 1. Set Up JDK in Jenkins

**Step 1: Install JDK**
- Download and install the JDK (Java Development Kit) from the official Oracle site or OpenJDK.
- Ensure you have JDK11, JDK17, and JDK21 or later installed.

**Step 2: Configure JDK in Jenkins**
1. In the Jenkins dashboard, go to **Manage Jenkins**.
2. Click **Tools**.
3. Scroll down to the **JDK** section.
4. Click **Add JDK**.
5. Provide a **Name** for the JDK (e.g., JDK 21).
6. Enter the `JAVA_HOME` path for your installed JDK.
   - You can find `JAVA_HOME` by typing the following in the Terminal:
     ```bash
     /usr/libexec/java_home
     ```
7. Click **Save**.

---

### 2. Set Up Maven in Jenkins

**Step 1: Install Maven**
- Download and install Maven from the official Maven website.
- Set up the environment variables:
  - Add Maven's `bin` folder to the `PATH`.
  - Ensure you have Maven 3.6.0 or later.

**Step 2: Configure Maven in Jenkins**
1. In the Jenkins dashboard, go to **Manage Jenkins**.
2. Click **Tools**.
3. Scroll down to the **Maven** section.
4. Click **Add Maven**.
5. Uncheck the **Install automatically** option.
6. Provide a **Name** for Maven (e.g., Homebrew Maven).
7. Enter the Maven Home directory path where Maven is installed.
   - Use the command:
     ```bash
     which mvn
     ```
     This shows Maven’s executable path. `MAVEN_HOME` is typically the parent directory where Maven is installed.
   - Run:
     ```bash
     ls -l /usr/local/bin/mvn
     ```
     This shows the actual path to the Maven directory, which might be:
     ```bash
     /usr/local/Cellar/maven/3.9.9/libexec
     ```
8. Click **Save**.

---

### 3. Set Up Git in Jenkins

**Step 1: Install Git**
- Download and install Git from the official Git website.
- Verify the installation:
```bash
  git --version

```
**Step 2: Configure Git in Jenkins**

1. In the Jenkins dashboard, go to Manage Jenkins.
2. Click Tools.
3. Scroll down to the Git section.
4. Click Add Git (if not already listed).
5. Jenkins will detect Git if installed.
6. Click Save.

*Add GitHub Credentials*

1. Go to Credentials.
2. Click System and Add domain.
  - Domain Name: Git (no description or specification needed).
3. Click Create.
4. Then click Add Credentials.
  - Kind: Username with password
  - Scope: Global
  - Username: Your GitHub username
  - Password: Your GitHub password
  - ID: Git
5. Click Save.

*Configure Plugins*

- Add the following plugins:
  - Coverage Plugin
  - Docker
  - Docker Pipeline
  - docker-build-step
  - GitHub Branch Source
  - JaCoCo plugin
  - Pipeline
  - Yet Another Docker Plugin

-----------------------------------------
## 4. Practical Example - Freestyle Project
1. Open your web browser.
2. Go to http://localhost:8080/ or your Jenkins server URL.
3. Log in with your admin credentials.
4. Click on New Item to create a new job.
  - Enter a name for your job and select Freestyle Project.
5. Configure job settings, including Source Code Management and Build steps.
  - Source Code Management: Choose Git and enter your GitHub repository URL and credentials.
  - Build Steps: Add Invoke top-level Maven targets.
    - Use Homebrew Maven or your Maven installation.
    - Goals: clean test
  - Post-Build Actions: Add Record JaCoCo Coverage Report.
6. Click Apply and Save.
7. Click Build.

---------------------------------------------------

## 5. Practical Example - Pipeline Project
  1. Open your web browser and go to http://localhost:8080/.
  2. Log in and click New Item.
  3. Enter a name for your job and select Pipeline.
  4.Configure the Pipeline section.
    - Pipeline Script (if you don’t have a Jenkinsfile in your project):

```groovy
pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/sarapap/TemperatureConverter.git' // Replace with your GitHub repository
            }
        }
        stage('Build') {
            steps {
                withEnv(["PATH+EXTRA=/usr/local/bin:/bin"]) {
                    sh 'mvn clean install'
                }
            }
        }
        stage('Test') {
            steps {
                withEnv(["PATH+EXTRA=/usr/local/bin:/bin"]) {
                    sh 'mvn test'
                }
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
5. Pipeline Script from SCM (when you have a Jenkinsfile in GitHub):
  - Choose SCM: Git
  - Copy your repository URL.
  - Add credentials.
6. Ensure the Jenkinsfile matches the name of the file in GitHub.
7. Click Apply, Save, and Build.

---------------------------------------------------
## Docker
1. Download Docker Desktop: Docker Desktop for Mac
2. Install Docker Desktop: Open the downloaded .dmg file and drag Docker to the Applications folder.
3. Start Docker Desktop: Launch Docker and complete the setup.
4. Verify Installation
```bash
docker --version

```
### 1. Practical Example - Docker
1. Write a Dockerfile to package your Java application into a Docker image.
2. Example Dockerfile

```docker
FROM maven:latest
LABEL authors="sarapap" // Replace with your username
WORKDIR /app
COPY pom.xml /app/
COPY . /app/
RUN mvn package
CMD ["java", "-jar", "target/TemperatureConverter.jar"] // Replace with your jar


```
### 2. Docker Credentials in Jenkins
1. Go to Manage Jenkins > Credentials > Domains > (global).
2. Click Add Credentials.
  - Kind: Username with password
  - Scope: Global
  - Username: Docker Hub username
  - Password: Docker Hub password
  - ID: e.g., docker_creds
3. Click Create.
---------------------------------------------
### 3. Pipeline Project with Docker

```groovy

pipeline {
    agent any
    environment {
        DOCKERHUB_REPO = 'sarapap/temperatureconverter'  // Your Docker Hub repository
        DOCKER_IMAGE_TAG = 'latest'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/sarapap/TemperatureConverter.git' // Replace with your repository
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    withEnv(["PATH+EXTRA=/usr/local/bin:/bin"]) {
                        docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                    }
                }
            }
        }
        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'docker_creds', 
                                                     usernameVariable: 'DOCKER_USER',
                                                     passwordVariable: 'DOCKER_PASS')]) {
                        sh """
                            docker login -u ${DOCKER_USER} -p ${DOCKER_PASS}
                            docker build -t ${DOCKER_USER}/temperatureconverter:latest .
                            docker push ${DOCKER_USER}/temperatureconverter:latest 
                            docker logout
                        """
                    }
                }
            }
        }
    }
}


```

---------------------------------
### 4. Docker in Virtual Machine
Use a Virtual Machine to test Docker if Docker Playground doesn’t work on Mac. 
Follow instructions to install Docker and test your Docker image in the VM.

### 5. Pipeline with JaCoCo Report

```groovy
pipeline {
    agent any
    environment {
        DOCKERHUB_REPO = 'sarapap/localdemo' // Your Docker Hub repository
        DOCKER_IMAGE_TAG = 'latest'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/sarapap/LocalDemo_v1.git' // Replace with your repository
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    withEnv(["PATH+EXTRA=/usr/local/bin:/bin"]) {
                        docker.build("${DOCKERHUB_REPO


```
