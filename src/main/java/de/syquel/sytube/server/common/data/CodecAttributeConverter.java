package de.syquel.sytube.server.common.data;

import de.syquel.sytube.server.video.data.Codec;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class CodecAttributeConverter implements AttributeConverter<Codec, String> {

    @Override
    public String convertToDatabaseColumn(final Codec codec) {
        return codec.toString();
    }

    @Override
    public Codec convertToEntityAttribute(final String s) {
        return Codec.valueOf(s);
    }
}
