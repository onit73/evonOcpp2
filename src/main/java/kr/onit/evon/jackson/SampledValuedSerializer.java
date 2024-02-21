package kr.onit.evon.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import kr.onit.evon.ocpp.types.dto.SampledValueRequest;

import java.io.IOException;

public class SampledValuedSerializer extends JsonSerializer<SampledValueRequest> {

    @Override
    public void serialize(SampledValueRequest value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();

        if(value.getValue() != null){
            gen.writeFieldName("value");
            gen.writeString(value.getValue());
        }

        if(value.getContext() != null) {
            gen.writeFieldName("context");
            gen.writeString(value.getContext().getValue());
        }

        if(value.getFormat() != null) {
            gen.writeFieldName("format");
            gen.writeString(value.getFormat().getValue());
        }

        if(value.getMeasurand() != null) {
            gen.writeFieldName("measurand");
            gen.writeString(value.getMeasurand().getValue());
        }

        if(value.getPhase() != null) {
            gen.writeFieldName("phase");
            gen.writeString(value.getPhase().getValue());

        }

        if(value.getLocation() != null) {
            gen.writeFieldName("location");
            gen.writeString(value.getLocation().getValue());
        }

        if(value.getUnit() != null) {
            gen.writeFieldName("unit");
            gen.writeString(value.getUnit().getValue());
        }

        gen.writeEndObject();
    }
}
