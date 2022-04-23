import java.sql.*;
import java.io.*; 
import java.time.LocalDateTime;

import net.proteanit.sql.DbUtils;

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
	// reminder: add sex later on
	public void insertStudent(String fName, String lName, String mid, String ssn, String birth, String sClass, String degree, String sex, String nNum, String cpn, String ppn, String cAddress, String stAddress, String city, String state, int z) throws SQLException {
		//open connection
		Connection conn = this.createConn();
		
		//create statement
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO STUDENT(Fname, Lname, Mid_initial, Ssn, Bdate, Sex, Class, Degree, Nnumber, C_phone, C_address, P_phone, P_st.address, P_city, P_state, P_zip_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		//prep values and insert them
		pstmt.setString(1, fName);
		
		pstmt.setString(2, lName);
		
		pstmt.setString(3, mid);
		
		pstmt.setString(4, ssn);
		
		pstmt.setString(5, birth);
		
		pstmt.setString(6, sex);
		
		pstmt.setString(7, sClass);
		
		pstmt.setString(8, degree);
		
		pstmt.setString(9, nNum);
		
		pstmt.setString(10, cpn);
		
		pstmt.setString(11, ppn);
		
		pstmt.setString(12, cAddress);
		
		pstmt.setString(13, stAddress);
		
		pstmt.setString(14, city);
		
		pstmt.setString(15, state);
		
		pstmt.setInt(16, z);
		
		//print inserted rows
		int rows = pstmt.executeUpdate();
		System.out.println("\n" + rows + " row(s) inserted");
		
		//close connection
	    closeConn(conn);	
	}
	
	public void insertDepartment(String dName, int dCode, int oNum, String officePhone, String college ) throws SQLException {
		//open connection
		Connection conn = this.createConn();
		
		//create statement
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO STUDENT(Department_name, Code, Office_num,  college, Office_phone) VALUES (?,?,?,?,?)");
		
		//prep values and insert them
		pstmt.setString(1, dName);
		
		pstmt.setInt(2, dCode);
		
		pstmt.setInt(3, oNum);
		
		pstmt.setString(4, college);
		
		pstmt.setString(5, officePhone);
		
		//debugging output
		int rows = pstmt.executeUpdate();
	    System.out.println("\n" + rows + " row(s) updated");
		System.out.println("Successfully updated entry");

		//close connection
	    closeConn(conn);	
	}
	
	public void insertCourse(String cName, String description, String cLvl, String cNum, int h, int dCode) throws SQLException {
		//open connection
		Connection conn = this.createConn();
		
		//create statement
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO STUDENT(Level, Description, Course_name, Course_num, sem_hours, Code) VALUES (?,?,?,?,?,?)");
		
		//prep values and insert them
		pstmt.setString(1, cLvl);
		
		pstmt.setString(2, description);
		
		pstmt.setString(3, cName);
		
		pstmt.setString(4, cNum);
		
		pstmt.setInt(5, h);
		
		pstmt.setInt(6, dCode);
		
		//debugging output
		int rows = pstmt.executeUpdate();
	    System.out.println("\n" + rows + " row(s) updated");
		System.out.println("Successfully updated entry");

		//close connection
	    closeConn(conn);
	}

	public void insertSection(String cNum, String sem, int year, int sn, String instructor) throws SQLException {
		//open connection
		Connection conn = this.createConn();
		
		//create statement
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO STUDENT(Course_num, Year, Semester, Instructor, Section_num) VALUES (?,?,?,?,?)");
		
		//prep values and insert them
		pstmt.setString(1, cNum);
		
		pstmt.setInt(2, year);
		
		pstmt.setString(3, sem);
		
		pstmt.setString(4, instructor);
		
		pstmt.setInt(5, sn);
		
		//debugging output
		int rows = pstmt.executeUpdate();
	    System.out.println("\n" + rows + " row(s) updated");
		System.out.println("Successfully updated entry");

		//close connection
	    closeConn(conn);
	}
	
	public ResultSet displayCourse(String findCourse ) throws SQLException {
	    //open connection
	    Connection conn = this.createConn();

	    //running query to check if student is 
	    String query = "SELECT Course_name, Course_num FROM COURSE AS C, DEPARTMENT AS D WHERE C.code = D.code AND D.code = ?";
	    PreparedStatement pstmt = conn.prepareStatement(query);
	    pstmt.setString(1, findCourse);
	    ResultSet rs = pstmt.executeQuery();

	    // try to display courses on list 
	    //courseList.setModel(DbUtils.resultSetToTableModel(rs));
	    /*while(rs.next())
	    {
	        txtFindCourse.setText(rs.getString(""));
	    }*/

	    //close connection
	    closeConn(conn);

	    return rs;
	    }

}
