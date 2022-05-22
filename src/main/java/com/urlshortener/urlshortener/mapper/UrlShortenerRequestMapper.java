package com.urlshortener.urlshortener.mapper;

import com.urlshortener.urlshortener.model.UrlShortener;
import com.urlshortener.urlshortener.request.UrlShortenerRequest;
import org.springframework.stereotype.Component;

@Component
public class UrlShortenerRequestMapper {

    public UrlShortener convertToEntity(UrlShortenerRequest urlShortenerRequest) {
        return UrlShortener.builder()
                .url(urlShortenerRequest.getUrl())
                .code(urlShortenerRequest.getCode())
                .build();
    }
}
