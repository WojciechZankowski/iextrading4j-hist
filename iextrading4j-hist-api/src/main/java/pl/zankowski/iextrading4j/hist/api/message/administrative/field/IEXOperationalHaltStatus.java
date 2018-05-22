package pl.zankowski.iextrading4j.hist.api.message.administrative.field;

import pl.zankowski.iextrading4j.hist.api.IEXByteEnum;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import static pl.zankowski.iextrading4j.hist.api.util.IEXByteEnumLookupUtil.lookup;

public enum IEXOperationalHaltStatus implements IEXByteEnum {

    OPERATIONAL_TRADING_HALt((byte) 0x4f),
    NOT_OPERATIONAL_HALTED((byte) 0x4e);

    private static final Map<Byte, IEXOperationalHaltStatus> LOOKUP = new HashMap<>();

    static {
        for (final IEXOperationalHaltStatus value : EnumSet.allOf(IEXOperationalHaltStatus.class))
            LOOKUP.put(value.getCode(), value);
    }

    private final byte code;

    IEXOperationalHaltStatus(final byte code) {
        this.code = code;
    }

    public static IEXOperationalHaltStatus getOperationalHaltStatus(final byte code) {
        return lookup(IEXOperationalHaltStatus.class, LOOKUP, code);
    }

    @Override
    public byte getCode() {
        return code;
    }
}
