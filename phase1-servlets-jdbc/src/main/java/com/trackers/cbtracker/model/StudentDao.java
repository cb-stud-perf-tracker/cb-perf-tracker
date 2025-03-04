// TODO: Handle the package error
package com.trackers.cbtracker.model;

import java.sql.DriverManager;
import java.sql.*;

// TODO: Import classes or interfaces required

public class StudentDao {

    // Hard-coded credentials (not secure, not flexible)
	// TODO: update valid values accordingly
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cb_perf_db";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "Vishu@143";

    public StudentDao() {
        // No parameters needed; the strings are above
    }

 	// Method to insert Student details in the db table
    // TODO: create required entity class in current package
    //		 make sure the constructor parameters order matches
    //		 the order of columns that this entity class represents
 	public  String insertStudent(Student s) {
 		String result = "";
 		 
 		try {
 			
 			String query = "insert into Student values(?,?,?)";
 			Class.forName("com.mysql.cj.jdbc.Driver");
 			Connection con=DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
 			PreparedStatement st=con.prepareStatement(query); 
 			st.setInt(1, s.getId());
 			st.setString(2, s.getEmail());
 			st.setString(3, s.getName());
 			int rs=st.executeUpdate();
 			
 			
 			if(rs!=0) {
 				System.out.println("Record inserted successfully");
 			}else {
 				System.out.println("Record insertion failed");
 			}
 			
 		} catch(ClassNotFoundException e) {
 			System.out.println("Driver not found error.");
 		} catch(SQLException e) {
 			System.out.println("DB Error: Check for any typo in SQL syntax.");
 		}
 		return result;
 	}

 	// Method to get a Student based on given email
    public  Student getStudentByEmail(String email) {
 		Student student = null;
 		
 		// TODO: handle exceptions gracefully
 		try {
 			
 			
 			
 		
 			// TODO: Choose a good query for the operation
 			String query = "Select *from Student where email = ?";
 			// TODO: Prepare PreparedStatement instance and 
 			// 		 fill the parameters
 			Class.forName("com.mysql.cj.jdbc.Driver");
 			Connection con=DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
 			PreparedStatement st=con.prepareStatement(query);
 			st.setString(1, email);
 			
 			// TODO: Execute query on PreparedStatment instance
 			//		 and save ResultSet instance
 			ResultSet rs=st.executeQuery();
 			// TODO: Create Student instance from the ResultSet data
 			//		 if ResultSet has a record
 			if(rs.next()) {
 				student = new Student(rs.getInt("id"),rs.getString("email"),rs.getString("name"));
 				
 				}
 		}catch(ClassNotFoundException e) {
 			System.out.println("Driver not found error.");
 		} catch(SQLException e) {
 			System.out.println("DB Error: Check for any typo in SQL syntax.");
 		}
 		return student;
 	}

 	// Method to get all Students
 	/*public List<Student> getAllStudents() {
 		// TODO: Create an instance for storing list of Student instances
 		List<Student> students = ____ ;
 		Student student = null;
 		
 		// TODO: handle exceptions gracefully
 		
 			// TODO: Choose a good query for the operation
 			String query = "...";
 			// TODO: Prepare PreparedStatement instance and 
 			// 		 fill the parameters
 			
 			// TODO: Execute query on PreparedStatment instance
 			//		 and save ResultSet instance
 			
 			// TODO: Create a Student instance for each record
 			//		 and add it to the list of students
 			
 		return students;
 	}
 	
 	// update student by id
 	public String updateStudent(int id, Student s) {
 		String result = "";

 		// TODO: handle exceptions gracefully
 		
 			// TODO: Choose a good query for the operation
 			String query = "...";
 			
 			// TODO: Almost same code as insert method
 			//		 take care of query
 			
 		
 		return result;
 	}
 	
 	// delete student by id
 	public String deleteStudentById(int id) {
 		String result = "";

 		// TODO: handle exceptions gracefully
 		
 			// TODO: Choose a good query for the operation
 			String query = "...";
 			
 			// TODO: Almost same code as update method
 			//		 take care of query
 			
 		
 		return result; 
 	}*/
}