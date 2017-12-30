package pl.zankowski.iextrading4j.hist.api.message;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;

import java.io.Serializable;
import java.util.Objects;

public abstract class IEXMessage implements Serializable {

    private final IEXMessageType messageType;

    public IEXMessage(final IEXMessageType messageType) {
        this.messageType = messageType;
    }

    public IEXMessageType getMessageType() {
        return messageType;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final IEXMessage that = (IEXMessage) o;
        return messageType == that.messageType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageType);
    }

    @Override
    public String toString() {
        return "IEXMessage{" +
                "messageType=" + messageType +
                '}';
    }
}
