package pl.zankowski.iextrading4j.hist.deep.trading.field;

public enum IEXEventFlag {

    ORDER_BOOK_IS_PROCESSING_EVENT((byte) 0x0),
    EVENT_PROCESSING_COMPLETE((byte) 0x1),
    UNKNOWN((byte) 0x11);

    private final byte code;

    IEXEventFlag(byte code) {
        this.code = code;
    }

    public byte getCode() {
        return code;
    }

    public static IEXEventFlag getEventFlag(final byte code) {
        for (IEXEventFlag iexEventFlag : values()) {
            if (iexEventFlag.getCode() == code) {
                return iexEventFlag;
            }
        }
        return IEXEventFlag.UNKNOWN;
    }

}
