package com.urlshortener.urlshortener.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class URLGenerator {

    @Value("${util.url-generator-string-length}")
    private int urlLength;

    private String randomChars = "abcdefghijklmnoprstuvyzqw123456789";

    public String generateURL() {
        return generateRandomChars(randomChars, urlLength);
    }

    public String generateRandomChars(String candidateChars, int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars
                    .length())));
        }

        return sb.toString();
    }
}
