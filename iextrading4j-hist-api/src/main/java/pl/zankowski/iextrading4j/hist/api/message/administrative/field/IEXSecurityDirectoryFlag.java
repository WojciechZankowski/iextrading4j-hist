package pl.zankowski.iextrading4j.hist.api.message.administrative.field;

import pl.zankowski.iextrading4j.hist.api.IEXByteEnum;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import static pl.zankowski.iextrading4j.hist.api.util.IEXByteEnumLookupUtil.lookup;

// TODO THIS IS WRONG
public enum IEXSecurityDirectoryFlag implements IEXByteEnum {

    SYMBOL_IS_NOT_TEST((byte) 0x80),
    SYMBOL_IS_TEST((byte) 0x80),
    SYMBOL_IS_NOT_WHEN_ISSUED((byte) 0x40),
    SYMBOL_IS_WHEN_ISSUED((byte) 0x40),
    SYMBOL_IS_NOT_ETP((byte) 0x20),
    SYMBOL_IS_ETP((byte) 0x20);

    private static final Map<Byte, IEXSecurityDirectoryFlag> LOOKUP = new HashMap<>();

    static {
        for (final IEXSecurityDirectoryFlag value : EnumSet.allOf(IEXSecurityDirectoryFlag.class))
            LOOKUP.put(value.getCode(), value);
    }

    private final byte code;

    IEXSecurityDirectoryFlag(final byte code) {
        this.code = code;
    }

    public static IEXSecurityDirectoryFlag getSecurityDirectoryFlag(final byte code) {
        return lookup(IEXSecurityDirectoryFlag.class, LOOKUP, code);
    }

    public byte getCode() {
        return code;
    }

}
