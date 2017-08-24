package pl.zankowski.iextrading4j.hist.deep.administrative.message;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;
import pl.zankowski.iextrading4j.hist.deep.administrative.field.IEXSystemEvent;

import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class IEXSystemEventMessage extends IEXMessage {

    private final IEXMessageType iexMessageType;
    private final IEXSystemEvent iexSystemEvent;
    private final long timestamp;

    public IEXSystemEventMessage(IEXMessageType iexMessageType, IEXSystemEvent iexSystemEvent, long timestamp) {
        this.iexMessageType = iexMessageType;
        this.iexSystemEvent = iexSystemEvent;
        this.timestamp = timestamp;
    }

    public IEXMessageType getIexMessageType() {
        return iexMessageType;
    }

    public IEXSystemEvent getIexSystemEvent() {
        return iexSystemEvent;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IEXSystemEventMessage)) return false;

        IEXSystemEventMessage that = (IEXSystemEventMessage) o;

        if (timestamp != that.timestamp) return false;
        if (iexMessageType != that.iexMessageType) return false;
        return iexSystemEvent == that.iexSystemEvent;
    }

    @Override
    public int hashCode() {
        int result = iexMessageType != null ? iexMessageType.hashCode() : 0;
        result = 31 * result + (iexSystemEvent != null ? iexSystemEvent.hashCode() : 0);
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        return result;
    }

    public static IEXMessage createIEXMessage(IEXMessageType iexMessageType, byte[] bytes) {
        IEXSystemEvent iexSystemEvent = IEXSystemEvent.getSystemEvent(bytes[1]);
        long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        return new IEXSystemEventMessage(iexMessageType, iexSystemEvent, timestamp);
    }

    @Override
    public String toString() {
        return "IEXSystemEventMessage{" +
                "iexMessageType=" + iexMessageType +
                ", iexSystemEvent=" + iexSystemEvent +
                ", timestamp=" + timestamp +
                '}';
    }
}
