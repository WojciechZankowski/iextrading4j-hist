package pl.zankowski.iextrading4j.hist.api.message.trading.field;

import pl.zankowski.iextrading4j.hist.api.IEXByteEnum;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import static pl.zankowski.iextrading4j.hist.api.util.IEXByteEnumLookupUtil.lookup;

public enum IEXSaleConditionFlag implements IEXByteEnum {

    NON_INTERMARKET_SWEEP_ORDER((byte) 0x00),
    INTERMARKET_SWEEP_FLAG((byte) 0x20),
    REGULAR_MARKET_SESSION_TRADE((byte) 0x40),
    EXTENDED_HOURS_FLAG((byte) 0x60),
    ROUND_OR_MIXED_LOT_TRADE((byte) 0x80),
    ODD_LOT_FLAG((byte) 0xA0),
    TRADE_IS_SUBJECT_TO_RULE_611((byte) 0xB0),
    TRADE_IS_NOT_SUBJECT_TO_RULE_611((byte) 0xC0);

    private static final Map<Byte, IEXSaleConditionFlag> LOOKUP = new HashMap<>();

    static {
        for (final IEXSaleConditionFlag value : EnumSet.allOf(IEXSaleConditionFlag.class))
            LOOKUP.put(value.getCode(), value);
    }

    private final byte code;

    IEXSaleConditionFlag(final byte code) {
        this.code = code;
    }

    public static IEXSaleConditionFlag getSaleConditionFlag(final byte code) {
        return lookup(IEXSaleConditionFlag.class, LOOKUP, code);
    }

    @Override
    public byte getCode() {
        return code;
    }

}
