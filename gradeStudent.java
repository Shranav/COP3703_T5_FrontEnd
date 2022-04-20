import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class gradeStudent {

	protected Shell shell;
	private Text txtNnumber;
	private Text txtCourse;
	private Text txtSection;
	private Text txtLetterGrade;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			gradeStudent window = new gradeStudent();
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
	
	public static void openGrade() {
		try {
			enrollStudent window = new enrollStudent();
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
		shell.setText("SWT Application");
		
		Label lblTitle = new Label(shell, SWT.NONE);
		lblTitle.setText("Enter A Student's Grade");
		lblTitle.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		lblTitle.setAlignment(SWT.CENTER);
		lblTitle.setBounds(10, 10, 419, 24);
		
		Label lblInfo = new Label(shell, SWT.NONE);
		lblInfo.setText("Please provide a student nNumber, Course, Section, and Grade to update their record. ");
		lblInfo.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.ITALIC));
		lblInfo.setAlignment(SWT.CENTER);
		lblInfo.setBounds(22, 40, 389, 37);
		
		Label lblStudentNnumber = new Label(shell, SWT.NONE);
		lblStudentNnumber.setText("Student nNumber:");
		lblStudentNnumber.setBounds(113, 98, 103, 15);
		
		txtNnumber = new Text(shell, SWT.BORDER);
		txtNnumber.setBounds(222, 95, 76, 21);
		
		Label lblCourse = new Label(shell, SWT.NONE);
		lblCourse.setText("Course:");
		lblCourse.setAlignment(SWT.CENTER);
		lblCourse.setBounds(113, 125, 103, 15);
		
		txtCourse = new Text(shell, SWT.BORDER);
		txtCourse.setBounds(222, 122, 76, 21);
		
		Label lblSection = new Label(shell, SWT.NONE);
		lblSection.setText("Section Number:");
		lblSection.setAlignment(SWT.CENTER);
		lblSection.setBounds(113, 152, 103, 15);
		
		txtSection = new Text(shell, SWT.BORDER);
		txtSection.setBounds(222, 149, 76, 21);
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//reopen menu
				shell.close();
				menuScreen.openMenu();
			}
		});
		btnBack.setText("Back");
		btnBack.setBounds(34, 219, 75, 25);
		
		Button btnSubmit = new Button(shell, SWT.NONE);
		btnSubmit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//extract text from txt boxes
				String nNum = txtNnumber.getText();
				String course = txtCourse.getText();
				String secNum = txtSection.getText();
				String letGrade = txtLetterGrade.getText();
				
				//check if txt boxes are not blank
				if (!nNum.isBlank() && !course.isBlank() && !secNum.isBlank() && !letGrade.isBlank()) {
					if (nNum.matches("^[Nn][0-9]+")) {
						if (secNum.matches("[123]")) {
							if (letGrade.matches("^[A-Za-z][-+]?")) {
								int section = Integer.parseInt(secNum);
								
								//make sql call
								jdbcHandler sqlconn = new jdbcHandler(loginScreen.username, loginScreen.password);
								try {
									sqlconn.updateGrades(nNum, course, section, letGrade);
									enrollStudent.createMsgBox(shell, "Successful", "The entry was successfully updated.");
									txtNnumber.setText("");
									txtCourse.setText("");
									txtSection.setText("");
									txtLetterGrade.setText("");
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
									enrollStudent.createMsgBox(shell, "Error", "There was an error with the update. Please try again.");
								}
							
							} else {
								enrollStudent.createMsgBox(shell, "Incorrect Grade", "Please enter a valid Grade.");
								txtLetterGrade.setText("");
							}
						} else {
							enrollStudent.createMsgBox(shell, "Incorrect Section Number", "Please enter a valid section number (either 1, 2, or 3).");
							txtSection.setText("");
						}
					} else {
						enrollStudent.createMsgBox(shell, "Incorrect Student nNumber", "The Student nNumber you've entered does not seem to be in the correct format. Please fix this.");
						txtNnumber.setText("");
					}
				} else {
					enrollStudent.createMsgBox(shell, "Incorrect Values", "Please double check your values entered for either Student nNumber or the Course/Section.");
				}
			}
		});
		btnSubmit.setText("Submit");
		btnSubmit.setBounds(326, 219, 75, 25);
		
		Label lblLetterGrade = new Label(shell, SWT.NONE);
		lblLetterGrade.setText("Letter Grade:");
		lblLetterGrade.setAlignment(SWT.CENTER);
		lblLetterGrade.setBounds(113, 182, 103, 15);
		
		txtLetterGrade = new Text(shell, SWT.BORDER);
		txtLetterGrade.setBounds(222, 179, 76, 21);

	}

}
