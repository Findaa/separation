package com.bntech.googleintegrator.googleintegrator.serice;

import com.bntech.googleintegrator.googleintegrator.data.object.SearchDto;
import com.bntech.googleintegrator.googleintegrator.persistance.SearchRecord;
import com.bntech.googleintegrator.googleintegrator.persistance.SearchRecordRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final SearchRecordRepository repo;

    public void addSearch(SearchDto request) {
        repo.save(SearchRecord.builder()
                .url(request.getUrl())
                .name(request.getName())
                .build());
    }

    public List<SearchDto> getAllSearches() {
        List<SearchRecord> records = repo.findAll();
        List<SearchDto> response = new ArrayList<>();

        records.forEach(record -> {
            response.add(SearchDto.builder()
                    .url(record.getUrl())
                    .name(record.getName())
                    .build());
        });

        return response;
    }

    public SearchDto getById(String id) throws BadRequestException {
        SearchRecord record = repo.findById(Integer.valueOf(id)).orElseThrow(BadRequestException::new);
        return SearchDto.builder()
                .url(record.getUrl())
                .name(record.getName())
                .build();

    }
}
