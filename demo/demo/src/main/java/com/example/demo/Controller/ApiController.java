package com.example.demo.Controller;


import com.example.demo.Model.ValuationResponse;
import com.example.demo.dto.ValuationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class ApiController {

    @Autowired
    private ValuationService valuationService;

    @GetMapping("/valuation/{ticker}")
    public ValuationResponse getValuation(@PathVariable String ticker) {

        return valuationService.calculate(ticker);
    }
}
