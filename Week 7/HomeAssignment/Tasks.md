# Docker and Minikube Assignment: Bank Account Functionality

## Objective

The objective of this assignment is to develop a class to illustrate bank account functionality, create a corresponding JUnit test case to verify its correctness, and deliver a Docker image containing the application. Additionally, you will deploy the Docker container to a local Kubernetes cluster using Minikube.

## Steps

### 1. Create Files

Create two files: `Account.java` and `AccountTest.java`.

### 2. Implement Account Class

Implement the `Account` class in `Account.java`. The `Account` class must include the following methods and member variables:
- A double member variable to hold the current account balance.
- `public Account() {...}`: The default constructor should initialize the balance to 0.0.
- `public void deposit(double amount) {...}`: A deposit method to add money to the account.
- `public double withdraw(double amount) {...}`: A withdraw method that withdraws the given amount from the account. If the amount given can be withdrawn, it should return that amount. If not, it should return 0.0.
- `public double getBalance() {...}`: A method to get the current balance in the account.

### 3. Write Test Cases

Write test cases for the `Account` class in `AccountTest.java`. Test cases should cover various scenarios including depositing money, withdrawing money, and checking balance.

### 4. Execute Test Cases

Execute the test cases and ensure they pass successfully.

## Example Code

### Account.java

```java
public class Account {
    private double balance;

    public Account() {
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            return amount;
        } else {
            return 0.0;
        }
    }

    public double getBalance() {
        return this.balance;
    }
}
``` 
### AccountTest.java

```java
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {
    private Account account;

    @Before
    public void setUp() {
        account = new Account();
    }

    @Test
    public void testInitialBalance() {
        assertEquals(0.0, account.getBalance(), 0.01);
    }

    @Test
    public void testDeposit() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdraw() {
        account.deposit(100.0);
        double amountWithdrawn = account.withdraw(50.0);
        assertEquals(50.0, amountWithdrawn, 0.01);
        assertEquals(50.0, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        double amountWithdrawn = account.withdraw(50.0);
        assertEquals(0.0, amountWithdrawn, 0.01);
        assertEquals(0.0, account.getBalance(), 0.01);
    }
}

```
# Docker Integration

## Objective

Package the application into a Docker container and automate the build and test process using Jenkins, DockerHub, and GitHub.

## Steps

### Set Up IntelliJ

- Use IntelliJ IDEA to write and manage your Java code.

### Set Up GitHub

- Create a GitHub repository and push your project files to it.

### Create a Dockerfile

In the root directory of your project, create a `Dockerfile` with the following content:

#### Dockerfile

```Dockerfile
# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Compile the application
RUN javac Account.java AccountTest.java

# Define the command to run the application
CMD ["java", "-cp", ".:junit-4.12.jar:hamcrest-core-1.3.jar", "org.junit.runner.JUnitCore", "AccountTest"]
```
###  Set Up Jenkins
Install Jenkins on your local machine or server.
Install the necessary plugins for Java, Git, and Docker integration.
###  Create a Jenkins Pipeline
Set up a new Jenkins job and configure it as a pipeline.
### Add Jenkinsfile
Create a Jenkinsfile in your repository with the following content:

```groovy
pipeline {
    agent any

    environment {
        DOCKER_CREDENTIALS_ID = 'your-docker-credentials-id'
        DOCKER_IMAGE = 'your-dockerhub-username/bank-account'
    }

    stages {
        stage('Build') {
            steps {
                sh 'javac Account.java AccountTest.java'
            }
        }
        stage('Test') {
            steps {
                sh 'java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore AccountTest'
            }
        }
        stage('Docker Build') {
            steps {
                script {
                    docker.build(DOCKER_IMAGE)
                }
            }
        }
        stage('Docker Push') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKER_CREDENTIALS_ID) {
                        docker.image(DOCKER_IMAGE).push()
                    }
                }
            }
        }
    }
}

```
### Run the Pipeline
Trigger the pipeline manually or set it up to trigger on each commit.

# Minikube Integration
## Objective
Deploy the Docker container to a local Kubernetes cluster using Minikube.

## Steps
Set Up Minikube
1. Install Minikube:
Follow the official Minikube installation guide to install Minikube on your local machine.

2. Start Minikube:
Start a Minikube cluster by running the following command:
```sh
minikube start
```
3. Enable Docker Environment:
   Configure your shell to use Minikube’s Docker daemon:
```sh
eval $(minikube docker-env)
```
4. Build Docker Image in Minikube:
  Build your Docker image directly in the Minikube environment:

```sh
docker build -t your-dockerhub-username/bank-account .
```
5. Create Kubernetes Deployment:
Create a Kubernetes deployment configuration file named deployment.yaml with the following content:

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: bank-account-deployment
spec:
  replicas: 1
  selector:
    matchLabels:
      app: bank-account
  template:
    metadata:
      labels:
        app: bank-account
    spec:
      containers:
      - name: bank-account
        image: your-dockerhub-username/bank-account
        ports:
        - containerPort: 8080
```
6. Apply the Deployment:
Deploy the application to Minikube:
> <ins>**Note**<ins> Prior to the deployment:
> 1. Ensure that the Docker image is pushed to a Docker registry accessible by Minikube.
> 2. Add steps to verify the deployment after applying it to Minikube to ensure it's running correctly.
```sh
kubectl apply -f deployment.yaml
```
7. Expose the Deployment:
Expose the deployment to access it from your host machine:

```sh
kubectl expose deployment bank-account-deployment --type=NodePort --port=8080
```
8. Access the Application:
Get the URL to access your application:

```sh
minikube service bank-account-deployment --url
```






