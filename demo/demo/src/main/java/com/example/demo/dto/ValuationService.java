package com.example.demo.dto;

import com.example.demo.Model.ValuationResponse;
import com.example.demo.Service.ApiCall;
import com.example.demo.Service.Valuation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;

@Service
public class ValuationService {

    @Autowired
    private ApiCall apiCall;

    private final Valuation valuation = new Valuation();

    public ValuationResponse calculate(String ticker) {

        JsonNode root = apiCall.ReadApi(ticker);

        JsonNode result = root.get("results").get(0);
        System.out.println(root.toPrettyString());

        double currentPrice = result.get("regularMarketPrice").asDouble();
        double bookValue = result
                .get("defaultKeyStatistics")
                .get("bookValue")
                .asDouble();

        double fairPrice = valuation.calculateFairPricePVP(bookValue, 1.0);
        boolean isCheap = valuation.areCheap(currentPrice, fairPrice);

        return new ValuationResponse(
                ticker.toUpperCase(),
                currentPrice,
                bookValue,
                fairPrice,
                isCheap
        );
    }
}
