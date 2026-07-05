package model;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {

    // Stock Symbol -> Quantity
    private HashMap<String, Integer> holdings;

    public Portfolio() {
        holdings = new HashMap<>();
    }

    // Add shares
    public void addStock(String symbol, int quantity) {

        holdings.put(symbol,
                holdings.getOrDefault(symbol, 0) + quantity);
    }

    // Sell shares
    public boolean removeStock(String symbol, int quantity) {

        if (!holdings.containsKey(symbol)) {
            return false;
        }

        int currentQuantity = holdings.get(symbol);

        if (currentQuantity < quantity) {
            return false;
        }

        if (currentQuantity == quantity) {
            holdings.remove(symbol);
        } else {
            holdings.put(symbol, currentQuantity - quantity);
        }

        return true;
    }

    // Check ownership
    public boolean ownsStock(String symbol) {
        return holdings.containsKey(symbol);
    }

    // Get shares owned
    public int getQuantity(String symbol) {
        return holdings.getOrDefault(symbol, 0);
    }

    // Total different stocks
    public int getTotalStocks() {
        return holdings.size();
    }

    // Get all holdings
    public HashMap<String, Integer> getHoldings() {
        return holdings;
    }

    // Portfolio value
    public double calculatePortfolioValue(
            HashMap<String, Stock> marketStocks) {

        double totalValue = 0;

        for (Map.Entry<String, Integer> entry : holdings.entrySet()) {

            String symbol = entry.getKey();
            int quantity = entry.getValue();

            Stock stock = marketStocks.get(symbol);

            if (stock != null) {
                totalValue += stock.getCurrentPrice() * quantity;
            }
        }

        return totalValue;
    }

    // Display portfolio
    public void displayPortfolio(
            HashMap<String, Stock> marketStocks) {

        System.out.println("\n========== MY PORTFOLIO ==========");

        if (holdings.isEmpty()) {
            System.out.println("No stocks owned.");
            return;
        }

        double totalValue = 0;

        for (Map.Entry<String, Integer> entry : holdings.entrySet()) {

            String symbol = entry.getKey();
            int quantity = entry.getValue();

            Stock stock = marketStocks.get(symbol);

            if (stock != null) {

                double stockValue =
                        stock.getCurrentPrice() * quantity;

                totalValue += stockValue;

                System.out.printf(
                        "%s | %d Shares | ₹%.2f%n",
                        symbol,
                        quantity,
                        stockValue
                );
            }
        }

        System.out.println("----------------------------------");
        System.out.printf("Total Portfolio Value: ₹%.2f%n",
                totalValue);
        System.out.println("==================================");
    }

    @Override
    public String toString() {
        return holdings.toString();
    }
}