package com.example.mockserverdemo.init;

import org.mockserver.mock.Expectation;
import org.mockserver.server.initialize.ExpectationInitializer;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

/**
 * <p>
 * Expectation Initializer Class，用来初始化 expectation
 * <p/>
 *
 */
public class ExpectationInit implements ExpectationInitializer {

    @Override
    public Expectation[] initializeExpectations() {
        return new Expectation[]{
                new Expectation(
                        request().withPath("/simpleFirst")).thenRespond(response().withBody("some first response")
                ),
                new Expectation(
                        request().withPath("/simpleSecond")).thenRespond(response().withBody("some second response")
                )
        };
    }

}

