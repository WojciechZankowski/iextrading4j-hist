package pl.zankowski.iextrading4j.hist.deep.administrative.message;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;
import pl.zankowski.iextrading4j.hist.deep.administrative.field.IEXSecurityEvent;

import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class IEXSecurityEventMessage extends IEXMessage {

    private final IEXMessageType iexMessageType;
    private final IEXSecurityEvent iexSecurityEvent;
    private final long timestamp;
    private final String symbol;

    public IEXSecurityEventMessage(IEXMessageType iexMessageType, IEXSecurityEvent iexSecurityEvent, long timestamp, String symbol) {
        this.iexMessageType = iexMessageType;
        this.iexSecurityEvent = iexSecurityEvent;
        this.timestamp = timestamp;
        this.symbol = symbol;
    }

    public static IEXMessage createIEXMessage(IEXMessageType iexMessageType, byte[] bytes) {
        IEXSecurityEvent iexSecurityEvent = IEXSecurityEvent.getSecurityEvent(bytes[1]);
        long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));
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
        if (!(o instanceof IEXSecurityEventMessage)) return false;

        IEXSecurityEventMessage that = (IEXSecurityEventMessage) o;

        if (timestamp != that.timestamp) return false;
        if (iexMessageType != that.iexMessageType) return false;
        if (iexSecurityEvent != that.iexSecurityEvent) return false;
        return symbol != null ? symbol.equals(that.symbol) : that.symbol == null;
    }

    @Override
    public int hashCode() {
        int result = iexMessageType != null ? iexMessageType.hashCode() : 0;
        result = 31 * result + (iexSecurityEvent != null ? iexSecurityEvent.hashCode() : 0);
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        return result;
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
