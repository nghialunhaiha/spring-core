package org.core.json;

public interface JsonSerializationService {

    <T> String toJson(T object) throws JsonSerializationException;

    <T> byte[] toJsonBytes(T object) throws JsonSerializationException;

    <T> T fromJson(String json, String type) throws JsonSerializationException;

    <T> T fromJson(String json, Class<T> type) throws JsonSerializationException;

    <T> T fromJsonBytes(byte[] json, Class<T> type) throws JsonSerializationException;

    <T> T fromObject(Object value, Class<T> type) throws JsonSerializationException;

}
