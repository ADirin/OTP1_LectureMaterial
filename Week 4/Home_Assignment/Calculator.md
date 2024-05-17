Unit 5- Testing
Objective:
The objective of this assignment is to familiarize yourself with Eclipse's JUnit 5 testing environment and determine test coverage.

Steps:
Create Maven Project:

Create a Maven project and add the necessary specifications for testing to the pom.xml file.
Import Code:

Unzip the file laskinEnglish.zip.
Drag and drop the extracted codes (src, test) into your project.
If special characters are not displayed correctly, change the character encoding at the Eclipse Workspace level:
Select Window | Preferences | General | Workspace.
Set Text file encoding to UTF-8.
PART 1 OF THE TASK: Coverage
Run Application and Tests:

Launch Main.java and verify from the output that there are errors in the implementation.
Run the JUnit tests:
Right-click on the project name in the Project Explorer.
Select Run As | JUnit Test.
Some tests will pass while others will not.
Determine Test Coverage:

Run a coverage analysis:
Right-click on the project name in the Package Explorer.
From the Coverage As menu, choose either "1 Java Application" or "2 JUnit Test".
The coverage summary appears on the Coverage tab at the bottom of the screen.
PART 2 OF THE TASK: JUnit 5
Fix Errors and Enhance Testing:

Correct the intentional errors in the tests.
Complete missing parts and methods (including product() and squareroot()).
Ensure comprehensive testing and create additional test methods if necessary.
Parameterized Test:

Refactor the ExtraTest class to use parameterized arrays for testing.
Handle Floating-Point Numbers:

Modify the calculator to handle double-precision floating-point numbers.
Provide a delta value when comparing floating-point numbers in assert routines.
Regression Testing:

After making changes, conduct regression testing by running the test suite to ensure all tests pass.
Run Tests with Maven:

Run tests with Maven:
Right-click on the project name and select Run As | Maven test.
View test results in the target/surefire-reports directory.
Resources:
EclEmma plugin
Code coverage
Java Code Coverage Tools
Submission:
Save the coverage report as an HTML page.
Attach a screenshot of the test results from Maven.
