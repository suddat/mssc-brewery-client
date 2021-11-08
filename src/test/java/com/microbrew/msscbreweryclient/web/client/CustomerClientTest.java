package com.microbrew.msscbreweryclient.web.client;

import com.microbrew.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomerClientTest {

  @Autowired CustomerClient client;

  @Test
  void getCustomerById() {
    CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());
    assertNotNull(customerDto);
  }

  @Test
  void saveNewCustomer() {
    CustomerDto customerDto = CustomerDto.builder().customerName("new customer").build();
    URI uri = client.saveNewCustomer(customerDto);
    assertNotNull(uri);
  }

  @Test
  void updateCustomer() {
    CustomerDto customerDto = CustomerDto.builder().customerName("update customer name").build();
    client.updateCustomer(UUID.randomUUID(), customerDto);
  }

  @Test
  void deleteCustomer() {
    client.deleteCustomer(UUID.randomUUID());
  }
}
