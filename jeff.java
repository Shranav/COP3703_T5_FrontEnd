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
	private Text nNumTxt;
	private Text fNameTxt;
	private Text midTxt;
	private Text lNameTxt;
	private Text birthTxt;
	private Text ssnTxt;
	private Text cpnTxt;
	private Text ppnTxt;
	private Text sClassTxt;
	private Text degreeTxt;
	private Text cAddressTxt;
	private Text stAddressTxt;
	private Text cityTxt;
	private Text stateTxt;
	private Text zipTxt;
	private Button maleBtn;
	private Button femaleBtn;
	private Button otherBtn;
	static String nNum;
	static String fName;
	static String mid;
	static String lName;
	static String birth;
	static String ssn;
	static String cpn; // Current Phone Number
	static String ppn; // Permanent Phone Number
	static String sClass;
	static String degree;
	static String cAddress; // Current Address
	static String stAddress; // Street Address
	static String city;
	static String state;
	static String zip;
	static String male;
	static String female;
	static String other;
	

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
		
		Label nNumLbl = new Label(shell, SWT.NONE);
		nNumLbl.setBounds(10, 60, 98, 15);
		nNumLbl.setText("Student Nnumber:");
		
		Label fNameLbl = new Label(shell, SWT.NONE);
		fNameLbl.setBounds(212, 60, 66, 15);
		fNameLbl.setText(" First Name:");
		
		Label midInitialLbl = new Label(shell, SWT.NONE);
		midInitialLbl.setText("Mid Initial:");
		midInitialLbl.setBounds(375, 60, 55, 15);
		
		Label lNameLbl = new Label(shell, SWT.NONE);
		lNameLbl.setBounds(478, 60, 61, 15);
		lNameLbl.setText("Last Name:");
		
		Label birthLbl = new Label(shell, SWT.NONE);
		birthLbl.setAlignment(SWT.CENTER);
		birthLbl.setBounds(10, 99, 83, 15);
		birthLbl.setText("Date of Birth:");
		
		Label sexLbl = new Label(shell, SWT.NONE);
		sexLbl.setAlignment(SWT.CENTER);
		sexLbl.setText("Sex:");
		sexLbl.setBounds(10, 296, 55, 15);
		
		Label ssnLbl = new Label(shell, SWT.NONE);
		ssnLbl.setAlignment(SWT.CENTER);
		ssnLbl.setText("SSN:");
		ssnLbl.setBounds(200, 99, 40, 15);
		
		Label cpnLbl = new Label(shell, SWT.NONE);
		cpnLbl.setBounds(10, 138, 129, 15);
		cpnLbl.setText("Current Phone Number:");
		
		Label degreeLbl = new Label(shell, SWT.NONE);
		degreeLbl.setAlignment(SWT.CENTER);
		degreeLbl.setBounds(129, 340, 55, 15);
		degreeLbl.setText("Degree:");
		
		Label sClassLbl = new Label(shell, SWT.NONE);
		sClassLbl.setAlignment(SWT.CENTER);
		sClassLbl.setText("Class:");
		sClassLbl.setBounds(129, 296, 40, 15);
		
		Label ppnLbl = new Label(shell, SWT.NONE);
		ppnLbl.setBounds(258, 138, 148, 15);
		ppnLbl.setText("Permanent Phone Number:");
		
		nNumTxt = new Text(shell, SWT.BORDER);
		nNumTxt.setBounds(114, 57, 76, 21);
		
		fNameTxt = new Text(shell, SWT.BORDER);
		fNameTxt.setBounds(284, 57, 76, 21);
		
		midTxt = new Text(shell, SWT.BORDER);
		midTxt.setBounds(436, 57, 24, 21);
		
		lNameTxt = new Text(shell, SWT.BORDER);
		lNameTxt.setBounds(545, 57, 76, 21);
		
		birthTxt = new Text(shell, SWT.BORDER);
		birthTxt.setBounds(99, 96, 76, 21);
		
		maleBtn = new Button(shell, SWT.RADIO);
		maleBtn.setBounds(10, 317, 46, 16);
		maleBtn.setText("Male");
		
		femaleBtn = new Button(shell, SWT.RADIO);
		femaleBtn.setBounds(10, 339, 55, 16);
		femaleBtn.setText("Female");
		
		ssnTxt = new Text(shell, SWT.BORDER);
		ssnTxt.setBounds(246, 96, 98, 21);
		
		cpnTxt = new Text(shell, SWT.BORDER);
		cpnTxt.setBounds(145, 135, 76, 21);
		
		ppnTxt = new Text(shell, SWT.BORDER);
		ppnTxt.setText("");
		ppnTxt.setBounds(412, 135, 76, 21);
		
		sClassTxt = new Text(shell, SWT.BORDER);
		sClassTxt.setBounds(175, 293, 76, 21);
		
		degreeTxt = new Text(shell, SWT.BORDER);
		degreeTxt.setText("");
		degreeTxt.setBounds(184, 337, 76, 21);
		
		Label cAddressLbl = new Label(shell, SWT.NONE);
		cAddressLbl.setBounds(10, 175, 90, 15);
		cAddressLbl.setText("Current Address:");
		
		cAddressTxt = new Text(shell, SWT.BORDER);
		cAddressTxt.setBounds(108, 172, 76, 21);
		
		Label pAddressLbl = new Label(shell, SWT.NONE);
		pAddressLbl.setBounds(10, 213, 106, 15);
		pAddressLbl.setText("Permanent Address:");
		
		Label zipLbl = new Label(shell, SWT.NONE);
		zipLbl.setText("Zip Code:");
		zipLbl.setBounds(484, 245, 55, 15);
		
		stAddressTxt = new Text(shell, SWT.BORDER);
		stAddressTxt.setBounds(99, 242, 91, 21);
		
		Label cityLbl = new Label(shell, SWT.NONE);
		cityLbl.setBounds(200, 245, 24, 15);
		cityLbl.setText("City:");
		
		cityTxt = new Text(shell, SWT.BORDER);
		cityTxt.setBounds(230, 242, 90, 21);
		
		Label stateLbl = new Label(shell, SWT.NONE);
		stateLbl.setBounds(338, 245, 32, 15);
		stateLbl.setText("State:");
		
		stateTxt = new Text(shell, SWT.BORDER);
		stateTxt.setBounds(375, 242, 76, 21);
		
		Label stAddressLnl = new Label(shell, SWT.NONE);
		stAddressLnl.setBounds(10, 245, 85, 15);
		stAddressLnl.setText("Street Address:");
		
		zipTxt = new Text(shell, SWT.BORDER);
		zipTxt.setBounds(545, 242, 76, 21);
		
		otherBtn = new Button(shell, SWT.RADIO);
		otherBtn.setBounds(10, 361, 55, 16);
		otherBtn.setText("Other");
		
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
				
				nNum = nNumTxt.getText();
				fName = fNameTxt.getText();
				mid = midTxt.getText();
				lName = lNameTxt.getText();
				birth = birthTxt.getText();
				ssn = ssnTxt.getText();
				cpn = cpnTxt.getText();
				ppn = ppnTxt.getText();
				sClass = sClassTxt.getText();
				degree = degreeTxt.getText();
				cAddress = cAddressTxt.getText();
				stAddress = stAddressTxt.getText();
				city = cityTxt.getText();
				state = stateTxt.getText();
				zip = zipTxt.getText();
				//male = maleTxt.getText();
				//female = femaleTxt.getText();
				//other = otherTxt.getText();
		
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
