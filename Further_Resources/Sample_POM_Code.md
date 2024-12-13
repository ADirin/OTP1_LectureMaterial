
# Configuring pom.xml
Below is an example pom.xml configuration with commonly used plugins like maven-compiler-plugin, maven-surefire-plugin, jacoco-maven-plugin, maven-javadoc-plugin, and maven-checkstyle-plugin.
- The following depencencies and plugings are included in this version of POM
  - Maven-compile -plugins
  - surefire: to execute unit tests during the test phase of maven build cycle which only include *test.java
  - Checksyle: to check the stlye of the code, Enforces code style rules, using the Google Java Style Guide as the rule set.
  - Java Object Modeling (JACOCO) which generates a code coverge report during verfy phase
  - Maven Havadoc Plugin: Generates the Javadocs in the directory target/apidocs
  - Junit dependency: JUnit is a popular framework used for writing and running unit tests in Java
  
            
Example pom.xml:
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/POM/4.0.0/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.example</groupId>
  <artifactId>my-maven-project</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>jar</packaging>

  <properties>
    <maven.compiler.source>17</maven.compiler.source> <!-- Java version for source code -->
    <maven.compiler.target>17</maven.compiler.target> <!-- Java version for compiled bytecode -->
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>

  <build>
    <plugins>
      <!-- Compiler Plugin -->
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        <configuration>
          <source>17</source>
          <target>17</target>
        </configuration>
      </plugin>

      <!-- Surefire Plugin for Unit Testing -->
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.0.0-M5</version>
        <configuration>
          <includes>
            <include>**/*Test.java</include>
          </includes>
        </configuration>
      </plugin>

      <!-- Jacoco Plugin for Code Coverage -->
      <plugin>
        <groupId>org.jacoco</groupId>
        <artifactId>jacoco-maven-plugin</artifactId>
        <version>0.8.8</version>
        <executions>
          <execution>
            <id>prepare-agent</id>
            <goals>
              <goal>prepare-agent</goal>
            </goals>
          </execution>
          <execution>
            <id>report</id>
            <phase>verify</phase>
            <goals>
              <goal>report</goal>
            </goals>
          </execution>
        </executions>
      </plugin>

      <!-- Javadoc Plugin -->
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-javadoc-plugin</artifactId>
        <version>3.3.1</version>
        <configuration>
          <source>${maven.compiler.source}</source>
          <encoding>${project.build.sourceEncoding}</encoding>
          <reportOutputDirectory>${project.build.directory}/apidocs</reportOutputDirectory>
        </configuration>
      </plugin>

      <!-- Checkstyle Plugin -->
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-checkstyle-plugin</artifactId>
        <version>3.2.0</version>
        <configuration>
          <configLocation>google_checks.xml</configLocation>
          <failsOnError>true</failsOnError>
        </configuration>
        <executions>
          <execution>
            <phase>verify</phase>
            <goals>
              <goal>checkstyle</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>

  <dependencies>
    <!-- Add your dependencies here -->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.13.2</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>

```


## Explanation of Plugins:
- maven-compiler-plugin: Configures the Java compiler settings (source and target versions).
- maven-surefire-plugin: Runs unit tests during the build process.
- jacoco-maven-plugin: Measures code coverage of your tests.
- maven-javadoc-plugin: Generates Javadoc for your project.
- maven-checkstyle-plugin: Enforces coding standards using Checkstyle.

### Update the lecture_assignment_2 based on the above POM.XML and see what kind of additional or differences this version of POM:XML present

### Run maven commands 
### Update the Site in your public html folder based on latest POM update
