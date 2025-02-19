// TODO: Handle the package error
package com.trackers.cbtracker;

// TODO: Import classes or interfaces required

public class StudentDao {

    // Hard-coded credentials (not secure, not flexible)
	// TODO: update valid values accordingly
    private static final String JDBC_URL = "...";
    private static final String JDBC_USER = "...";
    private static final String JDBC_PASS = "...";

    public StudentDao() {
        // No parameters needed; the strings are above
    }

 	// Method to insert Student details in the db table
    // TODO: create required entity class in current package
    //		 make sure the constructor parameters order matches
    //		 the order of columns that this entity class represents
 	public String insertStudent(Student s) {
 		String result = "";
 		
 		try {
 			// TODO: Choose a good query for the operation
 			String query = "...";
 			// TODO: Prepare PreparedStatement instance 
 			
 			// TODO: Populate PrepareStatement instance
 			//		 with data from received Student instance
 			
 			// TODO: Execute query on PreparedStatment instance
 			//		 and save the result
 			
 			// TODO: If the student record found,
 			//		 save a success message to the result
 			//		 save a failure message to the result, otherwise
 			
 		} catch(____) {
 			System.out.println("Driver not found error.");
 		} catch(____) {
 			System.out.println("DB Error: Check for any typo in SQL syntax.");
 		}
 		return result;
 	}

 	// Method to get a Student based on given email
    public Student getStudentByEmail(String email) {
 		Student student = null;
 		
 		// TODO: handle exceptions gracefully
 		
 			// TODO: Choose a good query for the operation
 			String query = "...";
 			// TODO: Prepare PreparedStatement instance and 
 			// 		 fill the parameters
 			
 			// TODO: Execute query on PreparedStatment instance
 			//		 and save ResultSet instance
 			
 			// TODO: Create Student instance from the ResultSet data
 			//		 if ResultSet has a record
 		
 		return student;
 	}

 	// Method to get all Students
 	public List<Student> getAllStudents() {
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
 	}
}