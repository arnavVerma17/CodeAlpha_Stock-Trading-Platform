package service;

import model.Portfolio;
import model.Stock;
import model.Transaction;
import model.User;

import java.util.ArrayList;

public class TradingService {

    private User user;
    private MarketService marketService;
    private ArrayList<Transaction> transactionHistory;

    public TradingService(User user,
                          MarketService marketService) {

        this.user = user;
        this.marketService = marketService;
        this.transactionHistory = new ArrayList<>();
    }

    // BUY STOCK

    public void buyStock(String symbol, int quantity) {

        Stock stock =
                marketService.getStock(symbol);

        if (stock == null) {

            System.out.println(
                    "Stock not found!"
            );
            return;
        }

        double totalCost =
                stock.getCurrentPrice() * quantity;

        if (!user.canAfford(totalCost)) {

            System.out.println(
                    "Insufficient Balance!"
            );
            return;
        }

        user.withdrawMoney(totalCost);

        user.getPortfolio().addStock(
                stock.getSymbol(),
                quantity
        );

        Transaction transaction =
                new Transaction(
                        stock.getSymbol(),
                        stock.getCompanyName(),
                        quantity,
                        stock.getCurrentPrice(),
                        "BUY"
                );

        transactionHistory.add(transaction);

        System.out.println(
                "\nStock Purchased Successfully!"
        );

        System.out.printf(
                "Cost: ₹%.2f%n",
                totalCost
        );
    }

    // SELL STOCK

    public void sellStock(String symbol,
                          int quantity) {

        Portfolio portfolio =
                user.getPortfolio();

        Stock stock =
                marketService.getStock(symbol);

        if (stock == null) {

            System.out.println(
                    "Stock not found!"
            );
            return;
        }

        if (!portfolio.ownsStock(symbol)) {

            System.out.println(
                    "You don't own this stock!"
            );
            return;
        }

        int ownedQuantity =
                portfolio.getQuantity(symbol);

        if (ownedQuantity < quantity) {

            System.out.println(
                    "Not enough shares!"
            );
            return;
        }

        double saleValue =
                stock.getCurrentPrice() * quantity;

        portfolio.removeStock(
                symbol,
                quantity
        );

        user.depositMoney(saleValue);

        Transaction transaction =
                new Transaction(
                        stock.getSymbol(),
                        stock.getCompanyName(),
                        quantity,
                        stock.getCurrentPrice(),
                        "SELL"
                );

        transactionHistory.add(transaction);

        System.out.println(
                "\nStock Sold Successfully!"
        );

        System.out.printf(
                "Received: ₹%.2f%n",
                saleValue
        );
    }

    // SHOW PORTFOLIO

    public void showPortfolio() {

        user.getPortfolio()
                .displayPortfolio(
                        marketService.getMarketStocks()
                );
    }

    // SHOW BALANCE

    public void showBalance() {

        System.out.printf(
                "\nCurrent Balance : ₹%.2f%n",
                user.getBalance()
        );
    }

    // TRANSACTION HISTORY

    public void showTransactionHistory() {

        System.out.println(
                "\n====== TRANSACTION HISTORY ======"
        );

        if (transactionHistory.isEmpty()) {

            System.out.println(
                    "No transactions found."
            );
            return;
        }

        for (Transaction transaction :
                transactionHistory) {

            transaction.displayTransaction();
        }
    }

    // TOTAL PORTFOLIO VALUE

    public double getPortfolioValue() {

        return user.getPortfolio()
                .calculatePortfolioValue(
                        marketService.getMarketStocks()
                );
    }

    // NET WORTH

    public double getNetWorth() {

        return user.getBalance()
                + getPortfolioValue();
    }

    // DASHBOARD

    public void showDashboard() {

        System.out.println(
                "\n========== DASHBOARD =========="
        );

        System.out.println(
                "Investor : "
                        + user.getUsername()
        );

        System.out.printf(
                "Wallet Balance : ₹%.2f%n",
                user.getBalance()
        );

        System.out.printf(
                "Portfolio Value : ₹%.2f%n",
                getPortfolioValue()
        );

        System.out.printf(
                "Net Worth : ₹%.2f%n",
                getNetWorth()
        );

        System.out.println(
                "================================"
        );
    }

    // NUMBER OF TRANSACTIONS

    public int getTransactionCount() {

        return transactionHistory.size();
    }

    public ArrayList<Transaction>
    getTransactionHistory() {

        return transactionHistory;
    }
}