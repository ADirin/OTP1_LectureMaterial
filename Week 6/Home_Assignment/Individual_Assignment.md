# Home Assignment

For this assignment, we will be extending the FarToCel application during our in-class sessions. 

1. **Extend Application:**  
   Expand the application to include conversions from Kelvin to Fahrenheit using the formula:  
   `((kel - 273.15) * (9/5) + 32)`; for example, 300.1 Kelvin is equal to 59.0 Fahrenheit.  
   Test the newly added function to ensure correctness.

AT test case and ensure that the newly added function is correct. (1 point)

   
2. **GitHub Repository:**  
   If you haven't already done so, create a GitHub repository for FarToCel and push the latest updates to it.

3. **Configure Pipeline**

1. In the **Pipeline** configuration page, scroll down to the **Pipeline** section.
2. Set the **Definition** to **Pipeline script from SCM**.
3. Select **SCM** as **Git**.
4. Enter your **Repository URL**. For example, `https://github.com/your-username/your-repo.git`.
5. If your repository is private, add credentials by clicking **Add** under **Credentials**.
   - Select **Kind** as **Username with password**.
   - Enter your GitHub username and personal access token.
   - Save the credentials and select them from the **Credentials** dropdown.
6. Set the **Branch Specifier** to the branch you want to use (e.g., `*/main`).

7. Add Jenkinsfile to Your Repository

Create a `Jenkinsfile` in the root of your GitHub repository with the following content:

```groovy
pipeline {
    agent {
        docker { 
            image 'docker:stable' 
            args '-v /var/run/docker.sock:/var/run/docker.sock' 
        }
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/your-username/your-repo.git', branch: 'main'
            }
        }
        stage('Build and Test') {
            steps {
                script {
                    // Build the Docker image
                    sh 'docker build -t my-java-app .'

                    // Run the Docker container
                    sh 'docker run --rm my-java-app'
                }
            }
        }
    }
}
```
Replace your-username and your-repo with your actual GitHub username and repository name.

4. **Docker Integration:**  
Include a Dockerfile in the FarToCel project. Build and run the Docker container locally. Ensure to add the filename tag and include the package to the manifest in the pom.xml.  
Dockerfile
FROM maven:latest
WORKDIR /app
COPY pom.xml /app/
COPY . /app/
RUN mvn package
CMD ["java", "-jar", "target/interconversions.jar"]

5. **GitHub and Jenkins Integration:**  
Ensure that the latest modifications to your TempConverter project are pushed to GitHub. Configure Jenkins to automatically start building after a new commit is uploaded to the repository.

7. **Docker Hub Account:**  
Create an account on hub.docker.com if you haven't already.

8. **Update Jenkins with Docker Plugins:**  
Update Jenkins with Docker plugins following the instructions provided in the class and accompanying video clip in the Oma.

Provide the link to your GitHub repository, screenshots of your Docker Hub repository, and Jenkins build reports as part of your submission.

8. **Update Jenkins with Docker Plugins:**  
Update Jenkins with Docker plugins following the instructions provided in the class and accompanying video clip in the Oma.

Provide the link to your GitHub repository, screenshots of your Docker Hub repository, and Jenkins build reports as part of your submission.
