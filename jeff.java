import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;

public class jeff {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;
	private Text text_10;
	private Text text_11;
	private Text text_12;
	private Text text_13;
	private Text text_14;

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

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(822, 760);
		shell.setText("SWT Application");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 21, 61, 15);
		lblNewLabel.setText("Student ID:");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(10, 62, 66, 15);
		lblNewLabel_1.setText(" First Name:");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setText("Mid Initial:");
		lblNewLabel_2.setBounds(10, 100, 55, 15);
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setBounds(10, 150, 61, 15);
		lblNewLabel_3.setText("Last Name:");
		
		Label lblSsdf = new Label(shell, SWT.NONE);
		lblSsdf.setAlignment(SWT.CENTER);
		lblSsdf.setBounds(10, 200, 83, 15);
		lblSsdf.setText("Date of Birth:");
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setAlignment(SWT.CENTER);
		lblNewLabel_4.setText("Sex:");
		lblNewLabel_4.setBounds(16, 231, 55, 15);
		
		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setAlignment(SWT.CENTER);
		lblNewLabel_5.setText("SSN:");
		lblNewLabel_5.setBounds(16, 329, 40, 15);
		
		Label lblNewLabel_6 = new Label(shell, SWT.NONE);
		lblNewLabel_6.setBounds(10, 365, 129, 15);
		lblNewLabel_6.setText("Current Phone Number:");
		
		Label lblNewLabel_7 = new Label(shell, SWT.NONE);
		lblNewLabel_7.setAlignment(SWT.CENTER);
		lblNewLabel_7.setBounds(10, 500, 55, 15);
		lblNewLabel_7.setText("Degree:");
		
		Label lblNewLabel_8 = new Label(shell, SWT.NONE);
		lblNewLabel_8.setAlignment(SWT.CENTER);
		lblNewLabel_8.setText("Class:");
		lblNewLabel_8.setBounds(10, 450, 46, 15);
		
		Label lblNewLabel_9 = new Label(shell, SWT.NONE);
		lblNewLabel_9.setBounds(10, 400, 148, 15);
		lblNewLabel_9.setText("Permanent Phone Number:");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(77, 18, 76, 21);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(82, 59, 76, 21);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(71, 97, 76, 21);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(82, 147, 76, 21);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(99, 197, 76, 21);
		
		Button btnRadioButton = new Button(shell, SWT.RADIO);
		btnRadioButton.setBounds(26, 250, 90, 16);
		btnRadioButton.setText("Male");
		
		Button btnRadioButton_1 = new Button(shell, SWT.RADIO);
		btnRadioButton_1.setBounds(26, 270, 90, 16);
		btnRadioButton_1.setText("Female");
		
		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBounds(60, 326, 76, 21);
		
		text_6 = new Text(shell, SWT.BORDER);
		text_6.setBounds(145, 362, 76, 21);
		
		text_7 = new Text(shell, SWT.BORDER);
		text_7.setText("");
		text_7.setBounds(164, 397, 76, 21);
		
		text_8 = new Text(shell, SWT.BORDER);
		text_8.setBounds(63, 447, 76, 21);
		
		text_9 = new Text(shell, SWT.BORDER);
		text_9.setText("");
		text_9.setBounds(71, 497, 76, 21);
		
		Label lblNewLabel_10 = new Label(shell, SWT.NONE);
		lblNewLabel_10.setBounds(10, 570, 90, 15);
		lblNewLabel_10.setText("Current Address:");
		
		text_10 = new Text(shell, SWT.BORDER);
		text_10.setBounds(106, 567, 76, 21);
		
		Label lblNewLabel_11 = new Label(shell, SWT.NONE);
		lblNewLabel_11.setBounds(10, 634, 106, 15);
		lblNewLabel_11.setText("Permanent Address:");
		
		Label lblNewLabel_12 = new Label(shell, SWT.NONE);
		lblNewLabel_12.setText("Zip Code:");
		lblNewLabel_12.setBounds(481, 657, 55, 15);
		
		text_11 = new Text(shell, SWT.BORDER);
		text_11.setBounds(99, 654, 76, 21);
		
		Label lblNewLabel_13 = new Label(shell, SWT.NONE);
		lblNewLabel_13.setBounds(208, 657, 24, 15);
		lblNewLabel_13.setText("City:");
		
		text_12 = new Text(shell, SWT.BORDER);
		text_12.setBounds(238, 654, 76, 21);
		
		Label lblNewLabel_14 = new Label(shell, SWT.NONE);
		lblNewLabel_14.setBounds(335, 657, 40, 15);
		lblNewLabel_14.setText("State:");
		
		text_13 = new Text(shell, SWT.BORDER);
		text_13.setBounds(376, 654, 76, 21);
		
		Label lblNewLabel_15 = new Label(shell, SWT.NONE);
		lblNewLabel_15.setBounds(10, 660, 85, 15);
		lblNewLabel_15.setText("Street Address:");
		
		text_14 = new Text(shell, SWT.BORDER);
		text_14.setBounds(542, 654, 76, 21);
		
		Button btnRadioButton_2 = new Button(shell, SWT.RADIO);
		btnRadioButton_2.setBounds(26, 290, 90, 16);
		btnRadioButton_2.setText("Other");

	}
}
