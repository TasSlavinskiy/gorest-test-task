package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.json.Json;
import data.User;
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;

public class Convert {

    private final static String baseFile = "user.json";

    public static void toJSON(User user) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), user);
    }

    public static User toJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile), User.class);
    }

    public static String getJson(User user) {
        Gson gson = new Gson();
        String json = gson.toJson(user);
        return json;
    }

}
