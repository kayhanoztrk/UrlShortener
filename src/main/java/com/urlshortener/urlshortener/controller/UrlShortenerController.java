package com.urlshortener.urlshortener.controller;

import com.urlshortener.urlshortener.dto.UrlShortenerDto;
import com.urlshortener.urlshortener.model.UrlShortener;
import com.urlshortener.urlshortener.request.UrlShortenerRequest;
import com.urlshortener.urlshortener.service.UrlShortenerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * ShortUrl Controller class.
 *
 * @author Kayhan Ozturk
 * @version 0.1
 * @since 0.1
 */
@RestController
@RequestMapping("/api/v1/url")
public class UrlShortenerController {

    private final UrlShortenerService urlShortenerService;

    public UrlShortenerController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<UrlShortenerDto>> findAllUrls() {
        return new ResponseEntity(urlShortenerService.findAllUrls(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<UrlShortenerDto> redirect(@Valid @PathVariable String code) throws URISyntaxException {
        UrlShortenerDto urlShortenerDto = urlShortenerService.findUrlByCode(code);
        URI uri = new URI(urlShortenerDto.getUrl());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<UrlShortenerDto>(httpHeaders, HttpStatus.SEE_OTHER);
    }

    @GetMapping("/find/{code}")
    public ResponseEntity<UrlShortenerDto> findUrlByCode(@Valid @PathVariable String code) throws URISyntaxException {
        UrlShortenerDto urlShortenerDto = urlShortenerService.findUrlByCode(code);
        return new ResponseEntity<UrlShortenerDto>(urlShortenerDto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody UrlShortenerRequest urlShortenerRequest) {
        UrlShortener urlShortener = urlShortenerService.create(urlShortenerRequest);
        return new ResponseEntity<>(urlShortener, HttpStatus.CREATED);
    }

}
