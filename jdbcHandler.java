import java.sql.*; 

public class jdbcHandler {
	String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
	String username, password;
	private Connection conn;
	
	public jdbcHandler(String user, String pass) {
		this.username = user;
		this.password = pass; 
	}
	
	public Connection createConn() throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
		this.conn = conn;
		return conn;
	}
	
	public void closeConn() throws SQLException {
		this.conn.close();
	}
	
	public int insertGradesFor(String nNum, String courseNum, int section, int currYear, String sem) throws SQLException {
		//open connection
		Connection conn = this.createConn();
		
		//create nNum statement
		
		//create statement
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO GRADES_FOR(Course_num, Year, Semester, Nnumber, Section_num) VALUES (?, ?, ?, ?, ?)");
		
		//prep values and insert them
		pstmt.setString(1, courseNum);
		pstmt.setInt(2, currYear);
		pstmt.setString(3, sem);
		pstmt.setString(4, nNum);
		pstmt.setInt(5, section);
		
		//executing update
		int rows = pstmt.executeUpdate();
	    
	    //close connection
	    this.closeConn();
	    
	    return rows;
	}
	
	public int updateGrades(String nNum, String courseNum, int section, String letGrade, int currYear, String sem) throws SQLException {
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
		
		//executing update
		int rows = pstmtUpdate.executeUpdate();
		
	    //close connection
		this.closeConn();
		
		return rows;
	}
	
	public String genGradeReport(String nNum) throws SQLException {
		String courseGrades = "Course Number | Section | Semester  |  Year  | Grade " + System.lineSeparator();
		
		//open connection
		Connection conn = this.createConn();
		
		//create statement
		PreparedStatement pstmt = conn.prepareStatement("SELECT Course_num, Section_num, Semester, Year, Grade_letter FROM GRADES_FOR WHERE Nnumber = ?");
		
		//insert value
		pstmt.setString(1, nNum);
		
		//execute query
		ResultSet rset = pstmt.executeQuery();
		
		//parse data
		String grade = "";
		while(rset.next()) {
			String courseNum = "       " + rset.getString(1) + "      ";
			String secNum = centerString(14, rset.getString(2));
			String sem = centerSem( rset.getString(3));
			String strYear = "  " + rset.getString(4) + " ";
			if (rset.getString(5) != null) {
				grade = "    " + rset.getString(5);
			} else {
				grade = "    IP";
			}
			courseGrades += courseNum + "|" + secNum + "|" + sem + "|" + strYear + "|" + grade + System.lineSeparator();
		}
		
		//close connection
		this.closeConn();
		
		//return result
		return courseGrades;
	}
	
	public String studentInfo(String nNum) throws SQLException {
		String studentInfo = "";
		
		//open connection
		Connection conn = this.createConn();
		
		//set up query
		PreparedStatement pstmt = conn.prepareStatement("SELECT Fname, Mid_initial, Lname, Class, Degree, Bdate FROM STUDENT WHERE NNUMBER = ?");
		
		//insert value
		pstmt.setString(1, nNum);
		
		//execute query
		ResultSet rs = pstmt.executeQuery();
		
		//parse results
		while(rs.next()) {
			String mInit = "";
			String major = majorLookup(nNum);
			String minor = minorLookup(nNum);
			
			if (rs.getString(2) != null) {
				mInit = rs.getString(2) + " ";
			}
			
			//birthday string manipulation
			String sqlBirth = rs.getString(6);
			String formattedBirth = sqlBirth.substring(5, 10) + "-" + sqlBirth.substring(0, 4);
			
			studentInfo += "Name: " + rs.getString(1) + " " + mInit + rs.getString(3) + System.lineSeparator();
			studentInfo += "Nnumber: " + nNum + System.lineSeparator();
			studentInfo += "Birthday: " + formattedBirth + System.lineSeparator();
			studentInfo += "Major: " + major +  System.lineSeparator();
			studentInfo += "Minor: " + minor + System.lineSeparator();
			studentInfo += "Class: " + rs.getString(4) + System.lineSeparator();
			studentInfo += "Degree: " + rs.getString(5) + System.lineSeparator() + System.lineSeparator(); 
		}
		
		//close conn
		this.closeConn();
		
		return studentInfo;
	}
	
	public String majorLookup(String nNum) throws SQLException {
		String major = "";
		//open connection
		Connection conn = this.createConn();
		
		//set up query
		PreparedStatement pstmt = conn.prepareStatement("SELECT CODE FROM CHOOSES_MAJOR WHERE NNUMBER = ?");
		
		//insert value
		pstmt.setString(1, nNum);
		
		//execute query
		ResultSet rs = pstmt.executeQuery();
		
		//parse results
		if (rs.next()) {
			major = rs.getString(1);
		} else {
			major = "Not Declared";
		}
		
		//close conn
		this.closeConn();

		return major;
	}
	
	public String minorLookup(String nNum) throws SQLException {
		String minor = "";
		//open connection
		Connection conn = this.createConn();
		
		//set up query
		PreparedStatement pstmt = conn.prepareStatement("SELECT CODE FROM CHOOSES_MINOR WHERE NNUMBER = ?");
		
		//insert value
		pstmt.setString(1, nNum);
		
		//execute query
		ResultSet rs = pstmt.executeQuery();
		
		//parse results
		if (rs.next()) {
			minor = rs.getString(1);
		} else {
			minor = "Not Declared";
		}
		
		//close conn
		this.closeConn();
		
		if (minor.isBlank()) {
			minor = "Not Declared";
		}

		return minor;
	}
	
	public String avgGPA (String nNum) throws SQLException {
		String GPA = System.lineSeparator() + "GPA: ";
		
		//open connection
		Connection conn = this.createConn();
		
		//set up query
		PreparedStatement pstmt = conn.prepareStatement("SELECT AVG(grade_num) FROM GRADES_FOR WHERE NNUMBER = ?");
		
		//insert value
		pstmt.setString(1, nNum);
		
		//execute query
		ResultSet rs = pstmt.executeQuery();
		
		//parse results
		rs.next();
		GPA += rs.getDouble(1);
		
		//close conn
		this.closeConn();
		
		return GPA;
	}
	
	public static String centerString (int width, String s) {
	    return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
	}
	
	public static String centerSem(String sem) {
		String semFormatted = "";
		if (sem.equals("spring")) {
			semFormatted = "  Spring  ";
		} else if (sem.equals("summer")) {
			semFormatted = "  Summer  ";
		} else {
			semFormatted = "   Fall   ";
		}
		return semFormatted;
	}
	
	public int insertStudent(String fName, String lName, String mid, String ssn, String birth, String sex, String sClass, String degree, String nNum, String cpn, String ppn, String cAddress, String stAddress, String city, String state, String z, String maj, String min) throws SQLException {
		//open connection
		Connection conn = this.createConn();
		
		//create statement
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO STUDENT(Fname, Lname, Mid_initial, Ssn, Bdate, Sex, Class, Degree, Nnumber, C_phone, C_address, P_phone, P_st_address, P_city, P_state, P_zip_code) VALUES (?, ?, ?, ?, TO_DATE(?, 'MM-DD-YYYY'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		//prep values and insert them to STUDENT
		pstmt.setString(1, fName);
		pstmt.setString(2, lName);
		if (mid.isBlank()) {
			pstmt.setNull(3, Types.NULL);
		} else {
			pstmt.setString(3, mid);
		}
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
		pstmt.setString(16, z);
		
		//executing update
		int rows = pstmt.executeUpdate();
		
		int rows1 = 1;
		if (!maj.isBlank()) {
			//create 2nd statement
			PreparedStatement pstmt1 = conn.prepareStatement("INSERT INTO CHOOSES_Major(Nnumber, Code) VALUES (?, ?)");
			
			//prep values and insert them to CHOOSES_MAJOR
			pstmt1.setString(1, nNum);
			pstmt1.setString(2, maj);
			
			//execute updates
			rows1 = pstmt1.executeUpdate();
		}
		
		int rows2 = 1;
		if (!min.isBlank()) {
			//create 3rd statement
			PreparedStatement pstmt2 = conn.prepareStatement("INSERT INTO CHOOSES_Minor(Nnumber, Code) VALUES (?, ?)");
			
			//prep values and insert them to CHOOSES_MINOR
			pstmt2.setString(1, nNum);
			pstmt2.setString(2, min);
			
			//execute update
			rows2 = pstmt2.executeUpdate();
		}

		//close connection
		this.closeConn();
		
		return Math.min(Math.min(rows, rows1), rows2);
	}
	
	public int insertDepartment(String dName, String dCode, int oNum, String officePhone, String college ) throws SQLException {
		//open connection
		Connection conn = this.createConn();
		
		//create statement
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO DEPARTMENT(Department_name, Code, Office_num,  college, Office_phone) VALUES (?,?,?,?,?)");
		
		//prep values and insert them
		pstmt.setString(1, dName);
		pstmt.setString(2, dCode);
		pstmt.setInt(3, oNum);
		pstmt.setString(4, college);
		pstmt.setString(5, officePhone);
		
		//executing update
		int row = pstmt.executeUpdate();

		//close connection
		this.closeConn();
		
		return row;
	}
	
	public int insertCourse(String cName, String description, String cLvl, String cNum, int h, String dCode) throws SQLException {
		//open connection
		Connection conn = this.createConn();
		
		//create statement
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO COURSE(Grade_level, Description, Course_name, Course_num, sem_hours, Code) VALUES (?,?,?,?,?,?)");
		
		//prep values and insert them
		pstmt.setString(1, cLvl);
		pstmt.setString(2, description);
		pstmt.setString(3, cName);
		pstmt.setString(4, cNum);
		pstmt.setInt(5, h);
		pstmt.setString(6, dCode);
		
		//executing update
		int row = pstmt.executeUpdate();

		//close connection
		this.closeConn();
		
		return row;
	}

	public int insertSection(String cNum, String sem, int year, int sn, String instructor) throws SQLException {
		//open connection
		Connection conn = this.createConn();
		
		//create statement
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO SECTION(Course_num, Year, Semester, Instructor, Section_num) VALUES (?,?,?,?,?)");
		
		//prep values and insert them
		pstmt.setString(1, cNum);
		pstmt.setInt(2, year);
		pstmt.setString(3, sem);
		pstmt.setString(4, instructor);
		pstmt.setInt(5, sn);
		
		//executing update
		int row = pstmt.executeUpdate();

		//close connection
		this.closeConn();
		
		return row;
	}
	
	public ResultSet displayCourse(String findCourse, String choice) throws SQLException {
	    //open connection
	    Connection conn = this.createConn();

	    //insert value and running query
	    String query = "";
	    if (choice.equals("name")) {
	    	query = "SELECT Course_name, Course_num FROM COURSE C, DEPARTMENT D WHERE C.code = D.code AND Department_name = ?";
	    } else {
	    	query = "SELECT Course_name, Course_num FROM COURSE C, DEPARTMENT D WHERE C.code = D.code AND D.code = ?";
	    }
	    PreparedStatement pstmt = conn.prepareStatement(query);
	    pstmt.setString(1, findCourse);
	    ResultSet rs = pstmt.executeQuery();

	    return rs;
	}
}
