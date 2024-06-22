package com.bntech.googleintegrator.manager.mapper;

import com.bntech.googleintegrator.manager.data.persistence.ShorthandLink;
import com.bntech.googleintegrator.manager.rest.dto.ShorthandLinkDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ShorthandLinkDtoMapper {
    ShorthandLinkDto shorthandLinkToShorthandLinkDto(ShorthandLink shorthandLink);

    @Mapping(target = "createdAt", ignore = true)
    ShorthandLink shorthandLinkDtoToShorthandLink(ShorthandLinkDto shorthandLinkDto);
}
