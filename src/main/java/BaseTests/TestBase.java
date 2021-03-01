package BaseTests;

import Utils.FileOperations;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import java.util.Properties;

public class TestBase {
    protected static RequestSpecification requestSpecification;
    protected static ResponseSpecification responseSpecification;
    private  FileOperations fileOperations = new FileOperations();
    protected Properties ceps;

    public String getCep(String cep){
        try {
            ceps = fileOperations.getProperties("cep");
            return ceps.getProperty(cep);
        }
        catch (Exception e){
            System.out.println("Não foi possível ler o arquivo"+e.getMessage());
            return null;
        }
    }

    @BeforeAll
    public static void createRequest(){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://zippopotam.us")
                .setBasePath("/us")
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }
}
