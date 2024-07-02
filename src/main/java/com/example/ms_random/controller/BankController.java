package com.example.ms_random.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/api/v2/banks")
public class BankController {


    private static final String BASE_URL = "https://random-data-api.com/api/v2";
    private static final String ENDPOINT = "/banks";

    @GetMapping("/random")
    public Mono<Map> getRandom() {
        WebClient webClient = WebClient.builder().baseUrl(BASE_URL).build();
        return webClient.get()
                .uri(ENDPOINT)
                .retrieve()
                .bodyToMono(Map.class)
                .onErrorResume(e -> {
                    // Cath the error
                    System.err.println("Error fetching data: " + e.getMessage());
                    // Return the error code
                    return Mono.empty();
                });
    }

}
