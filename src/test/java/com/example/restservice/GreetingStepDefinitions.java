package com.example.restservice;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GreetingStepDefinitions {

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<Greeting> responseEntity;

    @Given("the application is running")
    public void theApplicationIsRunning() {
        // Nothing to do here; assume the application is already running
    }

    @When("a user requests the greeting endpoint")
    public void aUserRequestsTheGreetingEndpoint() {
        responseEntity = restTemplate.getForEntity("/greeting", Greeting.class);
    }

    @Then("the response should have a 200 OK status code")
    public void theResponseShouldHaveA200OKStatusCode() {
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Then("the response should contain a valid Greeting object")
    public void theResponseShouldContainAValidGreetingObject() {
        Assertions.assertNotNull(responseEntity);
        Assertions.assertNotNull(responseEntity.getBody());
        Assertions.assertTrue(responseEntity.getBody() instanceof Greeting);
    }

    @When("a user requests the greeting endpoint with name {string}")
    public void aUserRequestsTheGreetingEndpointWithName(String name) {
        responseEntity = restTemplate.getForEntity("/greeting?name=" + name, Greeting.class);
    }

}