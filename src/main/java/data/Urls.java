package data;

import io.restassured.RestAssured;

public class Urls {

    public static final String STAGE = "https://gorest.co.in";
    public static final String GET_ALL_USERS = "/public-api/users";

    public static String getUrl(){
        String baseHost = System.getProperty("site_url");
        if(baseHost==null){
            baseHost =  STAGE;
        }
        return baseHost;
    }
}
