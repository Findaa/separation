package com.bntech.googleintegrator.googleintegrator.data.object;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchDto {
    private String url;
    private String name;
}
