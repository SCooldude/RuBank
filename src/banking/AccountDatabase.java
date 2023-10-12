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
    } //overload if necessary
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
        return false;
    } //remove the given account
    public boolean withdraw(Account account){
        return false;
    } //false if insufficient fund
    public void deposit(Account account){}
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
                System.out.println("* end of list.");
            }
        }
    }
    public void printFeesAndInterests(){
        if (numAcct == 0){
            System.out.println("Account Database is empty!");
        }
    } //calculate interests/fees
    public void printUpdatedBalances(){
        if (numAcct == 0){
            System.out.println("Account Database is empty!");
        }
    }
}
