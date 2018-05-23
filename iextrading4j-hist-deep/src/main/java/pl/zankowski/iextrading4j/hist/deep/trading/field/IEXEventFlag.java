package pl.zankowski.iextrading4j.hist.deep.trading.field;

import pl.zankowski.iextrading4j.hist.api.IEXByteEnum;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import static pl.zankowski.iextrading4j.hist.api.util.IEXByteEnumLookupUtil.lookup;

public enum IEXEventFlag implements IEXByteEnum {

    ORDER_BOOK_IS_PROCESSING_EVENT((byte) 0x0),
    EVENT_PROCESSING_COMPLETE((byte) 0x1);

    private static final Map<Byte, IEXEventFlag> LOOKUP = new HashMap<>();

    static {
        for (final IEXEventFlag value : EnumSet.allOf(IEXEventFlag.class))
            LOOKUP.put(value.getCode(), value);
    }

    private final byte code;

    IEXEventFlag(final byte code) {
        this.code = code;
    }

    @Override
    public byte getCode() {
        return code;
    }

    public static IEXEventFlag getEventFlag(final byte code) {
        return lookup(IEXEventFlag.class, LOOKUP, code);
    }

}
