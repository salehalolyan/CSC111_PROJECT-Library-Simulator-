/*
 * 1. Abdulaziz Alabdulkareem - 446103513
 * 2. Saleh Alolyan - 446100843
 */

import java.util.Scanner;

public class LibrarySimulator {
    public static void main(String[] args) {
        //identify variables
        Scanner scan = new Scanner(System.in);
        int id1 = 101, id2 = 102, id3 = 103;
        String name1 = "Abdulaziz", name2 = "Saleh", name3 = "Omar";
        int user1Books = 0, user2Books = 0, user3Books = 0;
        double totalRevenue = 0.0;
        int totalBorrows = 0;
        int totalReturns = 0;
        int mainChoice = 0;

        while (mainChoice != 5) {
            //starting main menu
            System.out.println("\n==============================");
            System.out.println(" Welcome to the Library System");
            System.out.println("==============================");
            System.out.println("1. " + id1 + " - " + name1);
            System.out.println("2. " + id2 + " - " + name2);
            System.out.println("3. " + id3 + " - " + name3);
            System.out.println("4. Administrator");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            mainChoice = scan.nextInt();
            //starting user session
            if (mainChoice >= 1 && mainChoice <= 3) {
                int borrowedBooks = 0; 
                int returnedBooks = 0; 
                double sessionFees = 0.0;
                String currentUserName = "";

                int userBooks = 0;
                if (mainChoice == 1) userBooks = user1Books;
                else if (mainChoice == 2) userBooks = user2Books;
                else userBooks = user3Books;

                int userChoice = 0;
                while (userChoice != 5) {
                    if (mainChoice == 1) {
                        currentUserName = name1;
                    } else if (mainChoice == 2) {
                        currentUserName = name2;
                        
                    } else {
                        currentUserName = name3;
                        
                    }
                    //showing user menu
                    System.out.println("\nUser: " + (currentUserName));
                    System.out.println("1. View Borrowed Books Count");
                    System.out.println("2. Borrow Book");
                    System.out.println("3. Return Book");
                    System.out.println("4. View Session Summary");
                    System.out.println("5. Exit to Main Menu");
                    System.out.print("Choose: ");
                    userChoice = scan.nextInt();
                    //checking user choices
                    if (userChoice == 1) {
                        System.out.println("Currently borrowed books: " + userBooks);
                    } else if (userChoice == 2) {
                        if (userBooks < 5) {
                            userBooks++;
                            borrowedBooks++;
                            totalBorrows++;
                            totalRevenue += 0.50;
                            sessionFees += 0.50;
                            System.out.print("Book borrowed successfully Fee: 0.50");
                        } else {
                            System.out.println("Error: You cannot borrow more than 5 books");
                        }
                    } else if (userChoice == 3) {
                        if (userBooks > 0) {
                            userBooks--;
                            returnedBooks++;
                            totalReturns++;
                            System.out.println("Book returned successfully");
                        } else {
                            System.out.println("Error: No books to return");
                        }
                    } else if (userChoice == 4) {
                        System.out.println("\n*** Session Summary ***");
                        System.out.println("Books borrowed: " + borrowedBooks);
                        System.out.println("Books returned: " + returnedBooks);
                        System.out.printf("Total fees: %.2f%n", sessionFees);
                    } else if (userChoice != 5) {
                        System.out.println("Invalid choice");
                    }
                }

                if (mainChoice == 1) user1Books = userBooks;
                else if (mainChoice == 2) user2Books = userBooks;
                else user3Books = userBooks;

                //starting admin session
            } else if (mainChoice == 4) {
                int adminChoice = 0;
                while (adminChoice != 3) {
                    //showing admin menu
                    System.out.println("\n*** Administrator Menu ***");
                    System.out.println("1. View Total Revenue");
                    System.out.println("2. Most frequent Operation");
                    System.out.println("3. Exit to Main Menu");
                    System.out.print("Choose: ");
                    adminChoice = scan.nextInt();
                    //checking admin choices
                    if (adminChoice == 1) {
                        System.out.printf("Total revenue collected: %.2f%n", totalRevenue);
                    } else if (adminChoice == 2) {
                        if (totalBorrows > totalReturns)
                            System.out.println("Most frequent operation: Borrow");
                        else if (totalReturns > totalBorrows)
                            System.out.println("Most frequent operation: Return");
                        else
                            System.out.println("Both operations are equally frequent.");
                    } else if (adminChoice != 3) {
                        System.out.println("Invalid choice");
                    }
                }
            } else if (mainChoice != 5) {
                System.out.println("Invalid selection");
            }
        }

        System.out.println("\nThank you for using the Library System. Goodbye");
        scan.close();
    }
}

