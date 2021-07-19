package de.syquel.sytube.server.common.data;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import javax.ws.rs.core.MediaType;

@Converter(autoApply = true)
public class MediaTypeAttributeConverter implements AttributeConverter<MediaType, String> {

    @Override
    public String convertToDatabaseColumn(final MediaType mediaType) {
        return mediaType.toString();
    }

    @Override
    public MediaType convertToEntityAttribute(final String s) {
        return MediaType.valueOf(s);
    }
}
