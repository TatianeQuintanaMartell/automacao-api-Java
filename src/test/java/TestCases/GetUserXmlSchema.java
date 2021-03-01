package TestCases;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

public class GetUserXmlSchema {
    private static RequestSpecification requestSpecification;
    @BeforeEach
    public void SetUp(){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://restapi.wcaquino.me")
                .setBasePath("/usersXML")
                .build();
    }
    @Test
    public void listarUsuarioXmlValidator(){
        given()
               .spec(requestSpecification)
        .when()
               .get()
        .then()
               .log().body()
               .statusCode(200)
               .body(RestAssuredMatchers.matchesXsdInClasspath("Schemas/users.xsd"));
    }
    @Test
    public void listarUsuarioXsdInvalido(){
        given()
                .spec(requestSpecification)
        .when()
                .get()
        .then()
                .log().body()
                .statusCode(200)
                .body(RestAssuredMatchers.matchesXsdInClasspath("Schemas/users-invalid.xsd"));
    }
}
