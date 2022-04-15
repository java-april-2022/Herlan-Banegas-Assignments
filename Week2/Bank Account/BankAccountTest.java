
public class BankAccountTest {
    public static void main(String[] args){
        BankAccount myAccount = new BankAccount();

        myAccount.deposit(5000, "savingsAccount");
        myAccount.deposit(8000, "checkingAccount");

        myAccount.withdraw(9000, 300);

        System.out.println(myAccount.getSavingsAccount());
        System.out.println(myAccount.getCheckingBalance());
        myAccount.accountTotals();
    }
}

