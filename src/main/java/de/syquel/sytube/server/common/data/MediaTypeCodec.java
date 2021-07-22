package de.syquel.sytube.server.common.data;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

import javax.ws.rs.core.MediaType;

public class MediaTypeCodec implements Codec<MediaType> {
    public MediaTypeCodec() {

    }

    @Override
    public MediaType decode(final BsonReader bsonReader, final DecoderContext decoderContext) {
        return MediaType.valueOf(bsonReader.readString());
    }

    @Override
    public void encode(final BsonWriter bsonWriter, final MediaType mediaType, final EncoderContext encoderContext) {
        bsonWriter.writeString(mediaType.toString());
    }

    @Override
    public Class<MediaType> getEncoderClass() {
        return MediaType.class;
    }
}
