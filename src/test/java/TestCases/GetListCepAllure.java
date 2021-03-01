package TestCases;

import BaseTests.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Feature("zippopotam")
public class GetListCepAllure extends TestBase {
    private String cep1 = getCep("cep1");
    private String cep2 = getCep("cep2");

    @Description("Validação dos ítens de Cep 90210 Beverly Hills")
    @Test
    public void listarCidadeBeverlyHills(){
        given()
              .spec(requestSpecification)
        .when()
                .get(cep1)
        .then()
                .log().body()
                .assertThat().statusCode(200)
                .body("places.'place name'",hasSize(1))
                .body("places[0].'place name'",equalTo("Beverly Hills"));

    }

    @Description("Validação dos ítens de Cep 90402 Santa Monica")
    @Test
    public void listarCidadeSantaMonica(){
        given()
                .spec(requestSpecification)
                .when()
                .get(cep2)
                .then()
                .log().body()
                .assertThat().statusCode(200)
                .body("places.'place name'",hasSize(1))
                .body("places[0].'place name'",equalTo("Santa Monica"));

    }
}
