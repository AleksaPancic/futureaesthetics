package app.serializers;

import app.models.entities.CategoryEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CategorySerializer extends JsonSerializer<CategoryEntity> {
    @Override
    public void serialize(CategoryEntity value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeStringField("name", value.getName());
        jgen.writeEndObject();
    }
}
