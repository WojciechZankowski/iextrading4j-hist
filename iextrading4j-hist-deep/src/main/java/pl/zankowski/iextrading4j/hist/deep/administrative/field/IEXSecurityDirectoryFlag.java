package pl.zankowski.iextrading4j.hist.deep.administrative.field;

/**
 * @author Wojciech Zankowski
 */
public enum IEXSecurityDirectoryFlag {

    SYMBOL_IS_NOT_TEST((byte) 0x80),
    SYMBOL_IS_TEST((byte) 0x80),
    SYMBOL_IS_NOT_WHEN_ISSUED((byte) 0x40),
    SYMBOL_IS_WHEN_ISSUED((byte) 0x40),
    SYMBOL_IS_NOT_ETP((byte) 0x20),
    SYMBOL_IS_ETP((byte) 0x20),
    UNKNOWN((byte) 0x11);

    private final byte code;

    IEXSecurityDirectoryFlag(byte code) {
        this.code = code;
    }

    public static IEXSecurityDirectoryFlag getSecurityDirectoryFlag(byte code) {
        for (IEXSecurityDirectoryFlag iexSecurityDirectoryFlag : values()) {
            if (iexSecurityDirectoryFlag.getCode() == code) {
                return iexSecurityDirectoryFlag;
            }
        }
        return IEXSecurityDirectoryFlag.UNKNOWN;
    }

    public byte getCode() {
        return code;
    }

}
