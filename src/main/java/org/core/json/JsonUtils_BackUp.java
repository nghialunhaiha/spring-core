package org.core.json;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Collection;

public class JsonUtils_BackUp {
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false).setSerializationInclusion(Include.NON_NULL)
            .configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

    static {
        objectMapper.getSerializerProvider().setNullKeySerializer(new NullKeySeriliazer());
    }

    public static <T> String toJson(T object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new JsonSerializationException(e.getMessage(), e);
        }
    }

    public static <T> String toJson(T object, String defaultValue) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static <T> T fromJson(String json, Class<T> type) {
        try {
            return objectMapper.readValue(json, type);
        } catch (Exception e) {
            throw new JsonSerializationException(e.getMessage(), e);
        }
    }

    public static <T> T fromJson(String json, String type) {
        try {
            @SuppressWarnings("unchecked")
            Class<T> typeClass = (Class<T>) Class.forName(type);
            return fromJson(json, typeClass);
        } catch (ClassNotFoundException e) {
            throw new JsonSerializationException(e.getMessage(), e);
        }
    }

    public static <T> byte[] toJsonBytes(T value) throws JsonSerializationException {
        try {
            return objectMapper.writeValueAsBytes(value);
        } catch (JsonProcessingException e) {
            throw new JsonSerializationException(e.getMessage(), e);
        }
    }

    public static <T> T fromJsonBytes(byte[] json, Class<T> type) throws JsonSerializationException {
        try {
            return objectMapper.readValue(json, type);
        } catch (Exception e) {
            throw new JsonSerializationException(e.getMessage(), e);
        }
    }

    public static <T> T fromJsonBytes(byte[] json, Class<T> type, T defaultValue) {
        try {
            T result = fromJsonBytes(json, type);
            if (result == null) {
                return (T) defaultValue;
            }
            return result;
        } catch (JsonSerializationException e) {
            return (T) defaultValue;
        }
    }

    public static <T> T fromObject(Object value, Class<T> type) throws JsonSerializationException {
        return fromJson(toJson(value), type);
    }

    public static <T extends Collection<?>> T toCollection(String json, Class<T> collectionType, Class<?> elementType)
            throws JsonSerializationException {
        try {
            return objectMapper.readValue(json, constructCollectionType(collectionType, elementType));
        } catch (Exception e) {
            throw new JsonSerializationException("Cannot convert Json to Object type "
                    + constructCollectionType(collectionType, elementType).toString(), e);
        }
    }

    public static JavaType constructCollectionType(Class<? extends Collection<?>> collectionClass,
            Class<?> elementType) {
        return objectMapper.getTypeFactory().constructCollectionType(collectionClass, elementType);
    }

}
