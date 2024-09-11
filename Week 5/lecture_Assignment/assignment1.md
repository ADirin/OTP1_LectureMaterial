# Dice Roll Application with Jenkins and GitHub Integration
This guide will walk you through creating a simple Java Maven project, pushing it to GitHub, and using Jenkins to automate unit tests and generate coverage reports.

## Step 1: Create a Maven Project in IntelliJ

1. Create a new Maven Project:
-- Navigate to File -> New -> Project.
-- Select Maven and check Create from archetype (if needed).
-- Click Next, then specify the GroupId (e.g., com.example) and ArtifactId (e.g., dice-roll-app).
-- Set the project location and click Finish.

2. Modify the pom.xml file to include dependencies for JUnit and Jacoco for test coverage:
