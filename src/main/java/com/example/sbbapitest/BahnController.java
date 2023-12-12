package com.example.sbbapitest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bahn")
@RequiredArgsConstructor
public class BahnController {

    private final BahnService service;

    @GetMapping
    List<Station> findStations() {
        return service.findStations();
    }

}
