package de.syquel.sytube.server.common.rest;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import de.syquel.sytube.server.video.data.Codec;

import java.io.IOException;

public class CodecDeserializer extends JsonDeserializer<Codec> {

    @Override
    public Codec deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
        return Codec.valueOf(p.getText());
    }
}
