import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class enrollStudent {

	protected Shell shell;
	private Text txtNnumber;
	private Text txtCourse;
	private Text txtSection;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			enrollStudent window = new enrollStudent();
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
	
	public static void openEnroll() {
		try {
			enrollStudent window = new enrollStudent();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void createMsgBox( Shell shell, String title, String txt) {
		MessageBox messageBox = new MessageBox(shell,SWT.ICON_INFORMATION |SWT.OK);
		messageBox.setText(title);
		messageBox.setMessage(txt);
		messageBox.open();
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblTitle = new Label(shell, SWT.NONE);
		lblTitle.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		lblTitle.setAlignment(SWT.CENTER);
		lblTitle.setBounds(10, 10, 419, 24);
		lblTitle.setText("Enroll A Student");
		
		Label lblInfo = new Label(shell, SWT.NONE);
		lblInfo.setAlignment(SWT.CENTER);
		lblInfo.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.ITALIC));
		lblInfo.setBounds(22, 40, 389, 37);
		lblInfo.setText("Please Provide a student nNumber and or Course/Section to enroll them in. ");
		
		txtNnumber = new Text(shell, SWT.BORDER);
		txtNnumber.setBounds(222, 101, 76, 21);
		
		Label lblStudentNnumber = new Label(shell, SWT.NONE);
		lblStudentNnumber.setBounds(113, 104, 103, 15);
		lblStudentNnumber.setText("Student nNumber:");
		
		txtCourse = new Text(shell, SWT.BORDER);
		txtCourse.setBounds(222, 128, 76, 21);
		
		Label lblCourse = new Label(shell, SWT.NONE);
		lblCourse.setAlignment(SWT.CENTER);
		lblCourse.setText("Course:");
		lblCourse.setBounds(113, 131, 103, 15);
		
		txtSection = new Text(shell, SWT.BORDER);
		txtSection.setBounds(222, 155, 76, 21);
		
		Label lblSection = new Label(shell, SWT.NONE);
		lblSection.setText("Section Number:");
		lblSection.setAlignment(SWT.CENTER);
		lblSection.setBounds(113, 158, 103, 15);
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//reopen menu
				shell.close();
				menuScreen.openMenu();
			}
		});
		btnBack.setBounds(34, 219, 75, 25);
		btnBack.setText("Back");
		
		Button btnSubmit = new Button(shell, SWT.NONE);
		btnSubmit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//do we have to do error handling? i.e. for 2nd requirement, if student or course doesnt exist what do we do?
				//what does the user enter? both course num and section? or just one or the other?
				//how are semesters divided up? only spring summer and fall? or include summer a, b, c etc?
				
				//extract text from txt boxes
				String nNum = txtNnumber.getText();
				String course = txtCourse.getText();
				String secNum = txtSection.getText();
				
				//check if txt boxes are not blank
				if (!nNum.isBlank() && !course.isBlank() && !secNum.isBlank()) {
					if (nNum.matches("^[Nn][0-9]+")) {
						if (secNum.matches("[123]")) {
							int section = Integer.parseInt(secNum);
							
							//make sql call
							jdbcHandler sqlconn = new jdbcHandler(loginScreen.username, loginScreen.password);
							try {
								sqlconn.insertGradesFor(nNum, course, section);
								createMsgBox(shell, "Successful", "The entry was successfully inserted.");
								txtNnumber.setText("");
								txtCourse.setText("");
								txtSection.setText("");
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								createMsgBox(shell, "Error", "There was an error with the insertion. Please try again.");
							}
							
						} else {
							createMsgBox(shell, "Incorrect Section Number", "Please enter a valid section number (either 1, 2, or 3).");
							txtSection.setText("");
						}
					} else {
						createMsgBox(shell, "Incorrect Student nNumber", "The Student nNumber you've entered does not seem to be in the correct format. Please fix this.");
						txtNnumber.setText("");
					}
				} else {
					createMsgBox(shell, "Incorrect Values", "Please double check your values entered for either Student nNumber or the Course/Section.");
					txtNnumber.setText("");
					txtCourse.setText("");
					txtSection.setText("");
				}
			}
		});
		btnSubmit.setBounds(326, 219, 75, 25);
		btnSubmit.setText("Submit");

	}
}
