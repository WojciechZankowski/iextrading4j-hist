package pl.zankowski.iextrading4j.hist.api.message.auction.field;

import pl.zankowski.iextrading4j.hist.api.IEXByteEnum;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import static pl.zankowski.iextrading4j.hist.api.util.IEXByteEnumLookupUtil.lookup;

public enum IEXAuctionType implements IEXByteEnum {

    OPENING_AUCTION((byte) 0x4f),
    CLOSING_AUCTION((byte) 0x43),
    IPO_AUCTION((byte) 0x49),
    HALT_AUCTION((byte) 0x48),
    VOLATILITY_AUCTION((byte) 0x56);

    private static final Map<Byte, IEXAuctionType> LOOKUP = new HashMap<>();

    static {
        for (final IEXAuctionType value : EnumSet.allOf(IEXAuctionType.class))
            LOOKUP.put(value.getCode(), value);
    }

    private final byte code;

    IEXAuctionType(final byte code) {
        this.code = code;
    }

    public static IEXAuctionType getAuctionType(final byte code) {
        return lookup(IEXAuctionType.class, LOOKUP, code);
    }

    @Override
    public byte getCode() {
        return code;
    }
}
