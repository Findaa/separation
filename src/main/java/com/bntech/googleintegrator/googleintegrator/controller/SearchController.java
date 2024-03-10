package com.bntech.googleintegrator.googleintegrator.controller;

import com.bntech.googleintegrator.googleintegrator.data.object.SearchDto;
import com.bntech.googleintegrator.googleintegrator.serice.SearchService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @PostMapping
    private ResponseEntity<String> addSearchRecord(@RequestBody SearchDto request) {
        searchService.addSearch(request);
        return ResponseEntity.ok("Added");
    }

    @GetMapping
    private ResponseEntity<List<SearchDto>> getSearchRecords() {
        return ResponseEntity.ok(searchService.getAllSearches());
    };

    @GetMapping("/{id}")
    private ResponseEntity<SearchDto> getSingleSearch(@PathVariable String id) throws BadRequestException {
        return ResponseEntity.status(302).body(searchService.getById(id));
    }
}
