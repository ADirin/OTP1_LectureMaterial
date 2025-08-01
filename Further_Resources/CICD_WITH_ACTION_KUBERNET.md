# ☕ Java App with CI/CD, Docker, and Minikube (Step-by-Step)

### 🔗 Sample code and the project structure available at:  
[https://github.com/ADirin/weem5_sep1_CICDAction.git](https://github.com/ADirin/weem5_sep1_CICDAction.git)

---

## 🚀 Overview

This guide walks you through:

- Creating a Java project in IntelliJ
- Adding unit tests and code coverage
- Building a Docker image and pushing it to Docker Hub via GitHub Actions
- Running the image using Minikube on Windows via Kubernetes `Job`

---

## 1. 📦 Create Java App in IntelliJ

1. Open **IntelliJ IDEA**
2. Go to `File → New → Project`
3. Choose **Maven**
4. Fill in:
   - **GroupId**: `org.example`
   - **ArtifactId**: `MyApp`
5. Click **Finish**

---

## 2. 🧑‍💻 Add Java Source Code

**File:** `src/main/java/org/example/App.java`

```java
package org.example;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello from Docker + K8s!");
    }

    public static int add(int a, int b) {
        return a + b;
    }
}
```
## 3. Add Unit Test
File: src/test/java/org/example/AppTest.java

```java
package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    public void testAdd() {
        assertEquals(5, App.add(2, 3));
    }
}

```

## 4. Update pom.xml

Make sure your pom.xml includes:

```xml
<properties>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
</properties>

<build>
    <plugins>
        <!-- Java compiler -->
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.11.0</version>
        </plugin>

        <!-- Unit testing -->
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.1.2</version>
        </plugin>

        <!-- Code coverage -->
        <plugin>
            <groupId>org.jacoco</groupId>
            <artifactId>jacoco-maven-plugin</artifactId>
            <version>0.8.11</version>
            <executions>
                <execution>
                    <goals><goal>prepare-agent</goal></goals>
                </execution>
                <execution>
                    <id>report</id>
                    <phase>test</phase>
                    <goals><goal>report</goal></goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>

<dependencies>
    <!-- JUnit 5 -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>

```
## 5. Create Dokerfile

``` dockerfile
# Use OpenJDK base image
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy compiled classes (build locally first)
COPY target/MyApp-1.0-SNAPSHOT.jar app.jar

# Run app
ENTRYPOINT ["java", "-jar", "app.jar"]
```

## 6. GitHub Action CI/CD
File: .github/workflows/maven.yml

```yaml

name: Java CI with Docker

on:
  push:
    branches: [ master ]
  pull_request:
    branches: [ master ]

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout code
        uses: actions/checkout@v3

      - name: Set up Java 11
        uses: actions/setup-java@v4
        with:
          distribution: temurin
          java-version: '11'

      - name: Build and test
        run: mvn clean package

      - name: Upload test results
        uses: actions/upload-artifact@v4
        with:
          name: junit-results
          path: target/surefire-reports/

      - name: Upload coverage report
        uses: actions/upload-artifact@v4
        with:
          name: jacoco-report
          path: target/site/jacoco/

      - name: Login to Docker Hub
        uses: docker/login-action@v3
        with:
          username: ${{ secrets.DOCKER_USERNAME }}
          password: ${{ secrets.DOCKER_PASSWORD }}

      - name: Build and Push Docker Image
        uses: docker/build-push-action@v5
        with:
          context: .
          push: true
          tags: amirdirin/myapp:latest
```
## Create a token
1. Go to hub.docker.com-> myAccount setting--> Personal Access Token--> click on Generate new Token 
Note: Copy and save the generated token since you can not see it later


## Add token into Repo "secrets":

Go to GitHub → Repo Settings → Secrets and Variables → Actions

Add: DOCKER_USERNAME and DOCKER_PASSWORD as shown bellow:

| Name              | Value                                                                                        |
| ----------------- | -------------------------------------------------------------------------------------------- |
| `DOCKER_USERNAME` | Your Docker Hub username (`amirdirin`)                                                       |
| `DOCKER_PASSWORD` | Your Docker Hub [access token](https://hub.docker.com/settings/security) (not your password) |


## 7. Minikube: Run Docker image on windows

### Step 1: Start Minikube

```bash
minikube start --driver=docker
```

Leave the terminal open.

### Step 2: Create Kubernetes Job Yaml
file: job.yaml

```yaml
apiVersion: batch/v1
kind: Job
metadata:
  name: run-myapp-job
spec:
  template:
    spec:
      containers:
      - name: myapp
        image: amirdirin/myapp:latest
      restartPolicy: Never
  backoffLimit: 1
```

### step 3: Apply job

```bash
kubectl apply -f job.yaml

```
### step 4: view Pod Logs

```bash
kubectl get pods
kubectl logs <pod-name>
```
Expected output

```text
Hello from Docker + K8s!

```

### Step 5
```bash

kubectl delete job run-myapp-job

```
