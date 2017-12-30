package pl.zankowski.iextrading4j.hist.api.message.administrative.field;

public enum IEXShortSalePriceTestStatus {

    PRICE_TEST_NOT_IN_EFFECT((byte) 0x0),
    PRICE_TEST_IN_EFFECT((byte) 0x1),
    UNKNOWN((byte) 0x11);

    private final byte code;

    IEXShortSalePriceTestStatus(byte code) {
        this.code = code;
    }

    public static IEXShortSalePriceTestStatus getShortSalePriceTestStatus(final byte code) {
        for (IEXShortSalePriceTestStatus iexShortSalePriceTestStatus : values()) {
            if (iexShortSalePriceTestStatus.getCode() == code) {
                return iexShortSalePriceTestStatus;
            }
        }
        return IEXShortSalePriceTestStatus.UNKNOWN;
    }

    public byte getCode() {
        return code;
    }
}
