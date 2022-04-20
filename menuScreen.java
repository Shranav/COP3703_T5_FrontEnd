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
		
		Label lblDisplayItems = new Label(shell, SWT.NONE);
		lblDisplayItems.setText("Display Items");
		lblDisplayItems.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		lblDisplayItems.setAlignment(SWT.CENTER);
		lblDisplayItems.setBounds(126, 104, 174, 25);
		
		Group group_1 = new Group(shell, SWT.NONE);
		group_1.setBounds(10, 126, 412, 69);
		
		Label lblPerformActions = new Label(shell, SWT.NONE);
		lblPerformActions.setText("Perform Actions");
		lblPerformActions.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		lblPerformActions.setAlignment(SWT.CENTER);
		lblPerformActions.setBounds(126, 205, 174, 25);
		
		Group group_1_1 = new Group(shell, SWT.NONE);
		group_1_1.setBounds(10, 227, 412, 69);
		
		Button btnEnroll = new Button(group_1_1, SWT.NONE);
		btnEnroll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				enrollStudent.openEnroll();
			}
		});
		btnEnroll.setBounds(42, 10, 97, 49);
		btnEnroll.setText("Enroll Student");

	}
}
