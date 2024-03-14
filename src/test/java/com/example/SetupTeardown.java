package com.example;

import io.cucumber.java.Before;
import org.opentestfactory.exception.ParameterException;
import org.opentestfactory.util.ParameterService;

public class SetupTeardown {
    private TestContext context;

    public SetupTeardown(TestContext context) {
        this.context = context;
    }

    @Before
    public void setUp() {
        try {
            // Retrieve the number of apples from ParameterService and store it in the context
            int initNumApples = ParameterService.INSTANCE.getInt("CPG_CUF_CUF1");
            context.setInitNumApples(initNumApples);
        } catch (ParameterException e) {
            // Handle the exception, e.g., log the error or take appropriate action
            System.out.println("ParameterException occurred: " + e.getMessage());
        }
    }
}