import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import data.Urls;
import data.User;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import util.Convert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;
import static io.restassured.config.RedirectConfig.redirectConfig;
import static io.restassured.config.RestAssuredConfig.config;
import static io.restassured.config.RestAssuredConfig.newConfig;

public class GoRestTest {

    private User newUser;
    private String ACCESS_TOKEN = "zB4kY2fVpgL_sStD_1uTmMdUk53AODwS20xG";

    private RequestSpecification spec(){
        RestAssuredConfig restAssuredConfig = RestAssuredConfig.config()
                .redirect(redirectConfig().followRedirects(false))
                .objectMapperConfig(new ObjectMapperConfig().jackson2ObjectMapperFactory(
                        (aClass, s) -> new ObjectMapper().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)));

        return (RequestSpecification) restAssuredConfig;
    }

    @BeforeTest
    public void setUp() throws ParseException {
        RestAssured.baseURI = Urls.getUrl();
        newUser = new User();
        newUser = newUser.randomUser();
    }

//    @BeforeMethod
//    public void configRest() {
//        RestAssured.requestSpecification = given().auth().oauth2(ACCESS_TOKEN).contentType("application/json");
//    }

    @Test
    public void getListAllUsers(){

        Response response = given()
                            .log().all()
                            .when()
                            .get("/public-api/users")
                            .then()
                            .log().all()
                            .extract()
                            .response();

        response.then().assertThat().statusCode(200);
    }

    @Test
    public void createNewUser() throws IOException {

//        Convert.toJSON(newUser);

        System.out.println(Convert.getJson(newUser));

//        RestAssured.config = config().redirect(redirectConfig().followRedirects(true).and().maxRedirects(20));

        RestAssuredConfig restAssuredConfig = RestAssuredConfig.config()
                .redirect(redirectConfig().followRedirects(false))
                .objectMapperConfig(new ObjectMapperConfig().jackson2ObjectMapperFactory(
                        (aClass, s) -> new ObjectMapper().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)));

        given()
                            .spec((RequestSpecification) restAssuredConfig)
                            .auth().oauth2(ACCESS_TOKEN).contentType("application/json")
                            .log().all()
                            .contentType(ContentType.JSON)
                            .body(newUser)
                            .expect().statusCode(200)
                            .when()
                            .post("/public-api/users")
                            .then()
                            .extract().response();

    }
}
