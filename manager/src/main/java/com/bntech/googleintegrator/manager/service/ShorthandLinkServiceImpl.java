package com.bntech.googleintegrator.manager.service;

import com.bntech.googleintegrator.manager.data.persistence.ShorthandLink;
import com.bntech.googleintegrator.manager.data.repository.ShorthandLinkRepository;
import com.bntech.googleintegrator.manager.mapper.ShorthandLinkDtoMapper;
import com.bntech.googleintegrator.manager.rest.dto.ShorthandLinkDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ShorthandLinkServiceImpl implements ShorthandLinkService {

    private final ShorthandLinkRepository repository;
    private final ShorthandLinkDtoMapper mapper;

    @Override
    public ShorthandLinkDto saveShorthandLink(ShorthandLinkDto requestBody) {
        ShorthandLink newLink = repository.save(mapper.shorthandLinkDtoToShorthandLink(requestBody));

        return mapper.shorthandLinkToShorthandLinkDto(newLink);
    }
}
