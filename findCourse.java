import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class findCourse {

	protected Shell shell;
	private Text txtFindCourse;
	private List courseList;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			findCourse window = new findCourse();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	public static void openCourseOffered() {
		
		try {
			findCourse window = new findCourse();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Courses Offered");
		
		Label lblCourseOffered = new Label(shell, SWT.NONE);
		lblCourseOffered.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		lblCourseOffered.setBounds(112, 10, 186, 21);
		lblCourseOffered.setText("Find Course Offered");
		
		txtFindCourse = new Text(shell, SWT.BORDER);
		txtFindCourse.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {  //Search for department name and code 
				
				String findCourse = txtFindCourse.getText();
				
				jdbcHandler sqlconn = new jdbcHandler(loginScreen.username, loginScreen.password);
				try {
					// reminder: add sex later on
					sqlconn.displayCourse(findCourse);
					enrollStudent.createMsgBox(shell, "Successful", "The entry was successfully updated.");
					txtFindCourse.setText("");
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					enrollStudent.createMsgBox(shell, "Error", "There was an error with the update. Please try again.");
				}
				
				/*//open connection
				Connection conn = this.createConn();
				
				//running query to check if student is 
				String query = "Select code FROM COURSE AS C, DEPARTMENT AS D WHERE C.code = D.code";
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1, txtFindCourse.getText());
				ResultSet rs = pstmt.executeQuery();
				
				// try to display courses on list 
				courseList.setModel(DbUtils.resultSetToTableModel(rs));
				/*while(rs.next())
				{
					txtFindCourse.setText(rs.getString(""));
				}
				
				//close connection
				closeConn(conn);*/
			}
		});
		txtFindCourse.setBounds(190, 37, 136, 21);
		
		Label lblFindCourse = new Label(shell, SWT.NONE);
		lblFindCourse.setBounds(10, 37, 174, 15);
		lblFindCourse.setText("Enter department name or code:");
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setBounds(97, 73, 250, 153);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		courseList = new List(scrolledComposite, SWT.BORDER);
		scrolledComposite.setContent(courseList);
		scrolledComposite.setMinSize(courseList.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		
				// Back to menu and close current one.
				shell.close();
				menuScreen.openMenu();
			}
		});
		btnBack.setBounds(10, 228, 75, 25);
		btnBack.setText("Back");
		
		Button btnSearch = new Button(shell, SWT.NONE);
		btnSearch.setBounds(336, 35, 75, 25);
		btnSearch.setText("Search");

	}
}
