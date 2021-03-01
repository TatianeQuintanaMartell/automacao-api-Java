package TestCases;

import BaseTests.UserBaseTest;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Test;
import java.io.File;
import static io.restassured.RestAssured.*;

public class PostCreateUsers extends UserBaseTest {

    @Test
    public void criarUsuarioComSucesso(){
        given()
                .log().all()
                .spec(requestSpecification)

        .when()
                .post()
        .then()
                .log().all()
                .spec(responseSpecification)
                .statusCode(201)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas"+ File.separator+"CreateUserJsonSchema.json"));

    }

}
