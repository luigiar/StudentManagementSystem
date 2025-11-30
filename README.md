# 🎓 Student Management System

A robust Java desktop application designed to manage university courses, student enrollments, and attendance tracking.
This project was engineered following **Software Engineering principles**, specifically adopting the **DAO (Data Access Object) pattern** to decouple the business logic from the persistence layer.

##  Software Architecture
This project is not just a collection of scripts, but a fully designed system:
* **Architectural Pattern:** MVC-inspired structure with a dedicated **Controller** mediating between the GUI and the Data Layer.
* **Persistence Layer:** Implemented via **DAO Pattern** (`AdminDAO`, `CorsoDAO`, `StudenteDAO`) to handle CRUD operations abstractly.
* **Design Tools:** Developed using CRC Cards for responsibility assignment and UML Class/Sequence Diagrams for behavior modeling.

##  Database Engineering (PostgreSQL)
The database is not just a storage container but ensures data integrity through **Advanced PL/pgSQL**:
* **Automated Logic:** Implemented **15+ Triggers** to handle complex events (e.g., `after_lezione_insert` automatically populates attendance records).
* **Data Integrity:** Custom **Stored Procedures** enforce constraints (e.g., ensuring course capacity is never exceeded via `before_iscrizione_studente`).
* **Security:** Login credentials verification logic encapsulated directly within the DB layer via `check_login` function.

##  Key Features
* **Course Management:** Create courses with specific thematic areas, max participants, and mandatory attendance thresholds.
* **Student Enrollment:** Register students and manage their eligibility based on attendance.
* **Statistics & Reporting:** View real-time stats (min/max/average students) and filter data via `TableRowFilter`.
* **Attendance Tracking:** Monitor student presence for each lesson to determine course completion eligibility.

## 🛠️ Tech Stack
* **Language:** Java
* **GUI:** Java Swing (JFrame, JPanel, custom `TableModel`)
* **Database:** PostgreSQL / Relational DB
* **Documentation:** Full UML analysis (Class & Sequence Diagrams) available in the `docs/` folder.

## 📂 Documentation
For a deep dive into the engineering process behind this software, check the `docs/` folder:
* [📄 Architecture & Design (PDF)](docs/Documentazione_ObjectOrientation_OOBD2122_18.pdf) - Includes Class Diagrams, Sequence Diagrams, and CRC Cards.
* [🗄️ Database Schema (PDF)](docs/Documentazione_BasiDiDati_OOBD2122_18.pdf) - Entity-Relationship diagram, Triggers and Stored Procedures analysis.

##  How to Run
1.  Clone the repository.
2.  Import the database schema (SQL script provided).
3.  Configure the `Connessione` class with your DB credentials.
4.  Run `MainFrame` class.

---
*Developed by Luigi Ariola - Computer Science Student @ UniNA*
