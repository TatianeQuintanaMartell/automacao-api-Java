package BaseTests;

import Models.CreateUserModel;
import Utils.EndPoints;
import Utils.FakersGeneration;
import Utils.ObjectUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import java.util.Map;

public class UserBaseTest extends EndPoints {

    protected static RequestSpecification requestSpecification;
    protected static ResponseSpecification responseSpecification;
    protected static Map<String,Object> creatUserObject;

    @BeforeAll
    public static  void setUp()  {

        email = FakersGeneration.setEmailProperties();
        creatUserObject= ObjectUtils.buildObjectMap("user",new CreateUserModel(email,PASSWORD));
        buildRequestSpec();
        buildResponseSpec();
    }

    private static void buildRequestSpec(){
        requestSpecification=new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_USERS)
                .setBody(creatUserObject)
                .setContentType(ContentType.JSON)
                .build();
    }

    private static void buildResponseSpec(){
        responseSpecification=new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }

}
