package com.example.search.service;

import com.example.search.response.SearchResult;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.CompletableFuture;
import java.util.Date;

@Service
@AllArgsConstructor
public class SearchService {
    private RestTemplate restTemplate;

    public CompletableFuture<SearchResult> search(Long bookId) {
        // Perform async HTTP call to get port
        CompletableFuture<String> portFuture = CompletableFuture.supplyAsync(() ->
                restTemplate.getForObject("http://details/details/port", String.class)
        );

        // Process the result and build SearchResult
        return portFuture.thenApply(result ->
                SearchResult.builder()
                        .code(201)
                        .timestamp(new Date())
                        .data(result)
                        .build()
        );
    }
}