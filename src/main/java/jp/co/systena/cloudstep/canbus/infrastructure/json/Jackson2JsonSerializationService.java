package jp.co.systena.cloudstep.canbus.infrastructure.json;

import org.springframework.stereotype.Component;

import jp.co.systena.cloudstep.canbus.application.json.JsonSerializationException;
import jp.co.systena.cloudstep.canbus.application.json.JsonSerializationService;

@Component
public class Jackson2JsonSerializationService implements JsonSerializationService {

    @Override
    public <T> String toJson(T object) {
        return JsonUtils.toJson(object);
    }

    @Override
    public <T> T fromJson(String json, Class<T> type) {
        return JsonUtils.fromJson(json, type);
    }

    @Override
    public <T> T fromJson(String json, String type) {
        return JsonUtils.fromJson(json, type);
    }

    @Override
    public <T> byte[] toJsonBytes(T value) throws JsonSerializationException {
        return JsonUtils.toJsonBytes(value);
    }

    @Override
    public <T> T fromJsonBytes(byte[] json, Class<T> type) throws JsonSerializationException {
        return JsonUtils.fromJsonBytes(json, type);
    }

    @Override
    public <T> T fromObject(Object value, Class<T> type) throws JsonSerializationException {
        return JsonUtils.fromObject(value, type);
    }

}
