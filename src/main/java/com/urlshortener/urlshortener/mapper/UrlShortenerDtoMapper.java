package com.urlshortener.urlshortener.mapper;

import com.urlshortener.urlshortener.dto.UrlShortenerDto;
import com.urlshortener.urlshortener.model.UrlShortener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ShortUrlDtoMapper class provides to convert entity to dto class.
 *
 * @author Kayhan Ozturk
 * @version 0.1
 * @since 0.1
 */
@Component
public class UrlShortenerDtoMapper {

    public UrlShortenerDto convertToDto(UrlShortener urlShortener) {
        return UrlShortenerDto.builder()
                .id(urlShortener.getId())
                .url(urlShortener.getUrl())
                .code(urlShortener.getCode())
                .build();
    }

    public List<UrlShortenerDto> convertToDto(List<UrlShortener> urlShortenerList) {
        return urlShortenerList.stream()
                .map(url -> convertToDto(url))
                .collect(Collectors.toList());
    }


}
