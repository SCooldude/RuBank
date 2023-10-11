package banking;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TransactionManager {

    private final AccountDatabase accountDatabase;

    public TransactionManager() {
        accountDatabase = new AccountDatabase();
    }
    public void run() {
        System.out.println("Transaction Manager is running.");

        Scanner scanner = new Scanner(System.in);

        System.out.println();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Q")) {
                break;
            }
            processCommand(input);
        }
        scanner.close();

        System.out.println("Transaction Manager is terminated.");
    }
    private void processCommand(String command) {
        StringTokenizer tokenizer = new StringTokenizer(command);
        boolean invalidcode = false;
            if (tokenizer.hasMoreTokens()) {
                String action = tokenizer.nextToken();

                switch (action) {
                    case "O":

                        if (tokenizer.countTokens() < 5) {
                            System.out.println("Missing data for opening an account.");
                            break;
                        }
                        String accountType = tokenizer.nextToken();
                        String firstName = tokenizer.nextToken();
                        String lastName = tokenizer.nextToken();
                        String dateString = tokenizer.nextToken();
                        Date date = Date.fromDateStr(dateString);

                        if (!date.isValid()) {
                            System.out.println("DOB invalid: " + dateString + " not a valid calendar date!");
                            break;
                        }
                        if (!date.isFutureDate()) {
                            System.out.println("DOB invalid: " + dateString + " cannot be today or a future day.");
                            break;
                        }
                        int age = date.calculateAge();

                        Account account = null;

                        switch (accountType) {
                            case "C":
                                if (age < 16) {
                                    System.out.println("DOB invalid: " + dateString + " under 16.");
                                    break;
                                }
                                try {
                                    double deposit = Double.parseDouble(tokenizer.nextToken());
                                    if (deposit <= 0) {
                                        System.out.println("Initial deposit cannot be 0 or negative.");
                                        break;
                                    }
                                    Profile profile = new Profile(firstName, lastName, date);
                                    account = new Checking(profile, deposit);
                                } catch (NumberFormatException e) {
                                    System.out.println("Not a valid amount.");
                                }
                                break;

                            case "MM":
                                if (age < 16) {
                                    System.out.println("DOB invalid: " + dateString + " under 16.");
                                    break;
                                }
                                try {
                                    double deposit = Double.parseDouble(tokenizer.nextToken());
                                    if (deposit <= 0) {
                                        System.out.println("Initial deposit cannot be 0 or negative.");
                                        break;
                                    }
                                    if (deposit < 2000){
                                        System.out.println("Minimum of $2000 to open a Money Market account.");
                                        break;
                                    }
                                    Profile profile = new Profile(firstName, lastName, date);
                                    int withdrawal = 0;
                                    account = new MoneyMarket(profile, deposit, true, withdrawal);
                                } catch (NumberFormatException e) {
                                    System.out.println("Not a valid amount.");
                                }
                                break;

                            case "S":
                                if (age < 16) {
                                    System.out.println("DOB invalid: " + dateString + " under 16.");
                                    break;
                                }
                                try {
                                    double deposit = Double.parseDouble(tokenizer.nextToken());
                                    int code = Integer.parseInt(tokenizer.nextToken());
                                    boolean isLoyal = code == 1;
                                    if (deposit <= 0) {
                                        System.out.println("Initial deposit cannot be 0 or negative.");
                                        break;
                                    }
                                    Profile profile = new Profile(firstName, lastName, date);
                                    account = new Savings(profile, deposit, isLoyal);
                                } catch (NumberFormatException e) {
                                    System.out.println("Not a valid amount.");
                                }
                                break;

                            case "CC":
                                if (age < 16) {
                                    System.out.println("DOB invalid: " + dateString + " under 16.");
                                    break;
                                }
                                if (age >= 24) {
                                    System.out.println("DOB invalid: " + dateString + " over 24.");
                                    break;
                                }
                                try {
                                    double deposit = Double.parseDouble(tokenizer.nextToken());
                                    int code = Integer.parseInt(tokenizer.nextToken());
                                    Campus campus = null;
                                    switch (code) {
                                        case 0:
                                            campus = Campus.NEW_BRUNSWICK;
                                            break;
                                        case 1:
                                            campus = Campus.NEWARK;
                                            break;
                                        case 2:
                                            campus = Campus.CAMDEN;
                                            break;
                                        default:
                                            System.out.println("Invalid campus code.");
                                            invalidcode = true;
                                            break;
                                    }
                                    if (deposit <= 0) {
                                        System.out.println("Initial deposit cannot be 0 or negative.");
                                        break;
                                    }
                                    Profile profile = new Profile(firstName, lastName, date);
                                    account = new CollegeChecking(profile, deposit, campus);
                                } catch (NumberFormatException e) {
                                    System.out.println("Not a valid amount.");
                                }
                                break;
                        }
                        if (invalidcode) {
                            break;
                        }

                        if (account != null) {
                            if (accountDatabase.open(account)) {
                                System.out.println(firstName + " " + lastName + " " + dateString + " (" + accountType + ")" + " opened.");
                            } else {
                                System.out.println(firstName + " " + lastName + " " + dateString + " (" + accountType + ")" + " is already in the database.");
                            }
                        }

                        break;

                    case ("C"):

                    case ("D"):

                    case ("W"):

                    case ("P"):
                        accountDatabase.printSorted();
                        break;

                    case ("PI"):
                        accountDatabase.printFeesAndInterests();
                        break;

                    case ("UB"):
                        accountDatabase.printUpdatedBalances();
                        break;

                    default:
                        if (action.equals("o")) {
                            System.out.println();
                            System.out.println("Invalid command!");
                        } else {
                            System.out.println("Invalid command!");
                }
           }
        }
    }
}
