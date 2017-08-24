package pl.zankowski.iextrading4j.hist.deep.auction.field;

/**
 * @author Wojciech Zankowski
 */
public enum IEXAuctionType {

    OPENING_AUCTION((byte) 0x4f),
    CLOSING_AUCTION((byte) 0x43),
    IPO_AUCTION((byte) 0x49),
    HALT_AUCTION((byte) 0x48),
    VOLATILITY_AUCTION((byte) 0x56),
    UNKNOWN((byte) 0x11);

    private final byte code;

    IEXAuctionType(byte code) {
        this.code = code;
    }

    public static IEXAuctionType getAuctionType(byte code) {
        for (IEXAuctionType iexAuctionType : values()) {
            if (iexAuctionType.getCode() == code) {
                return iexAuctionType;
            }
        }
        return IEXAuctionType.UNKNOWN;
    }

    public byte getCode() {
        return code;
    }
}
