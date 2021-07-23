package de.syquel.sytube.server.video.rest;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class VideoControllerTest {

    @Test
    public void listTest() {
        final JsonPath jsonPath = given()
                .when().get("/videos")
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .contentType(ContentType.JSON)
                    .extract().jsonPath();

        assertTrue(jsonPath.getList("$").isEmpty());
    }

    @Test
    public void readFailedTest() {
        given()
                .when().get("/videos/abcdabcdabcdabcdabcd")
                .then()
                .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    @Test
    public void readTest() {
        given()
                .when().get("/videos/abcdabcdabcdabcdabcdabcd")
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }
}