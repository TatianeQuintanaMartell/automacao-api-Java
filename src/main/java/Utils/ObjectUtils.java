package Utils;

import BaseTests.LoginBaseTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class ObjectUtils extends LoginBaseTest {
    public static String[] ArrayListStringsToStringArray(ArrayList<String[]> lista){
        String[] vetor = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            vetor[i] = lista.get(i)[0];
        }
        return vetor;
    }

    public static Map<String, Object> buildObjectMap(String key, Object object){
        Map<String, Object> createUser = new HashMap<>();
        createUser.put(key, object);
        return createUser;
    }

    public static void extrairToken(){
        buildRequestSpec();
        String token =
                given()
                        .spec(requestSpecification)
                .when()
                        .post()
                .then()
                      .extract().path("data.attributes.auth-token");
        FileOperations.setProperties("VariableProperties","token",token);

    }
}
