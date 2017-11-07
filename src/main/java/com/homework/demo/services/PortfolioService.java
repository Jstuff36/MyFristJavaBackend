package com.homework.demo.services;

import com.homework.demo.Stock;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PortfolioService {

    private Map<String, Map<String, Stock>> portfolios = new HashMap<>();

    public List<String> getAllPortfolioNames() {
        return new ArrayList<>(this.portfolios.keySet());
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolios.put(portfolioName, new HashMap<>());
    }

    public String deletePortfolioName(String portfolioName) {
        if (this.portfolios.containsKey(portfolioName)) {
            this.portfolios.remove(portfolioName);
            return "Success";
        } else {
            return "Portfolio not present";
        }
    }

    public Map<String, Stock> getStockList(String portfolioName) {
        return this.portfolios.get(portfolioName);
    }

    public Stock addStock(String portfolioName, String ticker, Double marketValue) {
        Map<String, Stock> portfolio = this.portfolios.get(portfolioName);
        Stock stock = new Stock(ticker, marketValue);
        portfolio.put(ticker, stock);
        return stock;
    }

    public String deleteStock(String portfolioName, String ticker) {
        if (this.portfolios.containsKey(portfolioName)) {
            Map<String, Stock> portfolio = this.portfolios.get(portfolioName);
            if (portfolio.containsKey(ticker)) {
                portfolio.remove(ticker);
                return "Success";
            } else {
                return "Stock ticker not found";
            }
        } else {
            return "Portfolio not found";
        }
    }

//    public void computePortfolioMarketValue() {
//        ArrayList<HashMap> allPortfolioSums = new ArrayList<HashMap>;
//
//    }

}
