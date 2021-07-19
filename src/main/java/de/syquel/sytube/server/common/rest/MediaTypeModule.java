package de.syquel.sytube.server.common.rest;

import com.fasterxml.jackson.databind.module.SimpleModule;

import javax.ws.rs.core.MediaType;

public class MediaTypeModule extends SimpleModule {

    public MediaTypeModule() {
        addSerializer(MediaType.class, new MediaTypeSerializer());
        addDeserializer(MediaType.class, new MediaTypeDeserializer());
    }
}
