package pl.zankowski.iextrading4j.hist.deep.administrative.message;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;
import pl.zankowski.iextrading4j.hist.deep.administrative.field.IEXTradingStatus;

import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class IEXTradingStatusMessage extends IEXMessage {

    private final IEXMessageType iexMessageType;
    private final IEXTradingStatus iexTradingStatus;
    private final long timestamp;
    private final String symbol;
    private final String reason;

    public IEXTradingStatusMessage(IEXMessageType iexMessageType, IEXTradingStatus iexTradingStatus, long timestamp, String symbol, String reason) {
        this.iexMessageType = iexMessageType;
        this.iexTradingStatus = iexTradingStatus;
        this.timestamp = timestamp;
        this.symbol = symbol;
        this.reason = reason;
    }

    public IEXMessageType getIexMessageType() {
        return iexMessageType;
    }

    public IEXTradingStatus getIexTradingStatus() {
        return iexTradingStatus;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IEXTradingStatusMessage)) return false;

        IEXTradingStatusMessage that = (IEXTradingStatusMessage) o;

        if (timestamp != that.timestamp) return false;
        if (iexMessageType != that.iexMessageType) return false;
        if (iexTradingStatus != that.iexTradingStatus) return false;
        if (symbol != null ? !symbol.equals(that.symbol) : that.symbol != null) return false;
        return reason != null ? reason.equals(that.reason) : that.reason == null;
    }

    @Override
    public int hashCode() {
        int result = iexMessageType != null ? iexMessageType.hashCode() : 0;
        result = 31 * result + (iexTradingStatus != null ? iexTradingStatus.hashCode() : 0);
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        return result;
    }

    public static IEXMessage createIEXMessage(IEXMessageType iexMessageType, byte[] bytes) {
        IEXTradingStatus iexTradingStatus = IEXTradingStatus.getTradingStatus(bytes[1]);
        long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));
        String reason = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 18, 22));
        return new IEXTradingStatusMessage(iexMessageType, iexTradingStatus, timestamp, symbol, reason);
    }

    @Override
    public String toString() {
        return "IEXTradingStatusMessage{" +
                "iexMessageType=" + iexMessageType +
                ", iexTradingStatus=" + iexTradingStatus +
                ", timestamp=" + timestamp +
                ", symbol='" + symbol + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
