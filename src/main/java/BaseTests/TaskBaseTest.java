package BaseTests;

import Models.CreateTaskModel;
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

public class TaskBaseTest extends EndPoints {

    protected static RequestSpecification requestSpecification;
    protected static ResponseSpecification responseSpecification;
    protected static Map<String, Object> createTaskObject;
    private static String token;

    @BeforeAll
    public static void setUp(){
        ObjectUtils.extrairToken();
        System.out.println("gerou token");
        token = FileOperations.getProperties("VariableProperties").getProperty(token);
        createTaskObject = ObjectUtils.buildObjectMap("task",new CreateTaskModel());
        buildRequestSpec();
        buildResponseSpec();

    }

    private static void buildRequestSpec(){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_TASK)
                .addHeader("Authorization",token)
                .setContentType(ContentType.JSON)
                .build();
    }

    private static void buildResponseSpec(){
        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }

}
