package de.syquel.sytube.server.video.data;

import java.util.Objects;

public class Codec {

    private final String type;
    private final String subtype;

    private Codec(final String type, final String subtype) {
        this.type = type;
        this.subtype = subtype;
    }

    public String getType() {
        return type;
    }

    public String getSubtype() {
        return subtype;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Codec codec = (Codec) o;
        return type.equals(codec.type) && subtype.equals(codec.subtype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, subtype);
    }

    @Override
    public String toString() {
        return type + subtype;
    }

    public static Codec valueOf(final String identifier) {
        final String[] identifiers = identifier.split("\\.", 2);

        if (identifiers.length == 2) {
            return new Codec(identifiers[0], identifiers[1]);
        } else if (identifiers.length == 1) {
            return new Codec(identifiers[0], "");
        }

        return new Codec("", "");
    }
}
