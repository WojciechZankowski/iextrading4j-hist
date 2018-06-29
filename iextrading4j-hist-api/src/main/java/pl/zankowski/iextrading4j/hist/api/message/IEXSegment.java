package pl.zankowski.iextrading4j.hist.api.message;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class IEXSegment {

    private final IEXMessageHeader messageHeader;
    private final List<IEXMessage> messages;

    protected IEXSegment(
            final IEXMessageHeader messageHeader,
            final List<IEXMessage> messages) {
        this.messageHeader = messageHeader;
        this.messages = new ArrayList<>(messages);
    }

    public IEXMessageHeader getMessageHeader() {
        return messageHeader;
    }

    public List<IEXMessage> getMessages() {
        return new ArrayList<>(messages);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IEXSegment that = (IEXSegment) o;
        return Objects.equals(messageHeader, that.messageHeader) &&
                Objects.equals(messages, that.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageHeader, messages);
    }

    @Override
    public String toString() {
        return "IEXSegment{" +
                "messageHeader=" + messageHeader +
                ", messages=" + messages +
                '}';
    }
}
