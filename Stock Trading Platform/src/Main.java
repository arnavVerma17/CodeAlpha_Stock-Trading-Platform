
import model.User;
import service.FileService;
import service.MarketService;
import service.TradingService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("     STOCK TRADING PLATFORM");
        System.out.println("====================================");

        User user = new User("Arnav", 100000);

        MarketService marketService = new MarketService();
        TradingService tradingService =
                new TradingService(user, marketService);
        FileService fileService = new FileService();

        // Load saved data
        fileService.loadUserData(user);

        int choice;

        do {

            marketService.updateMarketPrices();

            System.out.println("\n====================================");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. View Dashboard");
            System.out.println("6. Transaction History");
            System.out.println("7. Market Summary");
            System.out.println("8. Save Data");
            System.out.println("9. Exit");
            System.out.println("====================================");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    marketService.displayMarket();
                    break;

                case 2:

                    System.out.print("Enter Stock Symbol: ");
                    String buySymbol = sc.next().toUpperCase();

                    System.out.print("Enter Quantity: ");
                    int buyQty = sc.nextInt();

                    tradingService.buyStock(
                            buySymbol,
                            buyQty
                    );

                    break;

                case 3:

                    System.out.print("Enter Stock Symbol: ");
                    String sellSymbol = sc.next().toUpperCase();

                    System.out.print("Enter Quantity: ");
                    int sellQty = sc.nextInt();

                    tradingService.sellStock(
                            sellSymbol,
                            sellQty
                    );

                    break;

                case 4:

                    tradingService.showPortfolio();
                    break;

                case 5:

                    tradingService.showDashboard();
                    break;

                case 6:

                    tradingService.showTransactionHistory();
                    break;

                case 7:

                    marketService.displayMarketSummary();
                    break;

                case 8:

                    fileService.saveUserData(user);
                    break;

                case 9:

                    fileService.saveUserData(user);

                    System.out.println(
                            "\nThank you for using Stock Trading Platform!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid Choice!"
                    );
            }

        } while (choice != 9);

        sc.close();
    }
}