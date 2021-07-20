package de.syquel.sytube.server.common.rest;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.syquel.sytube.server.video.data.Codec;

import java.io.IOException;

public class CodecSerializer extends JsonSerializer<Codec> {

    @Override
    public void serialize(final Codec value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {
        gen.writeString(value.toString());
    }
}
