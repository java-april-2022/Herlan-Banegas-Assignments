public class BankAccount{
    private double checkingAccount;
    private double savingsAccount;
    public static int numberOfAccounts = 0;
    public static double totalMoneyForAccounts = 0;

    public BankAccount(){
        BankAccount.numberOfAccounts++;
    }

    public double getCheckingBalance(){
        return this.checkingAccount;
    }

    public double getSavingsAccount(){
        return this.savingsAccount;
    }

    public void deposit(double amount, String account){
        if (account == "savingsAccount"){
            this.savingsAccount += amount;
        }
        else if(account == "checkingAccount"){
            this.checkingAccount += amount;
        }
        totalMoneyForAccounts += amount;
    }

    public void withdraw(double checkingWithdraw, double savingsWithdraw){
        if(this.checkingAccount >= checkingWithdraw){
            this.checkingAccount -= checkingWithdraw;
        }
        else {
            System.out.println("Insufficient Funds in Checking Account.");
        }
        // totalMoneyForAccounts -= checkingWithdraw;
        if(this.savingsAccount >= savingsWithdraw){
            this.savingsAccount -= savingsWithdraw;
        }
        else {
            System.out.println("Insufficient Funds in Savings Account.");
        }
        totalMoneyForAccounts -= savingsWithdraw;
    }

    public void accountTotals() {
        System.out.println("Checking Account: " + this.checkingAccount);
        System.out.println("Savings Account: " + this.savingsAccount);
        System.out.println("Total Amount: " + totalMoneyForAccounts);
    }
}

