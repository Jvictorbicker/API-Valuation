package com.example.demo.Service;

import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



@Service
public class ApiCall {

    private  final ObjectMapper mapper = new ObjectMapper();

    public JsonNode ReadApi(String ticker) {
        HttpClient client = HttpClient.newHttpClient();

        URI url = URI.create("https://brapi.dev/api/quote/" + ticker +
                "?modules=financialData,defaultKeyStatistics");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .GET()
                .build();
        try {
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            return mapper.readTree(response.body()) ;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
