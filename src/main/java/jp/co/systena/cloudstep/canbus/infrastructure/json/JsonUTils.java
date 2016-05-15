package jp.co.systena.cloudstep.canbus.infrastructure.json;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import jp.co.systena.cloudstep.canbus.application.json.JsonSerializationException;

public class JsonUTils {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false).setSerializationInclusion(Include.NON_NULL)
                .configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
    }

    public static <T> String toJson(T value) {
        try {
            return OBJECT_MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new JsonSerializationException(e.getMessage(), e);
        }
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            throw new JsonSerializationException(e.getMessage(), e);
        }
    }
}
