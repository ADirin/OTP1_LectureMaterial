# Step-by-Step Instructions

## 1. Install Required Jenkins Plugins

Navigate to **Jenkins Dashboard > Manage Jenkins > Manage Plugins**.  
Install the following plugins if not already installed:
- **Git Plugin**
- **Pipeline Plugin**
- **Docker Pipeline Plugin**

## 2. Create a New Pipeline Item

1. Go to the **Jenkins Dashboard**.
2. Click **New Item**.
3. Enter a name for your pipeline, for example, `Run Dockerfile`.
4. Select **Pipeline**.
5. Click **OK**.

## 3. Configure Pipeline

1. In the **Pipeline** configuration page, scroll down to the **Pipeline** section.
2. Set the **Definition** to **Pipeline script from SCM**.
3. Select **SCM** as **Git**.
4. Enter your **Repository URL**. For example, `https://github.com/your-username/your-repo.git`.
5. If your repository is private, add credentials by clicking **Add** under **Credentials**.
   - Select **Kind** as **Username with password**.
   - Enter your GitHub username and personal access token.
   - Save the credentials and select them from the **Credentials** dropdown.
6. Set the **Branch Specifier** to the branch you want to use (e.g., `*/main`).

## 4. Add Jenkinsfile to Your Repository

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

## 5. Save and Build
-Save the pipeline configuration by clicking Save.
-To manually trigger a build, click Build Now on the left menu.
