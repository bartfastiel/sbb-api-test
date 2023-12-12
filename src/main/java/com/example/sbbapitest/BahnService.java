package com.example.sbbapitest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BahnService {

    private final WebClient webClient;

    public List<Station> findStations() {
        SbbResponse response = Objects.requireNonNull(
                        webClient
                                .get()
                                .uri("/api/explore/v2.1/catalog/datasets/haltestelle-offnungszeiten/records?limit=20")
                                .retrieve()
                                .toEntity(SbbResponse.class)
                                .block()
                )
                .getBody();

        List<Station> stations = new ArrayList<>();
        for (SbbResult result : Objects.requireNonNull(response).results()) {
            stations.add(
                    new Station(result.dst_nr(), result.stationsbezeichnung())
            );
        }
        return stations;
    }
}
