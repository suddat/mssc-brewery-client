package com.microbrew.msscbreweryclient.web.client;

import com.microbrew.msscbreweryclient.web.model.BeerDto;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {

  public final String BEER_PATH_V1 = "/api/v1/beer/";

  @Setter private String apiHost;
  private final RestTemplate restTemplate;

  public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public BeerDto getBeerById(UUID beerId) {
    return restTemplate.getForObject(apiHost + BEER_PATH_V1 + beerId.toString(), BeerDto.class);
  }

  public URI saveNewBeer(BeerDto beerDto){
      return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDto);
  }

  public void updateBeer(UUID beerId, BeerDto beerDto){
    restTemplate.put(apiHost + BEER_PATH_V1 + beerId.toString(), beerDto);
  }

  public void deleteBeer(UUID beerId){
    restTemplate.delete(apiHost + BEER_PATH_V1 + beerId);
  }

}
