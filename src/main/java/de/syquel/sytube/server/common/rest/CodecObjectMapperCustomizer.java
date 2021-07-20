package de.syquel.sytube.server.common.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.jackson.ObjectMapperCustomizer;

import javax.inject.Singleton;

@Singleton
public class CodecObjectMapperCustomizer implements ObjectMapperCustomizer {

    @Override
    public void customize(final ObjectMapper objectMapper) {
        objectMapper.registerModule(new CodecModule());
    }
}
