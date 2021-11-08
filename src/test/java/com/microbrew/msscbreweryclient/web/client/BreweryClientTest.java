package com.microbrew.msscbreweryclient.web.client;

import com.microbrew.msscbreweryclient.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
class BreweryClientTest {

  @Autowired BreweryClient client;

  @Test
  void getBeerById() {
    BeerDto beerDto = client.getBeerById(UUID.randomUUID());
    assertNotNull(beerDto);
  }

  @Test
  void testSaveNewBeer() {
    //given
    BeerDto beerDto = BeerDto.builder().beerName("new beer").build();

      URI uri = client.saveNewBeer(beerDto);
      assertNotNull(uri);

      log.info("uri : {}", uri.toString());
  }

  @Test
  void testUpdateBeer() {
    BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

    client.updateBeer(UUID.randomUUID(), beerDto);
  }

  @Test
  void testDeleteBeer() {
      client.deleteBeer(UUID.randomUUID());
  }
}
