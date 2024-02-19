package kr.dbinc.evon.jackson;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import kr.dbinc.evon.ocpp.types.dto.SampledValueRequest;
import kr.dbinc.evon.ocpp.types.enums.*;

import java.io.IOException;

public class SampledValueDeserializer extends JsonDeserializer<SampledValueRequest> {

    @Override
    public SampledValueRequest deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        ObjectCodec oc = p.getCodec();
        JsonNode node = oc.readTree(p);

        final String value = node.get("value").textValue();

        ReadingContext context = null;
        if(node.get("context") != null){
            context = ReadingContext.fromString(node.get("context").textValue());
        }

        ValueFormat format = null;
        if(node.get("format") != null){
            format = ValueFormat.valueOf(node.get("format").textValue());
        }

        Measurand measurand = null;
        if(node.get("measurand") != null){
            measurand = Measurand.fromString(node.get("measurand").textValue());
        }

        Phase phase = null;
        if(node.get("phase") != null){
            phase = Phase.fromString(node.get("phase").textValue());
        }

        Location location = null;
        if(node.get("location") != null){
            location = Location.valueOf(node.get("location").textValue());
        }


        UnitOfMeasure unit = null;
        if(node.get("unit") != null){
            unit = UnitOfMeasure.valueOf(node.get("unit").textValue());
        }
        return new SampledValueRequest(
                value,
                context,
                format,
                measurand,
                phase,
                location,
                unit
        );
    }
}
