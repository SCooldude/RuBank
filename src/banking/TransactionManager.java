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
            if (tokenizer.hasMoreTokens()) {
                String action = tokenizer.nextToken();

                label:
                switch (action) {
                    case ("O"):
                        if (tokenizer.countTokens() == 6) {
                            String accountType = tokenizer.nextToken();
                            String firstName = tokenizer.nextToken();
                            String lastName = tokenizer.nextToken();
                            String dateString = tokenizer.nextToken();

                            try {
                                double deposit = Double.parseDouble(tokenizer.nextToken());

                                int code = Integer.parseInt(tokenizer.nextToken());

                                if (deposit <= 0) {
                                    System.out.println("Initial deposit cannot be 0 or negative.");
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Not a valid amount.");
                                break;
                            }

                            Date date = Date.fromDateStr(dateString);
                            if (!date.isValid()) {
                                System.out.println("DOB invalid:" + dateString + "cannot be today or a future day.");
                                break;
                            }

                        } else if (tokenizer.countTokens() == 5) {
                            String accountType = tokenizer.nextToken();
                            String firstName = tokenizer.nextToken();
                            String lastName = tokenizer.nextToken();
                            String dateString = tokenizer.nextToken();
                            try {
                                double deposit = Double.parseDouble(tokenizer.nextToken());
                                int code = Integer.parseInt(tokenizer.nextToken());

                                if (deposit <= 0) {
                                    System.out.println("Initial deposit cannot be 0 or negative.");
                                    break;
                                }
                                Date date = Date.fromDateStr(dateString);
                                if (!date.isValid()) {
                                    System.out.println("DOB invalid:" + dateString + "cannot be today or a future day.");
                                    break;
                                }
                                boolean isLoyal = false;
                                if (code == 1) {
                                    isLoyal == True;
                                }
                                Account account = null;

                                switch (accountType) {
                                    case "C":
                                        account = new Checking(firstName, lastName, date, deposit);
                                        break;
                                    case "CC":
                                        account = new CollegeChecking(firstName, lastName, date, deposit, campus);
                                        break;
                                    case "S":
                                        account = new Savings(firstName, lastName, date, deposit, isLoyal);
                                        break;
                                    case "MM":
                                        account = new MoneyMarket(firstName, lastName, date, deposit, isLoyal);
                                        break;
                                    default:
                                        System.out.println("Invalid account type: " + accountType);
                                        break label;
                                }
                                if (accountDatabase.open(account)) {
                                    System.out.println(firstName + lastName + dateString + "(" + accountType + ")" + "opened.");
                                }
                                else {
                                    System.out.println(firstName + lastName + dateString + "(" + accountType + ")" + "is already in the database.");
                                }

                            } catch (NumberFormatException e) {
                                System.out.println("Not a valid amount.");
                                break;
                            }

                        } else {
                            System.out.println("Missing data for opening an account.");
                            break;
                        }


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
