package pl.zankowski.iextrading4j.hist.tops.trading.field;

public enum IEXMessageFlag {

    ACTIVE_IN_SESSION((byte) 0x00),
    ACTIVE_OUT_SESSION((byte) 0x40),
    HALTED_IN_SESSION((byte) 0x80),
    HALTED_OUT_SESSION((byte) 0xc0),
    UNKNOWN((byte) 0x11);

    private final byte flag;

    IEXMessageFlag(byte flag) {
        this.flag = flag;
    }

    public static IEXMessageFlag getMessageFromFlag(final byte flag) {
        for (IEXMessageFlag iexMessageFlag : values()) {
            if (iexMessageFlag.getFlag() == flag) {
                return iexMessageFlag;
            }
        }
        return IEXMessageFlag.UNKNOWN;
    }

    public byte getFlag() {
        return flag;
    }

}
