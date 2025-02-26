# **Aikido Practice Tracker: Java Application with Testing, CI/CD, and Docker**  

## **Objective**  
Develop a **Java console-based application** to **track Aikido practice sessions** and determine eligibility for **Kyu graduation**. The project includes **unit testing, code coverage, GitHub integration, Jenkins automation, and Docker containerization**.  

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
2. Docker Image (Running Aikido Tracker / screenshot of the created image from doecker decktop (images)).

## sample pom
```xml
<dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.11.1</version>
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
            <artifactId>junit-jupiter</artifactId>
            <version>5.8.1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <finalName>laskin</finalName>
        <plugins>
            <!-- Maven Compiler Plugin -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.13.0</version>
                <configuration>
                    <release>21</release>
                </configuration>
            </plugin>

            <!-- Maven Jar Plugin -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <version>3.4.1</version>
                <configuration>
                    <archive>
                        <manifest>
                            <mainClass>Laskin</mainClass>
                        </manifest>
                    </archive>
                </configuration>
            </plugin>

            <!-- JaCoCo Code Coverage Plugin -->
            <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <version>0.8.12</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>prepare-agent</goal>
                        </goals>
                    </execution>
                    <execution>
                        <id>report</id>
                        <phase>prepare-package</phase>
                        <goals>
                            <goal>report</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.5.1</version>
                <configuration>
                    <includes>
                        <include>**/*Test.java</include>
                    </includes>
                </configuration>
            </plugin>
        </plugins>
    </build>

```
[Potential Solution](https://github.com/ADirin/SEP1_week6_Inclass_Student.git) 

