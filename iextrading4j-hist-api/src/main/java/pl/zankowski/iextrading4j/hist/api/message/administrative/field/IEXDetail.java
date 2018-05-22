package pl.zankowski.iextrading4j.hist.api.message.administrative.field;

import pl.zankowski.iextrading4j.hist.api.IEXByteEnum;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import static pl.zankowski.iextrading4j.hist.api.util.IEXByteEnumLookupUtil.lookup;

public enum IEXDetail implements IEXByteEnum {

    NO_PRICE_TEST((byte) 0x20),
    PRICE_TEST_RESTRICTION_IN_EFFECT((byte) 0x41),
    PRICE_TEST_RESTRICTION_REMAINS((byte) 0x43),
    PRICE_TEST_RESTRICTION_DEACTIVATED((byte) 0x44),
    DETAIL_NOT_AVAILABLE((byte) 0x4e);

    private static final Map<Byte, IEXDetail> LOOKUP = new HashMap<>();

    static {
        for (final IEXDetail value : EnumSet.allOf(IEXDetail.class))
            LOOKUP.put(value.getCode(), value);
    }

    private final byte code;

    IEXDetail(final byte code) {
        this.code = code;
    }

    public static IEXDetail getDetail(final byte code) {
        return lookup(IEXDetail.class, LOOKUP, code);
    }

    @Override
    public byte getCode() {
        return code;
    }
}
