package pl.zankowski.iextrading4j.hist.api.message.administrative;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXTradingStatus;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;

import java.util.Arrays;
import java.util.Objects;

public class IEXTradingStatusMessage extends IEXMessage {

    private final IEXTradingStatus tradingStatus;
    private final long timestamp;
    private final String symbol;
    private final String reason;

    private IEXTradingStatusMessage(
            final IEXMessageType messageType,
            final IEXTradingStatus tradingStatus,
            final long timestamp,
            final String symbol,
            final String reason) {
        super(messageType);
        this.tradingStatus = tradingStatus;
        this.timestamp = timestamp;
        this.symbol = symbol;
        this.reason = reason;
    }

    public static IEXMessage createIEXMessage(IEXMessageType messageType, byte[] bytes) {
        final IEXTradingStatus tradingStatus = IEXTradingStatus.getTradingStatus(bytes[1]);
        final long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        final String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));
        final String reason = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 18, 22));

        return new IEXTradingStatusMessage(messageType, tradingStatus, timestamp, symbol, reason);
    }

    public IEXTradingStatus getTradingStatus() {
        return tradingStatus;
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
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        final IEXTradingStatusMessage that = (IEXTradingStatusMessage) o;
        return timestamp == that.timestamp &&
                tradingStatus == that.tradingStatus &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tradingStatus, timestamp, symbol, reason);
    }

    @Override
    public String toString() {
        return "IEXTradingStatusMessage{" +
                "tradingStatus=" + tradingStatus +
                ", timestamp=" + timestamp +
                ", symbol='" + symbol + '\'' +
                ", reason='" + reason + '\'' +
                "} " + super.toString();
    }
}
