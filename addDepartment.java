import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

public class addDepartment {

	protected Shell dWindow;
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
		dWindow.open();
		dWindow.layout();
		while (!dWindow.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		dWindow = new Shell();
		dWindow.setSize(346, 358);
		dWindow.setText("Department");
		
		Label dName = new Label(dWindow, SWT.NONE);
		dName.setText("Department Name:");
		dName.setBounds(10, 64, 107, 15);
		
		dNameTxt = new Text(dWindow, SWT.BORDER);
		dNameTxt.setBounds(123, 61, 76, 21);
		
		Label lblDepartment = new Label(dWindow, SWT.NONE);
		lblDepartment.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblDepartment.setBounds(98, 10, 162, 21);
		lblDepartment.setText("Add Department Info");
		
		code = new Label(dWindow, SWT.NONE);
		code.setText("Code:");
		code.setBounds(10, 100, 36, 15);
		
		codeTxt = new Text(dWindow, SWT.BORDER);
		codeTxt.setBounds(52, 97, 76, 21);
		
		officeNum = new Label(dWindow, SWT.NONE);
		officeNum.setBounds(10, 146, 82, 15);
		officeNum.setText("Office Number:");
		
		officeNumTxt = new Text(dWindow, SWT.BORDER);
		officeNumTxt.setBounds(98, 143, 76, 21);
		
		college = new Label(dWindow, SWT.NONE);
		college.setBounds(10, 185, 49, 15);
		college.setText("College:");
		
		collegeTxt = new Text(dWindow, SWT.BORDER);
		collegeTxt.setBounds(63, 182, 76, 21);
		
		officePhone = new Label(dWindow, SWT.NONE);
		officePhone.setBounds(10, 232, 77, 15);
		officePhone.setText("Office Phone:");
		
		officePhoneTxt = new Text(dWindow, SWT.BORDER);
		officePhoneTxt.setBounds(93, 229, 76, 21);
		
		Button backButton = new Button(dWindow, SWT.NONE);
		backButton.setBounds(10, 289, 75, 25);
		backButton.setText("Back");
		
		Button subButton = new Button(dWindow, SWT.NONE);
		subButton.setBounds(253, 289, 75, 25);
		subButton.setText("Submit");

	}
}
