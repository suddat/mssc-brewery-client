package com.microbrew.msscbreweryclient.web.client;

import com.microbrew.msscbreweryclient.web.model.CustomerDto;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "wr.brewery", ignoreUnknownFields = false)
public class CustomerClient {

    public final static String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private final RestTemplate restTemplate;
    @Setter
    public String apiHost;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDto getCustomerById(UUID customerId){
        return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1+ customerId, CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto){
        return restTemplate.postForLocation(apiHost+CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID customerId, CustomerDto customerDto){
        restTemplate.put(apiHost+CUSTOMER_PATH_V1+customerId, customerDto);
    }

    public void deleteCustomer(UUID customerId){
        restTemplate.delete(apiHost+CUSTOMER_PATH_V1+customerId);
    }

}
