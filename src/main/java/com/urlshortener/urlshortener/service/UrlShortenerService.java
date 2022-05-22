package com.urlshortener.urlshortener.service;

import com.urlshortener.urlshortener.dto.UrlShortenerDto;
import com.urlshortener.urlshortener.model.UrlShortener;
import com.urlshortener.urlshortener.request.UrlShortenerRequest;

import java.util.List;

public interface UrlShortenerService {
    List<UrlShortenerDto> findAllUrls();
    UrlShortenerDto findUrlByCode(String code);
    UrlShortener create(UrlShortenerRequest urlShortenerRequest);
}
