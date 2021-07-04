package com.example.pjatk.service;

import com.example.pjatk.model.NbpModel;
import com.example.pjatk.repository.NbpRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class NbpService {

    private final RestTemplate restTemplate;
    private final NbpRepository nbpRepository;

    public NbpService(RestTemplate restTemplate, NbpRepository nbpRepository) {
        this.restTemplate = restTemplate;
        this.nbpRepository = nbpRepository;
    }

    public NbpModel getExchangePrice(String currency, String date_from, String date_to) {
        String url = "http://api.nbp.pl/api/exchangerates/rates/";
        ResponseEntity<NbpModel> forEntity = restTemplate.getForEntity(url + "a" + "/" + currency + "/" + date_from + "/" + date_to, NbpModel.class);
        HttpStatus statusCode = forEntity.getStatusCode();
        if (statusCode == HttpStatus.OK) {
            return forEntity.getBody();
        } else {
            return null;
        }
    }
}
