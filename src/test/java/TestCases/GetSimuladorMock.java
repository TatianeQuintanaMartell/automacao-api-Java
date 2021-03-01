package TestCases;

import BaseTests.SimuladorMockBaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static Utils.FileOperations.csvToArrayList;
import static Utils.ObjectUtils.ArrayListStringsToStringArray;
import static io.restassured.RestAssured.*;

public class GetSimuladorMock extends SimuladorMockBaseTest {

    @Test
    public void  listarcsv(){
        Response response =
                given()
                        .spec(requestSpecification)
                .when()
                        .get()
                .then()
                     .log().body()
                     .spec(responseSpecification)
                    .extract().response();

        ArrayList<String> mesesActual = response.then().extract().response().getBody().path("meses");
        String[] mesesExpected = ArrayListStringsToStringArray(csvToArrayList("SimuladorMockMeses"));

        ArrayList<String> valoresActual = response.then().extract().response().getBody().path("valor");
        String[] valoresExpected = ArrayListStringsToStringArray(csvToArrayList("SimuladorMockValores"));

        Assertions.assertArrayEquals(mesesActual.toArray(),mesesExpected);
        Assertions.assertArrayEquals(valoresActual.toArray(),valoresExpected);

    }

}
