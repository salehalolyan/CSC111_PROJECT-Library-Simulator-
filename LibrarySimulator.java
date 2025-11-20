/*
 * 1. Abdulaziz Alabdulkareem - 446103513
 * 2. Saleh Alolyan - 446100843
 * 
 * https://github.com/salehalolyan/CSC111_PROJECT-Library-Simulator-
 */

import java.util.Scanner;

public class LibrarySimulator {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Predefined members
        Member m1 = new Member(101, "Abdulaziz", 0);
        Member m2 = new Member(102, "Saleh", 0);
        Member m3 = new Member(103, "Omar", 0);

        int mainChoice = 0;

        while (mainChoice != 5) {

            System.out.println("\n==============================");
            System.out.println(" Welcome to the Library System");
            System.out.println("==============================");
            System.out.println("1. " + m1.getId() + " - " + m1.getName());
            System.out.println("2. " + m2.getId() + " - " + m2.getName());
            System.out.println("3. " + m3.getId() + " - " + m3.getName());
            System.out.println("4. Administrator");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            mainChoice = scan.nextInt();

            // ========== USER LOGIN ==========
            if (mainChoice >= 1 && mainChoice <= 3) {

                Member current; // Pointer to selected user account

                // Identify selected member
                if (mainChoice == 1) current = m1;
                else if (mainChoice == 2) current = m2;
                else current = m3;

                int userChoice = 0;

                // Reset statistics every login
                current.reset();

                 // ===== User Operations Menu =====
                while (userChoice != 5) {

                    System.out.println("\nUser: " + current.getName());
                    System.out.println("1. View Borrowed Books Count");
                    System.out.println("2. Borrow Book");
                    System.out.println("3. Return Book");
                    System.out.println("4. View Session Summary");
                    System.out.println("5. Exit to Main Menu");
                    System.out.print("Choose: ");

                    userChoice = scan.nextInt();

                    switch (userChoice) {
                        case 1:
                            // Displays current borrowed count 
                            current.viewBorrowedCount(); 
                            break;

                        case 2:
                             // Attempt to borrow a book
                            current.borrowOne();
                            break;

                        case 3:
                            // Attempt to return a book
                            current.returnOne();
                            break;

                        case 4:
                            // Shows session-based activities
                            current.displayStatistics();
                            break;

                        case 5:
                            // Return to main menu
                            break;

                        default:
                            System.out.println("Invalid choice.");
                    }
                }
            }

            // ========== ADMIN MODE ==========
            else if (mainChoice == 4) {

                int adminChoice = 0;
                // ===== Administrator Menu =====
                while (adminChoice != 3) {

                    System.out.println("\n*** Administrator Menu ***");
                    System.out.println("1. View Total Revenue");
                    System.out.println("2. Most Frequent Operation");
                    System.out.println("3. Exit");
                    System.out.print("Choose: ");

                    adminChoice = scan.nextInt();

                    switch (adminChoice) {

                        case 1:
                            // Displays total fees collected from all users
                            System.out.printf("Total revenue collected: %.2f%n",
                                    Member.TotalRevenue);
                            break;

                        case 2:
                            // Determines which operation was used the most
                            if (Member.TotalBorrows > Member.TotalReturns)
                                System.out.println("Most frequent operation: Borrow");
                            else if (Member.TotalReturns > Member.TotalBorrows)
                                System.out.println("Most frequent operation: Return");
                            else
                                System.out.println("Both borrow and return are equal.");
                            break;

                        case 3:
                            // Return to main menu
                            break;

                        default:
                            System.out.println("Invalid choice.");
                    }
                }
            }

            else if (mainChoice != 5) {
                System.out.println("Invalid selection.");
            }
        }

        System.out.println("\nThank you for using the Library System. Goodbye");
        scan.close();
    }
}
