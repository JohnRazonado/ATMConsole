import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class atmSystem {
 public static void main(String[] args) throws IOException, InterruptedException{
		 /* TODO
		  * MAIN Tasks
		  * DONE	Sectioning of the system
		  * DONE	Account of user
		  * DONE	User input interface
		  * DONE	Deposit money
		  * DONE	Withdraw transfer
		  * 	Transfer funds
		  * DONE	Check account balance
		  * 	End Session
		  * DONE	Enter Selection
		  * 	Create and Account (optional) Or have it fix
		  * Cleaning of the Code TODO
		  * 	Arranging of the code (functioning adding classes)
		  * 	Making it pretty (adding color to text, simple animation if possible)
		  * 	Making it dynamic (acknowledging the resolution of the command line and font size) Possible but optional
		  * */
		 
		 // There could probably a built-in account of some sort here.
		 //   1: Savings  and  2: Checking	account
			int min=1;
			int max=5000;
	 
		 double savBal = (int)Math.floor(Math.random()*(max-min+1)+min);		// Savings account balance
		 double savRate = 0.25;		// Savings interest rate 
		 
		 double checkBal = (int)Math.floor(Math.random()*(max-min+1)+min);	// Checking account balance
		 double checkRate = 0.00; 	// Checking interest rate
		 // The interest rate is based on the common interest rate of Philippine Banks
		 
		 
		 BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		 boolean transact = true; // the main loop bool
		 
		 //This part sets up the peso format
		 NumberFormat peso = NumberFormat.getCurrencyInstance(new Locale("en", "PH"));
		 peso.setMaximumFractionDigits(2);
//		 peso.setCurrency(Currency.getInstance("PHP"));
		 
		 
		 // This clear the CMD console but don't work on different IDEs
		 // Remove if irresponsive
		 System.out.print("\033[H\033[2J");  
		 System.out.flush();  
		 
		 while (transact) {
			 System.out.print("\n\nATM Main Menu:\n"
					 + "\t1: Withdraw Money \n"
					 + "\t2: Deposit Money \n"
					 + "\t3: Transfer Funds \n"
					 + "\t4: Check Account Balance\n"
					 + "\t5: End Session\n \n"
					 + "Enter selection: ");
			 int select = Integer.parseInt(input.readLine());
			 
			// This clear the CMD console but don't work on different IDEs
			// Remove if irresponsive
			 System.out.print("\033[H\033[2J");  
			 System.out.flush();  
			 
			 
			 switch (select) {
				case 1: { //Withdraw Function here
					System.out.println("\n\nWITHDRAW");
					System.out.print("Select Account:\n\t1: Savings\n\t2: Checking\n Enter selection: ");
					select = Integer.parseInt(input.readLine());
					if(select == 1) { // Savings Account
						System.out.print("Current Balance " + peso.format(savBal) + "\n"
								+ "Enter the amount to withdraw: ");
						double withdraw = Double.parseDouble(input.readLine());
						double tempHolder = savBal;
						tempHolder -= withdraw;
						if(tempHolder > 0) {
							savBal -= withdraw;
							System.out.println("\n\n New Savings Balance: " + peso.format(savBal));
						} else {
							System.err.println("\n Insufficient Balance");
						}
				
					} else if (select == 2) { // Checking Account
						System.out.print("\n\nCurrent Balance " + peso.format(checkBal) + "\n"
								+ "Enter the amount to withdraw: ");
						double withdraw = Double.parseDouble(input.readLine());
						double tempHolder = checkBal;
						tempHolder -= withdraw;
						if(tempHolder > 0) {
							checkBal -= withdraw;
							System.out.println("\n\nNew Checking Balance: " + peso.format(checkBal));
						} else {
							System.err.println("\nInsufficient Balance");
						}
					} else {
						System.err.println("\nChoose only based on the selection and its corresponding number");
					}
					break;
				}
				
				
				case 2: { //Deposit Function here
					System.out.println("\n\nDEPOSIT");
					System.out.print("\nSelect Account:\n\t1: Savings\n\t2: Checking\n Enter selection: ");
					select = Integer.parseInt(input.readLine());
					if (select == 1) {
						System.out.print("\n\nCurrent Balance " + peso.format(savBal) + "\n"
								+ "Enter the amount to deposit: ");
						double deposit = Double.parseDouble(input.readLine());
						savBal += deposit;
						System.out.println("\n\nNew Savings Balance: " + peso.format(savBal));
					} else if (select == 2) {
						System.out.print("\n\nCurrent Balance " + peso.format(checkBal) + "\n"
								+ "Enter the amount to deposit: ");
						double deposit = Double.parseDouble(input.readLine());
						checkBal += deposit;
						System.out.println("\n\nNew Checking Balance: " + peso.format(checkBal));
					} else {
						System.err.println("\nChoose only based on the selection and its corresponding number");
					}
					break;
				}
				
				
				case 3: { //Transfer from Savings to Checking and Vice versa
					System.out.println("\n\nTRANSFER");
					System.out.print("\nSelect Account:\n\t1: Savings\n\t2: Checking\n Enter selection: ");
					select = Integer.parseInt(input.readLine());
					if (select == 1) {
						
					} else if (select == 2) {
						
					} else {
						System.err.println("\nChoose only based on the selection and its corresponding number");
					}
					
					break;
				}
				case 4: { //Balance Check Function here
					System.out.println("\n\nCHECK BALANCE");
					System.out.print("\nSelect Account:\n\t1: Savings\n\t2: Checking\n\t3: Both Account\n Enter selection: ");
					select = Integer.parseInt(input.readLine());
					if (select == 1) {
						System.out.println("\n\nCurrent Balance " + peso.format(savBal));
					} else if (select == 2) {
						System.out.println("\n\nCurrent Balance " + peso.format(checkBal));
					} else if(select == 3) {
						System.out.println("\n\nSavings Balance: " + peso.format(savBal) + "\nChecking Balance: " + peso.format(checkBal));
					} else {
						System.err.println("\nChoose only based on the selection and its corresponding number");
					}
					break;
				}
				case 5: { //Outright exit the program
					transact = false;
					break;
					
				}
				default:
					//throw new IllegalArgumentException("Unexpected value: " + select);
					System.err.println("Please Choose only what's on the menu\nusing its corresponding number.\n\n");
			 }
			 TimeUnit.SECONDS.sleep(2); // Some pause for the user to see the text
		 } 
		 System.out.println("\n\nThank you for trusting on us\n\n EXITING...");
 }

 // Questionable part here
// static void willTransact(boolean transact, BufferedReader input) {
//	 System.out.print("Would you like to transact another session? Y/N");
//	 String choose = input.readLine();
//	 if() {
//		 
// }
	 

}