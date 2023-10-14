package banking;

public class AccountDatabase {

    public AccountDatabase() {
        accounts = new Account[INITIAL_CAPACITY];
        numAcct = 0;
    }
    private static final int NOT_FOUND = -1;

    private static final int INITIAL_CAPACITY = 4;

    private Account [] accounts; //list of various types of accounts
    private int numAcct; //number of accounts in the array
    private int find(Account account) {
        for (int i = 0; i < numAcct; i++) {
            if (accounts[i].equals(account)) {
                return i;
            }
        }
        return NOT_FOUND;
    }
    public int getNumAcct() {
        return numAcct;
    }
    public Account[] getAccounts() {
        return accounts;
    }
    private void grow(){
        Account[] new_accounts = new Account[accounts.length + 4];

        // Copy elements from the old array to the new one
        for (int i = 0; i < accounts.length; i++) {
            new_accounts[i] = accounts[i];
        }
        // Update the reference to the events array
        accounts = new_accounts;

    } //increase the capacity by 4
    public boolean contains(Account account){
        return false;
    }
    public boolean open(Account account){
        int duplicateIndex = find(account);
        if (duplicateIndex != NOT_FOUND) {
            return false;
        }
        if (numAcct == accounts.length) {
            grow();
        }
        accounts[numAcct] = account;
        numAcct++;
        return true;
    } //add a new account
    public boolean close(Account account){
        int found = find(account);
        if (found == NOT_FOUND) {
            return false;
        } else {
            for (int i = found; i < numAcct - 1; i++) {
                accounts[i] = accounts[i + 1];
            }
            accounts[numAcct - 1] = null;
            numAcct--;
            return true;
        }
    }
    public boolean withdraw(Account account){
        for (int i = 0; i < numAcct; i++ ) {
            if (accounts[i].equals(account)){
                if (accounts[i].withdraw(account.getBalance())) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    public void deposit(Account account){
        boolean accountExists = false;
        for (int i = 0; i < numAcct; i++) {
            if (accounts[i].equals(account, 5)) {
                accountExists = true;
                accounts[i].deposit(account.getBalance());
                String message = account.getHolder().toString() + " (" + account.AA() + ") ";
                if (account.getBalance() == 0) {
                    System.out.println(message + "is not in the database.");
                } else {
                    System.out.println(message + "Deposit - balance updated.");
                }
                break;
            }
        }
        if (!accountExists) {
            System.out.println(account.getHolder().toString() + " (" + account.AA() + ") is not in the database.");
        }
    }

    public void printSorted() {
        if (numAcct == 0) {
            System.out.println("Account Database is empty!");
        } else {
            System.out.println("* Accounts sorted by account type and profile. *");
            for (int i = 0; i < numAcct - 1; i++) {
                boolean swapped = false;
                for (int j = 0; j < numAcct - i - 1; j++) {
                    if (accounts[j].compareTo(accounts[j + 1]) > 0) {
                        Account temp = accounts[j];
                        accounts[j] = accounts[j + 1];
                        accounts[j + 1] = temp;
                        swapped = true;
                    }
                }
                if (!swapped) {
                    break;
                }
            }
            for (int i = 0; i < numAcct; i++) {
                System.out.println(accounts[i].toString());
            }
            System.out.println("* end of list.");
        }
    }
    public void printFeesAndInterests(){
        if (numAcct == 0) {
            System.out.println("Account Database is empty!");
        } else {
            System.out.println("*list of accounts with fee and monthly interest.");
            for (int i = 0; i < numAcct - 1; i++) {
                boolean swapped = false;
                for (int j = 0; j < numAcct - i - 1; j++) {
                    if (accounts[j].compareTo(accounts[j + 1]) > 0) {
                        Account temp = accounts[j];
                        accounts[j] = accounts[j + 1];
                        accounts[j + 1] = temp;
                        swapped = true;
                    }
                }
                if (!swapped) {
                    break;
                }
            }
            for (int i = 0; i < numAcct; i++) {
                double MFee=accounts[i].monthlyFee();
                double MIntrestrate=accounts[i].monthlyInterest();
                System.out.println(accounts[i].toString()+"::fee $"+String.format("%.2f", MFee)+ "::monthly interest $"+String.format("%.2f", MIntrestrate));

            }
            System.out.println("* end of list.");
        }
    } //calculate interests/fees
    public void printUpdatedBalances() {
        if (numAcct == 0) {
            System.out.println("Account Database is empty!");
        } else {
            System.out.println("*list of accounts with fees and interests applied.");
            for (int i = 0; i < numAcct - 1; i++) {
                boolean swapped = false;
                for (int j = 0; j < numAcct - i - 1; j++) {
                    if (accounts[j].compareTo(accounts[j + 1]) > 0) {
                        Account temp = accounts[j];
                        accounts[j] = accounts[j + 1];
                        accounts[j + 1] = temp;
                        swapped = true;
                    }
                }
                if (!swapped) {
                    break;
                }
            }
            for (int i = 0; i < numAcct; i++) {
                double MFee = accounts[i].monthlyFee();
                double MIntrestrate = accounts[i].monthlyInterest();
                accounts[i].balance= accounts[i].balance + MFee +MIntrestrate;

                System.out.println(accounts[i].toString());

            }
            System.out.println("* end of list.");
        }
    }
}
