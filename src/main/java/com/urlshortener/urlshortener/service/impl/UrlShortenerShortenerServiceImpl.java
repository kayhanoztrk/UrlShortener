package com.urlshortener.urlshortener.service.impl;

import com.urlshortener.urlshortener.dto.UrlShortenerDto;
import com.urlshortener.urlshortener.exception.UrlNotFoundException;
import com.urlshortener.urlshortener.mapper.UrlShortenerDtoMapper;
import com.urlshortener.urlshortener.mapper.UrlShortenerRequestMapper;
import com.urlshortener.urlshortener.model.UrlShortener;
import com.urlshortener.urlshortener.repository.UrlShortenerRepository;
import com.urlshortener.urlshortener.request.UrlShortenerRequest;
import com.urlshortener.urlshortener.service.UrlShortenerService;
import com.urlshortener.urlshortener.util.URLGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlShortenerShortenerServiceImpl implements UrlShortenerService {

    private final UrlShortenerRepository urlShortenerRepository;
    private final UrlShortenerDtoMapper urlShortenerDtoMapper;
    private final UrlShortenerRequestMapper urlShortenerRequestMapper;
    private final URLGenerator urlGenerator;

    public UrlShortenerShortenerServiceImpl(UrlShortenerRepository urlShortenerRepository,
                                            UrlShortenerDtoMapper urlShortenerDtoMapper,
                                            UrlShortenerRequestMapper urlShortenerRequestMapper,
                                            URLGenerator urlGenerator) {
        this.urlShortenerRepository = urlShortenerRepository;
        this.urlShortenerDtoMapper = urlShortenerDtoMapper;
        this.urlShortenerRequestMapper = urlShortenerRequestMapper;
        this.urlGenerator = urlGenerator;
    }

    @Override
    public List<UrlShortenerDto> findAllUrls() {
        List<UrlShortener> urlShortenerList = urlShortenerRepository.findAll();
        List<UrlShortenerDto> urlShortenerDtoList = urlShortenerDtoMapper.convertToDto(urlShortenerList);
        return urlShortenerDtoList;
    }

    @Override
    public UrlShortenerDto findUrlByCode(String code) {
        UrlShortener urlShortener = urlShortenerRepository.findAllByCode(code)
                .orElseThrow(() -> new UrlNotFoundException("url not found!"));
        return urlShortenerDtoMapper.convertToDto(urlShortener);
    }

    @Override
    public UrlShortener create(UrlShortenerRequest urlShortenerRequest) {
        if (urlShortenerRequest.getCode() == null
                || urlShortenerRequest.getCode().isEmpty()) {
            String urlCode = urlGenerator.generateURL();
            urlShortenerRequest.setCode(urlCode);
        }

        UrlShortener urlShortener = urlShortenerRequestMapper.convertToEntity(urlShortenerRequest);
        if (!urlShortenerRepository.findAllByCode(urlShortenerRequest.getCode()).isPresent()) {
            urlShortenerRepository.save(urlShortener);
        }

        return urlShortener;
    }
}