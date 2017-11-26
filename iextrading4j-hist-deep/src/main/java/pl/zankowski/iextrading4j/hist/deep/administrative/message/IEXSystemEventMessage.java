package pl.zankowski.iextrading4j.hist.deep.administrative.message;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;
import pl.zankowski.iextrading4j.hist.deep.administrative.field.IEXSystemEvent;

import java.util.Arrays;
import java.util.Objects;

public class IEXSystemEventMessage extends IEXMessage {

    private final IEXMessageType iexMessageType;
    private final IEXSystemEvent iexSystemEvent;
    private final long timestamp;

    public IEXSystemEventMessage(
            final IEXMessageType iexMessageType,
            final IEXSystemEvent iexSystemEvent,
            final long timestamp) {
        this.iexMessageType = iexMessageType;
        this.iexSystemEvent = iexSystemEvent;
        this.timestamp = timestamp;
    }

    public static IEXMessage createIEXMessage(IEXMessageType iexMessageType, byte[] bytes) {
        final IEXSystemEvent iexSystemEvent = IEXSystemEvent.getSystemEvent(bytes[1]);
        final long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));

        return new IEXSystemEventMessage(iexMessageType, iexSystemEvent, timestamp);
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
        if (o == null || getClass() != o.getClass()) return false;
        IEXSystemEventMessage that = (IEXSystemEventMessage) o;
        return timestamp == that.timestamp &&
                iexMessageType == that.iexMessageType &&
                iexSystemEvent == that.iexSystemEvent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(iexMessageType, iexSystemEvent, timestamp);
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
