package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String stockSymbol;
    private String companyName;
    private int quantity;
    private double pricePerShare;
    private double totalAmount;
    private String transactionType;
    private LocalDateTime transactionTime;

    public Transaction(String stockSymbol,
                       String companyName,
                       int quantity,
                       double pricePerShare,
                       String transactionType) {

        this.stockSymbol = stockSymbol;
        this.companyName = companyName;
        this.quantity = quantity;
        this.pricePerShare = pricePerShare;
        this.transactionType = transactionType;

        this.totalAmount = quantity * pricePerShare;
        this.transactionTime = LocalDateTime.now();
    }

    // Getters

    public String getStockSymbol() {
        return stockSymbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerShare() {
        return pricePerShare;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    // Display transaction

    public void displayTransaction() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("--------------------------------------");
        System.out.println("Transaction Type : " + transactionType);
        System.out.println("Stock Symbol     : " + stockSymbol);
        System.out.println("Company Name     : " + companyName);
        System.out.println("Quantity         : " + quantity);
        System.out.printf("Price Per Share  : ₹%.2f%n", pricePerShare);
        System.out.printf("Total Amount     : ₹%.2f%n", totalAmount);
        System.out.println("Date & Time      : "
                + transactionTime.format(formatter));
        System.out.println("--------------------------------------");
    }

    @Override
    public String toString() {

        return String.format(
                "%s | %s | %d Shares | ₹%.2f | ₹%.2f | %s",
                transactionType,
                stockSymbol,
                quantity,
                pricePerShare,
                totalAmount,
                transactionTime
        );
    }
}