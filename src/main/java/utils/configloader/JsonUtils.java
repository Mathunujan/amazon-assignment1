package utils.configloader;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import utils.Constants;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public final class JsonUtils {
    private static Map<String, String> map;
    private JsonUtils() {
    }

    public static String getValue(String key) throws IOException {

            return JsonPath.read(new File(Constants.getConfigJsonPath()), key);

    }

    static void readJson(String jsonPath) throws IOException {

            map = new ObjectMapper().readValue(new File(jsonPath),
                    new TypeReference<HashMap<String, String>>() {
                    });

    }


    }



