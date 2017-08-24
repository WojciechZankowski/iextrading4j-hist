package pl.zankowski.iextrading4j.hist.deep.administrative.message;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;
import pl.zankowski.iextrading4j.hist.deep.administrative.field.IEXLULDTier;
import pl.zankowski.iextrading4j.hist.deep.administrative.field.IEXSecurityDirectoryFlag;

import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class IEXSecurityDirectoryMessage extends IEXMessage {

    private final IEXMessageType iexMessageType;
    private final IEXSecurityDirectoryFlag iexSecurityDirectoryFlag;
    private final long timestamp;
    private final String symbol;
    private final int roundLotSize;
    private final IEXPrice adjustedPOCPrice;
    private final IEXLULDTier iexluldTier;

    public IEXSecurityDirectoryMessage(IEXMessageType iexMessageType, IEXSecurityDirectoryFlag iexSecurityDirectoryFlag,
                                       long timestamp, String symbol, int roundLotSize, IEXPrice adjustedPOCPrice, IEXLULDTier iexluldTier) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IEXSecurityDirectoryMessage)) return false;

        IEXSecurityDirectoryMessage that = (IEXSecurityDirectoryMessage) o;

        if (timestamp != that.timestamp) return false;
        if (roundLotSize != that.roundLotSize) return false;
        if (iexMessageType != that.iexMessageType) return false;
        if (iexSecurityDirectoryFlag != that.iexSecurityDirectoryFlag) return false;
        if (symbol != null ? !symbol.equals(that.symbol) : that.symbol != null) return false;
        if (adjustedPOCPrice != null ? !adjustedPOCPrice.equals(that.adjustedPOCPrice) : that.adjustedPOCPrice != null)
            return false;
        return iexluldTier == that.iexluldTier;
    }

    @Override
    public int hashCode() {
        int result = iexMessageType != null ? iexMessageType.hashCode() : 0;
        result = 31 * result + (iexSecurityDirectoryFlag != null ? iexSecurityDirectoryFlag.hashCode() : 0);
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        result = 31 * result + roundLotSize;
        result = 31 * result + (adjustedPOCPrice != null ? adjustedPOCPrice.hashCode() : 0);
        result = 31 * result + (iexluldTier != null ? iexluldTier.hashCode() : 0);
        return result;
    }

    public static IEXSecurityDirectoryMessage createIEXMessage(IEXMessageType iexMessageType, byte[] bytes) {
        IEXSecurityDirectoryFlag iexSecurityDirectoryFlag = IEXSecurityDirectoryFlag.getSecurityDirectoryFlag(bytes[1]);
        long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));
        int roundLotSize = IEXByteConverter.convertBytesToInt(Arrays.copyOfRange(bytes, 18, 22));
        IEXPrice adjustedPOCPrice = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 22, 30));
        IEXLULDTier iexluldTier = IEXLULDTier.getLULDTier(bytes[30]);
        return new IEXSecurityDirectoryMessage(iexMessageType, iexSecurityDirectoryFlag, timestamp, symbol, roundLotSize,
                adjustedPOCPrice, iexluldTier);
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
