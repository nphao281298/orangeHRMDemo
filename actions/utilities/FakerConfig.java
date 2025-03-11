package utilities;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerConfig {
    Faker faker = new Faker(new Locale("en-US"));

    public static FakerConfig getFaker(){
        return new FakerConfig();
    }
    public String getFirstName(){
        return faker.name().firstName();
    }

    public String getLastName(){
        return faker.name().lastName();
    }

    public String getCityName(){
        return faker.address().cityName();
    }

    public String getEmail(){
        return faker.internet().emailAddress();
    }

    public String getPassword(){
        return faker.internet().password();
    }
}
