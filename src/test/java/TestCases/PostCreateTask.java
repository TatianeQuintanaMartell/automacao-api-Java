package TestCases;

import BaseTests.TaskBaseTest;
import Utils.FileOperations;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

public class PostCreateTask extends TaskBaseTest {

    @Test
    public void criarTarefa() {
        Response response =
                given()
                        .spec(requestSpecification)
                        .body(createTaskObject)
                .when()
                        .post()
                .then()
                        .spec(responseSpecification)
                        .statusCode(201)
                        .extract().response();
         FileOperations.setProperties("VariableProperties","id",response.then().extract().path("data.id"));
         deletarTarefa(FileOperations.getProperties("VariableProperties").getProperty("id"));

    }

    public void deletarTarefa(String id){
        given()
                .spec(requestSpecification)
        .when()
                .delete("/"+id)
        .then()
                .statusCode(204);
    }
}
