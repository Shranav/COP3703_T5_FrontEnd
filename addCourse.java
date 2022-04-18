import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

public class addCourse {

	protected Shell cWindow;
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
		cWindow.open();
		cWindow.layout();
		while (!cWindow.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		cWindow = new Shell();
		cWindow.setSize(343, 327);
		cWindow.setText("Course");
		
		Label cLvl = new Label(cWindow, SWT.NONE);
		cLvl.setBounds(10, 139, 76, 15);
		cLvl.setText("Course Level:");
		
		cNameTxt = new Text(cWindow, SWT.BORDER);
		cNameTxt.setBounds(92, 48, 76, 21);
		
		Label description = new Label(cWindow, SWT.NONE);
		description.setBounds(10, 94, 68, 15);
		description.setText("Description:");
		
		descriptionTxt = new Text(cWindow, SWT.BORDER);
		descriptionTxt.setBounds(84, 91, 76, 21);
		
		Label cName = new Label(cWindow, SWT.NONE);
		cName.setBounds(10, 51, 76, 15);
		cName.setText("Course Name:");
		
		cLvlTxt = new Text(cWindow, SWT.BORDER);
		cLvlTxt.setBounds(92, 136, 76, 21);
		
		Label cNum = new Label(cWindow, SWT.NONE);
		cNum.setBounds(10, 175, 94, 15);
		cNum.setText("Course Number:");
		
		cNumTxt = new Text(cWindow, SWT.BORDER);
		cNumTxt.setBounds(110, 172, 76, 21);
		
		Label hours = new Label(cWindow, SWT.NONE);
		hours.setText("Semester Hours:");
		hours.setBounds(10, 214, 94, 15);
		
		hoursTxt = new Text(cWindow, SWT.BORDER);
		hoursTxt.setBounds(110, 214, 76, 21);
		
		Label lblCourse = new Label(cWindow, SWT.NONE);
		lblCourse.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblCourse.setBounds(103, 10, 122, 21);
		lblCourse.setText("Add Course Info");
		
		Button backButton = new Button(cWindow, SWT.NONE);
		backButton.setBounds(10, 252, 75, 25);
		backButton.setText("Back");
		
		Button subButton = new Button(cWindow, SWT.NONE);
		subButton.setBounds(246, 252, 75, 25);
		subButton.setText("Submit");

	}

}
