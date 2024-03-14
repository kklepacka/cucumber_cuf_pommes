package com.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

import java.text.spi.NumberFormatProvider;

import org.opentestfactory.exception.ParameterException;
import org.opentestfactory.util.ParameterService;


public class StepDefinitions {

    private TestContext context;

    public StepDefinitions(TestContext context) {
        this.context = context;
    }

    @Given("That I have the expected number of apples retrieved from CUF1")
    public void that_I_have_the_expected_number_of_apples_retrieved_from_CUF1() {
        // Initialize the number of apples from the context
        // Note: No return statement is necessary or valid here
        int initNumApples = context.getInitNumApples(); // Corrected method name based on standard Java naming conventions
        // Storing initial number of apples in context or an instance variable if needed
        context.setRemainingApples(initNumApples); // Assuming you have such a method to update context
        System.out.println("Number of apples from context: " + initNumApples);
    }

    @When("I eat {int} apple")
    public void i_eat_apple(int applesEaten) {
        // Retrieve initNumApples from the context
        int initNumApples = context.getInitNumApples();
        // Calculate remaining apples after eating
        int remainingApples = initNumApples - applesEaten;
        // Update the context with the new remaining apples count
        context.setRemainingApples(remainingApples);
    }

    @Then("I should have the number of apples retrieved from CUF2")
    public void i_should_have_the_number_of_apples_retrieved_from_CUF2() throws ParameterException {
        // Retrieve the expected number of remaining apples from CUF2 for comparison
        int expectedApples = ParameterService.INSTANCE.getInt("CPG_CUF_CUF2");
        // Get the actual remaining apples from context
        int actualRemainingApples = context.getRemainingApples();
        // Assert that the remaining apples match the expected count from CUF2
        assertEquals(expectedApples, actualRemainingApples);
        System.out.println("Remaining apples: " + actualRemainingApples);
    }
}