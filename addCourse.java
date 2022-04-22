import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

public class addCourse {

	protected Shell shell;
	private Text cNameTxt;
	private Text descriptionTxt;
	private Text cLvlTxt;
	private Text cNumTxt;
	private Text hoursTxt;
	private Text codeTxt;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			addCourse window = new addCourse();
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
	
	public static void openCourse() {
		
		try {
			addCourse window = new addCourse();
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
		shell.setSize(343, 375);
		shell.setText("Course");
		shell.setLayout(null);
		
		Label lblCLvl = new Label(shell, SWT.NONE);
		lblCLvl.setBounds(10, 139, 76, 15);
		lblCLvl.setText("Course Level:");
		
		cNameTxt = new Text(shell, SWT.BORDER);
		cNameTxt.setBounds(92, 48, 76, 21);
		
		Label lblDescription = new Label(shell, SWT.NONE);
		lblDescription.setBounds(10, 94, 68, 15);
		lblDescription.setText("Description:");
		
		descriptionTxt = new Text(shell, SWT.BORDER);
		descriptionTxt.setBounds(84, 91, 210, 21);
		
		Label lblCName = new Label(shell, SWT.NONE);
		lblCName.setBounds(10, 51, 76, 15);
		lblCName.setText("Course Name:");
		
		cLvlTxt = new Text(shell, SWT.BORDER);
		cLvlTxt.setBounds(92, 136, 76, 21);
		
		Label lblCNum = new Label(shell, SWT.NONE);
		lblCNum.setBounds(10, 175, 94, 15);
		lblCNum.setText("Course Number:");
		
		cNumTxt = new Text(shell, SWT.BORDER);
		cNumTxt.setBounds(110, 172, 76, 21);
		
		Label lblHours = new Label(shell, SWT.NONE);
		lblHours.setBounds(10, 214, 94, 15);
		lblHours.setText("Semester Hours:");
		
		hoursTxt = new Text(shell, SWT.BORDER);
		hoursTxt.setBounds(110, 214, 76, 21);
		
		Label lblCourse = new Label(shell, SWT.NONE);
		lblCourse.setBounds(92, 10, 146, 25);
		lblCourse.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		lblCourse.setText("Add Course Info");
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.setBounds(10, 302, 75, 25);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		
				// Back to menu and close current one.
				shell.close();
				menuScreen.openMenu();
			}
		});
		btnBack.setText("Back");
		
		Button btnSub = new Button(shell, SWT.NONE);
		btnSub.setBounds(244, 302, 75, 25);
		btnSub.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				String cName = cNameTxt.getText();
				String description = descriptionTxt.getText();
				String cLvl = cLvlTxt.getText();
				String cNum = cNumTxt.getText();
				String hours = hoursTxt.getText();
				String code = codeTxt.getText();
				
				  //check if txt boxes are not blank
					if (!cName.isBlank() && !description.isBlank() && !cLvl.isBlank() && !cNum.isBlank() && !hours.isBlank()) {
						if (cName.matches("")) {
							if (description.matches("")) {
								if (cLvl.matches("")) {
									if (cNum.matches("")) {
										if (hours.matches("")) {
											int cn = Integer.parseInt(cNum);
											int h = Integer.parseInt(hours);
											int dCode = Integer.parseInt(code);
											
											//int section = Integer.parseInt(secNum);
											
											//make sql call
											jdbcHandler sqlconn = new jdbcHandler(loginScreen.username, loginScreen.password);
											try {
												sqlconn.insertCourse(cName, description, cLvl, cn, h, dCode);
												createMsgBox(shell, "Successful", "The entry was successfully inserted.");
												cNameTxt.setText("");
												descriptionTxt.setText("");
												cLvlTxt.setText("");
												cNumTxt.setText("");
												hoursTxt.setText("");
												codeTxt.setText("");
												
											} catch (SQLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
												createMsgBox(shell, "Error", "There was an error with the insertion. Please try again.");
											}
											
											
										}else {
											createMsgBox(shell, "Invalid", "Please enter a valid Hours.");
											hoursTxt.setText("");
										}
										
									}else {
										createMsgBox(shell, "Invalid", "Please enter a valid Course Number.");
										cNumTxt.setText("");
									}
									
								}else {
									createMsgBox(shell, "Invalid", "Please enter a valid Course Level.");
									cLvlTxt.setText("");
								}
								
							} else {
								createMsgBox(shell, "Invalid", "Please enter a valid Office Description.");
								descriptionTxt.setText("");
							}
						} else {
							createMsgBox(shell, "Invalid", "Please enter a valid Course Name.");
							cNameTxt.setText("");
						}
					} else {
						createMsgBox(shell, "Incorrect Values", "Please double check your values entered for either Student nNumber or the Course/Section.");
					  }
		
				// Submit info and return back to menu next screen and close current one.
				shell.close();
				menuScreen.openMenu();
			}
		});
		btnSub.setText("Submit");
		
		Label lblDCode = new Label(shell, SWT.NONE);
		lblDCode.setBounds(10, 254, 102, 15);
		lblDCode.setText("Department Code:");
		
		codeTxt = new Text(shell, SWT.BORDER);
		codeTxt.setBounds(114, 251, 76, 21);

	}

}
