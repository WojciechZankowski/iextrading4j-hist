package pl.zankowski.iextrading4j.hist.api.message.administrative.field;

public enum IEXDetail {

    NO_PRICE_TEST((byte) 0x20),
    PRICE_TEST_RESTRICTION_IN_EFFECT((byte) 0x41),
    PRICE_TEST_RESTRICTION_REMAINS((byte) 0x43),
    PRICE_TEST_RESTRICTION_DEACTIVATED((byte) 0x44),
    DETAIL_NOT_AVAILABLE((byte) 0x4e),
    UNKNOWN((byte) 0x11);

    private final byte code;

    IEXDetail(byte code) {
        this.code = code;
    }

    public static IEXDetail getDetail(final byte code) {
        for (IEXDetail iexDetail : values()) {
            if (iexDetail.getCode() == code) {
                return iexDetail;
            }
        }
        return IEXDetail.UNKNOWN;
    }

    public byte getCode() {
        return code;
    }
}
