CREATE TABLE Student (
       id INT AUTO_INCREMENT PRIMARY KEY,
       email VARCHAR(100) NOT NULL UNIQUE,
       name VARCHAR(100)
     );

     CREATE TABLE PerformanceRecord (
       id INT AUTO_INCREMENT PRIMARY KEY,
       student_id INT NOT NULL,
       date_of_record DATE,
       batch_id VARCHAR(16),
       upload_id VARCHAR(16),
       FOREIGN KEY (student_id) REFERENCES Student(id)
     );
     
     CREATE TABLE PerformanceScore (
		id INT AUTO_INCREMENT PRIMARY KEY,
        performance_record_id INT,
        topic_name VARCHAR(10),
        score_value INT,
        FOREIGN KEY (performance_record_id) REFERENCES PerformanceRecord(id)
     );