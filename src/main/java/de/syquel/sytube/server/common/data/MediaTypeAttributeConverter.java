package de.syquel.sytube.server.common.data;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.hibernate.annotations.TypeDef;

import io.quarkus.runtime.annotations.RegisterForReflection;

@TypeDef(typeClass = MimeType.class)
@RegisterForReflection
@ApplicationScoped
@Converter(autoApply = true)
public class MediaTypeAttributeConverter implements AttributeConverter<MimeType, String> {

    @Override
    public String convertToDatabaseColumn(final MimeType mediaType) {
        return mediaType != null ? mediaType.toString() : null;
    }

    @Override
    public MimeType convertToEntityAttribute(final String s) {
        if (s == null) {
            return null;
        }

        try {
            return new MimeType(s);
        } catch (final MimeTypeParseException e) {
            throw new IllegalArgumentException("Illegal mime-type format " + s, e);
        }
    }
}
