# Home Assignment: TempConvert Extension, GitHub, and Jenkins Integration

This assignment extends your temperature conversion application, tests it, integrates it with GitHub, and automates CI/CD through Jenkins.

## IntelliJ: Extend TempConvert

- [ ] **Task 1: Extend the TempConvert Assignment**  
  Extend the `TempConvert` assignment by adding an additional function called `kelvinToCel()`.

```java
public static float kelvinToCel(float kel){
    return (float) (kel - 273.15);
}
```

- [ ] **Task 2: Unit Test for kelvinToCel()**
  - Test the newly created kelvinToCel() function.
  - Ensure that assertEquals returns true for both expected and actual values.
```java
@Test
public void testKelvinToCel() {
    assertEquals(0.0, TempConvert.kelvinToCel(273.15), 0.001);
}

```
- [ ] **Task 3: Run Maven Commands**
Run the following Maven commands to ensure the project builds correctly:

  1. mvn clean
  2. mvn compile
  3. mvn verify

After running, check if the site folder is created in the target directory.

## GitHub: Repository Management

- [ ] **Task 4: Create GitHub Repository**
Create a new GitHub repository named TempConverter.
- [ ] **Task 5: Add the Project to GitHub**
Use Git inside IntelliJ to:

  1. Add the TempConverter project to the GitHub repository.
  2. Commit and push the changes to the repository.

# Jenkins, GitHub, and IntelliJ Integration

## Jenkins Setup
Based on the instructions provided in the [Jenkins Basic Guide](https://users.metropolia.fi/~amirdi/SEP1/Jenkins/JenkinsBasic.pdf), perform the following tasks.

### Task 6: Run Maven Project in Jenkins

- Create a **Jenkins** project for your Maven build.
- The project should be named `TempConverter_Maven_yourname` (replace `yourname` with your actual name).
- Run your Maven project in Jenkins without a pipeline.

### Task 7: Create Jenkinsfile

- Add a `Jenkinsfile` to your **GitHub** repository at the root.
- Include the pipeline workflow in the `Jenkinsfile`.

---

## Jenkins Pipeline Creation

### Task 8: Create a New Jenkins Pipeline Item

- Create a new **Pipeline** item in **Jenkins**.
- Copy the workflow from your `Jenkinsfile` (in your GitHub repository) and paste it into the Jenkins pipeline section.

---

## Report Submission

### Task 9: Create a Report

- Run code coverage reports using:
  - **Maven**
  - **GitHub pipeline**
  - **Jenkins pipeline**
  
- Take screenshots of all three coverage reports.

### Task 10: Submit the Report

- Compile all screenshots into a Word document.
- Save the document as a **PDF**.
- Submit the **PDF** report to **Oma**.

---

> **Note:** Ensure that all **Jenkins** items follow the naming convention `xxxx-yourname`. For example, `TempConverter_Maven_amir`.

     

- [ ] 
