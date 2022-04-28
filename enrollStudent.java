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
	private Text txtYear;
	private Text txtSem;

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
		lblInfo.setText("Please provide a student nNumber, Course Code, Section, Semester, and Year to enroll them in. ");
		
		txtNnumber = new Text(shell, SWT.BORDER);
		txtNnumber.setBounds(222, 87, 76, 21);
		
		Label lblStudentNnumber = new Label(shell, SWT.NONE);
		lblStudentNnumber.setBounds(113, 90, 103, 15);
		lblStudentNnumber.setText("Student nNumber:");
		
		txtCourse = new Text(shell, SWT.BORDER);
		txtCourse.setBounds(222, 114, 76, 21);
		
		Label lblCourse = new Label(shell, SWT.NONE);
		lblCourse.setAlignment(SWT.CENTER);
		lblCourse.setText("Course Code:");
		lblCourse.setBounds(113, 117, 103, 15);
		
		txtSection = new Text(shell, SWT.BORDER);
		txtSection.setBounds(222, 141, 76, 21);
		
		Label lblSection = new Label(shell, SWT.NONE);
		lblSection.setText("Section Number:");
		lblSection.setAlignment(SWT.CENTER);
		lblSection.setBounds(113, 144, 103, 15);
		
		Label lblYear = new Label(shell, SWT.NONE);
		lblYear.setText("Year:");
		lblYear.setAlignment(SWT.CENTER);
		lblYear.setBounds(113, 170, 103, 15);
		
		txtYear = new Text(shell, SWT.BORDER);
		txtYear.setBounds(222, 167, 76, 21);
		
		Label lblSemester = new Label(shell, SWT.NONE);
		lblSemester.setText("Semester:");
		lblSemester.setAlignment(SWT.CENTER);
		lblSemester.setBounds(113, 197, 103, 15);
		
		txtSem = new Text(shell, SWT.BORDER);
		txtSem.setBounds(222, 194, 76, 21);
		
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
				//extract text from txt boxes
				String nNum = txtNnumber.getText().toUpperCase();
				String course = txtCourse.getText();
				String secNum = txtSection.getText();
				String year = txtYear.getText();
				String sem = txtSem.getText().toLowerCase();
				
				//check if txt boxes are not blank
				if (!nNum.isBlank() && !course.isBlank() && !secNum.isBlank() && !year.isBlank() && !sem.isBlank()) {
					if (nNum.matches("^[Nn][0-9]{8}$")) {
						if (secNum.matches("[1-9]+")) {
							if (year.matches("[0-9]{4}")) {
								if (sem.equals("spring") || sem.equals("summer") || sem.equals("fall")) {
									int section = Integer.parseInt(secNum);
									int yearInt = Integer.parseInt(year);
									
									//make sql call
									jdbcHandler sqlconn = new jdbcHandler(loginScreen.username, loginScreen.password);
									try {
										int result = sqlconn.insertGradesFor(nNum, course, section, yearInt, sem);
										if (result > 0) {
											createMsgBox(shell, "Successful", "The entry was successfully inserted.");
											txtNnumber.setText("");
											txtCourse.setText("");
											txtSection.setText("");
											txtYear.setText("");
											txtSem.setText("");
										} else {
											createMsgBox(shell, "Error", "There was an error with the insertion. Please try again.");

										}
									} catch (SQLException e1) {
										createMsgBox(shell, "Error", "There was an error with the insertion. Hint: " + e1.getLocalizedMessage() + ". Please try again.");
									}
									
								} else {
									createMsgBox(shell, "Incorrect Semester", "Please choose between spring, summer, or fall");
								}
							} else {
								createMsgBox(shell, "Incorrect Year", "Please enter the year in the 4 digit format.");
							}
						} else {
							createMsgBox(shell, "Incorrect Section Number", "Please enter a valid section number (either 1, 2, 3, etc).");
							txtSection.setText("");
						}
					} else {
						createMsgBox(shell, "Incorrect Student nNumber", "The Student nNumber you've entered does not seem to be in the correct format. Please fix this.");
					}
				} else {
					createMsgBox(shell, "Incorrect Values", "Please double check your values entered for either Student nNumber or the Course/Section.");
				}
			}
		});
		btnSubmit.setBounds(326, 219, 75, 25);
		btnSubmit.setText("Submit");

	}
}
