import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;


public class atmSystem {
 public static void main(String[] args) throws IOException, InterruptedException{
		 /* TODO
		  * MAIN Tasks
		  * 	Sectioning of the system
		  * 	Account of user
		  * 	User input interface
		  * 	Deposit money
		  * 	Withdraw transfer
		  * 	Transfer funds
		  * 	Check account balance
		  * 	End Session
		  * 	Enter Selection
		  * 	Create and Account (optional) Or have it fix
		  * Cleaning of the Code
		  * 	Arranging of the code (functioning adding classes)
		  * 	Making it pretty (adding color to text, simple animation if possible)
		  * 	Making it dynamic (acknowledging the resolution of the command line and font size) Possible but optional
		  * */
		 
		 // There could probably a built-in account of some sort here.
		 // Checking and Savings account
		 
		 double checkBal = 0.00; 	// Checking account balance
		 double checkRate = 0.00; 	// Checking interest rate
		 
		 double savBal = 0.00; 		// Savings account balance
		 double savRate = 0.25;		// Savings interest rate 
		 // The interest rate is based on the common interest rate of Philippine Banks
		 
		 
		 BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		 boolean transact = true;
		 
		 // This clear the CMD console but don't work on different IDEs
		 System.out.print("\033[H\033[2J");  
		 System.out.flush();  
		 
		 while (transact) {
			 System.out.print("\n\nATM Main Menu:\n\n"
					 + "1. Withdraw Money \n"
					 + "2. Deposit Money \n"
					 + "3. Transfer Funds \n"
					 + "4. Check Account Balance\n"
					 + "5. End Session\n \n"
					 + "Enter selection: ");
			 int select = Integer.parseInt(input.readLine());
			 
			 switch (select) {
				case 1: { //Withdraw Function here
					
					break;
				}
				case 2: { //Deposit Function here
					
					break;
				}
				case 3: { //Transfer Function here
					
					break;
				}
				case 4: { //Balance Check Function here
					
					break;
				}
				case 5: { //Outright exit the program
					transact = false;
					break;
					
				}
				default:
					//throw new IllegalArgumentException("Unexpected value: " + select);
					System.err.println("Please Choose only what's on the menu\nusing its corresponding number.\n\n");
					TimeUnit.MILLISECONDS.sleep(500);
			 }
		 } 
		 System.out.println("Thank you for trusting on us\n\n EXITING...");
 }

 // Questionable part here
// static void willTransact(boolean transact, BufferedReader input) {
//	 System.out.print("Would you like to transact another session? Y/N");
//	 String choose = input.readLine();
//	 if() {
//		 
// }
	 

}