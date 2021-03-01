package TestCases;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class PostContatosMap {
    private static RequestSpecification requestSpecification;
    private static ResponseSpecification responseSpecification;
    @BeforeEach
    public void setUp(){
        Map <String,Object> requestParams = new HashMap();
        requestParams.put("name","tatiane");
        requestParams.put("left_name","quintana");
        requestParams.put("email","tatiaaane@hotmail.com");
        requestParams.put("age","10");
        requestParams.put("phone","51983108310");
        requestParams.put("address","rua 10");
        requestParams.put("state","santa");
        requestParams.put("city","poa");

        requestSpecification = new RequestSpecBuilder()
             .setBaseUri("https://api-de-tarefas.herokuapp.com")
             .setBasePath("/contacts")
             .setContentType(ContentType.JSON)
             .addHeader("Content-Type","application/json")
             .addHeader("Accept","application/vnd.tasksmanager.v2")
             .setBody(requestParams)
             .build();

        responseSpecification = new ResponseSpecBuilder()
             .expectContentType(ContentType.JSON)
             .build();
    }
    @Test
    public void criarContato(){
        given()
              .spec(requestSpecification)
        .when()
              .post()
        .then()
              .spec(responseSpecification)
        .and()
              .log().body()
              .statusCode(201);
    }
    @Test
    public void criarContatoExtraindoID(){
        String id =
            given()
                  .spec(requestSpecification)
            .when()
                  .post()
            .then()
                  .spec(responseSpecification)
            .and()
                 .log().body()
                 .statusCode(201)
                 .extract().path("data.id");
        System.out.println(id.toString());
        deletarContato(id);
        verificarSeDeletouPorID(id);
    }
    private void deletarContato(String id){
        given()
                .spec(requestSpecification)
        .when()
                .delete("/"+id)
        .then()
                .log().ifValidationFails(LogDetail.BODY)
                .statusCode(204);
    }
    private void verificarSeDeletouPorID(String id){
        given()
             .spec(requestSpecification)
        .when()
             .delete("/"+id)
        .then()
             .log().ifValidationFails(LogDetail.BODY)
             .statusCode(404);
    }
}
