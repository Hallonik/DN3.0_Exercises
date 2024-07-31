package Design_Patterns_And_Principles.ObserverPatternExample;

import java.util.ArrayList;
import java.util.List;

interface Stock {
    void register(Observer observer);
    void deregister(Observer observer);
    void notifyObservers();
}

interface Observer {
    void update(String stockName, double stockPrice);
}



class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockName;
    private double stockPrice;

    public StockMarket(String stockName, double stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, stockPrice);
        }
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }
}

class MobileApp implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("MobileApp: Stock " + stockName + " is now $" + stockPrice);
    }
}

class WebApp implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("WebApp: Stock " + stockName + " is now $" + stockPrice);
    }
}

public class ObserverPatternDemo {
    public static void main(String[] args) {
        // Create a StockMarket object
        StockMarket stockMarket = new StockMarket("Apple", 150.00);

        // Create observer objects
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        // Register observers with the stock market
        stockMarket.register(mobileApp);
        stockMarket.register(webApp);

        // Change stock price and notify observers
        System.out.println("Updating stock price...");
        stockMarket.setStockPrice(155.00);
        System.out.println();

        // Deregister one observer and update stock price again
        stockMarket.deregister(mobileApp);
        System.out.println("Updating stock price again...");
        stockMarket.setStockPrice(160.00);
    }
}


