# Home Assignment

For this assignment, we will be extending the FarToCel application during our in-class sessions. 

1. **Extend Application:**  
   Expand the application to include conversions from Kelvin to Fahrenheit using the formula:  
   `((kel - 273.15) * (9/5) + 32)`; for example, 300.1 Kelvin is equal to 59.0 Fahrenheit.  
   Test the newly added function to ensure correctness.

2. **GitHub Repository:**  
   If you haven't already done so, create a GitHub repository for FarToCel and push the latest updates to it.

3. **Jenkins Setup:**  
   Set up a Jenkins project for the FarToCel project (either as freestyle or Maven, named FarToCelKel_pollSCM_Amir) and configure it to poll the source code repository for changes (`* * * * *`).  
   Build and verify the setup.

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
Ensure that the latest modifications to your FarToCel project are pushed to GitHub. Configure Jenkins to automatically start building after a new commit is uploaded to the repository.

6. **Docker Hub Account:**  
Create an account on hub.docker.com if you haven't already.

7. **Update Jenkins with Docker Plugins:**  
Update Jenkins with Docker plugins following the instructions provided in the class and accompanying video clip in the Oma.

Provide the link to your GitHub repository, screenshots of your Docker Hub repository, and Jenkins build reports as part of your submission.

8. **Update Jenkins with Docker Plugins:**  
Update Jenkins with Docker plugins following the instructions provided in the class and accompanying video clip in the Oma.

Provide the link to your GitHub repository, screenshots of your Docker Hub repository, and Jenkins build reports as part of your submission.
