package pl.zankowski.iextrading4j.hist.api.message.administrative.field;

import pl.zankowski.iextrading4j.hist.api.IEXByteEnum;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import static pl.zankowski.iextrading4j.hist.api.util.IEXByteEnumLookupUtil.lookup;

public enum IEXShortSalePriceTestStatus implements IEXByteEnum {

    PRICE_TEST_NOT_IN_EFFECT((byte) 0x0),
    PRICE_TEST_IN_EFFECT((byte) 0x1);

    private static final Map<Byte, IEXShortSalePriceTestStatus> LOOKUP = new HashMap<>();

    static {
        for (final IEXShortSalePriceTestStatus value : EnumSet.allOf(IEXShortSalePriceTestStatus.class))
            LOOKUP.put(value.getCode(), value);
    }

    private final byte code;

    IEXShortSalePriceTestStatus(final byte code) {
        this.code = code;
    }

    public static IEXShortSalePriceTestStatus getShortSalePriceTestStatus(final byte code) {
        return lookup(IEXShortSalePriceTestStatus.class, LOOKUP, code);
    }

    @Override
    public byte getCode() {
        return code;
    }
}
