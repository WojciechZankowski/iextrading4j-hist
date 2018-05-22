package pl.zankowski.iextrading4j.hist.api.message.administrative.field;

import pl.zankowski.iextrading4j.hist.api.IEXByteEnum;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import static pl.zankowski.iextrading4j.hist.api.util.IEXByteEnumLookupUtil.lookup;

public enum IEXSystemEvent implements IEXByteEnum {

    MESSAGES_START((byte) 0x4f),
    SYSTEM_HOURS_START((byte) 0x53),
    REGULAR_MARKET_HOURS_START((byte) 0x52),
    REGULAR_MARKET_HOURS_END((byte) 0x4d),
    SYSTEM_HOURS_END((byte) 0x45),
    MESSAGES_END((byte) 0x43);

    private static final Map<Byte, IEXSystemEvent> LOOKUP = new HashMap<>();

    static {
        for (final IEXSystemEvent value : EnumSet.allOf(IEXSystemEvent.class))
            LOOKUP.put(value.getCode(), value);
    }

    private final byte code;

    IEXSystemEvent(final byte code) {
        this.code = code;
    }

    public static IEXSystemEvent getSystemEvent(final byte code) {
        return lookup(IEXSystemEvent.class, LOOKUP, code);
    }

    @Override
    public byte getCode() {
        return code;
    }

}
