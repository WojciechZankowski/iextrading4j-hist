package pl.zankowski.iextrading4j.hist.api.message.administrative.field;

import pl.zankowski.iextrading4j.hist.api.IEXByteEnum;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import static pl.zankowski.iextrading4j.hist.api.util.IEXByteEnumLookupUtil.lookup;

public enum IEXTradingStatus implements IEXByteEnum {

    TRADING_HALTED((byte) 0x48),
    ORDER_ACCEPTANCE_PERIOD((byte) 0x4f),
    ORDER_ACCEPTANCE_PERIOD_ON_IEX((byte) 0x50),
    TRADING_ON_IEX((byte) 0x54);

    private static final Map<Byte, IEXTradingStatus> LOOKUP = new HashMap<>();

    static {
        for (final IEXTradingStatus value : EnumSet.allOf(IEXTradingStatus.class))
            LOOKUP.put(value.getCode(), value);
    }

    private final byte code;

    IEXTradingStatus(final byte code) {
        this.code = code;
    }

    public static IEXTradingStatus getTradingStatus(final byte code) {
        return lookup(IEXTradingStatus.class, LOOKUP, code);
    }

    @Override
    public byte getCode() {
        return code;
    }

}
