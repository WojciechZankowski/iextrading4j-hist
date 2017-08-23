package pl.zankowski.iextrading4j.hist.api;

/**
 * @author Wojciech Zankowski
 */
public enum IEXMessageType {

    QUOTE_UPDATE('Q'),
    TRADE_REPORT('T'),
    TRADE_BREAK('B'),
    UNKNOWN(' ');

    private final char code;

    IEXMessageType(char code) {
        this.code = code;
    }

    public static IEXMessageType getMessageType(char code) {
        for (IEXMessageType iexMessageType : values()) {
            if (iexMessageType.getCode() == code) {
                return iexMessageType;
            }
        }
        return IEXMessageType.UNKNOWN;
    }

    public char getCode() {
        return code;
    }

}
