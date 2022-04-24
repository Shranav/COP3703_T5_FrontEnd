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

public class addDepartment {

	protected Shell shell;
	private Text dNameTxt;
	private Label lblCode;
	private Text codeTxt;
	private Label lblOfficeNum;
	private Text officeNumTxt;
	private Label lblOfficePhone;
	private Text officePhoneTxt;
	private Label lblCollege;
	private Text collegeTxt;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			addDepartment window = new addDepartment();
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
	
	public static void openDepartment() {
		
		try {
			addDepartment window = new addDepartment();
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
		shell.setSize(346, 358);
		shell.setText("Department");
		
		Label lblDName = new Label(shell, SWT.NONE);
		lblDName.setText("Department Name:");
		lblDName.setBounds(10, 64, 107, 15);
		
		dNameTxt = new Text(shell, SWT.BORDER);
		dNameTxt.setBounds(123, 61, 174, 21);
		
		Label Department = new Label(shell, SWT.NONE);
		Department.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		Department.setBounds(63, 10, 199, 25);
		Department.setText("Add Department Info");
		
		lblCode = new Label(shell, SWT.NONE);
		lblCode.setText("Code:");
		lblCode.setBounds(10, 100, 36, 15);
		
		codeTxt = new Text(shell, SWT.BORDER);
		codeTxt.setBounds(52, 97, 76, 21);
		
		lblOfficeNum = new Label(shell, SWT.NONE);
		lblOfficeNum.setBounds(10, 146, 82, 15);
		lblOfficeNum.setText("Office Number:");
		
		officeNumTxt = new Text(shell, SWT.BORDER);
		officeNumTxt.setBounds(98, 143, 76, 21);
		
		lblOfficePhone = new Label(shell, SWT.NONE);
		lblOfficePhone.setBounds(10, 182, 164, 15);
		lblOfficePhone.setText("Office Phone (XXX-XXX-XXXX):");
		
		officePhoneTxt = new Text(shell, SWT.BORDER);
		officePhoneTxt.setBounds(180, 179, 117, 21);
		
		lblCollege = new Label(shell, SWT.NONE);
		lblCollege.setBounds(10, 219, 49, 15);
		lblCollege.setText("College:");
		
		collegeTxt = new Text(shell, SWT.BORDER);
		collegeTxt.setBounds(63, 216, 111, 21);
		
		Button btnSub = new Button(shell, SWT.NONE);
		btnSub.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Extract text
				String dName = dNameTxt.getText();
				String code = codeTxt.getText();
				String officeNum = officeNumTxt.getText();
				String officePhone = officePhoneTxt.getText();
			    String college = collegeTxt.getText();
			    
			  //check if txt boxes are not blank
				if (!dName.isBlank() && !code.isBlank() && !officeNum.isBlank() && !officePhone.isBlank() && !college.isBlank()) {
					if (code.matches("^([0-9]|[0-9]{2}|[0-9]{3}|[0-9]{4})$")) {
						if (officeNum.matches("^[0-9]{4}$")) {
							if (officePhone.matches("^[0-9]{3}-[0-9]{3}-[0-9]{4}$")) {
								int dCode = Integer.parseInt(code);
								int oNum = Integer.parseInt(officeNum);
								
								//make sql call
								jdbcHandler sqlconn = new jdbcHandler(loginScreen.username, loginScreen.password);
								try {
									sqlconn.insertDepartment(dName, dCode, oNum, officePhone, college);
									createMsgBox(shell, "Successful", "The entry was successfully added.");
									dNameTxt.setText("");
									codeTxt.setText("");
									officeNumTxt.setText("");
									officePhoneTxt.setText("");
									collegeTxt.setText("");
								} catch (SQLException e1) {
									e1.printStackTrace();
									createMsgBox(shell, "Error", "There was an error with the insertion. Hint: " + e1.getLocalizedMessage() + ". Please try again.");
								}
								
							} else {
								createMsgBox(shell, "Invalid", "Please enter a valid Office Phone Number.");
								officePhoneTxt.setText("");
							}
						} else {
							createMsgBox(shell, "Invalid", "Please enter a valid Office Number.");
							officeNumTxt.setText("");
						}
					} else {
						createMsgBox(shell, "Invalid", "Please enter a valid Department code.");
						codeTxt.setText("");
					}
				} else {
					createMsgBox(shell, "Incorrect Values", "Please double check your values entered.");
				}
			}
		});
		btnSub.setBounds(253, 289, 75, 25);
		btnSub.setText("Submit");
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Back to menu and close current screen.
				shell.close();
				menuScreen.openMenu();
			}
		});
		btnBack.setBounds(10, 289, 75, 25);
		btnBack.setText("Back");

	}
}
