import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class addSection {

	protected Shell shell;
	private Text semTxt;
	private Text sYearTxt;
	private Text sNumTxt;
	private Text instructorTxt;
	private Text courseNumTxt;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			addSection window = new addSection();
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
	
	public static void openSection() {
		
		try {
			addSection window = new addSection();
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
		shell.setSize(333, 335);
		shell.setText("Section");
		
		Label lblSection = new Label(shell, SWT.NONE);
		lblSection.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		lblSection.setBounds(87, 10, 156, 25);
		lblSection.setText("Add Section Info");
		
		Label lblSem = new Label(shell, SWT.NONE);
		lblSem.setBounds(10, 89, 55, 15);
		lblSem.setText("Semester:");
		
		semTxt = new Text(shell, SWT.BORDER);
		semTxt.setText("");
		semTxt.setBounds(71, 86, 76, 21);
		
		Label lblSemYear = new Label(shell, SWT.NONE);
		lblSemYear.setBounds(10, 130, 30, 15);
		lblSemYear.setText("Year:");
		
		sYearTxt = new Text(shell, SWT.BORDER);
		sYearTxt.setBounds(46, 127, 76, 21);
		
		Label lblSectionNum = new Label(shell, SWT.NONE);
		lblSectionNum.setBounds(10, 174, 89, 15);
		lblSectionNum.setText("Section Number:");
		
		sNumTxt = new Text(shell, SWT.BORDER);
		sNumTxt.setBounds(105, 171, 76, 21);
		
		Label lblInstructor = new Label(shell, SWT.NONE);
		lblInstructor.setBounds(10, 217, 55, 15);
		lblInstructor.setText("Instructor:");
		
		instructorTxt = new Text(shell, SWT.BORDER);
		instructorTxt.setBounds(71, 214, 110, 21);
		
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		
				// Back to menu and close current one.
				shell.close();
				menuScreen.openMenu();
			}
		});
		btnBack.setBounds(10, 257, 75, 25);
		btnBack.setText("Back");
		
		Button btnSub = new Button(shell, SWT.NONE);
		btnSub.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				String courseNum = courseNumTxt.getText();
				String sem = semTxt.getText();
				String sYear = sYearTxt.getText();
				String sNum = sNumTxt.getText();
				String instructor = instructorTxt.getText();
				
				if (!sem.isBlank() && !sYear.isBlank() && !sNum.isBlank() && !instructor.isBlank()) {
					if (sem.matches("")) {
						if (sYear.matches("")) {
							if (sNum.matches("")) {
								if (instructor.matches("")) {
									int year = Integer.parseInt(sYear);
									int cn = Integer.parseInt(courseNum);
									int sn = Integer.parseInt(sNum);
										
										//int section = Integer.parseInt(secNum);
										
										//make sql call
										jdbcHandler sqlconn = new jdbcHandler(loginScreen.username, loginScreen.password);
										try {
											sqlconn.insertSection(cn, sem, year, sn, instructor);
											createMsgBox(shell, "Successful", "The entry was successfully inserted.");
											courseNumTxt.setText("");
											semTxt.setText("");
											sYearTxt.setText("");
											sNumTxt.setText("");
											instructorTxt.setText("");
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
											createMsgBox(shell, "Error", "There was an error with the insertion. Please try again.");
										}
										
										
									}else {
										createMsgBox(shell, "Invalid", "Please enter a valid Instructor.");
										instructorTxt.setText("");
									}
									
								}else {
									createMsgBox(shell, "Invalid", "Please enter a valid Section Number.");
									sNumTxt.setText("");
								}
								
							}else {
								createMsgBox(shell, "Invalid", "Please enter a valid Year.");
								sYearTxt.setText("");
							}
							
						} else {
							createMsgBox(shell, "Invalid", "Please enter a valid Office Semester.");
							semTxt.setText("");
						}

				} else {
					createMsgBox(shell, "Incorrect Values", "Please double check your values entered for either Student nNumber or the Course/Section.");
				  }
				
				// Submit info and return back to menu next screen and close current one.
				shell.close();
				menuScreen.openMenu();
			}
		});
		btnSub.setBounds(238, 257, 75, 25);
		btnSub.setText("Sumbit");
		
		courseNumTxt = new Text(shell, SWT.BORDER);
		courseNumTxt.setBounds(105, 51, 76, 21);
		
		Label lblCourseNum = new Label(shell, SWT.NONE);
		lblCourseNum.setBounds(10, 54, 89, 15);
		lblCourseNum.setText("Course Number:");

	}
}
