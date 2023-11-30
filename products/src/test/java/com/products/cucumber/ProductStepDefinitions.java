package com.products.cucumber;

import com.products.entity.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductStepDefinitions {


    @Autowired
    private RestTemplate restTemplate;
    private ResponseEntity<String> responseEntity;
    Product product = null;


    @Given("I set POST product api endpoint")
    public void setPostEndpoint(){

    }

    @When("I set request Header and send the POST HTTP request")
    public void sendPostRequest() throws IOException {

        String jsonBody = "{ \"name\": \"Product1\", \"price\": 91, \"quantity\": 11 }";
        String addURI= "http://localhost:8081/products";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String>entity = new HttpEntity<String>(jsonBody, headers);
        responseEntity = restTemplate.postForEntity(addURI, entity, String.class);
    }

    @Then("I receive valid response")
    public void i_receive_valid_response() {

        HttpStatus statusCode = (HttpStatus) responseEntity.getStatusCode();
        int statusCodeValue = statusCode.value();
        System.out.println("Status Code "+statusCodeValue);
        String responseBody = String.valueOf(responseEntity.getBody());
        assertEquals(200,statusCodeValue);
    }

// GET SCENARIO
    private ResponseEntity<Product> responseEntity2;

    @Given("I set GET product api endpoint")
    public void setGetEndpoint() {
        // You can set the GET endpoint URL here if needed
    }

    @When("I send a GET HTTP request for product with ID {int}")
    public void sendGetRequest(int productId) {
        String getURI = "http://localhost:8081/products/" + productId;
        responseEntity2 = restTemplate.getForEntity(getURI, Product.class);
    }

    @Then("I receive a valid response with product details")
    public void receiveValidResponse() {
        HttpStatus statusCode = (HttpStatus) responseEntity2.getStatusCode();
        assertEquals(HttpStatus.OK, statusCode);

        int statusCodeValue = statusCode.value();
        System.out.println("Status Code "+statusCodeValue);
        assertEquals(200,statusCodeValue);

        String responseBody = String.valueOf(responseEntity2.getBody());
        System.out.println(responseBody);


        Product product = responseEntity2.getBody();
        assertNotNull(product);
    }
}









