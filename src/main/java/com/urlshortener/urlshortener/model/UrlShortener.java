package com.urlshortener.urlshortener.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * ShortUrl entity.
 *
 * @author Kayhan Ozturk
 * @version 0.1
 * @since   0.1
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UrlShortener {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String url;

    @NotNull
    @Column(unique = true)
    private String code;
}
