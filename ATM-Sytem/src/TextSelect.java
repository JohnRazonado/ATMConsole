import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextSelect{
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    Operation calc = new Operation();
    // Operation accounts = new Operation();

    public void select(String transaction, Account acc) throws IOException{
        System.out.print(colorConsole.GREEN_BOLD_BRIGHT +"\nSelect Account:\n\t1: Savings\n\t2: Checking\n\nEnter selection: ");
		int select = 0;
        try {
		    select = Integer.parseInt(input.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Numberformat Error: Put numbers only");
		} catch (IOException e) {
			System.out.println("IO Error");
		}
        if (select == 1){
            if(transaction.equals("transfer")){
                double savBal = acc.getSaving();
                double checkBal = acc.getChecking();
                transact("Savings", transaction, savBal, checkBal, acc);
            }
            double balance = acc.getSaving();
            balance = transact("Savings", transaction, balance);
            acc.setSaving(balance);
        } else if (select == 2){
            double balance = acc.getChecking();
            balance = transact("Checking", transaction, balance);
            acc.setChecking(balance);
        } else {
            System.out.println(colorConsole.WHITE_BOLD_BRIGHT
            + "-------------------------------------------");
			System.err.println("\nChoose only based on the selection and its corresponding number");
        }
    }

    public double transact (String account,String transaction, double balance) throws NumberFormatException, IOException {
        // account = Savings or Checking
        // transaction = deposit or withdraw
        
        double amount = 0;
        System.out.println(colorConsole.WHITE_BOLD_BRIGHT +"-------------------------------------------");
		if (!transaction.equals("balance")){
        System.out.print(colorConsole.LIGHT_PINK_BOLD_BRIGHT +"\nCurrent Balance: " + "P" + (calc.formatter(balance)) + "\n\n" + "Enter the amount to "+ transaction + ": ");
        amount = Double.parseDouble(input.readLine());
        }
        if (transaction.equals("withdraw")) {
            double tempHolder = balance;
            tempHolder = calc.add(tempHolder, -amount);
            if (tempHolder > 0) {
                balance = calc.add(balance, -amount);
            } else {
                System.err.println("\nInsufficient Balance");
            }
        } else if(transaction.equals("deposit")){
            balance += amount;
        }
        balance(account, balance);
        return balance;
    }
    public void transact (String account, String transaction, double mainBalance, double transBalance, Account acc) throws NumberFormatException, IOException{
    System.out.print(colorConsole.LIGHT_PINK_BOLD_BRIGHT +"\nCurrent Balance: " + "P" + (calc.formatter(mainBalance)) + "\n\n" + "Enter the amount to "+ transaction + ": ");
    double amount = Double.parseDouble(input.readLine());
    double tempHolder = mainBalance;
    tempHolder -= amount;
    if (tempHolder > 0) {
        mainBalance = calc.add(mainBalance, -amount);
        transBalance = calc.add(transBalance, amount);
        balance(account, mainBalance);
        balance(account, transBalance);
    } else {
        System.out.println(colorConsole.WHITE_BOLD_BRIGHT +"-------------------------------------------");
		System.err.println("\nInsufficient Balance to Transfer");
    }
    
    }
    public void balance (String account,double balance){
        System.out.println(colorConsole.LIGHT_GREEN_BOLD_BRIGHT +"\nNew "+ account +" Balance: " + "P" + (calc.formatter(balance)) + "\n");
    }

}
