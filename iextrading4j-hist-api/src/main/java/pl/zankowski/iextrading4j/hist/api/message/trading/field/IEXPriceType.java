package pl.zankowski.iextrading4j.hist.api.message.trading.field;

public enum IEXPriceType {

    IEX_OFFICIAL_OPENING_PRICE((byte) 0x51),
    IEX_OFFICIAL_CLOSING_PRICE((byte) 0x4d),
    UNKNOWN((byte) 0x11);

    private final byte code;

    IEXPriceType(byte code) {
        this.code = code;
    }

    public byte getCode() {
        return code;
    }

    public static IEXPriceType getPriceType(final byte code) {
        for (IEXPriceType iexPriceType : values()) {
            if (iexPriceType.getCode() == code) {
                return iexPriceType;
            }
        }
        return IEXPriceType.UNKNOWN;
    }

}
