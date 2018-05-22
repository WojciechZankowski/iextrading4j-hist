package pl.zankowski.iextrading4j.hist.api.message.auction.field;

import pl.zankowski.iextrading4j.hist.api.IEXByteEnum;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import static pl.zankowski.iextrading4j.hist.api.util.IEXByteEnumLookupUtil.lookup;

public enum IEXSide implements IEXByteEnum {

    BUY_IMBALANCE((byte) 0x42),
    SELL_IMBALANCE((byte) 0x53),
    NO_IMBALANCE((byte) 0x4e);

    private static final Map<Byte, IEXSide> LOOKUP = new HashMap<>();

    static {
        for (final IEXSide value : EnumSet.allOf(IEXSide.class))
            LOOKUP.put(value.getCode(), value);
    }

    private final byte code;

    IEXSide(final byte code) {
        this.code = code;
    }

    public static IEXSide getSide(final byte code) {
        return lookup(IEXSide.class, LOOKUP, code);
    }

    @Override
    public byte getCode() {
        return code;
    }
}
