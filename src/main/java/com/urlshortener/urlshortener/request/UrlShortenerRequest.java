package com.urlshortener.urlshortener.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlShortenerRequest {
    @NotNull(message = "url can not be null")
    private String url;
    private String code;
}
