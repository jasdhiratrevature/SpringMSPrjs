package com.revature.healthrecordsvc.controller;

import com.revature.healthrecordsvc.dto.Allergy;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/health-record")
public class PatientHealthRecordController {

    @GetMapping("/allergies")
    @CircuitBreaker(name = "healthRecordAllergies", fallbackMethod = "getDefaultAllergies")
    public List<Allergy> getAllAllergies() {
        List<Allergy> allergies = null;
        RestTemplate template = new RestTemplate();
       // allergies = template.getForObject("http://localhost:8082/api/allergies/", ArrayList.class);
        allergies = template.getForObject("http://allergy-svc:8082/api/allergies/", ArrayList.class);
        return allergies;
    }

    public List<Allergy> getDefaultAllergies(Exception e) {
        return Stream.of(
                new Allergy(1, "Pet Allergy"),
                new Allergy(2, "Drug Allergy"),
                new Allergy(3, "Smoke Allergy")
        ).collect(Collectors.toList());
    }

}

