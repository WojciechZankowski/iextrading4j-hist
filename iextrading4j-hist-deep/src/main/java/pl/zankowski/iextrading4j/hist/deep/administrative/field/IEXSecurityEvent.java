package pl.zankowski.iextrading4j.hist.deep.administrative.field;

public enum IEXSecurityEvent {

    OPENING_PROCESS_COMPLETE((byte) 0x4f),
    CLOSING_PROCESS_COMPLETE((byte) 0x43),
    UNKNOWN((byte) 0x11);

    private final byte code;

    IEXSecurityEvent(byte code) {
        this.code = code;
    }

    public static IEXSecurityEvent getSecurityEvent(final byte code) {
        for (IEXSecurityEvent iexSecurityEvent : values()) {
            if (iexSecurityEvent.getCode() == code) {
                return iexSecurityEvent;
            }
        }
        return IEXSecurityEvent.UNKNOWN;
    }

    public byte getCode() {
        return code;
    }

}
