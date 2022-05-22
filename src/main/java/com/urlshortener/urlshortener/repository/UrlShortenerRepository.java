package com.urlshortener.urlshortener.repository;

import com.urlshortener.urlshortener.model.UrlShortener;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlShortenerRepository extends JpaRepository<UrlShortener, Long> {
    Optional<UrlShortener> findAllByCode(String code);
}
