package pl.zankowski.iextrading4j.hist.deep.administrative.message;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;
import pl.zankowski.iextrading4j.hist.deep.administrative.field.IEXTradingStatus;

import java.util.Arrays;
import java.util.Objects;

public class IEXTradingStatusMessage extends IEXMessage {

    private final IEXMessageType iexMessageType;
    private final IEXTradingStatus iexTradingStatus;
    private final long timestamp;
    private final String symbol;
    private final String reason;

    public IEXTradingStatusMessage(
            final IEXMessageType iexMessageType,
            final IEXTradingStatus iexTradingStatus,
            final long timestamp,
            final String symbol,
            final String reason) {
        this.iexMessageType = iexMessageType;
        this.iexTradingStatus = iexTradingStatus;
        this.timestamp = timestamp;
        this.symbol = symbol;
        this.reason = reason;
    }

    public static IEXMessage createIEXMessage(IEXMessageType iexMessageType, byte[] bytes) {
        final IEXTradingStatus iexTradingStatus = IEXTradingStatus.getTradingStatus(bytes[1]);
        final long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        final String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));
        final String reason = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 18, 22));
        return new IEXTradingStatusMessage(iexMessageType, iexTradingStatus, timestamp, symbol, reason);
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
        if (o == null || getClass() != o.getClass()) return false;
        IEXTradingStatusMessage that = (IEXTradingStatusMessage) o;
        return timestamp == that.timestamp &&
                iexMessageType == that.iexMessageType &&
                iexTradingStatus == that.iexTradingStatus &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iexMessageType, iexTradingStatus, timestamp, symbol, reason);
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
