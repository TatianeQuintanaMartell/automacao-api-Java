package BaseTests;

import Models.LoginModel;
import Utils.EndPoints;
import Utils.FileOperations;
import Utils.ObjectUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import java.util.Map;

public class LoginBaseTest extends EndPoints {
    protected static RequestSpecification requestSpecification;
    protected static ResponseSpecification responseSpecification;
    protected static Map<String, Object>  loginObject;

    @BeforeAll
    public static void setUp(){
        email= FileOperations.getProperties("UserDataProperties").getProperty("email");
        buildRequestSpec();
        buildResponseSpec();
    }

    protected static void buildRequestSpec(){
        loginObject= ObjectUtils.buildObjectMap("session",new LoginModel(email,PASSWORD));
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_SESSION)
                .setBody(loginObject)
                .setContentType(ContentType.JSON)
                .build();
    }

    protected static void buildResponseSpec(){
        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }

}
