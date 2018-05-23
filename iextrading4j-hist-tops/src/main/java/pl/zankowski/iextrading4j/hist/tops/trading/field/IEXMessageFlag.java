package pl.zankowski.iextrading4j.hist.tops.trading.field;

import pl.zankowski.iextrading4j.hist.api.IEXByteEnum;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import static pl.zankowski.iextrading4j.hist.api.util.IEXByteEnumLookupUtil.lookup;

public enum IEXMessageFlag implements IEXByteEnum {

    ACTIVE_IN_SESSION((byte) 0x00),
    ACTIVE_OUT_SESSION((byte) 0x40),
    HALTED_IN_SESSION((byte) 0x80),
    HALTED_OUT_SESSION((byte) 0xc0);

    private static final Map<Byte, IEXMessageFlag> LOOKUP = new HashMap<>();

    static {
        for (final IEXMessageFlag value : EnumSet.allOf(IEXMessageFlag.class))
            LOOKUP.put(value.getCode(), value);
    }

    private final byte code;

    IEXMessageFlag(final byte code) {
        this.code = code;
    }

    public static IEXMessageFlag getMessageFromFlag(final byte code) {
        return lookup(IEXMessageFlag.class, LOOKUP, code);
    }

    @Override
    public byte getCode() {
        return code;
    }

}
