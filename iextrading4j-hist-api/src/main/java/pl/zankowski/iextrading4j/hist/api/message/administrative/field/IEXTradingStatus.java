package pl.zankowski.iextrading4j.hist.api.message.administrative.field;

public enum IEXTradingStatus {

    TRADING_HALTED((byte) 0x48),
    ORDER_ACCEPTANCE_PERIOD((byte) 0x4f),
    ORDER_ACCEPTANCE_PERIOD_ON_IEX((byte) 0x50),
    TRADING_ON_IEX((byte) 0x54),
    UNKNOWN((byte) 0x11);

    private final byte code;

    IEXTradingStatus(byte code) {
        this.code = code;
    }

    public static IEXTradingStatus getTradingStatus(final byte code) {
        for (IEXTradingStatus iexTradingStatus : values()) {
            if (iexTradingStatus.getCode() == code) {
                return iexTradingStatus;
            }
        }
        return IEXTradingStatus.UNKNOWN;
    }

    public byte getCode() {
        return code;
    }

}
