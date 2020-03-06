import data.Urls;
import data.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class GoRestTest {

    private User newUser = new User();
    private String ACCESS_TOKEN = "zB4kY2fVpgL_sStD_1uTmMdUk53AODwS20xG";

    @BeforeTest
    public void configureRestAssured()  {

        RestAssured.baseURI = Urls.getUrl();
        RestAssured.requestSpecification = given().auth().oauth2(ACCESS_TOKEN).contentType("application/json");
        newUser = newUser.randomUser();
    }


    @Test
    public void getListAllUsers(){

        Response response = given()
                            .log().all()
                            .when()
                            .get("/public-api/users")
                            .then()
                            .log().all()
                            .assertThat()
                            .statusCode(200)
                            .extract()
                            .response();

        System.out.println(response.print());
    }

    @Test
    public void createNewUser() {
        System.out.println(newUser.toString());
    }
}
