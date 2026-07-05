package service;

import model.User;

import java.io.*;
import java.util.Map;

public class FileService {

    private static final String FILE_NAME =
            "portfolio.txt";

    // SAVE DATA

    public void saveUserData(User user) {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(FILE_NAME))) {

            writer.write(
                    "BALANCE:"
                            + user.getBalance()
            );

            writer.newLine();

            for (Map.Entry<String, Integer> entry :
                    user.getPortfolio()
                            .getHoldings()
                            .entrySet()) {

                writer.write(
                        entry.getKey()
                                + ","
                                + entry.getValue()
                );

                writer.newLine();
            }

            System.out.println(
                    "\nData Saved Successfully!"
            );

        } catch (IOException e) {

            System.out.println(
                    "Error Saving Data!"
            );

            e.printStackTrace();
        }
    }

    // LOAD DATA

    public void loadUserData(User user) {

        File file = new File(FILE_NAME);

        if (!file.exists()) {

            System.out.println(
                    "No saved data found."
            );

            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(FILE_NAME))) {

            String line;

            boolean firstLine = true;

            while ((line = reader.readLine())
                    != null) {

                if (firstLine) {

                    firstLine = false;
                    continue;
                }

                String[] data =
                        line.split(",");

                String symbol =
                        data[0];

                int quantity =
                        Integer.parseInt(
                                data[1]
                        );

                user.getPortfolio()
                        .addStock(
                                symbol,
                                quantity
                        );
            }

            System.out.println(
                    "\nData Loaded Successfully!"
            );

        } catch (IOException e) {

            System.out.println(
                    "Error Loading Data!"
            );

            e.printStackTrace();
        }
    }
}