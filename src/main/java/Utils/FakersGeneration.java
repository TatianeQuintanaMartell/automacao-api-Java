package Utils;

import com.github.javafaker.Faker;
import java.util.Locale;

public class FakersGeneration {

    public static String setEmailProperties() {
        String email = new Faker(new Locale("pt-BR")).internet().emailAddress();
        FileOperations.setProperties("UserDataProperties","email",email);
        return email;

    }

}
