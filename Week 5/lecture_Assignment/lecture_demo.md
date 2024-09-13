# Using Jenkins for JUnit Testing and Code Coverage

## 1. Using a Freestyle Project in Jenkins

### Steps to Set Up a Freestyle Job for JUnit Testing

1. **Go to Jenkins Dashboard**
   - Navigate to the Jenkins dashboard.

2. **Create a New Freestyle Project**
   - Click on "New Item".
   - Enter the job name.
   - Select "Freestyle project" and click "OK".

3. **Configure Source Code Management (SCM)**
   - Under "Source Code Management", select Git.
   - In "Repository URL", provide the URL to your GitHub repository (e.g., `https://github.com/your-username/your-repo.git`).
   - Optionally, specify the branch you want to build (e.g., `main` or `master`).

4. **Build Triggers (Optional)**
   - Configure Jenkins to automatically pull and run tests when changes are detected using Poll SCM or GitHub Webhooks.

5. **Build Steps**
   - In the "Build" section, add a Build Step to run JUnit tests.
     - For Maven: Select "Invoke top-level Maven targets" and specify the goals: `clean test`.
     - For Shell or Gradle: Add a Build Step to execute commands directly:
       - For shell: Choose "Execute Shell" and run `mvn clean test`.

6. **Post-Build Actions**
   - To capture JUnit results, add "Post-build Actions":
     - Choose "Publish JUnit test result report".
     - In "Test Report XMLs", enter the path to the generated XML test reports (e.g., `target/surefire-reports/*.xml` for Maven projects).

7. **Save and Run**
   - Save the job and click "Build Now" to run the tests.

### Sequence Diagram

![Freestyle Project Sequence Diagram](link-to-your-image-file)

---

## 2. Using a Pipeline with a Jenkinsfile in GitHub

### Steps to Set Up a Jenkins Pipeline with a Jenkinsfile

1. **Create a Jenkinsfile in GitHub**
   - Add a `Jenkinsfile` to your GitHub repository with the following content:

    ```groovy
    pipeline {
        agent any
        stages {
            stage('Checkout') {
                steps {
                    git 'https://github.com/your-username/your-repo.git'
                }
            }
            stage('Build') {
                steps {
                    sh 'mvn clean install'
                }
            }
            stage('Test') {
                steps {
                    sh 'mvn test'
                }
            }
            stage('Code Coverage') {
                steps {
                    sh 'mvn jacoco:report'
                }
            }
            stage('Publish Test Results') {
                steps {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
            stage('Publish Coverage Report') {
                steps {
                    jacoco()
                }
            }
        }
    }
    ```

2. **Create a Pipeline Job in Jenkins**
   - Go to Jenkins dashboard.
   - Click on "New Item".
   - Enter a job name.
   - Select "Pipeline" and click "OK".

3. **Configure the Pipeline**
   - Under the "Pipeline" section, set "Definition" to "Pipeline script from SCM".
   - Select "Git" as SCM and provide your GitHub repository URL.
   - In "Script Path", enter `Jenkinsfile`.

4. **Save and Run**
   - Save the job and click "Build Now" to run the pipeline.

### Sequence Diagram

![Pipeline with Jenkinsfile Sequence Diagram](link-to-your-image-file)

---

## 3. Creating a Jenkins Pipeline

### Steps to Create a Declarative Pipeline

1. **Create a New Pipeline Job in Jenkins**
   - Go to Jenkins dashboard.
   - Click on "New Item".
   - Enter a job name.
   - Select "Pipeline" and click "OK".

2. **Configure the Pipeline**
   - Under the "Pipeline" section, choose "Pipeline script" and write the following script:

    ```groovy
    pipeline {
        agent any
        stages {
            stage('Checkout') {
                steps {
                    git 'https://github.com/your-username/your-repo.git'
                }
            }
            stage('Build') {
                steps {
                    sh 'mvn clean install'
                }
            }
            stage('Test') {
                steps {
                    sh 'mvn test'
                }
            }
            stage('Code Coverage') {
                steps {
                    sh 'mvn jacoco:report'
                }
            }
            stage('Publish Test Results') {
                steps {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
            stage('Publish Coverage Report') {
                steps {
                    jacoco()
                }
            }
        }
    }
    ```

3. **Save and Run**
   - Save the job and click "Build Now" to run the pipeline.

### Sequence Diagram

![Declarative Pipeline Sequence Diagram](link-to-your-image-file)
