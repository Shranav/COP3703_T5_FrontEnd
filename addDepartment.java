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
	private Label lblCode;
	private Text codeTxt;
	private Label lblOfficeNum;
	private Text officeNumTxt;
	private Label lblOfficePhone;
	private Text officePhoneTxt;
	private Label lblCollege;
	private Text collegeTxt;
	static String dName;
	static String code;
	static String officeNum;
	static String officePhone;
	static String college;
	

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
		
		Label lblDName = new Label(shell, SWT.NONE);
		lblDName.setText("Department Name:");
		lblDName.setBounds(10, 64, 107, 15);
		
		dNameTxt = new Text(shell, SWT.BORDER);
		dNameTxt.setBounds(123, 61, 76, 21);
		
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
		
		lblCollege = new Label(shell, SWT.NONE);
		lblCollege.setBounds(10, 219, 49, 15);
		lblCollege.setText("College:");
		
		collegeTxt = new Text(shell, SWT.BORDER);
		collegeTxt.setBounds(63, 216, 76, 21);
		
		lblOfficePhone = new Label(shell, SWT.NONE);
		lblOfficePhone.setBounds(10, 182, 77, 15);
		lblOfficePhone.setText("Office Phone:");
		
		officePhoneTxt = new Text(shell, SWT.BORDER);
		officePhoneTxt.setBounds(87, 179, 76, 21);
		
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
				
				dName = dNameTxt.getText();
				code = codeTxt.getText();
				officeNum = officeNumTxt.getText();
				officePhone = officePhoneTxt.getText();
			        college = collegeTxt.getText();
		
				// Submit info and return back to menu next screen and close current one.
				shell.close();
				menuScreen.openMenu();
			}
		});
		btnSub.setBounds(253, 289, 75, 25);
		btnSub.setText("Submit");

	}
}
