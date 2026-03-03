package com.example.demo.Controller;


import com.example.demo.Service.ApiCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class ApiController {

    @Autowired
    private ApiCall apicall;

    @GetMapping("/quote/{ticker}")
    public String getQuote(@PathVariable String ticker) {
        return apicall.ReadApi(ticker);
    }
}
