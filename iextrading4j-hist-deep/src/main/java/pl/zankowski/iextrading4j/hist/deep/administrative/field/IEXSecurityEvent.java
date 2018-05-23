package pl.zankowski.iextrading4j.hist.deep.administrative.field;

import pl.zankowski.iextrading4j.hist.api.IEXByteEnum;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import static pl.zankowski.iextrading4j.hist.api.util.IEXByteEnumLookupUtil.lookup;

public enum IEXSecurityEvent implements IEXByteEnum {

    OPENING_PROCESS_COMPLETE((byte) 0x4f),
    CLOSING_PROCESS_COMPLETE((byte) 0x43);

    private static final Map<Byte, IEXSecurityEvent> LOOKUP = new HashMap<>();

    static {
        for (final IEXSecurityEvent value : EnumSet.allOf(IEXSecurityEvent.class))
            LOOKUP.put(value.getCode(), value);
    }

    private final byte code;

    IEXSecurityEvent(byte code) {
        this.code = code;
    }

    public static IEXSecurityEvent getSecurityEvent(final byte code) {
        return lookup(IEXSecurityEvent.class, LOOKUP, code);
    }

    @Override
    public byte getCode() {
        return code;
    }

}
