package pl.zankowski.iextrading4j.hist.api.message.administrative;

import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXSystemEvent;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;

import java.util.Arrays;
import java.util.Objects;

import static pl.zankowski.iextrading4j.hist.api.IEXMessageType.SYSTEM_EVENT;

public class IEXSystemEventMessage extends IEXMessage {

    public static final int LENGTH = 10;

    private final IEXSystemEvent systemEvent;
    private final long timestamp;

    private IEXSystemEventMessage(
            final IEXSystemEvent systemEvent,
            final long timestamp) {
        super(SYSTEM_EVENT);
        this.systemEvent = systemEvent;
        this.timestamp = timestamp;
    }

    public static IEXSystemEventMessage createIEXMessage(final byte[] bytes) {
        final IEXSystemEvent systemEvent = IEXSystemEvent.getSystemEvent(bytes[1]);
        final long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));

        return new IEXSystemEventMessage(systemEvent, timestamp);
    }

    public IEXSystemEvent getSystemEvent() {
        return systemEvent;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        final IEXSystemEventMessage that = (IEXSystemEventMessage) o;
        return timestamp == that.timestamp &&
                systemEvent == that.systemEvent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), systemEvent, timestamp);
    }

    @Override
    public String toString() {
        return "IEXSystemEventMessage{" +
                "systemEvent=" + systemEvent +
                ", timestamp=" + timestamp +
                "} " + super.toString();
    }
}
