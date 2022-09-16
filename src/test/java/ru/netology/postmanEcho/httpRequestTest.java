package ru.netology.postmanEcho;


import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class PostmanEchoTest {

    @Test
    void shouldCheckHttpRequest1() {
        given()
                .baseUri("https://postman-echo.com")
                .body("some data")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("some data"))
        ;
    }

    @Test
    void shouldCheckHttpRequest2() {
        given()
                .baseUri("https://postman-echo.com")
                .body("Go and do it")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", containsString("and"))
        ;
    }
}