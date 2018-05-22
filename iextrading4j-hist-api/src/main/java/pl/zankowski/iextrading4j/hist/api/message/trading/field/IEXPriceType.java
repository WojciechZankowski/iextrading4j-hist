package pl.zankowski.iextrading4j.hist.api.message.trading.field;

import pl.zankowski.iextrading4j.hist.api.IEXByteEnum;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import static pl.zankowski.iextrading4j.hist.api.util.IEXByteEnumLookupUtil.lookup;

public enum IEXPriceType implements IEXByteEnum {

    IEX_OFFICIAL_OPENING_PRICE((byte) 0x51),
    IEX_OFFICIAL_CLOSING_PRICE((byte) 0x4d);

    private static final Map<Byte, IEXPriceType> LOOKUP = new HashMap<>();

    static {
        for (final IEXPriceType value : EnumSet.allOf(IEXPriceType.class))
            LOOKUP.put(value.getCode(), value);
    }

    private final byte code;

    IEXPriceType(final byte code) {
        this.code = code;
    }

    @Override
    public byte getCode() {
        return code;
    }

    public static IEXPriceType getPriceType(final byte code) {
        return lookup(IEXPriceType.class, LOOKUP, code);
    }

}
