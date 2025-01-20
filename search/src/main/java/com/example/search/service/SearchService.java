package com.example.search.service;

import com.example.search.response.SearchResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.CompletableFuture;
import java.util.Date;

@Service
@AllArgsConstructor
public class SearchService {
    private RestTemplate restTemplate;


    public CompletableFuture<SearchResult> search(Long bookId) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Perform HTTP call to get port
                String port = restTemplate.getForObject("http://details/details/port", String.class);

                // Build and return SearchResult
                return SearchResult.builder()
                        .code(201)
                        .timestamp(new Date())
                        .data(port)
                        .build();
            } catch (Exception e) {
                // Hystrix fallback will handle this
                throw new RuntimeException("Service call failed", e);
            }
        });
    }

}