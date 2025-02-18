## 1. Database Server Installation

1. **Choose a Relational DB**
   - I am using MySQL 8.0

3. **Create a Database**  
   - For example, “Run `CREATE DATABASE cb_perf_db;`” in MySQL.  

---

## 2. Database Schema / Tables

1. **Initial SQL Script**  
   - Find an SQL file (`schema.sql`) in the repo with SQL commands that creates the tables for "Student", "PerformanceRecord", and "PerformanceScore" etc.  
   - This ensures every team member has the same baseline schema.

2. **Run the Script**  
   - Instructions: Open your DB client (or Command Line Client), navigate to your repo directory, and run:  
     `mysql -u root -p cb_perf_db < schema.sql`”  
   - Or if you’re using an IDE or tool like MySQL Workbench, open the `schema.sql` file and run.

---

## 3. JDBC Connection Settings

1. **DB URL, User, Password**  
   - Database details:  
   - ```properties
     db url = jdbc:mysql://localhost:3306/cb_perf_db
     db user = root
     db password = your_password
     ```
   - **Note:** DO NO commit passwords to the repo. Keep them in a local config or environment variable.

2. **JDBC Driver**  
   - If you’re using MySQL, "Download `mysql-connector-java-X.X.X.jar` and place it in `WebContent/WEB-INF/lib` (or your Eclipse project’s classpath)."  
   - Alternatively, you can configure the library inside Eclipse’s build path.

---

## 4. Testing the Connection

1. **Simple Test**  
   - Provide a small snippet of code or a quick test in Eclipse to confirm the DB connection is working before you start building servlets. Handle any exceptions. For example:
     ```java
     Connection conn = DriverManager.getConnection(
       "jdbc:mysql://localhost:3306/cb_perf_db",
       "root",
       "your_password"
     );
     System.out.println("Connection successful!");
     ```
2. **Troubleshooting**  
   - Common errors ("Communications link failure" might mean the DB is not running or the port is incorrect).  
   - Check firewall rules, or ensure you have correct privileges on the DB.

---

### Example of a “DB Setup” Instruction Document

> **Project DB Setup (Phase 1)**
>
> 1. Install MySQL 8.0 (or use Docker).
> 2. Create a database:
>   ```sql
>   CREATE DATABASE cb_perf_db;
>   ```
> 3. Import our schema:
>   ```bash
>   mysql -u root -p cb_perf_db < schema.sql
>   ```
> 4. Configure your Eclipse project to point to:
>   ```
>   db.url=jdbc:mysql://localhost:3306/cb_perf_db
>   db.user=root
>   db.password=your_password
>   ```
> 5. Copy `mysql-connector-java-X.X.X.jar` into `WebContent/WEB-INF/lib`.
> 6. Test connection via a simple JDBC snippet or your DAO class.
