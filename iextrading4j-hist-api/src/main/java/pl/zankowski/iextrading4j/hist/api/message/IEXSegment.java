package pl.zankowski.iextrading4j.hist.api.message;

import java.util.List;

/**
 * @author Wojciech Zankowski
 */
public abstract class IEXSegment {

    private final IEXMessageHeader messageHeader;
    private final List<IEXMessage> messages;

    protected IEXSegment(IEXMessageHeader messageHeader, List<IEXMessage> messages) {
        this.messageHeader = messageHeader;
        this.messages = messages;
    }

    public IEXMessageHeader getMessageHeader() {
        return messageHeader;
    }

    public List<IEXMessage> getMessages() {
        return messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IEXSegment)) return false;

        IEXSegment that = (IEXSegment) o;

        if (messageHeader != null ? !messageHeader.equals(that.messageHeader) : that.messageHeader != null)
            return false;
        return messages != null ? messages.equals(that.messages) : that.messages == null;
    }

    @Override
    public int hashCode() {
        int result = messageHeader != null ? messageHeader.hashCode() : 0;
        result = 31 * result + (messages != null ? messages.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (IEXMessage iexMessage : messages) {
            builder.append(iexMessage);
            builder.append("\n");
        }
        return "IEXMessageBlock{\n" +
                messageHeader + "\n" +
                builder.toString() +
                '}';
    }

}
