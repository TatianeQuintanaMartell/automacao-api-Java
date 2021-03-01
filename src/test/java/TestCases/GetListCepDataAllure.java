package TestCases;

import BaseTests.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@Feature("Zippopotam DataClass")
public class GetListCepDataAllure extends TestBase {
    @Description("Beverly Hills")
    @ParameterizedTest
    @MethodSource("Utils.DataClass#cep1")
    public void listarCidadeBeverlyHills(String cep){
        given()
                .spec(requestSpecification)
        .when()
                .get(cep)
        .then()
                .log().body()
                .assertThat().statusCode(200)
                .body("places.'place name'",hasSize(1))
                .body("places[0].'place name'",equalTo("Beverly Hills"));

    }
    @Description("Santa Monica")
    @ParameterizedTest
    @MethodSource("Utils.DataClass#cep2")
    public void listarCidadeSantaMonica(String cep){
        given()
                .spec(requestSpecification)
        .when()
                .get(cep)
        .then()
                .log().body()
                .assertThat().statusCode(200)
                .body("places.'place name'",hasSize(1))
                .body("places[0].'place name'",equalTo("Santa Monica"));

    }
}
