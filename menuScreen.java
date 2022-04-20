import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class menuScreen {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			menuScreen window = new menuScreen();
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
	
	public static void openMenu() {
		System.out.println(loginScreen.username);
		System.out.println(loginScreen.password);
		
		try {
			menuScreen window = new menuScreen();
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
		shell.setSize(450, 450);
		shell.setText("SWT Application");
		
		Label lblAddItems = new Label(shell, SWT.NONE);
		lblAddItems.setAlignment(SWT.CENTER);
		lblAddItems.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		lblAddItems.setBounds(126, 5, 174, 25);
		lblAddItems.setText("Add Items");
		
		Group group = new Group(shell, SWT.NONE);
		group.setBounds(10, 26, 412, 69);
		
		Button btnStudent = new Button(group, SWT.NONE);
		btnStudent.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		
				// Open next screen and close current one.
				shell.close();
				addStudent.openStudent();
			}
		});
		btnStudent.setBounds(8, 16, 94, 35);
		btnStudent.setText("Student");
		
		Button btnDepartment = new Button(group, SWT.NONE);
		btnDepartment.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		
				// Open next screen and close current one.
				shell.close();
				addDepartment.openDepartment();
			}
		});
		btnDepartment.setBounds(108, 16, 94, 35);
		btnDepartment.setText("Department");
		
		Button btnCourse = new Button(group, SWT.NONE);
		btnCourse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		
				// Open next screen and close current one.
				shell.close();
				addCourse.openCourse();
			}
		});
		btnCourse.setBounds(208, 16, 94, 35);
		btnCourse.setText("Course");
		
		Button btnSection = new Button(group, SWT.NONE);
		btnSection.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		
				// Open next screen and close current one.
				shell.close();
				addSection.openSection();
			}
		});
		btnSection.setBounds(308, 16, 94, 35);
		btnSection.setText("Course Section");
		
		Label lblDisplayItems = new Label(shell, SWT.NONE);
		lblDisplayItems.setText("Display Items");
		lblDisplayItems.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		lblDisplayItems.setAlignment(SWT.CENTER);
		lblDisplayItems.setBounds(126, 104, 174, 25);
		
		Group group_1 = new Group(shell, SWT.NONE);
		group_1.setBounds(10, 126, 412, 69);
		
		Button btnCourseOffered = new Button(group_1, SWT.NONE);
		btnCourseOffered.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		
				// Open next screen and close current one.
				shell.close();
				findCourse.openCourseOffered();
			}
		});
		btnCourseOffered.setBounds(243, 21, 97, 38);
		btnCourseOffered.setText("Courses Offered");
		
		Button btnGradeReport = new Button(group_1, SWT.NONE);
		btnGradeReport.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		
				// Open next screen and close current one.
				shell.close();
				findGradeReport.openGradeReport();
			}
		});
		btnGradeReport.setBounds(49, 21, 97, 38);
		btnGradeReport.setText("Grade Report");
		
		Label lblPerformActions = new Label(shell, SWT.NONE);
		lblPerformActions.setText("Perform Actions");
		lblPerformActions.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		lblPerformActions.setAlignment(SWT.CENTER);
		lblPerformActions.setBounds(126, 205, 174, 25);
		
		Group group_2 = new Group(shell, SWT.NONE);
		group_2.setBounds(10, 227, 412, 69);
		
		Button btnEnroll = new Button(group_2, SWT.NONE);
		btnEnroll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//close menu and open Enroll
				shell.close();
			//enrollStudent.openEnroll();
			}
		});
		btnEnroll.setBounds(50, 21, 97, 38);
		btnEnroll.setText("Enroll Student");
		
		Button btnGrade = new Button(group_2, SWT.NONE);
		btnGrade.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//close menu and open Grade
				shell.close();
			//gradeStudent.openGrade();
			}
		});
		btnGrade.setText("Enter a Grade");
		btnGrade.setBounds(242, 21, 97, 38);

	}
}
