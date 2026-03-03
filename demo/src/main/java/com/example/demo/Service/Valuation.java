package com.example.demo.Service;

public class Valuation {
    public double calculateFairPricePVP(double bookValue, double pvpFair) {
        return bookValue * pvpFair;
    }
    public boolean areCheap(double precoAtual, double precoJusto) {
        return precoAtual < precoJusto;
    }
}
