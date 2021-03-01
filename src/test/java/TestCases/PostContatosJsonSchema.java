package TestCases;

import Models.RequestContactsModel;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PostContatosJsonSchema {
    private static RequestSpecification requestSpecification;
    private static ResponseSpecification responseSpecification;
    private RequestContactsModel requestContactsModel = new RequestContactsModel();
    @BeforeEach
    public void setUp(){
        requestSpecification = new RequestSpecBuilder()
             .setBaseUri("https://api-de-tarefas.herokuapp.com")
             .setBasePath("/contacts")
             .setContentType(ContentType.JSON)
             .addHeader("Content-Type","application/json")
             .addHeader("Accept","application/vnd.tasksmanager.v2")
             .setBody(requestContactsModel)
             .build();

        responseSpecification = new ResponseSpecBuilder()
             .expectContentType(ContentType.JSON)
             .build();
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
                 .statusCode(201)
                 .log().body()
                 .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas/json-schema.json"))
                 .extract().path("data.id");
        System.out.println(id.toString());
        deletarContato(id);
        verificarSeDeletouPorID(id);
    }
    @Test
    public void criarContatoExtraindoIDSchemaInvalido(){
        String id =
                given()
                        .spec(requestSpecification)
                 .when()
                        .post()
                 .then()
                        .spec(responseSpecification)
                        .statusCode(201)
                        .log().body()
                        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas/json-schema-invalid.json"))
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
