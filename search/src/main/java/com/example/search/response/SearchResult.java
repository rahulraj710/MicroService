package com.example.search.response;

import lombok.*;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResult {
    private int code;
    private Date timestamp;
    private String data;
}
