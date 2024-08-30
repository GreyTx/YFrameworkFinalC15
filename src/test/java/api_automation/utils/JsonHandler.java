package api_automation.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Utility class for handling JSON serialization and deserialization using Jackson.
 *
 * Provides methods to convert objects to JSON strings and to convert JSON strings
 * back into objects.
 */
public class JsonHandler {

    private static final ObjectMapper objectMapper = new ObjectMapper();


    public static String convertObjectToJson(Object obj) {
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            LoggingUtils.logger.info(e.getMessage());

            return null;

        }
    }


    public static <T> T convertJsonToObject(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            LoggingUtils.logger.info(e.getMessage());
            return null;

        }
    }
}
