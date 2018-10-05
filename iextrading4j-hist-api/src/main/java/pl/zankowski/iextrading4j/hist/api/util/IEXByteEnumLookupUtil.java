package pl.zankowski.iextrading4j.hist.api.util;

import pl.zankowski.iextrading4j.hist.api.IEXByteEnum;

import java.util.Map;

public class IEXByteEnumLookupUtil {

    public static <E extends Enum<E> & IEXByteEnum> E lookup(final Class<E> clazz, final Map<Byte, E> lookup,
            byte code) {
        final E value = lookup.get(code);
        if (value == null) {
            throw new IllegalArgumentException("Unknown value: " + code + " for enum " + clazz.getSimpleName());
        }
        return value;
    }

}
