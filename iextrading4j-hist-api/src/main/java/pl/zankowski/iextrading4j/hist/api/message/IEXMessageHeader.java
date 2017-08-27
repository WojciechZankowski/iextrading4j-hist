package pl.zankowski.iextrading4j.hist.api.message;

import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;

import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class IEXMessageHeader {

    private final byte version;
    private final short messageProtocolID;
    private final int channelID;
    private final int sessionID;
    private final short payloadLength;
    private final short messageCount;
    private final long streamOffset;
    private final long firstMessageSequenceNumber;
    private final long sendTime;

    private IEXMessageHeader(byte version, short messageProtocolID, int channelID, int sessionID, short payloadLength, short messageCount, long streamOffset, long firstMessageSequenceNumber, long sendTime) {
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

    public static IEXMessageHeader createIEXMessageHeader(byte[] bytes) {
        if (bytes.length != 40) {
            throw new IllegalArgumentException("IEX TOPS Message Header has to has 40 bytes.");
        }

        byte version = bytes[0];
        short msgProtocolID = IEXByteConverter.convertBytesToShort(Arrays.copyOfRange(bytes, 2, 4));
        int channelID = IEXByteConverter.convertBytesToInt(Arrays.copyOfRange(bytes, 4, 8));
        int sessionID = IEXByteConverter.convertBytesToInt(Arrays.copyOfRange(bytes, 8, 12));
        short payloadLength = IEXByteConverter.convertBytesToShort(Arrays.copyOfRange(bytes, 12, 14));
        short messageCount = IEXByteConverter.convertBytesToShort(Arrays.copyOfRange(bytes, 14, 16));
        long streamOffset = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 16, 24));
        long firstMessageSequenceNumber = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 24, 32));
        long sendTime = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 32, 40));

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
        if (!(o instanceof IEXMessageHeader)) return false;

        IEXMessageHeader that = (IEXMessageHeader) o;

        if (version != that.version) return false;
        if (messageProtocolID != that.messageProtocolID) return false;
        if (channelID != that.channelID) return false;
        if (sessionID != that.sessionID) return false;
        if (payloadLength != that.payloadLength) return false;
        if (messageCount != that.messageCount) return false;
        if (streamOffset != that.streamOffset) return false;
        if (firstMessageSequenceNumber != that.firstMessageSequenceNumber) return false;
        return sendTime == that.sendTime;
    }

    @Override
    public int hashCode() {
        int result = (int) version;
        result = 31 * result + (int) messageProtocolID;
        result = 31 * result + channelID;
        result = 31 * result + sessionID;
        result = 31 * result + (int) payloadLength;
        result = 31 * result + (int) messageCount;
        result = 31 * result + (int) (streamOffset ^ (streamOffset >>> 32));
        result = 31 * result + (int) (firstMessageSequenceNumber ^ (firstMessageSequenceNumber >>> 32));
        result = 31 * result + (int) (sendTime ^ (sendTime >>> 32));
        return result;
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
