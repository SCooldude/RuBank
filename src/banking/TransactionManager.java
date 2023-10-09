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

                switch (action) {
                    case ("O"):
                        if (tokenizer.countTokens() == 6) {
                            String accountType = tokenizer.nextToken();
                            String firstName = tokenizer.nextToken();
                            String lastName = tokenizer.nextToken();
                            String dateString = tokenizer.nextToken();
                            String deposit = tokenizer.nextToken();
                            int code = Integer.parseInt(tokenizer.nextToken());

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
                            double deposit = Double.parseDouble(tokenizer.nextToken());
                            if (accountType.equals("MM")) {
                                if (deposit < 2000) {
                                    System.out.println("not enough money for MM");
                                    break;
                                }
                            }
                            Date date = Date.fromDateStr(dateString);
                            if (!date.isValid()) {
                                System.out.println("DOB invalid:" + dateString + "cannot be today or a future day.");
                                break;
                            }

                        } else {
                            System.out.println("error");
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
