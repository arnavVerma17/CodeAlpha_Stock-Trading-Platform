package model;

public class User {

    private String username;
    private double balance;
    private Portfolio portfolio;

    public User(String username, double initialBalance) {
        this.username = username;
        this.balance = initialBalance;
        this.portfolio = new Portfolio();
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public double getBalance() {
        return balance;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    // Add money to wallet
    public void depositMoney(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        balance += amount;

        System.out.printf("₹%.2f added successfully.%n", amount);
        System.out.printf("Current Balance: ₹%.2f%n", balance);
    }

    // Withdraw money
    public boolean withdrawMoney(double amount) {

        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return false;
        }

        balance -= amount;
        return true;
    }

    // Check if user can buy stock
    public boolean canAfford(double amount) {
        return balance >= amount;
    }

    // Display user details
    public void displayUserInfo() {

        System.out.println("\n========== USER DETAILS ==========");
        System.out.println("Username : " + username);
        System.out.printf("Wallet Balance : ₹%.2f%n", balance);
        System.out.println("==================================");
    }

    // Display dashboard
    public void displayDashboard() {

        System.out.println("\n========== DASHBOARD ==========");
        System.out.println("Investor : " + username);
        System.out.printf("Available Balance : ₹%.2f%n", balance);

        int totalStocks = portfolio.getTotalStocks();

        System.out.println("Total Holdings : " + totalStocks);
        System.out.println("===============================");
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", balance=" + balance +
                '}';
    }
}