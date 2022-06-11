import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class atmSystemcl {
	
	public static void main(String[] args) throws IOException, InterruptedException{	 	
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		boolean transact = true; 
		 
		while (transact) {
			System.out.print(colorConsole.YELLOW + "ATM Main Menu:\n"
					+ "\t1: Withdraw Money \n"
					+ "\t2: Deposit Money \n"
					+ "\t3: Transfer Funds \n"
					+ "\t4: Check Account Balance\n"
					+ "\t5: End Session\n \n"
					+ "Enter selection: ");
			int select = Integer.parseInt(input.readLine());
			 			 
			switch (select) {
				case 1: 
					System.out.println(colorConsole.RED + "\nOPERATION: WITHDRAW");
					withdraw();
					break;
				case 2: 
					System.out.println(colorConsole.GREEN +"\nOPERATION: DEPOSIT");
					deposit();
					break;
				case 3:
					System.out.println(colorConsole.ORANGE +"\nOPERATION: TRANSFER");
					transfer();
					break;
				case 4: 
					System.out.println(colorConsole.TEAL +"\nOPERATION: CHECK BALANCE");
					balance();
					break;
				case 5: {
					transact = false;
					break;
				}		
				default:
					System.err.println("Please Choose only what's on the menu\nusing its corresponding number.\n\n");
			 }
			
			 TimeUnit.SECONDS.sleep(2); 
		 } 
		
		 System.out.println("\n\nThank you for trusting on us\n\n EXITING...");
		}
	
	public static void withdraw() throws IOException {
		
		int min=1, max=5000, select;
 
		double savBal = (int)Math.floor(Math.random()*(max-min+1)+min);	 
		double checkBal = (int)Math.floor(Math.random()*(max-min+1)+min);
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("\nSelect Account:\n\t1: Savings\n\t2: Checking\n\nEnter selection: ");
		select = Integer.parseInt(input.readLine());
			if (select == 1) {
				System.out.print("\nCurrent Balance: " + "P" + (savBal) + "\n\n" + "Enter the amount to withdraw: ");
				double withdraw = Double.parseDouble(input.readLine());
				double tempHolder = savBal;
				tempHolder -= withdraw;
				if (tempHolder > 0) {
					savBal -= withdraw;
					System.out.println("\nNew Savings Balance: " + "P" + (savBal));
					System.out.println("");
				} 
				else {
					System.err.println("\nInsufficient Balance");
				}	
			} 
			
			else if (select == 2) { 
				System.out.print("\nCurrent Balance: " + "P" + (checkBal) + "\n\n" + "Enter the amount to withdraw: ");
				double withdraw = Double.parseDouble(input.readLine());
				double tempHolder = checkBal;
				tempHolder -= withdraw;
				if(tempHolder > 0) {
					checkBal -= withdraw;
					System.out.println("\nNew Checking Balance: " + "P" + (checkBal));
					System.out.println("");
				} 
				else {
					System.err.println("\nInsufficient Balance");
				}
			} 
			else {
				System.err.println("\nChoose only based on the selection and its corresponding number");
			}
		}
	
	public static void deposit() throws IOException {
		
		int min=1, max=5000, select;
		 
		double savBal = (int)Math.floor(Math.random()*(max-min+1)+min);	 
		double checkBal = (int)Math.floor(Math.random()*(max-min+1)+min);
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("\nSelect Account:\n\t1: Savings\n\t2: Checking\n\nEnter selection: ");
		select = Integer.parseInt(input.readLine());
			if (select == 1) {
				System.out.print("\nCurrent Balance: " + "P" + (savBal) + "\n\n" + "Enter the amount to deposit: ");
				double deposit = Double.parseDouble(input.readLine());
				savBal += deposit;
				System.out.println("\nNew Savings Balance: " + "P" + (savBal));
				System.out.println("");
			} 
			else if (select == 2) {
				System.out.print("\nCurrent Balance: " + "P" + (checkBal) + "\n\n" + "Enter the amount to deposit: ");
				double deposit = Double.parseDouble(input.readLine());
				checkBal += deposit;
				System.out.println("\nNew Checking Balance: " + "P" + (checkBal));
				System.out.println("");
			} 
			else {
				System.err.println("\nChoose only based on the selection and its corresponding number");
			}
		}
	
	public static void transfer()throws IOException {
		
		int min=1, max=5000, select;
		 
		double savBal = (int)Math.floor(Math.random()*(max-min+1)+min);	 
		double checkBal = (int)Math.floor(Math.random()*(max-min+1)+min);
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("\nSelect Account:\n\t1: Savings\n\t2: Checking\n\nEnter selection: ");
		select = Integer.parseInt(input.readLine());
			if (select == 1) { 
				System.out.print("Current Savings Balance " + "P" + (savBal) + "\n\n" + "Enter the amount to be transfer: ");
				double trans = Double.parseDouble(input.readLine());
				double tempHolder = savBal;
				tempHolder -= trans;
				if(tempHolder > 0) {
					savBal -= trans;
					checkBal += trans;
					System.out.println("\nNew Savings Balance: " + "P" + (savBal));
					System.out.println("New Checking Balance: " + "P" + (checkBal));
					System.out.println("");
				} 
				else {
					System.err.println("\nInsufficient Balance to Transfer");
				}
			} 
			else if (select == 2) { 
				System.out.print("Current Checking Balance " + "P" + (checkBal) + "\n\n" + "Enter the amount to be transfer: ");
				double trans = Double.parseDouble(input.readLine());
				double tempHolder = checkBal;
				tempHolder -= trans;
				if(tempHolder > 0) {
					checkBal -= trans;
					savBal += trans;
					System.out.println("\nNew Savings Balance: " + "P" + (checkBal));
					System.out.println("New Checking Balance: " + "P" + (savBal));
					System.out.println("");
				} 
				else {
					System.err.println("\nInsufficient Balance to Transfer");
				}
			} 
			else {
				System.err.println("\nChoose only based on the selection and its corresponding number");
			}	
		}
	
	public static void balance() throws IOException{
		
		int min=1, max=5000, select;
		 
		double savBal = (int)Math.floor(Math.random()*(max-min+1)+min);	 
		double checkBal = (int)Math.floor(Math.random()*(max-min+1)+min);
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("\nSelect Account:\n\t1: Savings\n\t2: Checking\n\t3: Both Account\n\nEnter selection: ");
		select = Integer.parseInt(input.readLine());
		if (select == 1) {
			System.out.println("\nCurrent Balance " + "P" + (savBal));
			System.out.println("");
		} 
		else if (select == 2) {
			System.out.println("\nCurrent Balance " + "P" + (checkBal));
			System.out.println("");
		} 
		else if(select == 3) {
			System.out.println("\nSavings Balance: " + "P" + (savBal) + "\nChecking Balance: " + "P" + (checkBal));
			System.out.println("");
		} 
		else {
			System.err.println("\nChoose only based on the selection and its corresponding number");
		}
	}
	
class colorConsole {
	public static final String RESET = "\033[0m"; 
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE
    public static final String LIGHT_PURPLE = "\033[38;2;200;0;200m"; //LIGHT PURPLE
    public static final String TEAL = "\033[38;2;0;225;221m"; //TEAL
    public static final String ORANGE = "\033[38;2;225;153;0m"; //ORANGE
    public static final String LIGHT_GREEN = "\033[38;2;136;255;0m"; //LIGHT GREEN
    public static final String LIGHT_BLUE = "\033[38;2;120;172;255m"; //LIGHT BLUE
    public static final String DARK_BLUE = "\033[38;2;72;0;255m"; //DARK BLUE
    public static final String ROSY_PINK = "\033[38;2;255;0;162m"; //ROSY PINK
    public static final String BROWN = "\033[38;2;135;82;62m"; //BROWN
    public static final String FOREST_GREEN = "\033[38;2;62;135;81m"; //FOREST GREEN
    public static final String BANANA_YELLOW = "\033[38;2;240;238;113m"; //BANANA YELLOW
    public static final String DARK_RED = "\033[38;2;145;40;16m"; //DARK RED
    public static final String LIGHT_PINK = "\033[38;2;255;153;240m"; //LIGHT PINK
 	}
}
	

