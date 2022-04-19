import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

public class addDepartment {

	protected Shell shell;
	private Text dNameTxt;
	private Label code;
	private Text codeTxt;
	private Label officeNum;
	private Text officeNumTxt;
	private Label college;
	private Text collegeTxt;
	private Label officePhone;
	private Text officePhoneTxt;

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

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(346, 358);
		shell.setText("Department");
		
		Label dName = new Label(shell, SWT.NONE);
		dName.setText("Department Name:");
		dName.setBounds(10, 64, 107, 15);
		
		dNameTxt = new Text(shell, SWT.BORDER);
		dNameTxt.setBounds(123, 61, 76, 21);
		
		Label Department = new Label(shell, SWT.NONE);
		Department.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		Department.setBounds(63, 10, 199, 25);
		Department.setText("Add Department Info");
		
		code = new Label(shell, SWT.NONE);
		code.setText("Code:");
		code.setBounds(10, 100, 36, 15);
		
		codeTxt = new Text(shell, SWT.BORDER);
		codeTxt.setBounds(52, 97, 76, 21);
		
		officeNum = new Label(shell, SWT.NONE);
		officeNum.setBounds(10, 146, 82, 15);
		officeNum.setText("Office Number:");
		
		officeNumTxt = new Text(shell, SWT.BORDER);
		officeNumTxt.setBounds(98, 143, 76, 21);
		
		college = new Label(shell, SWT.NONE);
		college.setBounds(10, 185, 49, 15);
		college.setText("College:");
		
		collegeTxt = new Text(shell, SWT.BORDER);
		collegeTxt.setBounds(63, 182, 76, 21);
		
		officePhone = new Label(shell, SWT.NONE);
		officePhone.setBounds(10, 232, 77, 15);
		officePhone.setText("Office Phone:");
		
		officePhoneTxt = new Text(shell, SWT.BORDER);
		officePhoneTxt.setBounds(93, 229, 76, 21);
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		
				// Back to menu and close current one.
				shell.close();
				menuScreen.openMenu();
			}
		});
		btnBack.setBounds(10, 289, 75, 25);
		btnBack.setText("Back");
		
		Button btnSub = new Button(shell, SWT.NONE);
		btnSub.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//username = txtUsername.getText();
				//password = txtPassword.getText();
		
				// Submit info and return back to menu next screen and close current one.
				shell.close();
				menuScreen.openMenu();
			}
		});
		btnSub.setBounds(253, 289, 75, 25);
		btnSub.setText("Submit");

	}
}
