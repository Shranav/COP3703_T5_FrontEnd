import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.ScrolledComposite;

public class findCourse {

	protected Shell shell;
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	public static void openCourseOffered() {
		
		try {
			findCourse window = new findCourse();
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
		shell.setSize(450, 300);
		shell.setText("Courses Offered");
		
		Label lblCourseOffered = new Label(shell, SWT.NONE);
		lblCourseOffered.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		lblCourseOffered.setBounds(112, 10, 186, 21);
		lblCourseOffered.setText("Find Course Offered");
		
		findCourse = new Text(shell, SWT.BORDER);
		findCourse.setBounds(190, 37, 136, 21);
		
		Label lblFindCourse = new Label(shell, SWT.NONE);
		lblFindCourse.setBounds(10, 37, 174, 15);
		lblFindCourse.setText("Insert department name or code:");
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setBounds(97, 73, 250, 153);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		List courseList = new List(scrolledComposite, SWT.BORDER);
		scrolledComposite.setContent(courseList);
		scrolledComposite.setMinSize(courseList.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		
				// Back to menu and close current one.
				shell.close();
				menuScreen.openMenu();
			}
		});
		btnBack.setBounds(10, 228, 75, 25);
		btnBack.setText("Back");

	}
}
