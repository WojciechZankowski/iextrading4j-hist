package pl.zankowski.iextrading4j.hist.deep.auction.field;

/**
 * @author Wojciech Zankowski
 */
public enum IEXSide {

    BUY_IMBALANCE((byte) 0x42),
    SELL_IMBALANCE((byte) 0x53),
    NO_IMBALANCE((byte) 0x4e),
    UNKNOWN((byte) 0x11);

    private final byte code;

    IEXSide(byte code) {
        this.code = code;
    }

    public static IEXSide getSide(byte code) {
        for (IEXSide iexSide : values()) {
            if (iexSide.getCode() == code) {
                return iexSide;
            }
        }
        return IEXSide.UNKNOWN;
    }

    public byte getCode() {
        return code;
    }
}