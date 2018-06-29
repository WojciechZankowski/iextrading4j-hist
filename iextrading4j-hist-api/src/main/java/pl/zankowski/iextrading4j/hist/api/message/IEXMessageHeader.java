package pl.zankowski.iextrading4j.hist.api.message;

import pl.zankowski.iextrading4j.hist.api.exception.IEXMessageException;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;

import java.util.Arrays;
import java.util.Objects;

public class IEXMessageHeader {

    public static final int LENGTH = 40;

    private final byte version;
    private final short messageProtocolID;
    private final int channelID;
    private final int sessionID;
    private final short payloadLength;
    private final short messageCount;
    private final long streamOffset;
    private final long firstMessageSequenceNumber;
    private final long sendTime;

    private IEXMessageHeader(
            final byte version,
            final short messageProtocolID,
            final int channelID,
            final int sessionID,
            final short payloadLength,
            final short messageCount,
            final long streamOffset,
            final long firstMessageSequenceNumber,
            final long sendTime) {
        this.version = version;
        this.messageProtocolID = messageProtocolID;
        this.channelID = channelID;
        this.sessionID = sessionID;
        this.payloadLength = payloadLength;
        this.messageCount = messageCount;
        this.streamOffset = streamOffset;
        this.firstMessageSequenceNumber = firstMessageSequenceNumber;
        this.sendTime = sendTime;
    }

    public static IEXMessageHeader createIEXMessageHeader(final byte[] bytes) {
        if (bytes.length != LENGTH) {
            throw new IEXMessageException("Failed to parse message. IEXMessageHeader requires 40 bytes.");
        }

        final byte version = bytes[0];
        final short msgProtocolID = IEXByteConverter.convertBytesToShort(Arrays.copyOfRange(bytes, 2, 4));
        final int channelID = IEXByteConverter.convertBytesToInt(Arrays.copyOfRange(bytes, 4, 8));
        final int sessionID = IEXByteConverter.convertBytesToInt(Arrays.copyOfRange(bytes, 8, 12));
        final short payloadLength = IEXByteConverter.convertBytesToShort(Arrays.copyOfRange(bytes, 12, 14));
        final short messageCount = IEXByteConverter.convertBytesToShort(Arrays.copyOfRange(bytes, 14, 16));
        final long streamOffset = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 16, 24));
        final long firstMessageSequenceNumber = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 24, 32));
        final long sendTime = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 32, 40));

        return new IEXMessageHeader(version, msgProtocolID, channelID, sessionID, payloadLength, messageCount,
                streamOffset, firstMessageSequenceNumber, sendTime);
    }

    public byte getVersion() {
        return version;
    }

    public short getMessageProtocolID() {
        return messageProtocolID;
    }

    public int getChannelID() {
        return channelID;
    }

    public int getSessionID() {
        return sessionID;
    }

    public short getPayloadLength() {
        return payloadLength;
    }

    public short getMessageCount() {
        return messageCount;
    }

    public long getStreamOffset() {
        return streamOffset;
    }

    public long getFirstMessageSequenceNumber() {
        return firstMessageSequenceNumber;
    }

    public long getSendTime() {
        return sendTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IEXMessageHeader that = (IEXMessageHeader) o;
        return version == that.version &&
                messageProtocolID == that.messageProtocolID &&
                channelID == that.channelID &&
                sessionID == that.sessionID &&
                payloadLength == that.payloadLength &&
                messageCount == that.messageCount &&
                streamOffset == that.streamOffset &&
                firstMessageSequenceNumber == that.firstMessageSequenceNumber &&
                sendTime == that.sendTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(version, messageProtocolID, channelID, sessionID, payloadLength,
                messageCount, streamOffset, firstMessageSequenceNumber, sendTime);
    }

    @Override
    public String toString() {
        return "IEXMessageHeader{" +
                "version=" + version +
                ", messageProtocolID=" + messageProtocolID +
                ", channelID=" + channelID +
                ", sessionID=" + sessionID +
                ", payloadLength=" + payloadLength +
                ", messageCount=" + messageCount +
                ", streamOffset=" + streamOffset +
                ", firstMessageSequenceNumber=" + firstMessageSequenceNumber +
                ", sendTime=" + sendTime +
                '}';
    }
}
