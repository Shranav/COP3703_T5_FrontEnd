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
import java.sql.*;

public class findCourse {

	protected Shell shell;
	private Text txtFindCourse;
	private List courseList;
	String choice = "name";

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
		shell.setSize(500, 350);
		shell.setText("Courses Offered");
		
		Label lblCourseOffered = new Label(shell, SWT.NONE);
		lblCourseOffered.setAlignment(SWT.CENTER);
		lblCourseOffered.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		lblCourseOffered.setBounds(10, 10, 441, 21);
		lblCourseOffered.setText("Find Course Offered");
		
		Label lblChooseYourInput = new Label(shell, SWT.NONE);
		lblChooseYourInput.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.ITALIC));
		lblChooseYourInput.setBounds(20, 41, 106, 15);
		lblChooseYourInput.setText("Choose your Input:");
		
		Label lblName = new Label(shell, SWT.NONE);
		lblName.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.ITALIC));
		lblName.setBounds(304, 41, 129, 15);
		lblName.setText("Enter department name:");
		
		Label lblCode = new Label(shell, SWT.NONE);
		lblCode.setText("Enter department code:");
		lblCode.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.ITALIC));
		lblCode.setBounds(304, 41, 129, 15);
		
		Button btnName = new Button(shell, SWT.RADIO);
		btnName.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblName.setVisible(true);
				lblCode.setVisible(false);
				choice = "name";
			}
		});
		btnName.setBounds(10, 62, 128, 16);
		btnName.setText("Department Name");
		btnName.setSelection(true);
		
		Button btnCode = new Button(shell, SWT.RADIO);
		btnCode.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblName.setVisible(false);
				lblCode.setVisible(true);
				choice = "code";
			}
		});
		btnCode.setBounds(10, 81, 128, 16);
		btnCode.setText("Department Code");
		
		txtFindCourse = new Text(shell, SWT.BORDER);
		txtFindCourse.setBounds(293, 62, 136, 21);
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setBounds(101, 107, 250, 153);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		courseList = new List(scrolledComposite, SWT.BORDER | SWT.V_SCROLL);
		scrolledComposite.setContent(courseList);
		scrolledComposite.setMinSize(courseList.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Back to menu and close current screen.
				shell.close();
				menuScreen.openMenu();
			}
		});
		btnBack.setBounds(10, 271, 75, 25);
		btnBack.setText("Back");
		
		Button btnSearch = new Button(shell, SWT.NONE);
		btnSearch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				courseList.removeAll();
				String findCourse = txtFindCourse.getText();
				String regPat = "";
				if (choice.equals("code")) {
					regPat = "^([0-9A-Za-z]|[0-9A-Za-z]{2}|[0-9A-Za-z]{3}|[0-9A-Za-z]{4})$";
				} else {
					regPat = "^[A-za-z\\s]+$";
				}
				
	            if (findCourse.matches(regPat)) {
	            	//make sql call
					jdbcHandler sqlconn = new jdbcHandler(loginScreen.username, loginScreen.password);
		            try {
		                ResultSet courses = sqlconn.displayCourse(findCourse, choice);
		                while (courses.next()) {
		                    String result = courses.getString(2) + " - " + courses.getString(1);
		                    courseList.add(result);
		                }
		                if (courseList.getItemCount() == 0) {
		                	enrollStudent.createMsgBox(shell, "No Result", "No courses were found for the department " + choice + " entered.");
		                }
		                sqlconn.closeConn();
		                txtFindCourse.setText("");
		            }catch (SQLException e1) {
		                e1.printStackTrace();
		                enrollStudent.createMsgBox(shell, "Error", "There was an error with the search. Hint: " + e1.getLocalizedMessage() + ". Please try again.");
		            }
	            } else {
	            	enrollStudent.createMsgBox(shell, "Incorrect Department " + choice, "The department " + choice + " you've entered is incorrect. Please check this.");
	            }
			}
		});
		btnSearch.setBounds(376, 271, 75, 25);
		btnSearch.setText("Search");

	}
}
