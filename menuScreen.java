import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

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
		
		Label lblAddItems_1 = new Label(shell, SWT.NONE);
		lblAddItems_1.setText("Add Items");
		lblAddItems_1.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		lblAddItems_1.setAlignment(SWT.CENTER);
		lblAddItems_1.setBounds(126, 104, 174, 25);

	}
}
