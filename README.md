# 📈 Stock Trading Platform

A lightweight, console-based **Stock Trading Simulation Application** built in **Java**. This application simulates a live stock market where users can monitor stock price movements, buy and sell shares, manage their investment portfolio, and save their data locally using file handling.

---

## 🚀 Features

### 📊 Live Market Simulation
- Realistic stock price fluctuations between **-5% and +5%**.
- Prices update dynamically during each menu interaction.

### 💹 Trading Engine
- Buy and sell stocks instantly using real-time market prices.
- Automatic validation for wallet balance and available shares.

### 💼 Portfolio Management
- Track owned stocks and quantities.
- View average purchase value.
- Monitor wallet balance and total portfolio valuation.
- Calculate real-time net worth.

### 📈 Market Analytics
- Display all available stocks with current prices.
- Identify the **Top Gainer** and **Top Loser** in the market.

### 📝 Transaction History
- Maintain a complete audit trail of every trade.
- Store:
  - Buy/Sell action
  - Stock symbol
  - Quantity
  - Price
  - Date & Time

### 💾 Data Persistence
- Automatically saves user portfolio.
- Loads previous portfolio data on startup.
- Uses a local text file (`portfolio.txt`) for storage.

---

# 🏗️ Project Structure

```
StockTradingPlatform/
│
├── model/
│   ├── Portfolio.java
│   ├── Stock.java
│   ├── Transaction.java
│   └── User.java
│
├── service/
│   ├── FileService.java
│   ├── MarketService.java
│   └── TradingService.java
│
├── portfolio.txt
└── Main.java
```

### 📂 File Description

#### model/

| File | Description |
|------|-------------|
| Portfolio.java | Manages user's stock holdings and calculates portfolio value. |
| Stock.java | Represents a stock and handles price fluctuations. |
| Transaction.java | Stores details of every buy/sell transaction. |
| User.java | Maintains user information and wallet balance. |

#### service/

| File | Description |
|------|-------------|
| FileService.java | Saves and loads portfolio data from `portfolio.txt`. |
| MarketService.java | Manages available stocks and updates market prices. |
| TradingService.java | Executes buy/sell operations with validation. |

#### Root Files

| File | Description |
|------|-------------|
| Main.java | Entry point containing the interactive console menu. |
| portfolio.txt | Stores portfolio data for persistence. |

---

# 📦 Available Stocks

The application starts with a predefined list of popular technology companies.

| Symbol | Company |
|---------|----------|
| AAPL | Apple Inc. |
| GOOG | Google |
| TSLA | Tesla |
| AMZN | Amazon |
| MSFT | Microsoft |
| NVDA | NVIDIA |

---

# 🛠️ Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Collections Framework
- File Handling
- Local Data Persistence
- Console-Based User Interface

---

# 📋 Prerequisites

Before running the project, ensure you have:

- Java Development Kit (JDK) 8 or above
- Command Prompt / Terminal
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

---

# ⚙️ Installation

## 1. Clone the Repository

```bash
git clone https://github.com/your-username/cli-stock-trading-platform.git
```

## 2. Navigate to the Project

```bash
cd cli-stock-trading-platform
```

## 3. Compile the Project

```bash
javac Main.java model/*.java service/*.java
```

## 4. Run the Application

```bash
java Main
```

---

# 🎮 How to Use

When the application starts, you'll receive a virtual investment budget of:

**₹100,000**

Use the numbered menu to interact with the application.

```
====================================
        STOCK TRADING PLATFORM
====================================

1. View Market
2. Buy Stock
3. Sell Stock
4. View Portfolio
5. View Dashboard
6. Transaction History
7. Market Summary
8. Save Data
9. Exit

====================================
Enter Choice:
```

---

# 📊 Dashboard Includes

- Wallet Balance
- Portfolio Value
- Net Worth
- Owned Stocks
- Current Market Prices

---

# 💰 Buying Stocks

- Select **Buy Stock**.
- Enter the stock symbol.
- Enter the quantity.
- The system validates your available balance before completing the purchase.

---

# 💸 Selling Stocks

- Select **Sell Stock**.
- Choose a stock you own.
- Enter the quantity to sell.
- Your wallet balance updates automatically after a successful sale.

---

# 📈 Market Summary

The Market Summary displays:

- 📈 Top Gainer
- 📉 Top Loser
- Current prices of all listed stocks

---

# 💾 Data Storage

Portfolio information is stored inside:

```
portfolio.txt
```

The file contains:

- Wallet Balance
- Owned Stocks
- Stock Quantities

This allows users to continue from their previous session.

---

# 📚 Concepts Demonstrated

This project demonstrates several core Java concepts, including:

- Object-Oriented Programming
- Classes and Objects
- Encapsulation
- Collections (HashMap, ArrayList)
- File Handling
- Exception Handling
- Modular Programming
- Service Layer Architecture
- Console-Based Application Design

---

# 🌟 Future Improvements

Potential enhancements include:

- User Login & Authentication
- Multiple User Profiles
- Portfolio Performance Charts
- CSV Export of Transactions
- Database Integration (MySQL)
- Real-Time Stock API Integration
- GUI using JavaFX or Swing
- Watchlist Feature
- Price Alerts
- Dividend Simulation

---

# 👨‍💻 Author

**Arnav Verma**

AI & Machine Learning Stude

---

## ⭐ If you found this project useful, consider giving it a Star!
