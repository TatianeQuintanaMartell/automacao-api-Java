package TestCases;


import BaseTests.LoginBaseTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;


public class PostLogin extends LoginBaseTest {
    @Test
    public void fazerLogin(){
        given()
                .log().all()
                .spec(requestSpecification)
        .when()
                .post()

        .then()
                .log().all()
                .statusCode(200);

    }
}
