package pl.zankowski.iextrading4j.hist.deep.administrative;

import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;
import pl.zankowski.iextrading4j.hist.deep.administrative.field.IEXSecurityEvent;

import java.util.Arrays;
import java.util.Objects;

import static pl.zankowski.iextrading4j.hist.api.IEXMessageType.SECURITY_EVENT;

public class IEXSecurityEventMessage extends IEXMessage {

    private final IEXSecurityEvent securityEvent;
    private final long timestamp;
    private final String symbol;

    private IEXSecurityEventMessage(
            final IEXSecurityEvent securityEvent,
            final long timestamp,
            final String symbol) {
        super(SECURITY_EVENT);
        this.securityEvent = securityEvent;
        this.timestamp = timestamp;
        this.symbol = symbol;
    }

    public static IEXSecurityEventMessage createIEXMessage(final byte[] bytes) {
        final IEXSecurityEvent iexSecurityEvent = IEXSecurityEvent.getSecurityEvent(bytes[1]);
        final long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        final String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));

        return new IEXSecurityEventMessage(iexSecurityEvent, timestamp, symbol);
    }

    public IEXSecurityEvent getSecurityEvent() {
        return securityEvent;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        final IEXSecurityEventMessage that = (IEXSecurityEventMessage) o;
        return timestamp == that.timestamp &&
                securityEvent == that.securityEvent &&
                Objects.equals(symbol, that.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), securityEvent, timestamp, symbol);
    }

    @Override
    public String toString() {
        return "IEXSecurityEventMessage{" +
                "securityEvent=" + securityEvent +
                ", timestamp=" + timestamp +
                ", symbol='" + symbol + '\'' +
                "} " + super.toString();
    }
}
