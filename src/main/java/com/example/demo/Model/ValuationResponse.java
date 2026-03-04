package com.example.demo.Model;

public class ValuationResponse {

    private final String ticker;
    private final double currentPrice;
    private final double bookValuePerShare;
    private final double fairPrice;
    private final boolean  isCheap;

    public ValuationResponse(String ticker, double currentPrice,
                             double bookValuePerShare, double fairPrice,
                             boolean isCheap) {
        this.ticker = ticker;
        this.currentPrice = currentPrice;
        this.bookValuePerShare = bookValuePerShare;
        this.fairPrice = fairPrice;
        this.isCheap = isCheap;
    }

    public String getTicker() {
        return ticker;
    }
    public double getCurrentPrice() {
        return currentPrice;
    }
    public double getBookValuePerShare() {
        return bookValuePerShare;
    }
    public double getFairPrice() {
        return fairPrice;
    }
    public boolean isCheap() {
        return isCheap;
    }

}
