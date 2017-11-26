package pl.zankowski.iextrading4j.hist.deep.administrative.message;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;
import pl.zankowski.iextrading4j.hist.deep.administrative.field.IEXLULDTier;
import pl.zankowski.iextrading4j.hist.deep.administrative.field.IEXSecurityDirectoryFlag;

import java.util.Arrays;
import java.util.Objects;

public class IEXSecurityDirectoryMessage extends IEXMessage {

    private final IEXMessageType iexMessageType;
    private final IEXSecurityDirectoryFlag iexSecurityDirectoryFlag;
    private final long timestamp;
    private final String symbol;
    private final int roundLotSize;
    private final IEXPrice adjustedPOCPrice;
    private final IEXLULDTier iexluldTier;

    public IEXSecurityDirectoryMessage(
            final IEXMessageType iexMessageType,
            final IEXSecurityDirectoryFlag iexSecurityDirectoryFlag,
            final long timestamp,
            final String symbol,
            final int roundLotSize,
            final IEXPrice adjustedPOCPrice,
            final IEXLULDTier iexluldTier) {
        this.iexMessageType = iexMessageType;
        this.iexSecurityDirectoryFlag = iexSecurityDirectoryFlag;
        this.timestamp = timestamp;
        this.symbol = symbol;
        this.roundLotSize = roundLotSize;
        this.adjustedPOCPrice = adjustedPOCPrice;
        this.iexluldTier = iexluldTier;
    }

    public IEXMessageType getIexMessageType() {
        return iexMessageType;
    }

    public IEXSecurityDirectoryFlag getIexSecurityDirectoryFlag() {
        return iexSecurityDirectoryFlag;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getRoundLotSize() {
        return roundLotSize;
    }

    public IEXPrice getAdjustedPOCPrice() {
        return adjustedPOCPrice;
    }

    public IEXLULDTier getIexluldTier() {
        return iexluldTier;
    }

    public static IEXSecurityDirectoryMessage createIEXMessage(final IEXMessageType iexMessageType, final byte[] bytes) {
        final IEXSecurityDirectoryFlag iexSecurityDirectoryFlag = IEXSecurityDirectoryFlag.getSecurityDirectoryFlag(bytes[1]);
        final long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        final String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));
        final int roundLotSize = IEXByteConverter.convertBytesToInt(Arrays.copyOfRange(bytes, 18, 22));
        final IEXPrice adjustedPOCPrice = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 22, 30));
        final IEXLULDTier iexluldTier = IEXLULDTier.getLULDTier(bytes[30]);

        return new IEXSecurityDirectoryMessage(iexMessageType, iexSecurityDirectoryFlag, timestamp, symbol, roundLotSize,
                adjustedPOCPrice, iexluldTier);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IEXSecurityDirectoryMessage that = (IEXSecurityDirectoryMessage) o;
        return timestamp == that.timestamp &&
                roundLotSize == that.roundLotSize &&
                iexMessageType == that.iexMessageType &&
                iexSecurityDirectoryFlag == that.iexSecurityDirectoryFlag &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(adjustedPOCPrice, that.adjustedPOCPrice) &&
                iexluldTier == that.iexluldTier;
    }

    @Override
    public int hashCode() {
        return Objects.hash(iexMessageType, iexSecurityDirectoryFlag, timestamp, symbol, roundLotSize, adjustedPOCPrice, iexluldTier);
    }

    @Override
    public String toString() {
        return "IEXSecurityDirectoryMessage{" +
                "iexMessageType=" + iexMessageType +
                ", iexSecurityDirectoryFlag=" + iexSecurityDirectoryFlag +
                ", timestamp=" + timestamp +
                ", symbol='" + symbol + '\'' +
                ", roundLotSize=" + roundLotSize +
                ", adjustedPOCPrice=" + adjustedPOCPrice +
                ", iexluldTier=" + iexluldTier +
                '}';
    }
}
