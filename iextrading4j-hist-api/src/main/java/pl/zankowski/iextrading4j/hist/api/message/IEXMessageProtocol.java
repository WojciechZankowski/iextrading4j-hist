package pl.zankowski.iextrading4j.hist.api.message;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum IEXMessageProtocol {

    TOPS_1_5(0x8002),
    TOPS_1_6(0x8003),
    DEEP(0x8004);

    private static final Map<Integer, IEXMessageProtocol> LOOKUP = new HashMap<>();

    static {
        for (final IEXMessageProtocol value : EnumSet.allOf(IEXMessageProtocol.class))
            LOOKUP.put(value.getCode(), value);
    }

    private final int code;

    IEXMessageProtocol(final int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static IEXMessageProtocol getMessageProtocol(final int code) {
        final IEXMessageProtocol value = LOOKUP.get(code);
        if (value == null) {
            throw new IllegalArgumentException("Unknown value: " + code + " for enum IEXMessageProtocol");
        }
        return value;
    }
}
