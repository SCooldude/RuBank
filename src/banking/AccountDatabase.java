package banking;

public class AccountDatabase {

    public AccountDatabase() {
        accounts = new Account[4];
        numAcct = 0;
    }
    private Account [] accounts; //list of various types of accounts
    private int numAcct; //number of accounts in the array
    private int find(Account account) {
        return 0;
    } //search for an account in the array
    private void grow(){

    } //increase the capacity by 4
    public boolean contains(Account account){
        return false;
    } //overload if necessary
    public boolean open(Account account){
        return true;
    } //add a new account
    public boolean close(Account account){
        return false;
    } //remove the given account
    public boolean withdraw(Account account){
        return false;
    } //false if insufficient fund
    public void deposit(Account account){}
    public void printSorted(){
        if (numAcct == 0){
            System.out.println("Account Database is empty!");
        }
    } //sort by account type and profile
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
