package pl.zankowski.iextrading4j.hist.api.message.trading.field;

public enum IEXSaleConditionFlag {

    NON_INTERMARKET_SWEEP_ORDER((byte) 0x00),
    INTERMARKET_SWEEP_FLAG((byte) 0x20),
    REGULAR_MARKET_SESSION_TRADE((byte) 0x40),
    EXTENDED_HOURS_FLAG((byte) 0x60),
    ROUND_OR_MIXED_LOT_TRADE((byte) 0x80),
    ODD_LOT_FLAG((byte) 0xA0),
    TRADE_IS_SUBJECT_TO_RULE_611((byte) 0xB0),
    TRADE_IS_NOT_SUBJECT_TO_RULE_611((byte) 0xC0),
    UNKNOWN((byte) 0x11);

    private final byte code;

    IEXSaleConditionFlag(byte code) {
        this.code = code;
    }

    public static IEXSaleConditionFlag getSaleConditionFlag(final byte code) {
        for (IEXSaleConditionFlag iexSaleConditionFlag : values()) {
            if (iexSaleConditionFlag.getCode() == code) {
                return iexSaleConditionFlag;
            }
        }
        return IEXSaleConditionFlag.UNKNOWN;
    }

    public byte getCode() {
        return code;
    }

}
