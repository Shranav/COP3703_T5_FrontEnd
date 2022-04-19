import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

public class jeff {

	protected Shell shell;
	private Text NTxt;
	private Text fNameTxt;
	private Text midTxt;
	private Text lNameTxt;
	private Text birthTxt;
	private Text ssnTxt;
	private Text cpnTxt;
	private Text ppnTxt;
	private Text sClassTxt;
	private Text DegreeTxt;
	private Text cAddressTxt;
	private Text stAddressTxt;
	private Text cityTxt;
	private Text stateTxt;
	private Text zipTxt;
	private Button maleButton;
	private Button femaleButton;
	private Button otherbutton;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			jeff window = new jeff();
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
	
	public static void openStudent() {
		
		try {
			jeff window = new jeff();
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
		shell.setSize(644, 501);
		shell.setText("Student");
		
		Label nNum = new Label(shell, SWT.NONE);
		nNum.setBounds(10, 60, 98, 15);
		nNum.setText("Student Nnumber:");
		
		Label fName = new Label(shell, SWT.NONE);
		fName.setBounds(212, 60, 66, 15);
		fName.setText(" First Name:");
		
		Label midInitial = new Label(shell, SWT.NONE);
		midInitial.setText("Mid Initial:");
		midInitial.setBounds(375, 60, 55, 15);
		
		Label lName = new Label(shell, SWT.NONE);
		lName.setBounds(478, 60, 61, 15);
		lName.setText("Last Name:");
		
		Label birth = new Label(shell, SWT.NONE);
		birth.setAlignment(SWT.CENTER);
		birth.setBounds(10, 99, 83, 15);
		birth.setText("Date of Birth:");
		
		Label sex = new Label(shell, SWT.NONE);
		sex.setAlignment(SWT.CENTER);
		sex.setText("Sex:");
		sex.setBounds(10, 296, 55, 15);
		
		Label ssn = new Label(shell, SWT.NONE);
		ssn.setAlignment(SWT.CENTER);
		ssn.setText("SSN:");
		ssn.setBounds(200, 99, 40, 15);
		
		Label cpn = new Label(shell, SWT.NONE);
		cpn.setBounds(10, 138, 129, 15);
		cpn.setText("Current Phone Number:");
		
		Label degree = new Label(shell, SWT.NONE);
		degree.setAlignment(SWT.CENTER);
		degree.setBounds(129, 340, 55, 15);
		degree.setText("Degree:");
		
		Label sClass = new Label(shell, SWT.NONE);
		sClass.setAlignment(SWT.CENTER);
		sClass.setText("Class:");
		sClass.setBounds(129, 296, 40, 15);
		
		Label ppn = new Label(shell, SWT.NONE);
		ppn.setBounds(258, 138, 148, 15);
		ppn.setText("Permanent Phone Number:");
		
		NTxt = new Text(shell, SWT.BORDER);
		NTxt.setBounds(114, 57, 76, 21);
		
		fNameTxt = new Text(shell, SWT.BORDER);
		fNameTxt.setBounds(284, 57, 76, 21);
		
		midTxt = new Text(shell, SWT.BORDER);
		midTxt.setBounds(436, 57, 24, 21);
		
		lNameTxt = new Text(shell, SWT.BORDER);
		lNameTxt.setBounds(545, 57, 76, 21);
		
		birthTxt = new Text(shell, SWT.BORDER);
		birthTxt.setBounds(99, 96, 76, 21);
		
		maleButton = new Button(shell, SWT.RADIO);
		maleButton.setBounds(10, 317, 46, 16);
		maleButton.setText("Male");
		
		femaleButton = new Button(shell, SWT.RADIO);
		femaleButton.setBounds(10, 339, 55, 16);
		femaleButton.setText("Female");
		
		ssnTxt = new Text(shell, SWT.BORDER);
		ssnTxt.setBounds(246, 96, 98, 21);
		
		cpnTxt = new Text(shell, SWT.BORDER);
		cpnTxt.setBounds(145, 135, 76, 21);
		
		ppnTxt = new Text(shell, SWT.BORDER);
		ppnTxt.setText("");
		ppnTxt.setBounds(412, 135, 76, 21);
		
		sClassTxt = new Text(shell, SWT.BORDER);
		sClassTxt.setBounds(175, 293, 76, 21);
		
		DegreeTxt = new Text(shell, SWT.BORDER);
		DegreeTxt.setText("");
		DegreeTxt.setBounds(184, 337, 76, 21);
		
		Label cAddress = new Label(shell, SWT.NONE);
		cAddress.setBounds(10, 175, 90, 15);
		cAddress.setText("Current Address:");
		
		cAddressTxt = new Text(shell, SWT.BORDER);
		cAddressTxt.setBounds(108, 172, 76, 21);
		
		Label pAddress = new Label(shell, SWT.NONE);
		pAddress.setBounds(10, 213, 106, 15);
		pAddress.setText("Permanent Address:");
		
		Label zip = new Label(shell, SWT.NONE);
		zip.setText("Zip Code:");
		zip.setBounds(484, 245, 55, 15);
		
		stAddressTxt = new Text(shell, SWT.BORDER);
		stAddressTxt.setBounds(99, 242, 91, 21);
		
		Label city = new Label(shell, SWT.NONE);
		city.setBounds(200, 245, 24, 15);
		city.setText("City:");
		
		cityTxt = new Text(shell, SWT.BORDER);
		cityTxt.setBounds(230, 242, 90, 21);
		
		Label state = new Label(shell, SWT.NONE);
		state.setBounds(338, 245, 32, 15);
		state.setText("State:");
		
		stateTxt = new Text(shell, SWT.BORDER);
		stateTxt.setBounds(375, 242, 76, 21);
		
		Label stAddress = new Label(shell, SWT.NONE);
		stAddress.setBounds(10, 245, 85, 15);
		stAddress.setText("Street Address:");
		
		zipTxt = new Text(shell, SWT.BORDER);
		zipTxt.setBounds(545, 242, 76, 21);
		
		otherbutton = new Button(shell, SWT.RADIO);
		otherbutton.setBounds(10, 361, 55, 16);
		otherbutton.setText("Other");
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		
				// Back to menu and close current one.
				shell.close();
				menuScreen.openMenu();
			}
		});
		btnBack.setBounds(10, 425, 75, 25);
		btnBack.setText("Back");
		
		Button btnSub = new Button(shell, SWT.NONE);
		btnSub.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		
				// Submit info and return back to menu next screen and close current one.
				shell.close();
				menuScreen.openMenu();
			}
		});
		btnSub.setBounds(546, 425, 75, 25);
		btnSub.setText("Submit");
		
		Label lblStudent = new Label(shell, SWT.NONE);
		lblStudent.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		lblStudent.setBounds(230, 10, 160, 25);
		lblStudent.setText("Add Student Info");

	}
}
