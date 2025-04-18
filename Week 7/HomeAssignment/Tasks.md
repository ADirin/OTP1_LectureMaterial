
# NOTE: Optional Assignmengt for all 

# Lecture Assignment: Weekly Sports Time Tracker Application

## Objective
This assignment aims to help students develop a Java application that tracks the time spent on sports activities during the week. Students will also practice version control with GitHub, continuous integration and deployment using Jenkins, containerization with Docker, and running the application in a Virtual Machine / Linux environment or  [lab-play_webapp](https://labs.play-with-docker.com/).

**How to do:**
1. Develop the Java Application

- Create a single-class Java application that allows users to log sports activities, view logged activities, and calculate total time spent on sports for the week.

2. Version Control with GitHub

- Initialize a Git repository in your project directory.
- Commit your code frequently with meaningful messages.
- Push the repository to your GitHub account.
- Make sure to include a README file explaining the project and how to use the application.

3. Continuous Integration and Deployment with Jenkins

- Set up a Jenkins server (you can use a local instance or a cloud-based instance).
- Create a Jenkins pipeline that:
    - Pulls the latest code from your GitHub repository.
    - Builds the Java application using Maven (if needed).
    - Runs tests  using JUnit and coverage report.
    - Creates a Docker image of the application.

4. Containerization with Docker
- Create a Dockerfile in your project directory. 
    - Build your Docker image with a command like:
    - Push the image to Docker Hub

5. Running the Application in a Linux in Virtual Machine or [lab-play_webapp](https://labs.play-with-docker.com/)

   
- Pull your Docker image from Docker Hub
```cmd
  docker pull your-dockerhub-username/sports-time-tracker:latest
```
- Run the Docker container:
```cmd
docker run -it --rm your-dockerhub-username/sports-time-tracker:latest
```

## Deliverables
- Submit the link to your GitHub repository with all the code and documentation.
- Provide screenshots of the Jenkins pipeline, Docker image creation, and running the application in the virtual machine.

## Evaluation Criteria
1. Functionality: Does the application work as intended?
2. Code Quality: Is the code well-organized, readable, and properly commented?
3. GitHub Practices: Are commits meaningful? Is the repository well-structured?
4. Jenkins Pipeline: Is the pipeline correctly set up and functional?
5. Docker Implementation: Is the Docker image created and running successfully in the VM?

