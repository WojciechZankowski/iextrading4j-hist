package pl.zankowski.iextrading4j.hist.api;

/**
 * @author Wojciech Zankowski
 */
public enum IEXMessageType {

    QUOTE_UPDATE('Q'),
    TRADE_REPORT('T'),
    TRADE_BREAK('B'),
    SYSTEM_EVENT('S'),
    SECURITY_DIRECTORY('D'),
    TRADING_STATUS('H'),
    OPERATIONAL_HALT_STATUS('O'),
    SHORT_SALE_PRICE_TEST_STATUS('P'),
    SECURITY_EVENT('E'),
    PRICE_LEVEL_UPDATE_BUY('8'),
    PRICE_LEVEL_UPDATE_SELL('5'),
    AUCTION_INFORMATION('A'),
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
