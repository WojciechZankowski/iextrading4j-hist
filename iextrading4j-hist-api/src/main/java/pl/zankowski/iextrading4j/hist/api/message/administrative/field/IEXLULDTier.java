package pl.zankowski.iextrading4j.hist.api.message.administrative.field;

import pl.zankowski.iextrading4j.hist.api.IEXByteEnum;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import static pl.zankowski.iextrading4j.hist.api.util.IEXByteEnumLookupUtil.lookup;

public enum IEXLULDTier implements IEXByteEnum {

    NOT_APPLICABLE((byte) 0x0),
    TIER_1_NMS((byte) 0x1),
    TIER_2_NMS((byte) 0x2);

    private static final Map<Byte, IEXLULDTier> LOOKUP = new HashMap<>();

    static {
        for (final IEXLULDTier value : EnumSet.allOf(IEXLULDTier.class))
            LOOKUP.put(value.getCode(), value);
    }

    private final byte code;

    IEXLULDTier(final byte code) {
        this.code = code;
    }

    public static IEXLULDTier getLULDTier(final byte code) {
        return lookup(IEXLULDTier.class, LOOKUP, code);
    }

    @Override
    public byte getCode() {
        return code;
    }
}
