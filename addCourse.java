import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
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

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(343, 327);
		shell.setText("Course");
		shell.setLayout(null);
		
		Label cLvl = new Label(shell, SWT.NONE);
		cLvl.setBounds(10, 139, 76, 15);
		cLvl.setText("Course Level:");
		
		cNameTxt = new Text(shell, SWT.BORDER);
		cNameTxt.setBounds(92, 48, 76, 21);
		
		Label description = new Label(shell, SWT.NONE);
		description.setBounds(10, 94, 68, 15);
		description.setText("Description:");
		
		descriptionTxt = new Text(shell, SWT.BORDER);
		descriptionTxt.setBounds(84, 91, 76, 21);
		
		Label cName = new Label(shell, SWT.NONE);
		cName.setBounds(10, 51, 76, 15);
		cName.setText("Course Name:");
		
		cLvlTxt = new Text(shell, SWT.BORDER);
		cLvlTxt.setBounds(92, 136, 76, 21);
		
		Label cNum = new Label(shell, SWT.NONE);
		cNum.setBounds(10, 175, 94, 15);
		cNum.setText("Course Number:");
		
		cNumTxt = new Text(shell, SWT.BORDER);
		cNumTxt.setBounds(110, 172, 76, 21);
		
		Label hours = new Label(shell, SWT.NONE);
		hours.setBounds(10, 214, 94, 15);
		hours.setText("Semester Hours:");
		
		hoursTxt = new Text(shell, SWT.BORDER);
		hoursTxt.setBounds(110, 214, 76, 21);
		
		Label lblCourse = new Label(shell, SWT.NONE);
		lblCourse.setBounds(92, 10, 146, 25);
		lblCourse.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		lblCourse.setText("Add Course Info");
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.setBounds(10, 252, 75, 25);
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
		btnSub.setBounds(246, 252, 75, 25);
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
		btnSub.setText("Submit");

	}

}
