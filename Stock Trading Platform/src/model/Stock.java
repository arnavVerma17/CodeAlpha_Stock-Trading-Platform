package model;

import java.util.Random;

public class Stock {

    private String symbol;
    private String companyName;
    private double currentPrice;
    private double previousPrice;
    private double dayHigh;
    private double dayLow;

    public Stock(String symbol, String companyName, double currentPrice) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.currentPrice = currentPrice;
        this.previousPrice = currentPrice;
        this.dayHigh = currentPrice;
        this.dayLow = currentPrice;
    }

    // Getters
    public String getSymbol() {
        return symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public double getDayHigh() {
        return dayHigh;
    }

    public double getDayLow() {
        return dayLow;
    }

    // Simulate market fluctuations
    public void updatePrice() {

        Random random = new Random();

        // Price change between -5% and +5%
        double percentageChange = (random.nextDouble() * 10) - 5;

        previousPrice = currentPrice;

        currentPrice += currentPrice * (percentageChange / 100);

        if (currentPrice < 1) {
            currentPrice = 1;
        }

        if (currentPrice > dayHigh) {
            dayHigh = currentPrice;
        }

        if (currentPrice < dayLow) {
            dayLow = currentPrice;
        }
    }

    // Calculate price movement
    public double getPriceChange() {
        return currentPrice - previousPrice;
    }

    // Calculate percentage movement
    public double getPercentageChange() {
        return ((currentPrice - previousPrice) / previousPrice) * 100;
    }

    // Display stock details
    public void displayStockInfo() {

        System.out.println("-------------------------------------");
        System.out.println("Company Name : " + companyName);
        System.out.println("Symbol       : " + symbol);
        System.out.printf("Current Price: ₹%.2f%n", currentPrice);
        System.out.printf("Day High     : ₹%.2f%n", dayHigh);
        System.out.printf("Day Low      : ₹%.2f%n", dayLow);
        System.out.printf("Change       : %.2f%% %n", getPercentageChange());
        System.out.println("-------------------------------------");
    }

    @Override
    public String toString() {
        return symbol + " | " + companyName + " | ₹" +
                String.format("%.2f", currentPrice);
    }
}