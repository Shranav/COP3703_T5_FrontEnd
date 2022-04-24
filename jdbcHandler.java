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
		
		//executing update
		pstmt.executeUpdate();
	    
	    //close connection
	    this.closeConn();
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
		
		//executing update
		pstmtUpdate.executeUpdate();
		
	    //close connection
		this.closeConn();
	}
	
	public String genGradeReport(String nNum) throws SQLException {
		
		String studentInfo = "";
		String courseGrades = " Course Number | Section | Semester | Year | Grade " + System.lineSeparator();
		
		//open connection
		Connection conn = this.createConn();
		
		//create statement
		PreparedStatement pstmt = conn.prepareStatement("SELECT Fname, Mid_initial, Lname, Class, Degree, Course_num, Section_num, Semester, Year, Grade_letter FROM STUDENT, GRADES_FOR WHERE STUDENT.NNUMBER = GRADES_FOR.NNUMBER AND STUDENT.NNUMBER = ?");
		
		//insert value
		pstmt.setString(1, nNum);
		
		//execute query
		ResultSet rset = pstmt.executeQuery();
		
		//parse data
		int counter = 0;
		String mInit = "";
		String grade = "";
		while(rset.next()) {
			System.out.println("in while " + counter);
			if (counter == 0) {
				if (rset.getString(2) != null) {
					mInit = rset.getString(2);
				}
				System.out.println("in if counter");
				studentInfo += "Name: " + rset.getString(1) + " " + mInit + rset.getString(3) + System.lineSeparator();
				studentInfo += "Class: " + rset.getString(4) + "\tDegree: " + rset.getString(5) + System.lineSeparator(); 
			}
			String courseNum = centerString(21, rset.getString(6));
			String secNum = centerString(12, rset.getString(7));
			String sem = centerString(14, rset.getString(8));
			String strYear = centerString(6, rset.getString(9));
			System.out.println("outside of ifs");
			if (rset.getString(10) != null) {
				grade = centerString(10, rset.getString(10));
			} else {
				grade = centerString(10, "IP");
			}
			courseGrades += courseNum + "|" + secNum + "|" + sem + "|" + strYear + "|" + grade + System.lineSeparator();
			counter++;
		}
		
		//close connection
		this.closeConn();
		
		//return result
		return studentInfo + courseGrades;
	}
	
	public String avgGPA (String nNum) throws SQLException {
		String GPA = "GPA: ";
		
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
	
	// reminder: add sex later on
	public void insertStudent(String fName, String lName, String mid, String ssn, String birth, String sex, String sClass, String degree, String nNum, String cpn, String ppn, String cAddress, String stAddress, String city, String state, int z) throws SQLException {
		//open connection
		Connection conn = this.createConn();
		
		//create statement
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO STUDENT(Fname, Lname, Mid_initial, Ssn, Bdate, Sex, Class, Degree, Nnumber, C_phone, C_address, P_phone, P_st_address, P_city, P_state, P_zip_code) VALUES (?, ?, ?, ?, TO_DATE(?, 'MM-DD-YYYY'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
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
		
		//executing update
		pstmt.executeUpdate();
		
		//close connection
		this.closeConn();	
	}
	
	public void insertDepartment(String dName, int dCode, int oNum, String officePhone, String college ) throws SQLException {
		//open connection
		Connection conn = this.createConn();
		
		//create statement
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO DEPARTMENT(Department_name, Code, Office_num,  college, Office_phone) VALUES (?,?,?,?,?)");
		
		//prep values and insert them
		pstmt.setString(1, dName);
		pstmt.setInt(2, dCode);
		pstmt.setInt(3, oNum);
		pstmt.setString(4, college);
		pstmt.setString(5, officePhone);
		
		//executing update
		pstmt.executeUpdate();

		//close connection
		this.closeConn();	
	}
	
	public void insertCourse(String cName, String description, String cLvl, String cNum, int h, int dCode) throws SQLException {
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
		pstmt.setInt(6, dCode);
		
		//executing update
		pstmt.executeUpdate();

		//close connection
		this.closeConn();
	}

	public void insertSection(String cNum, String sem, int year, int sn, String instructor) throws SQLException {
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
		pstmt.executeUpdate();

		//close connection
		this.closeConn();
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
