package pl.zankowski.iextrading4j.hist.deep.administrative.field;

/**
 * @author Wojciech Zankowski
 */
public enum IEXOperationalHaltStatus {

    OPERATIONAL_TRADING_HALt((byte) 0x4f),
    NOT_OPERATIONAL_HALTED((byte) 0x4e),
    UNKNOWN((byte) 0x11);

    private final byte code;

    IEXOperationalHaltStatus(byte code) {
        this.code = code;
    }

    public static IEXOperationalHaltStatus getOperationalHaltStatus(byte code) {
        for (IEXOperationalHaltStatus iexOperationalHaltStatus : values()) {
            if (iexOperationalHaltStatus.getCode() == code) {
                return iexOperationalHaltStatus;
            }
        }
        return IEXOperationalHaltStatus.UNKNOWN;
    }

    public byte getCode() {
        return code;
    }
}
