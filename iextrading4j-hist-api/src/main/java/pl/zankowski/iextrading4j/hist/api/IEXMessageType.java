package pl.zankowski.iextrading4j.hist.api;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import static pl.zankowski.iextrading4j.hist.api.util.IEXByteEnumLookupUtil.lookup;

public enum IEXMessageType implements IEXByteEnum {

    QUOTE_UPDATE((byte) 0x51),
    TRADE_REPORT((byte) 0x54),
    TRADE_BREAK((byte) 0x42),
    SYSTEM_EVENT((byte) 0x53),
    SECURITY_DIRECTORY((byte) 0x44),
    TRADING_STATUS((byte) 0x48),
    OPERATIONAL_HALT_STATUS((byte) 0x4f),
    SHORT_SALE_PRICE_TEST_STATUS((byte) 0x50),
    SECURITY_EVENT((byte) 0x45),
    PRICE_LEVEL_UPDATE_BUY((byte) 0x38),
    PRICE_LEVEL_UPDATE_SELL((byte) 0x35),
    OFFICIAL_PRICE_MESSAGE((byte) 0x58),
    AUCTION_INFORMATION((byte) 0x41);

    private static final Map<Byte, IEXMessageType> LOOKUP = new HashMap<>();

    static {
        for (final IEXMessageType value : EnumSet.allOf(IEXMessageType.class))
            LOOKUP.put(value.getCode(), value);
    }

    private final byte code;

    IEXMessageType(final byte code) {
        this.code = code;
    }

    public static IEXMessageType getMessageType(final byte code) {
        return lookup(IEXMessageType.class, LOOKUP, code);
    }

    @Override
    public byte getCode() {
        return code;
    }

}
