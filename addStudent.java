import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

public class addStudent {

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
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			addStudent window = new addStudent();
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
			addStudent window = new addStudent();
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
		birthLbl.setBounds(10, 99, 174, 15);
		birthLbl.setText("Date of Birth (MM/DD/YYYY):");
		
		Label sexLbl = new Label(shell, SWT.NONE);
		sexLbl.setAlignment(SWT.CENTER);
		sexLbl.setText("Sex:");
		sexLbl.setBounds(10, 296, 55, 15);
		
		Label ssnLbl = new Label(shell, SWT.NONE);
		ssnLbl.setAlignment(SWT.CENTER);
		ssnLbl.setText("SSN:");
		ssnLbl.setBounds(266, 99, 40, 15);
		
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
		birthTxt.setBounds(184, 96, 76, 21);
		
		maleBtn = new Button(shell, SWT.RADIO);
		maleBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		maleBtn.setBounds(10, 317, 46, 16);
		maleBtn.setText("Male");
		
		femaleBtn = new Button(shell, SWT.RADIO);
		femaleBtn.setBounds(10, 339, 55, 16);
		femaleBtn.setText("Female");
		
		ssnTxt = new Text(shell, SWT.BORDER);
		ssnTxt.setBounds(308, 96, 98, 21);
		
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
				
				String nNum = nNumTxt.getText();
				String fName = fNameTxt.getText();
				String mid = midTxt.getText();
				String lName = lNameTxt.getText();
				String birth = birthTxt.getText();
				String ssn = ssnTxt.getText();
				String cpn = cpnTxt.getText();
				String ppn = ppnTxt.getText();
				String sClass = sClassTxt.getText();
				String degree = degreeTxt.getText();
				String cAddress = cAddressTxt.getText();
				String stAddress = stAddressTxt.getText();
				String city = cityTxt.getText();
				String state = stateTxt.getText();
				String zip = zipTxt.getText();
				//String sex = btnSex;
				
				if (!nNum.isBlank() && !fName.isBlank() && !mid.isBlank() && !lName.isBlank() && !birth.isBlank() && !ssn.isBlank() && !cpn.isBlank() && !ppn.isBlank() && !sClass.isBlank() && !degree.isBlank() && !cAddress.isBlank() && !stAddress.isBlank() && !city.isBlank() && !state.isBlank() && !zip.isBlank()) {
					if (nNum.matches("^[Nn][0-9]+")) {
						if (fName.matches("")) {
							if (mid.matches("")) {
								if (lName.matches("")) {
									if(birth.matches("")) {
										if(ssn.matches("[0-9]{9}")) {
											if(cpn.matches("")) {
												if(ppn.matches("")) {
													if(sClass.matches("")) {
														if(degree.matches("")) {
															if(cAddress.matches("")) {
																if(stAddress.matches("")) {
																	if(city.matches("")) {
																		if(state.matches("")) {
																			if(zip.matches("")) {
																				int Ssn = Integer.parseInt(ssn);
																				int z = Integer.parseInt(zip);
									
																				//make sql call
																				jdbcHandler sqlconn = new jdbcHandler(loginScreen.username, loginScreen.password);
																				try {
																					// reminder: add sex later on
																					sqlconn.insertStudent(fName, lName, mid, Ssn, birth, sClass, degree, nNum, cpn, ppn, cAddress, stAddress, city, state, z);
																					enrollStudent.createMsgBox(shell, "Successful", "The entry was successfully updated.");
																					nNumTxt.setText("");
																					fNameTxt.setText("");
																					midTxt.setText("");
																					lNameTxt.setText("");
																					birthTxt.setText("");
																					ssnTxt.setText("");
																					cpnTxt.setText("");
																					ppnTxt.setText("");
																					sClassTxt.setText("");
																					degreeTxt.setText("");
																					cAddressTxt.setText("");
																					stAddressTxt.setText("");
																					cityTxt.setText("");
																					stateTxt.setText("");
																					zipTxt.setText("");
																				}catch (SQLException e1) {
																					// TODO Auto-generated catch block
																					e1.printStackTrace();
																					enrollStudent.createMsgBox(shell, "Error", "There was an error with the update. Please try again.");
																				}
																				
																			}else {
																				enrollStudent.createMsgBox(shell, "Invalid", "Please enter a valid Zip Code.");
																				zipTxt.setText("");
																			}
																			
																		}else {
																			enrollStudent.createMsgBox(shell, "Invalid", "Please enter a valid State.");
																			stateTxt.setText("");
																		}
																		
																	}else {
																		enrollStudent.createMsgBox(shell, "Invalid", "Please enter a valid City.");
																		cityTxt.setText("");
																	}
																	
																}else {
																	enrollStudent.createMsgBox(shell, "Invalid", "Please enter a valid Street-Address.");
																	stAddressTxt.setText("");
																}
																
															}else {
																enrollStudent.createMsgBox(shell, "Invalid", "Please enter a valid Current Address.");
																cAddressTxt.setText("");
															}
															
														}else {
															enrollStudent.createMsgBox(shell, "Invalid", "Please enter a valid Degree.");
															degreeTxt.setText("");
														}
														
													}else {
														enrollStudent.createMsgBox(shell, "Invalid", "Please enter a valid Class.");
														sClassTxt.setText("");
													}
													
												}else {
													enrollStudent.createMsgBox(shell, "Invalid", "Please enter a valid Permanent Phone Number.");
													ppnTxt.setText("");
												}
												
											}else {
												enrollStudent.createMsgBox(shell, "Invalid", "Please enter a valid Current Phone Number.");
												cpnTxt.setText("");
											}
											
										}
										else {
											enrollStudent.createMsgBox(shell, "Invalid", "Please enter a valid Social Security Number.");
											ssnTxt.setText("");
										}
										
									}else {
										enrollStudent.createMsgBox(shell, "Invalid", "Please enter a valid Birth-Date.");
										birthTxt.setText("");
									}
									
								}else {
									enrollStudent.createMsgBox(shell, "Invalid", "Please enter a valid Last Name.");
									lNameTxt.setText("");
								}
							
							} else {
								enrollStudent.createMsgBox(shell, "Invalid", "Please enter a valid middle-Initial.");
								midTxt.setText("");
							}
						} else {
							enrollStudent.createMsgBox(shell, "Invalid", "Please enter a valid First Name.");
							fNameTxt.setText("");
						}
					} else {
						enrollStudent.createMsgBox(shell, "Invalid", "The Student nNumber you've entered does not seem to be in the correct format. Please fix this.");
						nNumTxt.setText("");
					}
				} else {
					enrollStudent.createMsgBox(shell, "Incorrect Values", "Please double check your values entered for either Student nNumber or the Course/Section.");
				}
		
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
