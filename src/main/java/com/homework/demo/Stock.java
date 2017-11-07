package com.homework.demo;

public class Stock {

    private String ticker;
    private Double marketValue;

    public Stock(String ticker, Double marketValue) {
        this.ticker = ticker;
        this.marketValue = marketValue;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(Double marketValue) {
        this.marketValue = marketValue;
    }
}
