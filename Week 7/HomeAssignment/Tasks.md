# Docker and Minikube Assignment: Bank Account Functionality
> Clone last week's (Week6) solutions for this week assignment and make the following modifications:
1. Go to the hub.docker.com and create an account and a repo which you need to add the pipeline bellow, for example. 'amirdirin/assign7-fall2024_final' in the pipeline below
1. Update your Jenkins file in github as:
```sh
pipeline {
    agent any
    
    environment {
        DOCKERHUB_CREDENTIALS_ID = 'docker-hub-credentials'
        DOCKERHUB_REPO = 'amirdirin/assign7-fall2024_final'
        DOCKER_IMAGE_TAG = 'latest' // Correct tag to use
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    retry(3) {
                        git branch: 'teh5', url: 'https://github.com/ADirin/OTP1_Assign7_Fall2024.git'
                    }
                }
            }
        }
        
        stage('Build Docker Image') {
            steps {
                echo 'Starting Build Docker Image'
                script {
                    timeout(time: 10, unit: 'MINUTES') {
                        bat "docker build -t ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG} --progress=plain ."
                    }
                    echo 'Completed Build Docker Image'
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                echo 'Starting Push Docker Image to Docker Hub'
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                        bat "docker push ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}"
                    }
                }
                echo 'Completed Push Docker Image to Docker Hub'
            }
        }
    }
}
```

## Cretae a jenkins workspace and connect to the repo which you have cloned the week 6 solution and modified the Jenkinsfile based on the above given scripts
* fix any problem which you encountere
* When everything goes well then check the hun.docker.com

  ![hub.docker](/Images/hub_image_2.PNG)
  
# Assignment 7 continues
## Objective





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






