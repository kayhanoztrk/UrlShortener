package com.urlshortener.urlshortener.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * ShortUrlDto for ShortUrl model class.
 *
 * @author  Kayhan Ozturk
 * @version 0.1
 * @since   0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UrlShortenerDto {
    private Long id;
    private String url;
    private String code;
}