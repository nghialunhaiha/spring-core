package org.led.simba.product;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.core.json.JsonUTils;

import java.io.IOException;
import java.util.Map;

/**
 * Created by nghialun on 17/10/2016.
 */
public class ProductItemDeserialize extends JsonDeserializer {
    @Override
    public Object deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = jp.getCodec();
        Map<?, ?> map = objectCodec.readValue(jp, Map.class);
        String json = JsonUTils.toJson(map);
        JsonNode node = jp.getCodec().readTree(jp);

        return null;
    }
}
