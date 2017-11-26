package pl.zankowski.iextrading4j.hist.deep.administrative.message;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;
import pl.zankowski.iextrading4j.hist.deep.administrative.field.IEXSecurityEvent;

import java.util.Arrays;
import java.util.Objects;

public class IEXSecurityEventMessage extends IEXMessage {

    private final IEXMessageType iexMessageType;
    private final IEXSecurityEvent iexSecurityEvent;
    private final long timestamp;
    private final String symbol;

    public IEXSecurityEventMessage(
            final IEXMessageType iexMessageType,
            final IEXSecurityEvent iexSecurityEvent,
            final long timestamp,
            final String symbol) {
        this.iexMessageType = iexMessageType;
        this.iexSecurityEvent = iexSecurityEvent;
        this.timestamp = timestamp;
        this.symbol = symbol;
    }

    public static IEXMessage createIEXMessage(final IEXMessageType iexMessageType, final byte[] bytes) {
        final IEXSecurityEvent iexSecurityEvent = IEXSecurityEvent.getSecurityEvent(bytes[1]);
        final long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        final String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));

        return new IEXSecurityEventMessage(iexMessageType, iexSecurityEvent, timestamp, symbol);
    }

    public IEXMessageType getIexMessageType() {
        return iexMessageType;
    }

    public IEXSecurityEvent getIexSecurityEvent() {
        return iexSecurityEvent;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IEXSecurityEventMessage that = (IEXSecurityEventMessage) o;
        return timestamp == that.timestamp &&
                iexMessageType == that.iexMessageType &&
                iexSecurityEvent == that.iexSecurityEvent &&
                Objects.equals(symbol, that.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iexMessageType, iexSecurityEvent, timestamp, symbol);
    }

    @Override
    public String toString() {
        return "IEXSecurityEventMessage{" +
                "iexMessageType=" + iexMessageType +
                ", iexSecurityEvent=" + iexSecurityEvent +
                ", timestamp=" + timestamp +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
