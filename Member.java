/*
 * 1. Abdulaziz Alabdulkareem - 446103513
 * 2. Saleh Alolyan - 446100843
 * 
 * https://github.com/salehalolyan/CSC111_PROJECT-Library-Simulator-
 */
public class Member {

    // ===== Member Attributes (Instance Variables) =====
    private int id;                 // Unique ID for each member
    private String name;            // Member's name
    private int borrowedCount;      // How many books the member currently has
    private int numViewBorrowed;    // How many times the user viewed borrowed count in each session
    private int numBorrows;         // Number of borrow operations in each session
    private int numReturns;         // Number of return operations in each session
    private double sessionFees;     // Total fees collected from this member in each session

    // ===== Shared (Static) Variables — Applies to ALL Members =====
    public static double TotalRevenue = 0.0;   // Total revenue from all members
    public static int TotalViewBorrowed = 0;   // Total number of "view borrowed count" operations
    public static int TotalBorrows = 0;        // Total number of borrow operations system-wide
    public static int TotalReturns = 0;        // Total number of return operations system-wide

    // ===== Constructor =====
    public Member(int id, String name, int borrowedCount) {
        this.id = id;
        this.name = name;
        this.borrowedCount = borrowedCount;

        // Reset session-based statistics
        this.numViewBorrowed = 0;
        this.numBorrows = 0;
        this.numReturns = 0;
        this.sessionFees = 0.0;
    }

    // ===== Helper Methods (Private) =====

    // Check if the member is allowed to borrow (max 5)
    private boolean canBorrow() {
        return borrowedCount < 5;
    }

    // Check if the member can return a book
    private boolean canReturn() {
        return borrowedCount > 0;
    }

    // ===== Public Functional Methods =====

    // Shows how many books the user currently has
    public void viewBorrowedCount() {
        numViewBorrowed++;
        TotalViewBorrowed++;

        System.out.println("Currently borrowed books: " + this.borrowedCount);
    }

    // Attempts to borrow one book
    public boolean borrowOne() {
        if (canBorrow()) {
            borrowedCount++;
            numBorrows++;
            TotalBorrows++;

            // Add fee
            sessionFees += 0.50;
            TotalRevenue += 0.50;

            System.out.println("Book borrowed successfully Fee: 0.50");
            return true;

        } else {
            System.out.println("Error: You cannot borrow more than 5 books");
            return false;
        }
    }

    // Attempts to return one book
    public boolean returnOne() {
        if (canReturn()) {
            borrowedCount--;
            numReturns++;
            TotalReturns++;

            System.out.println("Book returned successfully");
            return true;

        } else {
            System.out.println("Error: No books to return");
            return false;
        }
    }

    // Displays the session summary for this member
    public void displayStatistics() {
        System.out.println("\n*** Session Summary ***");
        System.out.println("Books borrowed: " + this.numBorrows);
        System.out.println("Books returned: " + this.numReturns);
        System.out.printf("Total fees: %.2f%n", this.sessionFees);
    }

    // Resets session-based statistics 
    public void reset() {
        this.numViewBorrowed = 0;
        this.numBorrows = 0;
        this.numReturns = 0;
        this.sessionFees = 0.0;
    }

    // ===== Getters =====

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBorrowedCount() {
        return borrowedCount;
    }
}
