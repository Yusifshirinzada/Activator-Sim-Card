package au.com.telstra.simcardactivator.controller;

import au.com.telstra.simcardactivator.model.ActivateResponse;
import au.com.telstra.simcardactivator.model.Sim;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SimCardActuationHandler {
    private final RestTemplate restTemplate;
    private final String incentiveApiUrl;

    public SimCardActuationHandler(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
        this.incentiveApiUrl = "http://localhost:8080/activate";
    }

    public ActivateResponse actuate(Sim simCard) {
        return restTemplate.postForObject(incentiveApiUrl, simCard, ActivateResponse.class);
    }
}
