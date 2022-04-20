import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
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
	private Text sectionNumTxt;
	private Text instructorTxt;
	private Text cNumTxt;
	static String semester;
	static String sYear;
	static String sectionNum;
	static String instructor;
	static String cNum;

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
		
		sectionNumTxt = new Text(shell, SWT.BORDER);
		sectionNumTxt.setBounds(105, 171, 76, 21);
		
		Label lblInstructor = new Label(shell, SWT.NONE);
		lblInstructor.setBounds(10, 217, 55, 15);
		lblInstructor.setText("Instructor:");
		
		instructorTxt = new Text(shell, SWT.BORDER);
		instructorTxt.setBounds(71, 214, 110, 21);
		
		Label lblCNum = new Label(shell, SWT.NONE);
		lblCNum.setBounds(10, 51, 89, 15);
		lblCNum.setText("Course Number:");
		
		cNumTxt = new Text(shell, SWT.BORDER);
		cNumTxt.setBounds(105, 48, 76, 21);
		
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
				
				semester = semTxt.getText();
				sYear = sYearTxt.getText();
				sectionNum = sectionNumTxt.getText();
				instructor = instructorTxt.getText();
				cNum = cNumTxt.getText();
				
				// Submit info and return back to menu next screen and close current one.
				shell.close();
				menuScreen.openMenu();
			}
		});
		btnSub.setBounds(238, 257, 75, 25);
		btnSub.setText("Sumbit");

	}
}
