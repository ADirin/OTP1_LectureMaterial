# Java-Based Three-Tier Projects for Students and Teachers

## Project Instructions

Welcome to your Java-based three-tier project! Throughout this course, you will implement a practical project using **Java** and a **relational database** (e.g. **MariaDB**). The goal is to gain hands-on experience in building real-world applications with Java, and you are **required** to use **only Java frameworks** (such as **JavaFX** for the user interface and **JDBC** for database interaction) along with a relational database management system (MariaDB).




![SP](/Images/SP.JPG)


## IMPORTANT NOTE 
 - The lectures, demos, assignments, and examples in this course are all based on Java; therefore, using non-Java frameworks in the project is *not* recommended. However, if you choose to use other non-frameworks, please note that you will not receive support from the instructor, and the responsibility for meeting the course and project requirements will rest entirely on your team.
 - The students themselves must add the product backlog user stories and select the implementation of user stories in each sprint, even though recommendations for implementation are provided in this file.

---

## 10 Java-Based Three-Tier Project Ideas

Below are **10 Java-based three-tier project ideas** that focus on everyday applications for both students and teachers. The projects are to be implemented using **JavaFX** for the presentation layer, **JDBC** for database interactions, and **MariaDB** for the database layer.

---

### 1. Student Timetable Management System
- **Description**: A system where students can manage their class schedules, view class times, and receive reminders for upcoming classes.
- **Features**:
  - Create, view, and modify timetables.
  - Alerts for upcoming classes and assignments.
  - Option to view schedules for different days and weeks.
- **Technologies**: JavaFX, MariaDB (for class and timetable data).

---

### 2. Classroom Attendance System
- **Description**: A system for teachers to take attendance and monitor student participation in class. Teachers can view reports and track attendance over time.
- **Features**: 
  - Record attendance for each class.
  - Generate attendance reports for individual students and classes.
  - Option to mark excused absences.
- **Technologies**: JavaFX, MariaDB (for student and attendance data).

---

### 3. Homework Submission and Tracking System
- **Description**: A platform for students to submit homework assignments, and for teachers to track and grade them.
- **Features**:
  - Students can upload and track homework submissions.
  - Teachers can grade assignments and provide feedback.
  - Notifications for upcoming deadlines.
- **Technologies**: JavaFX, MariaDB (for homework, student, and grade data).

---

### 4. Online Flashcard System for Study
- **Description**: A tool for students to create, review, and study flashcards. Teachers can upload sets of flashcards for different subjects.
- **Features**:
  - Students can create their own flashcards and quizzes.
  - Teachers can upload study materials for the class.
  - Progress tracking and statistics for reviewing flashcards.
- **Technologies**: JavaFX, MariaDB (for flashcards, student, and teacher data).

---

### 5. Digital Note-taking and Annotation Tool
- **Description**: A system for students to take notes during lectures and annotate them with additional information or images.
- **Features**:
  - Ability to add, edit, and categorize notes.
  - Annotate notes with images, diagrams, and highlights.
  - Search and filter notes by topics or keywords.
- **Technologies**: JavaFX, MariaDB (for notes and categories).

---

### 6. Teacher’s Gradebook and Report Card System
- **Description**: A digital gradebook for teachers to record grades, calculate averages, and generate report cards.
- **Features**:
  - Record and calculate grades for students.
  - Generate report cards based on student performance.
  - Option to calculate weighted averages for assignments, exams, and projects.
- **Technologies**: JavaFX, MariaDB (for student, grades, and report card data).

---

### 7. Personalized Study Planner
- **Description**: A tool for students to organize their study sessions, track progress on assignments, and manage deadlines.
- **Features**:
  - Students can create and track study plans and set reminders.
  - Track assignments, due dates, and exam schedules.
  - Integration with class schedules.
- **Technologies**: JavaFX, MariaDB (for study plans, assignments, and schedule data).

---

### 8. Classroom Resource Sharing Platform
- **Description**: A platform for teachers and students to share study materials, textbooks, and other educational resources.
- **Features**:
  - Upload and download resources (e.g., textbooks, study guides, presentations).
  - Categorize resources by subject or topic.
  - Rating and reviewing system for materials.
- **Technologies**: JavaFX, MariaDB (for resources, users, and ratings).

---

### 9. Campus Event Management System
- **Description**: A system where students and teachers can view upcoming campus events, RSVP, and track attendance.
- **Features**:
  - List of upcoming events, including workshops, seminars, and extracurricular activities.
  - RSVP for events and track participation.
  - Event notifications and reminders.
- **Technologies**: JavaFX, MariaDB (for event, user, and RSVP data).

---

### 10. Library Book Reservation System
- **Description**: A system where students and teachers can reserve books from the campus library, check availability, and get notifications when books are due.
- **Features**:
  - Browse and search the library catalog.
  - Reserve books and check availability.
  - Get reminders for due dates and overdue books.
- **Technologies**: JavaFX, MariaDB (for book, reservation, and user data).

### 11. Aikido training tracking 
- **Technologies** open 

### 12. Sprint review application 
- **Technologies** open 
---

## Project Breakdown for 8 Weeks

Each project should be broken down into phases over the 8 weeks (4 Sprints, each for two weeks) of the course. Below is a suggested timeline:

![Project Completion Journey](/Images/SP1.JPG)

**NOTE:** You must utilize the topics you learn during the lectures in your project, such as JUnit tests, code coverage, CI/CD, containers (Docker), etc....

### Week 1-2: (Sprint 1)
- **Design the database schema** and create necessary tables (e.g., students, teachers, books, etc.).
- **Start the JavaFX user interface** with basic forms (login, registration, etc.).
- *See the schdule for sprint review meeting*

  ![SP](/Images/SP2.JPG)

### Week 3-4: (Sprint 2)
- **Implement CRUD functionality** for core features (adding students, books, assignments, etc.).
- **Link JavaFX interface to MariaDB** for data display and manipulation.
- - *See the schdule for sprint review meeting*

![SP](/Images/SP3.JPG)

### Week 5-6: (Sprint 3)
- **Add additional features** like notifications, reports, and search functionality.
- Improve the **UI/UX design** for a more polished application.
- - *See the schdule for sprint review meeting*
    
![SP](/Images/SP4.JPG)

### Week 7: (Sprint 4)
- **Integrate final features** such as progress tracking, reminders, or additional user roles (admin, teacher, student).
- Perform **extensive testing** to ensure all features work as expected.
- - *See the schdule for sprint review meeting*

![SP](/Images/SP5.JPG)

### Week 8:
- **Prepare final project presentation** and demonstrate the working system.
- **Write project documentation** and explain the system's design and usage.
- - *See the schdule for sprint review meeting*

---

## Additional Notes:
- **Database**: You will use relational database  such as **MariaDB** for all data storage needs. Design the schema to support user accounts, events, assignments, grades, and any other relevant data.
- **JavaFX**: Use JavaFX for building the user interface. Ensure the application has a clear, user-friendly interface for students and teachers.
- **Relational Database**: Make sure to implement a relational structure (tables with primary and foreign keys) to handle relationships such as student-teacher, course-student, and so on.

[Proposed scheduel](https://amirsilta.atlassian.net/jira/software/projects/SCRUM/boards/1/timeline) and sprint implementation (**NOTE**) this is only suggestion and the team must plan more in depth based on the project nature 
 ![Sample_sprint_Implementation](/Images/Sample_sprint_Implementation.JPG)


---

These projects are practical and directly relevant to everyday life in educational settings. They will help you develop a comprehensive understanding of **Java**, **JavaFX**, and **MariaDB** as you create real-world applications that can be used by students and teachers.
