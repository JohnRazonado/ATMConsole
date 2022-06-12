import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class atmSystem {
	
	public static void main(String[] args) throws IOException, InterruptedException{	 	
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		boolean transact = true; 
		
		int min=1, max=5000, select;
		double savBal = (int)Math.floor(Math.random()*(max-min+1)+min);	 
		double checkBal = (int)Math.floor(Math.random()*(max-min+1)+min);

		//This part sets up the peso format 
		// Still unstable
		// NumberFormat peso = NumberFormat.getCurrencyInstance(new Locale("608", "PH"));
		// peso.setMaximumFractionDigits(2);
		//	peso.setCurrency(Currency.getInstance("PHP"));
		 
		while (transact) {
			System.out.println(colorConsole.ORANGE +"-------------------------------------------");
			System.out.print(colorConsole.YELLOW + "ATM Main Menu:\n"
					+ "\t1: Withdraw Money \n"
					+ "\t2: Deposit Money \n"
					+ "\t3: Transfer Funds \n"
					+ "\t4: Check Account Balance\n"
					+ "\t5: End Session\n \n"
					+ "Enter selection: ");
			select = Integer.parseInt(input.readLine());
			 			 
			switch (select) {
				case 1: 
					System.out.println(colorConsole.ORANGE +"-------------------------------------------");
					System.out.println(colorConsole.RED + "\nOPERATION: WITHDRAW");
					withdraw(savBal, checkBal);
					break;
				case 2: 
					System.out.println(colorConsole.GREEN +"\nOPERATION: DEPOSIT");
					deposit(savBal, checkBal);
					break;
				case 3:
					System.out.println(colorConsole.ORANGE +"\nOPERATION: TRANSFER");
					transfer(savBal, checkBal);
					break;
				case 4: 
					System.out.println(colorConsole.TEAL +"\nOPERATION: CHECK BALANCE");
					balance(savBal, checkBal);
					break;
				case 5: {
					transact = false;
					System.out.println(colorConsole.DARK_RED +"\n\nThank you for trusting on us\n\n EXITING...");
					System.exit(0);
					break;
				}		
				default:
					System.out.println(colorConsole.ORANGE +"-------------------------------------------");
					System.err.println("Please Choose only what's on the menu\nusing its corresponding number.\n\n");
			 }
			
			 TimeUnit.SECONDS.sleep(2); 
		 } 
		
		}
	
	public static void withdraw(double savBal, double checkBal) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(colorConsole.ORANGE +"-------------------------------------------");
		System.out.print(colorConsole.YELLOW +"\nSelect Account:\n\t1: Savings\n\t2: Checking\n\nEnter selection: ");
		int select = Integer.parseInt(input.readLine());
			if (select == 1) {
				System.out.println(colorConsole.ORANGE +"-------------------------------------------");
				System.out.print("\nCurrent Balance: " + "P" + (savBal) + "\n\n" + "Enter the amount to withdraw: ");
				double withdraw = Double.parseDouble(input.readLine());
				double tempHolder = savBal;
				tempHolder -= withdraw;
				if (tempHolder > 0) {
					savBal -= withdraw;
					System.out.println(colorConsole.BANANA_YELLOW +"\nNew Savings Balance: " + "P" + (savBal));
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
					System.out.println(colorConsole.BANANA_YELLOW +"\nNew Checking Balance: " + "P" + (checkBal));
					System.out.println("");
				} 
				else {
					System.out.println(colorConsole.ORANGE +"-------------------------------------------");
					System.err.println("\nInsufficient Balance");
				}
			} 
			else {
				System.out.println(colorConsole.ORANGE +"-------------------------------------------");
				System.err.println("\nChoose only based on the selection and its corresponding number");
			}
		}
	
	public static void deposit(double savBal, double checkBal) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(colorConsole.ORANGE +"-------------------------------------------");
		System.out.print(colorConsole.YELLOW +"\nSelect Account:\n\t1: Savings\n\t2: Checking\n\nEnter selection: ");
		int select = Integer.parseInt(input.readLine());
			if (select == 1) {
				System.out.println(colorConsole.ORANGE +"-------------------------------------------");
				System.out.print("\nCurrent Balance: " + "P" + (savBal) + "\n\n" + "Enter the amount to deposit: ");
				double deposit = Double.parseDouble(input.readLine());
				savBal += deposit;
				System.out.println(colorConsole.BANANA_YELLOW +"\nNew Savings Balance: " + "P" + (savBal));
				System.out.println("");
			} 
			else if (select == 2) {
				System.out.println(colorConsole.ORANGE +"-------------------------------------------");
				System.out.print("\nCurrent Balance: " + "P" + (checkBal) + "\n\n" + "Enter the amount to deposit: ");
				double deposit = Double.parseDouble(input.readLine());
				checkBal += deposit;
				System.out.println(colorConsole.BANANA_YELLOW +"\nNew Checking Balance: " + "P" + (checkBal));
				System.out.println("");
			} 
			else {
				System.out.println(colorConsole.ORANGE +"-------------------------------------------");
				System.err.println("\nChoose only based on the selection and its corresponding number");
			}
		}
	
	public static void transfer(double savBal, double checkBal) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(colorConsole.ORANGE +"-------------------------------------------");
		System.out.print(colorConsole.YELLOW +"\nSelect Account:\n\t1: Savings\n\t2: Checking\n\nEnter selection: ");
		int select = Integer.parseInt(input.readLine());
			if (select == 1) { 
				System.out.println(colorConsole.ORANGE +"-------------------------------------------");
				System.out.print("Current Savings Balance " + "P" + (savBal) + "\n\n" + "Enter the amount to be transfer: ");
				double trans = Double.parseDouble(input.readLine());
				double tempHolder = savBal;
				tempHolder -= trans;
				if(tempHolder > 0) {
					savBal -= trans;
					checkBal += trans;
					System.out.println(colorConsole.BANANA_YELLOW +"\nNew Savings Balance: " + "P" + (savBal));
					System.out.println(colorConsole.BANANA_YELLOW +"New Checking Balance: " + "P" + (checkBal));
					System.out.println("");
				} 
				else {
					System.out.println(colorConsole.ORANGE +"-------------------------------------------");
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
					System.out.println(colorConsole.BANANA_YELLOW +"\nNew Savings Balance: " + "P" + (checkBal));
					System.out.println(colorConsole.BANANA_YELLOW +"New Checking Balance: " + "P" + (savBal));
					System.out.println("");
				} 
				else {
					System.err.println("\nInsufficient Balance to Transfer");
				}
			} 
			else {
				System.out.println(colorConsole.ORANGE +"-------------------------------------------");
				System.err.println("\nChoose only based on the selection and its corresponding number");
			}	
		}
	
	public static void balance(double savBal, double checkBal) throws IOException{
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.println(colorConsole.YELLOW +"-------------------------------------------");
		System.out.print(colorConsole.YELLOW +"\nSelect Account:\n\t1: Savings\n\t2: Checking\n\t3: Both Account\n\nEnter selection: ");
		int select = Integer.parseInt(input.readLine());
		if (select == 1) {
			System.out.println(colorConsole.ORANGE +"-------------------------------------------");
			System.out.println(colorConsole.BANANA_YELLOW +"\nCurrent Balance " + "P" + (savBal));
			System.out.println("");
		} 
		else if (select == 2) {
			System.out.println(colorConsole.BANANA_YELLOW +"\nCurrent Balance " + "P" + (checkBal));
			System.out.println("");
		} 
		else if(select == 3) {
			System.out.println(colorConsole.BANANA_YELLOW +"\nSavings Balance: " + "P" + (savBal) + "\nChecking Balance: " + "P" + (checkBal));
			System.out.println("");
		} 
		else {
			System.out.println(colorConsole.ORANGE +"-------------------------------------------");
			System.err.println("\nChoose only based on the selection and its corresponding number");
		}
	}
	
// use this to color the texts
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
	

