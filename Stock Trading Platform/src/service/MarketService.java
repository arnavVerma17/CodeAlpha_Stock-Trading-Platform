package service;

import model.Stock;

import java.util.HashMap;
import java.util.Map;

public class MarketService {

    private HashMap<String, Stock> marketStocks;

    public MarketService() {

        marketStocks = new HashMap<>();

        initializeMarket();
    }

    // Add initial stocks

    private void initializeMarket() {

        marketStocks.put(
                "AAPL",
                new Stock("AAPL",
                        "Apple Inc.",
                        190.00)
        );

        marketStocks.put(
                "GOOG",
                new Stock("GOOG",
                        "Google",
                        2400.00)
        );

        marketStocks.put(
                "TSLA",
                new Stock("TSLA",
                        "Tesla",
                        220.00)
        );

        marketStocks.put(
                "AMZN",
                new Stock("AMZN",
                        "Amazon",
                        180.00)
        );

        marketStocks.put(
                "MSFT",
                new Stock("MSFT",
                        "Microsoft",
                        420.00)
        );

        marketStocks.put(
                "NVDA",
                new Stock("NVDA",
                        "NVIDIA",
                        1100.00)
        );
    }

    // Display market

    public void displayMarket() {

        System.out.println("\n========== LIVE MARKET ==========");

        for (Stock stock : marketStocks.values()) {

            stock.displayStockInfo();
        }
    }

    // Search stock

    public Stock getStock(String symbol) {

        return marketStocks.get(
                symbol.toUpperCase()
        );
    }

    // Check existence

    public boolean stockExists(String symbol) {

        return marketStocks.containsKey(
                symbol.toUpperCase()
        );
    }

    // Update all stock prices

    public void updateMarketPrices() {

        for (Stock stock : marketStocks.values()) {

            stock.updatePrice();
        }
    }

    // Portfolio calculations use this

    public HashMap<String, Stock> getMarketStocks() {

        return marketStocks;
    }

    // Top gainer

    public void displayTopGainer() {

        Stock topGainer = null;

        double maxChange = Double.NEGATIVE_INFINITY;

        for (Stock stock : marketStocks.values()) {

            double change =
                    stock.getPercentageChange();

            if (change > maxChange) {

                maxChange = change;
                topGainer = stock;
            }
        }

        if (topGainer != null) {

            System.out.println("\nTop Gainer");

            System.out.println(
                    topGainer.getCompanyName()
                            + " ("
                            + topGainer.getSymbol()
                            + ")"
            );

            System.out.printf(
                    "Change : %.2f%%%n",
                    topGainer.getPercentageChange()
            );
        }
    }

    // Top loser

    public void displayTopLoser() {

        Stock topLoser = null;

        double minChange = Double.POSITIVE_INFINITY;

        for (Stock stock : marketStocks.values()) {

            double change =
                    stock.getPercentageChange();

            if (change < minChange) {

                minChange = change;
                topLoser = stock;
            }
        }

        if (topLoser != null) {

            System.out.println("\nTop Loser");

            System.out.println(
                    topLoser.getCompanyName()
                            + " ("
                            + topLoser.getSymbol()
                            + ")"
            );

            System.out.printf(
                    "Change : %.2f%%%n",
                    topLoser.getPercentageChange()
            );
        }
    }

    // Market summary

    public void displayMarketSummary() {

        System.out.println("\n========== MARKET SUMMARY ==========");

        System.out.println(
                "Total Listed Stocks : "
                        + marketStocks.size()
        );

        displayTopGainer();

        displayTopLoser();

        System.out.println(
                "===================================="
        );
    }
}