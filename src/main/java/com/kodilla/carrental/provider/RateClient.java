package com.kodilla.carrental.provider;

import com.kodilla.carrental.config.RateConfig;
import com.kodilla.carrental.domain.Rate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class RateClient {

    private final RestTemplate restTemplate;
    private final RateConfig rateConfig;

    public URI getRatesURL() {
        return UriComponentsBuilder.fromHttpUrl(rateConfig.getRateApiEndpoint() + "api/v7/convert")
                .queryParam("q", "PLN_EUR,PLN_USD")
                .queryParam("compact","ultra")
                .queryParam("apiKey",
                        "ed67dd71fdc4696e2e8e")
                .build().encode().toUri();
    }

    public Rate getRates() {
        URI uri = getRatesURL();
        Rate rateResponse = restTemplate.getForObject(uri, Rate.class);
        return rateResponse;
    }
}
