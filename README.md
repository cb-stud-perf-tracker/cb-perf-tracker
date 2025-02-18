# Student Performance Tracker

This project is a **Student Performance Tracker** application designed to help instructors and administrators upload and view student performance data. It can be implemented in two phases:

1. **Phase 1**: **Servlets + JDBC**  
   - Built as a classic Eclipse Dynamic Web Project (Dynamic Web Module 3.0) targeting Tomcat v9.0.  
2. **Phase 2**: **Spring Boot + Angular**  
   - Modern approach with REST APIs, JPA (or JDBC Template), and a Single-Page Application in Angular.

---

## Table of Contents

1. [Features](#features)  
2. [Architecture Overview](#architecture-overview)  
3. [Project Structure](#project-structure)  
4. [Getting Started](#getting-started)  
   - [Phase 1: Servlets + JDBC (Eclipse)](#phase-1-servlets--jdbc-eclipse)  
   - [Phase 2: Spring Boot + Angular (Maven)](#phase-2-spring-boot--angular-maven)  
5. [Usage](#usage)  
6. [Contributing](#contributing)  
7. [License](#license)  

---

## Features

- **CSV Upload**: Instructors can upload CSV files with student performance data.  
- **Data Storage**: Student records and scores are stored in a relational database (MySQL, PostgreSQL, etc.).  
- **Historical Performance**: Multiple uploads over time let students and instructors track progress historically.  
- **Visualization** (Phase 2): Front-end charts (line, bar) to display trends and comparisons.  
- **Archiving** (Phase 2): Automatic or manual archiving of data older than 6 months (configurable).  
- **Role-Based Access** (Phase 2): Basic user roles (student, teacher, admin) with restricted views.

---

## Architecture Overview

### Phase 1 (Servlets + JDBC)

- **Database Setup**  
   - Install MySQL 8.0 (or use Docker).  
   - Create a database: `CREATE DATABASE student_performance_db;`  
   - Run our schema script: `mysql -u root -p student_performance_db < schema.sql`  
   - Update your local config or environment variables with the DB credentials:  
     ```properties
     db.url=jdbc:mysql://localhost:3306/student_performance_db
     db.user=root
     db.password=YOUR_PASSWORD
     ```
     
   - Drop mysql-connector-java-X.X.X.jar into WebContent/WEB-INF/lib.
   For more details, see [DB_SETUP](DB_SETUP.md).

- **Eclipse Dynamic Web Project** using Tomcat 9.  
   - JSP/HTML for the upload form and data listing.  
   - Direct JDBC for database operations (CRUD).  
   - Ideal for understanding the fundamentals of file handling, request/response flow, and manual DB connectivity.

### Phase 2 (Spring Boot + Angular)

- **Spring Boot** back-end for REST controllers, CSV-parsing services, and DB repositories.  
- **Angular** front-end for a dynamic single-page application (SPA).  
  - Teacher Portal for CSV upload and data views  
  - Student Portal for individual score charts  
  - Admin Portal for archiving rules, user management  
- **Relational Database** for robust data storage.  
- **Scheduled Archiving** to move or flag older data automatically.

---

## Project Structure

You might organize your code similarly to:

```plaintext
student-performance-tracker/
├── README.md
├── CONTRIBUTING.md
├── phase1-servlets-jdbc/
│   ├── webapp/ (JSPs, static assets)
│   ├── src/ (Servlets, DAOs)
│   ├── .project / .settings (Eclipse files)
│   └── ...
└── phase2-spring-boot-angular/
    ├── backend/
    │   ├── src/
    │   ├── pom.xml
    │   └── ...
    └── frontend/
        ├── src/
        ├── package.json
        └── ...
```

Feel free to adjust this to suit your team’s preferences.

---

## Getting Started

### Phase 1: Servlets + JDBC (Eclipse)

#### Prerequisites
- **Java 8+** installed.  
- **Eclipse IDE** (ideally the Eclipse IDE for Enterprise Java Developers).  
- **Tomcat 9** set up in Eclipse (Window → Preferences → Server → Runtime Environments).  
- **A Relational Database** (MySQL, PostgreSQL, etc.).  
  - Make sure you have a `cb_perf_db` (or similar) and credentials ready.  
  - Store credentials in a properties file or environment variable to avoid committing them.

#### Steps to Run
1. **Clone this Repository**  
   ```bash
   git clone https://github.com/cb-stud-perf-tracker/cb-perf-tracker.git
   cd student-performance-tracker
   ```
2. **Import the Eclipse Project**  
   - In Eclipse: File → Import → “Existing Projects into Workspace.”  
   - Browse to `phase1-servlets-jdbc`.  
   - Finish the import.
3. **Configure Tomcat Server in Eclipse**  
   - Go to Servers tab → right-click → “New → Server” → “Tomcat v9.0 Server.”  
   - Point it to your Tomcat installation directory.
4. **Set Up Database Connection**  
   - Add your JDBC driver (e.g., `mysql-connector.jar`) to the project’s `webapp/WEB-INF/lib` folder (or configure in the build path).  
   - Update any `DBConfig.java` or `db.properties` with your DB URL, user, and password.
5. **Run on Server**  
   - Right-click the project → “Run As → Run on Server.”  
   - Select Tomcat 9 and start.  
   - Eclipse will deploy the `.war` to Tomcat.  
   - Access the application via `http://localhost:8080/<YourContextPath>/`.

---

### Phase 2: Spring Boot + Angular (Maven)

#### Prerequisites
- **Java 8+** installed.  
- **Apache Maven** installed.  
- **Node.js + npm** installed for Angular.  
- **A Relational Database**. (Same as above, MySQL/PostgreSQL, etc.)  

#### Steps to Run
1. **Navigate to Phase 2 Folder**
   ```bash
   cd phase2-spring-boot-angular
   ```
2. **Back-End (Spring Boot)**
   ```bash
   cd backend
   mvn spring-boot:run
   ```
   - This starts the Spring Boot application on `http://localhost:8080` by default.
3. **Front-End (Angular)**
   ```bash
   cd ../frontend
   npm install
   npm start
   ```
   - Angular dev server by default runs on `http://localhost:4200`.
   - You can connect to the back-end API at `http://localhost:8080/api/...`.

---

## Usage

1. **Upload a CSV**  
   - Phase 1 (Servlets): JSP/HTML form at `http://localhost:8080/<YourContextPath>/uploadForm.jsp`.  
   - Phase 2 (Angular): Navigate to `/upload`, browse for CSV, submit.
2. **View Records**  
   - Phase 1: Access a simple JSP page like `/listRecords.jsp`.  
   - Phase 2: Angular route: `/records` (pulls data via `GET /api/records`).
3. **Visualizations (Phase 2)**  
   - Various Angular routes for charts, e.g., `/dashboard`, implementing line/bar charts.
4. **Archiving (Phase 2)**  
   - Admin can set an archiving threshold (e.g., 6 months).  
   - Scheduled job or manual endpoint to archive older records.

---

## Contributing

We welcome contributions from team members! Please see our [CONTRIBUTING.md](./CONTRIBUTING.md) for detailed guidelines on:

- Branch naming conventions (e.g., `feature/<task-name>`).  
- Pull Request workflow.  
- Code review process.  
- Issue tracking.

For questions, open an [Issue](https://github.com/cb-stud-perf-tracker/cb-perf-tracker/issues) or start a discussion. We appreciate feedback to improve the project!

---

## License

(Choose a license if you want this to be open source, or remove this section if you’re unsure. Common choices include MIT, Apache 2.0, or GPL.)

Example:

```
MIT License
Copyright (c) 2025 Vikas Bandaru

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software")...
```

See [LICENSE](./LICENSE) for the full text (if included).

---

### Questions or Feedback?

For questions, open an [Issue](https://github.com/cb-stud-perf-tracker/cb-perf-tracker/issues) or discuss in our team chat (Slack, Discord, etc.).  
