package pl.zankowski.iextrading4j.hist.deep.administrative.field;

public enum IEXLULDTier {

    NOT_APPLICABLE((byte) 0x0),
    TIER_1_NMS((byte) 0x1),
    TIER_2_NMS((byte) 0x2),
    UNKNOWN((byte) 0x11);

    private final byte code;

    IEXLULDTier(byte code) {
        this.code = code;
    }

    public static IEXLULDTier getLULDTier(final byte code) {
        for (IEXLULDTier iexluldTier : values()) {
            if (iexluldTier.getCode() == code) {
                return iexluldTier;
            }
        }
        return IEXLULDTier.UNKNOWN;
    }

    public byte getCode() {
        return code;
    }
}
