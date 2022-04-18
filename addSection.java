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

	protected Shell sWindow;
	private Text semTxt;
	private Text sYearTxt;
	private Text sectionNumTxt;
	private Text instructorTxt;
	private Text cNumTxt;

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
		sWindow.open();
		sWindow.layout();
		while (!sWindow.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		sWindow = new Shell();
		sWindow.setSize(333, 335);
		sWindow.setText("Section");
		
		Label lblSection = new Label(sWindow, SWT.NONE);
		lblSection.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblSection.setBounds(105, 10, 127, 21);
		lblSection.setText("Add Section Info");
		
		Label sem = new Label(sWindow, SWT.NONE);
		sem.setBounds(10, 89, 55, 15);
		sem.setText("Semester:");
		
		semTxt = new Text(sWindow, SWT.BORDER);
		semTxt.setText("");
		semTxt.setBounds(71, 86, 76, 21);
		
		Label sYear = new Label(sWindow, SWT.NONE);
		sYear.setBounds(10, 130, 30, 15);
		sYear.setText("Year:");
		
		sYearTxt = new Text(sWindow, SWT.BORDER);
		sYearTxt.setBounds(46, 127, 76, 21);
		
		Label sectionNum = new Label(sWindow, SWT.NONE);
		sectionNum.setBounds(10, 174, 89, 15);
		sectionNum.setText("Section Number:");
		
		sectionNumTxt = new Text(sWindow, SWT.BORDER);
		sectionNumTxt.setBounds(105, 171, 76, 21);
		
		Label instructor = new Label(sWindow, SWT.NONE);
		instructor.setBounds(10, 217, 55, 15);
		instructor.setText("Instructor:");
		
		instructorTxt = new Text(sWindow, SWT.BORDER);
		instructorTxt.setBounds(71, 214, 110, 21);
		
		Label cNum = new Label(sWindow, SWT.NONE);
		cNum.setBounds(10, 51, 89, 15);
		cNum.setText("Course Number:");
		
		cNumTxt = new Text(sWindow, SWT.BORDER);
		cNumTxt.setBounds(105, 48, 76, 21);
		
		Button backButton = new Button(sWindow, SWT.NONE);
		backButton.setBounds(10, 257, 75, 25);
		backButton.setText("Back");
		
		Button subButton = new Button(sWindow, SWT.NONE);
		subButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		subButton.setBounds(238, 257, 75, 25);
		subButton.setText("Sumbit");

	}
}
