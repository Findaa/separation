package com.bntech.googleintegrator.googleintegrator.serice;

import com.bntech.googleintegrator.googleintegrator.data.object.SearchDto;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface SearchService {
    void addSearch(SearchDto request);
    List<SearchDto> getAllSearches();
    SearchDto getById(String id) throws BadRequestException;
}
