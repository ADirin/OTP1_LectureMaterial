# **Aikido Practice Tracker: Java Application with Testing, CI/CD, and Docker**  

## **Objective**  
Students will develop a **Java console-based application** to **track Aikido practice sessions** and determine eligibility for **Kyu graduation**. The project includes **unit testing, code coverage, GitHub integration, Jenkins automation, and Docker containerization**.  

---

## **Project Overview**  

### **Application: Aikido Practice Tracker**  
- Users can **log training sessions**.  
- The system **calculates total practice time**.  
- After **6 months or 100 sessions**, the user is eligible for **Kyu graduation**.  

---

## **Features & Functionalities**  

### **1. Console-Based Aikido Tracker**  
#### ✅ **Functionalities**  
- Add a training session (date & duration).  
- View total training time.  
- Check if eligible for Kyu graduation.  

#### ✅ **Example Menu**  

===== Aikido Practice Tracker =====

1. Add Practice Session
2. View Total Practice Time
3. Check Graduation Eligibility
4. Exit Choose an option:



---

### **2. Unit Testing & Code Coverage**  
- **JUnit 5 tests** for:  
  - Adding training sessions.  
  - Calculating total practice time.  
  - Checking graduation eligibility.  
- Use **JaCoCo** for test coverage.  

#### **Example Unit Test:**  
```java
@Test
void testAddPracticeSession() {
    tracker.addSession("2024-02-01", 90);
    assertEquals(90, tracker.getTotalPracticeTime());
}
```
### **3. GitHub Integration**
Commit project to GitHub repository.
```sh
git init
git add .
git commit -m "Initial commit - Aikido Tracker"
git push origin main


```

### **4. Jenkins CI/CD Automation**
- Freestyle Job: Pull code & run unit tests.
- Pipeline Job (Jenkinsfile in GitHub):
    - Code Checkout
    - Build & Test
    - Code Coverage

```groovy
pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-repo.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}

```

### **5. Docker Containerization**
Dockerfile Configuration

```dockerfile

FROM openjdk:21
WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]


```
Build & Run Docker Image Locally

```sh
docker build -t aikido-tracker .
docker run -it aikido-tracker
```
## Deliverables
1. GitHub Repository (Code, Tests, Jenkinsfile, Dockerfile).
2. Jenkins Setup (Screenshots of Jobs).
3. Docker Image (Running Aikido Tracker).

## Assessment Criteria
```markdown
## **Assessment Criteria**  

| **Criteria**                  | **Marks** |
|--------------------------------|-----------|
| Functionality (Tracker System) | 20        |
| Unit Testing (JUnit)           | 15        |
| Code Coverage (JaCoCo)         | 10        |
| GitHub Usage                   | 10        |
| Jenkins Freestyle Job          | 15        |
| Jenkinsfile (Pipeline Job)     | 15        |
| Docker Implementation          | 15        |


```
[Potential Solution](https://github.com/ADirin/SEP1_week6_Inclass_Student.git) 

