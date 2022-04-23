import java.sql.*; 

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
	
	public void insertGradesFor(String nNum, String courseNum, int section, int currYear, String sem) throws SQLException {
		//open connection
		Connection conn = this.createConn();
		
		//create statement
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO GRADES_FOR(Course_num, Year, Semester, Nnumber, Section_num) VALUES (?, ?, ?, ?, ?)");
		
		//prep values and insert them
		pstmt.setString(1, courseNum);
		pstmt.setInt(2, currYear);
		pstmt.setString(3, sem);
		pstmt.setString(4, nNum);
		pstmt.setInt(5, section);
		
		//print inserted rows
		int rows = pstmt.executeUpdate();
	    System.out.println("\n" + rows + " row(s) inserted");
	    
	    //close connection
	    closeConn(conn);
	}
	
	public void updateGrades(String nNum, String courseNum, int section, String letGrade, int currYear, String sem) throws SQLException {
		//open connection
		Connection conn = this.createConn();
		
		//create statement
		PreparedStatement pstmtUpdate = conn.prepareStatement("UPDATE GRADES_FOR SET Grade_letter = '" + letGrade + "', Grade_num = ? WHERE Nnumber = '" + nNum + "' AND Course_num = '" + courseNum + "' AND Section_num = " + section + " AND year = " + currYear + " AND Semester = '" + sem + "'");
		
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
		case "F", "FA":
			gradeNum = 0;
			break;
		default:
			gradeNum = -1;
			break;
		}
		
		if (gradeNum == -1) {
			pstmtUpdate.setNull(1, Types.NULL);
		} else {
			pstmtUpdate.setDouble(1, gradeNum);
		}
		
		//debugging output
		int rows = pstmtUpdate.executeUpdate();
	    System.out.println("\n" + rows + " row(s) updated");
		System.out.println("Successfully updated entry");
		
	    //close connection
	    closeConn(conn);
	}
	
	public String genGradeReport(String nNum) throws SQLException {
		
		String studentInfo = "";
		String courseGrades = " Course Number | Section | Semester | Year | Grade " + System.lineSeparator();
		String avgGPA = "GPA: ";
		
		//open connection
		Connection conn = this.createConn();
		
		//create statements
		//PreparedStatement pstmt = conn.prepareStatement("SELECT Fname, Mid_initial, Lname, Class, Degree FROM STUDENT WHERE Nnumber = ?");
		//pstmt.setString(1, nNum);
//		ResultSet rset = pstmt.executeQuery();
		String q = "SELECT Fname, Mid_initial, Lname, Class, Degree FROM STUDENT WHERE Nnumber = '" + nNum + "'";
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(q);
		
		rset.next();
		String mInit = "";
		if (rset != null) {
			if (rset.getString(2) != null) {
				mInit = rset.getString(2);
			}
			studentInfo += "Name: " + rset.getString(1) + " " + mInit + rset.getString(3) + System.lineSeparator();
			studentInfo += "Class: " + rset.getString(4) + "\tDegree: " + rset.getString(5) + System.lineSeparator(); 
		}
		rset.close();
		closeConn(conn);
		
//		PreparedStatement pstmt2 = conn.prepareStatement("SELECT Course_num, Section_num, Semester, Year, Grade_letter, Grade_num FROM GRADES_FOR WHERE Nnumber = ?");
//		pstmt2.setString(1, nNum);
//		ResultSet rset2 = pstmt2.executeQuery();
		conn = this.createConn();
		String q2 = "SELECT Course_num, Section_num, Semester, Year, Grade_letter, Grade_num FROM GRADES_FOR WHERE Nnumber = '" + nNum + "'";
		Statement stmt2 = conn.createStatement();
		ResultSet rset2 = stmt2.executeQuery(q2);
		
		while(rset2.next()) {
			System.out.println("in while");
			String courseNum = centerString(15, rset2.getString(1));
			String secNum = centerString(9, rset2.getString(2));
			String sem = centerString(10, rset2.getString(3));
			String strYear = centerString(6, rset2.getString(4));
			String grade = centerString(7, rset2.getString(5));
			if (rset2.wasNull()) {
				grade = centerString(7, "IP");
			}
			courseGrades += courseNum + "|" + secNum + "|" + sem + "|" + strYear + "|" + grade + System.lineSeparator();
		}
		
		rset2.close();
		closeConn(conn);
		
//		PreparedStatement pstmt3 = conn.prepareStatement("SELECT AVG(Grade_num) FROM GRADES_FOR WHERE Nnumber = ?");
//		pstmt3.setString(1, nNum);
//		ResultSet rset3 = pstmt3.executeQuery();
		conn = this.createConn();
		
		String q3 = "SELECT AVG(Grade_num) FROM GRADES_FOR WHERE Nnumber = '" + nNum + "'";
		Statement stmt3 = conn.createStatement();
		ResultSet rset3 = stmt3.executeQuery(q3);
		
		rset3.next();
		avgGPA += rset3.getDouble(1);
		
		rset.close();
		
		//insert values
		//pstmt.setString(1, nNum);
		//pstmt2.setString(1, nNum);
		//pstmt3.setString(1, nNum);
		
		//execute queries
		//ResultSet rset = pstmt.executeQuery();
		//ResultSet rset2 = pstmt2.executeQuery();
		//ResultSet rset3 = pstmt3.executeQuery();
		
		//format and store results
//		String studentInfo = "";
//		String courseGrades = " Course Number | Section | Semester | Year | Grade " + System.lineSeparator();
//		String avgGPA = "GPA: ";
		
//		rset.next();
//		String mInit = "";
//		if (rset != null) {
//			if (rset.getString(2) != null) {
//				mInit = rset.getString(2);
//			}
//			studentInfo += "Name: " + rset.getString(1) + " " + mInit + rset.getString(3) + System.lineSeparator();
//			studentInfo += "Class: " + rset.getString(4) + "\tDegree: " + rset.getString(5) + System.lineSeparator(); 
//		}
		
//		while(rset2.next()) {
//			System.out.println("in while");
//			String courseNum = centerString(15, rset2.getString(1));
//			String secNum = centerString(9, rset2.getString(2));
//			String sem = centerString(10, rset2.getString(3));
//			String strYear = centerString(6, rset2.getString(4));
//			String grade = centerString(7, rset2.getString(5));
//			if (rset2.wasNull()) {
//				grade = centerString(7, "IP");
//			}
//			courseGrades += courseNum + "|" + secNum + "|" + sem + "|" + strYear + "|" + grade + System.lineSeparator();
//		}
		
//		rset3.next();
//		avgGPA += rset3.getString(1);
		
		return studentInfo + courseGrades + avgGPA;
	}
	
	public static String centerString (int width, String s) {
	    return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
	}
	
	// reminder: add sex later on
	public void insertStudent(String fName, String lName, String mid, String ssn, String birth, String sex, String sClass, String degree, String nNum, String cpn, String ppn, String cAddress, String stAddress, String city, String state, int z) throws SQLException {
		//open connection
		Connection conn = this.createConn();
		
		//create statement
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO STUDENT(Fname, Lname, Mid_initial, Ssn, Bdate, Sex, Class, Degree, Nnumber, C_phone, C_address, P_phone, P_st_address, P_city, P_state, P_zip_code) VALUES (?, ?, ?, ?, TO_DATE(?, 'MM-DD-YYYY'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		//debug
		System.out.println("Fname: " + fName);
		System.out.println("Lname: " + lName);
		System.out.println("mid: " + mid);
		System.out.println("ssn: " + ssn);
		System.out.println("birth: " + birth);
		System.out.println("sex: " + sex);
		System.out.println("class: " + sClass);
		System.out.println("degree: " + degree);
		System.out.println("nNum: " + nNum);
		System.out.println("cpn: " + cpn);
		System.out.println("ppn: " + ppn);
		System.out.println("cAdd: " + cAddress);
		System.out.println("stadd: " + stAddress);
		System.out.println("city: " + city);
		System.out.println("state: " + state);
		System.out.println("z: " + z);
		
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
		pstmt.setString(11, cAddress);
		pstmt.setString(12, ppn);
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
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO DEPARTMENT(Department_name, Code, Office_num,  college, Office_phone) VALUES ('?','?','?','?','?')");
		
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
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO COURSE(Grade_level, Description, Course_name, Course_num, sem_hours, Code) VALUES ('?','?','?','?','?','?')");
		
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
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO SECTION(Course_num, Year, Semester, Instructor, Section_num) VALUES ('?','?','?','?','?')");
		
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

	    //running query
	    String query = "SELECT Course_name, Course_num FROM COURSE C, DEPARTMENT D WHERE C.code = D.code AND D.code = ?";
	    PreparedStatement pstmt = conn.prepareStatement(query);
	    pstmt.setString(1, findCourse);
	    ResultSet rs = pstmt.executeQuery();

	    //close connection
	    closeConn(conn);

	    return rs;
	    }

	}
