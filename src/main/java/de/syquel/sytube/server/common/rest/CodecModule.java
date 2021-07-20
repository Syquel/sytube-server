package de.syquel.sytube.server.common.rest;

import com.fasterxml.jackson.databind.module.SimpleModule;
import de.syquel.sytube.server.video.data.Codec;

public class CodecModule extends SimpleModule {

    public CodecModule() {
        addSerializer(Codec.class, new CodecSerializer());
        addDeserializer(Codec.class, new CodecDeserializer());
    }
}
