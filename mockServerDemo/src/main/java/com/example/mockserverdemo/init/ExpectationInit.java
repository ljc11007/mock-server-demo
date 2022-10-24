package com.example.mockserverdemo.init;

import com.example.mockserverdemo.entity.UserEntity;
import org.mockserver.mock.Expectation;
import org.mockserver.server.initialize.ExpectationInitializer;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.JsonBody.json;

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
                        request().withPath("/simpleFirst").withMethod("POST").withQueryStringParameter("id","111").withBody(json(UserEntity.jsonRequest))).thenRespond(response().withBody(UserEntity.jsonResponse)
                ),
                new Expectation(
                        request().withPath("/simpleSecond")).thenRespond(response().withBody("some second response")
                )
        };
    }

}

