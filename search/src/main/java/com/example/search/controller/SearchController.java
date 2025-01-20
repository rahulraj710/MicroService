package com.example.search.controller;

import com.example.search.response.SearchResult;
import com.example.search.service.SearchService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequiredArgsConstructor
public class SearchController {
    private final SearchService service;

    @GetMapping("/weather/search")
    @HystrixCommand(fallbackMethod = "onError")
    public ResponseEntity<?> getDetails() {
        SearchResult result = service.search(1L).join(); // Block until the result is available
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<?> onError() {// Block until the result is available
        return ResponseEntity.ok("no");
    }
}
