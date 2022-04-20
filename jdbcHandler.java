import java.sql.*;
import java.io.*; 
import java.time.LocalDateTime;

public class jdbcHandler {
	String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
	String username, password;
	
	public jdbcHandler(String user, String pass) {
		this.username = user;
		this.password = pass; 
	}
	
	public Connection createConn() throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
		return conn;
	}
	
	public void closeConn(Connection conn) throws SQLException {
		conn.close();
	}
	
	public void insertGradesFor(String nNum, String courseNum, int section) throws SQLException {
		//open connection
		Connection conn = this.createConn();
		
		//create statement
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO GRADES_FOR(Course_num, Year, Semester, Nnumber, Section_num) VALUES (?, ?, ?, ?, ?)");
		
		//prep values and insert them
		pstmt.setString(1, courseNum);
		
		//year insert:
		LocalDateTime now = LocalDateTime.now();  
		int currYear = now.getYear();
		pstmt.setInt(2, currYear);
		
		//query and insert semester double check this with teacher. How do we acquire semester?
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery("SELECT Semester FROM SECTION WHERE Course_num = '" + courseNum + "' AND Year = " + currYear + " AND Section_num = " + section);
		String sem = rset.getString("Semester");
		pstmt.setString(3, sem);
		
		//set nNumber and section
		pstmt.setString(4, nNum);
		pstmt.setInt(5, section);
		
		//print inserted rows
		int rows = pstmt.executeUpdate();
	    System.out.println("\n" + rows + " row(s) inserted");
	    
	    //close connection
	    closeConn(conn);
	}
	
	public void updateGrades(String nNum, String courseNum, int section, String letGrade) throws SQLException {
		//open connection
		Connection conn = this.createConn();
		
		//create statement
		PreparedStatement pstmtUpdate = conn.prepareStatement("UPDATE GRADES_FOR SET Grade_letter = '" + letGrade + "', Grade_num = ? WHERE Nnumber = '" + nNum + "' AND Course_num = '" + courseNum + "' AND Section_num = " + section + " AND Semester = '?'");
		
		//grade num calcs:
		double gradeNum;
		switch (letGrade) {
		case "A":
			gradeNum = 4.0;
			break;
		case "A-":
			gradeNum = 3.7;
			break;
		case "B+":
			gradeNum = 3.3;
			break;
		case "B":
			gradeNum = 3.0;
			break;
		case "B-":
			gradeNum = 2.7;
			break;
		case "C+":
			gradeNum = 2.3;
			break;
		case "C":
			gradeNum = 2.0;
			break;
		case "D":
			gradeNum = 1.0;
			break;
		case "F":
			gradeNum = 0;
			break;
		default:
			gradeNum = -1;
			break;
		}
		pstmtUpdate.setDouble(1, gradeNum);
		
		//semester - not sure what to do here so copied from enrollStudent method - ask teacher.
		LocalDateTime now = LocalDateTime.now();  
		int currYear = now.getYear();
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery("SELECT Semester FROM SECTION WHERE Course_num = '" + courseNum + "' AND Year = " + currYear + " AND Section_num = " + section);
		String sem = rset.getString("Semester");
		pstmtUpdate.setString(2, sem);
		
		//debugging output
		int rows = pstmtUpdate.executeUpdate();
	    System.out.println("\n" + rows + " row(s) updated");
		System.out.println("Successfully updated entry");
		
	    //close connection
	    closeConn(conn);
	}
}
