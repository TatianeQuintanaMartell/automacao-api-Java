package TestCases;

import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetListContatosBasic {
    private String URL = "https://api-de-tarefas.herokuapp.com/contacts";
    @Test
    public void listarContatos(){
        given()
        .when()
             .get(URL)
        .then()
             .log().body()
             .assertThat()
             .statusCode(200);
    }
    @Test
    public void listarContatosExtractResponse(){
        Response response =
                given()
                .when()
                        .get(URL)
                .then()
                        .log().body()
                        .assertThat()
                        .statusCode(200)
                        .extract().response();
        response.body().prettyPrint();
    }
    @Test
    public void listarContatosExtractId(){
        String response =
                given()
                .when()
                      .get(URL)
                .then()
                      .assertThat()
                      .statusCode(200)
                      .extract().path("data[0].id");
       System.out.println(response.toString());
    }
    @Test
    public void listarContatosExtractIdValidacaoLog(){
        String response =
                given()
                .when()
                        .get(URL)
                .then()
                        .log()
                        .ifValidationFails(LogDetail.BODY)
                        .assertThat().statusCode(500)
                        .extract().path("data[0].id");
        System.out.println(response.toString());
    }
    @Test
    public void listarContatoValidacaoResponse(){
                 given()
                .when()
                         .get(URL)
                .then()
                         .log().body()
                         .assertThat().statusCode(200)
                         .body("data[0].attributes.name",equalTo("JuniorTOPa30"));
                         //.body("data[0].'attributes'",hasSize(1));
    }
}
