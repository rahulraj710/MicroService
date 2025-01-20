package com.example.search.controller;

import com.example.search.response.SearchResult;
import com.example.search.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SearchController {
    private final SearchService service;

    @GetMapping("/weather/search")
    public ResponseEntity<?> getDetails() {
        SearchResult result = service.search(1L).join(); // Block until the result is available
        return ResponseEntity.ok(result);
    }
}
