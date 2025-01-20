package com.example.search.controller;

import com.example.search.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
public class SearchController {
    private final SearchService service;

    @GetMapping("/weather/search")
    public CompletableFuture<ResponseEntity<?>> getDetails() {
        return service.search(1L)
                .thenApply(result -> ResponseEntity.ok(result));
    }
}
