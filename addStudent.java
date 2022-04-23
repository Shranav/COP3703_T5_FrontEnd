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
	private Text sexTxt;
	

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
		
		Label lblNNum = new Label(shell, SWT.NONE);
		lblNNum.setBounds(10, 60, 98, 15);
		lblNNum.setText("Student Nnumber:");
		
		Label lblFName = new Label(shell, SWT.NONE);
		lblFName.setBounds(212, 60, 66, 15);
		lblFName.setText(" First Name:");
		
		Label lblMidInitial = new Label(shell, SWT.NONE);
		lblMidInitial.setText("Mid Initial:");
		lblMidInitial.setBounds(375, 60, 55, 15);
		
		Label lblLName = new Label(shell, SWT.NONE);
		lblLName.setBounds(478, 60, 61, 15);
		lblLName.setText("Last Name:");
		
		Label lblBirth = new Label(shell, SWT.NONE);
		lblBirth.setAlignment(SWT.CENTER);
		lblBirth.setBounds(10, 99, 174, 15);
		lblBirth.setText("Date of Birth (MM-DD-YYYY):");
		
		Label lblSex = new Label(shell, SWT.NONE);
		lblSex.setAlignment(SWT.CENTER);
		lblSex.setText("Sex (M, F, or O):");
		lblSex.setBounds(255, 223, 98, 15);
		
		Label lblSsn = new Label(shell, SWT.NONE);
		lblSsn.setAlignment(SWT.CENTER);
		lblSsn.setText("SSN (AAA-GG-SSSS):");
		lblSsn.setBounds(266, 99, 119, 15);
		
		Label lblCpn = new Label(shell, SWT.NONE);
		lblCpn.setBounds(10, 138, 218, 15);
		lblCpn.setText("Current Phone Number (XXX-XXX-XXXX):");
		
		Label lblDegree = new Label(shell, SWT.NONE);
		lblDegree.setAlignment(SWT.CENTER);
		lblDegree.setBounds(167, 340, 55, 15);
		lblDegree.setText("Degree:");
		
		Label lblSClass = new Label(shell, SWT.NONE);
		lblSClass.setAlignment(SWT.CENTER);
		lblSClass.setText("Class:");
		lblSClass.setBounds(10, 340, 40, 15);
		
		Label lblPpn = new Label(shell, SWT.NONE);
		lblPpn.setBounds(10, 177, 241, 15);
		lblPpn.setText("Permanent Phone Number (XXX-XXX-XXXX):");
		
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
		
		ssnTxt = new Text(shell, SWT.BORDER);
		ssnTxt.setBounds(388, 96, 98, 21);
		
		cpnTxt = new Text(shell, SWT.BORDER);
		cpnTxt.setBounds(234, 135, 115, 21);
		
		ppnTxt = new Text(shell, SWT.BORDER);
		ppnTxt.setText("");
		ppnTxt.setBounds(255, 174, 115, 21);
		
		Label lblCAddress = new Label(shell, SWT.NONE);
		lblCAddress.setBounds(10, 223, 90, 15);
		lblCAddress.setText("Current Address:");
		
		cAddressTxt = new Text(shell, SWT.BORDER);
		cAddressTxt.setBounds(114, 220, 76, 21);
		
		sexTxt = new Text(shell, SWT.BORDER);
		sexTxt.setBounds(359, 220, 24, 21);
		
		Label pAddressLbl = new Label(shell, SWT.NONE);
		pAddressLbl.setBounds(10, 260, 106, 15);
		pAddressLbl.setText("Permanent Address:");
		
		Label lblZip = new Label(shell, SWT.NONE);
		lblZip.setText("Zip Code:");
		lblZip.setBounds(478, 296, 55, 15);
		
		stAddressTxt = new Text(shell, SWT.BORDER);
		stAddressTxt.setBounds(93, 293, 91, 21);
		
		Label lblCity = new Label(shell, SWT.NONE);
		lblCity.setBounds(204, 296, 24, 15);
		lblCity.setText("City:");
		
		cityTxt = new Text(shell, SWT.BORDER);
		cityTxt.setBounds(232, 293, 90, 21);
		
		Label lblState = new Label(shell, SWT.NONE);
		lblState.setBounds(338, 296, 32, 15);
		lblState.setText("State:");
		
		stateTxt = new Text(shell, SWT.BORDER);
		stateTxt.setBounds(375, 293, 85, 21);
		
		Label lblStAddress = new Label(shell, SWT.NONE);
		lblStAddress.setBounds(10, 296, 80, 15);
		lblStAddress.setText("Street Address:");
		
		zipTxt = new Text(shell, SWT.BORDER);
		zipTxt.setBounds(539, 293, 76, 21);
		
		sClassTxt = new Text(shell, SWT.BORDER);
		sClassTxt.setBounds(56, 337, 76, 21);
		
		degreeTxt = new Text(shell, SWT.BORDER);
		degreeTxt.setText("");
		degreeTxt.setBounds(228, 337, 76, 21);
		
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
				String sex =  sexTxt.getText();
				
				if (!nNum.isBlank() && !fName.isBlank() && !mid.isBlank() && !lName.isBlank() && !birth.isBlank() && !sex.isBlank() && !ssn.isBlank() && !cpn.isBlank() && !ppn.isBlank() && !sClass.isBlank() && !degree.isBlank() && !cAddress.isBlank() && !stAddress.isBlank() && !city.isBlank() && !state.isBlank() && !zip.isBlank()) {
					if (nNum.matches("^[Nn][0-9]+$")) {
						if (fName.matches("^[a-zA-z]+$")) {
							if (mid.matches("^[a-zA-z]{1}$")) {
								if (lName.matches("^[a-zA-z]+$")) {
									if(birth.matches("^[01][0-9]-[0-3][0-9]-[0-9]{4}$")) {
										if(ssn.matches("^[0-9]{3}-[0-9]{2}-[0-9]{4}$")) {
											if(cpn.matches("^[0-9]{3}-[0-9]{3}-[0-9]{4}$")) {
												if(ppn.matches("^[0-9]{3}-[0-9]{3}-[0-9]{4}$")) {
													if(sex.matches("^[M-MF-FO-O]$")) {
														//if(degree.matches("")) {
															//if(cAddress.matches("")) {
																//if(stAddress.matches("")) {
																	//if(city.matches("")) {
																		//if(state.matches("")) {
																			if(zip.matches("^[0-9]{5}$")) {
																				//int Ssn = Integer.parseInt(ssn);
																				int z = Integer.parseInt(zip);
									
																				//make sql call
																				jdbcHandler sqlconn = new jdbcHandler(loginScreen.username, loginScreen.password);
																				try {
																					// reminder: add sex later on
																					sqlconn.insertStudent(fName, lName, mid, ssn, birth, sex, sClass, degree, nNum, cpn, ppn, cAddress, stAddress, city, state, z);
																					enrollStudent.createMsgBox(shell, "Successful", "The entry was successfully updated.");
																					nNumTxt.setText("");
																					fNameTxt.setText("");
																					midTxt.setText("");
																					lNameTxt.setText("");
																					birthTxt.setText("");
																					sexTxt.setText("");
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
																			
																		//}else {
																			//enrollStudent.createMsgBox(shell, "Invalid", "Please enter a valid State.");
																			//stateTxt.setText("");
																		//}
																		
																	//}else {
																		//enrollStudent.createMsgBox(shell, "Invalid", "Please enter a valid City.");
																		//cityTxt.setText("");
																	//}
																	
																//}else {
																	//enrollStudent.createMsgBox(shell, "Invalid", "Please enter a valid Street-Address.");
																	//stAddressTxt.setText("");
																//}
																
															//}else {
																//enrollStudent.createMsgBox(shell, "Invalid", "Please enter a valid Current Address.");
																//cAddressTxt.setText("");
															//}
															
														//}else {
															//enrollStudent.createMsgBox(shell, "Invalid", "Please enter a valid Degree.");
															//degreeTxt.setText("");
														//}
														
													}else {
														enrollStudent.createMsgBox(shell, "Invalid", "Please enter a valid Sex.");
														sexTxt.setText("");
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
					enrollStudent.createMsgBox(shell, "Incorrect Values", "Please double check your values entered.");
				}
		
				// Submit info and return back to menu next screen and close current one.
				//shell.close();
				//menuScreen.openMenu();
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
