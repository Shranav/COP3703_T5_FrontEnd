import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;

public class findCourse {

	protected Shell cFindWindow;
	private Text findCourse;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			findCourse window = new findCourse();
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
		cFindWindow.open();
		cFindWindow.layout();
		while (!cFindWindow.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		cFindWindow = new Shell();
		cFindWindow.setSize(450, 300);
		cFindWindow.setText("Courses Offered");
		
		Label lblCourseOffered = new Label(cFindWindow, SWT.NONE);
		lblCourseOffered.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblCourseOffered.setBounds(136, 10, 158, 21);
		lblCourseOffered.setText("Find Course Offered");
		
		findCourse = new Text(cFindWindow, SWT.BORDER);
		findCourse.setBounds(190, 37, 136, 21);
		
		Label lblFindCourse = new Label(cFindWindow, SWT.NONE);
		lblFindCourse.setBounds(10, 37, 174, 15);
		lblFindCourse.setText("Insert department name or code:");
		
		List courseList = new List(cFindWindow, SWT.BORDER);
		courseList.setBounds(97, 73, 250, 153);
		
		Button backButton = new Button(cFindWindow, SWT.NONE);
		backButton.setBounds(10, 228, 75, 25);
		backButton.setText("Back");

	}
}
