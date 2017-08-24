package pl.zankowski.iextrading4j.hist.deep.administrative.field;

/**
 * @author Wojciech Zankowski
 */
public enum IEXSystemEvent {

    MESSAGES_START((byte) 0x4f),
    SYSTEM_HOURS_START((byte) 0x53),
    REGULAR_MARKET_HOURS_START((byte) 0x52),
    REGULAR_MARKET_HOURS_END((byte) 0x4d),
    SYSTEM_HOURS_END((byte) 0x45),
    MESSAGES_END((byte) 0x43),
    UNKNOWN((byte) 0x11);

    private final byte code;

    IEXSystemEvent(byte code) {
        this.code = code;
    }

    public static IEXSystemEvent getSystemEvent(byte code) {
        for (IEXSystemEvent iexSystemEvent : values()) {
            if (iexSystemEvent.getCode() == code) {
                return iexSystemEvent;
            }
        }
        return IEXSystemEvent.UNKNOWN;
    }

    public byte getCode() {
        return code;
    }

}
