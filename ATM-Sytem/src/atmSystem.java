import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class atmSystem {
	public static void main(String[] args) throws IOException, InterruptedException{	 	
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		boolean transact = true; 
		int min=1, max=5000, select=0;
		Account account = new Account((Math.round((Math.random()*(max-min+1)+min)*100.0)/100.0), (Math.round((Math.random()*(max-min+1)+min)*100.0)/100.0));
		TextSelect selection = new TextSelect();
		while (transact) {
			System.out.println(colorConsole.WHITE_BOLD_BRIGHT  +"-------------------------------------------");
			System.out.print(colorConsole.LIGHT_BLUE_BOLD_BRIGHT + "ATM Main Menu:\n"
					+ "\t1: Withdraw Money \n"
					+ "\t2: Deposit Money \n"
					+ "\t3: Transfer Funds \n"
					+ "\t4: Check Account Balance\n"
					+ "\t5: End Session\n \n"
					+ "Enter selection: ");
			try {
				select = Integer.parseInt(input.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Numberformat Error: Put numbers only");
			} catch (IOException e) {
				System.out.println("IO Error");
			}
			 			 
			switch (select) {
				case 1: 
					System.out.println(colorConsole.WHITE_BOLD_BRIGHT +"-------------------------------------------");
					System.out.println(colorConsole.ROSY_PINK_BOLD_BRIGHT + "\nOPERATION: WITHDRAW");
					selection.select("withdraw", account);
					break;
				case 2: 
					System.out.println(colorConsole.GREEN +"\nOPERATION: DEPOSIT");
					selection.select("deposit", account);
					break;
				case 3:
					System.out.println(colorConsole.ORANGE_BOLD_BRIGHT +"\nOPERATION: TRANSFER");
					selection.select("transfer", account);
					break;
				case 4: 
					System.out.println(colorConsole.TEAL_BOLD_BRIGHT +"\nOPERATION: CHECK BALANCE");
					selection.select("balance", account);
					break;
				case 5: {
					transact = false;
					System.out.println(colorConsole.LIGHT_GREEN_BOLD_BRIGHT +"\n\nThank you for trusting on us\n\n EXITING...");
					System.exit(0);
					break;
				}		
				default:
					System.out.println(colorConsole.WHITE_BOLD_BRIGHT +"-------------------------------------------");
					System.err.println("Please Choose only what's on the menu\nusing its corresponding number.\n\n");
			 }
			 TimeUnit.SECONDS.sleep(2); 
		 } 
	}
}
	

