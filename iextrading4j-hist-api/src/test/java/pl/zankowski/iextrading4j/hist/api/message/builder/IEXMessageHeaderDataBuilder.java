package pl.zankowski.iextrading4j.hist.api.message.builder;

import pl.zankowski.iextrading4j.hist.api.message.IEXMessageHeader;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

public class IEXMessageHeaderDataBuilder implements TestDataBuilder {

    private byte version = 1;
    private byte reserved = 1;
    private short messageProtocolID = -32766;
    private int channelID = 1;
    private int sessionID = 1133838336;
    private short payloadLength = 44;
    private short messageCount = 1;
    private long streamOffset = 5076984;
    private long firstMessageSequenceNumber = 115387;
    private long sendTime = 1494855059287436131L;

    public static IEXMessageHeader defaultMessageHeader() {
        return messageHeader().build();
    }

    public static IEXMessageHeaderDataBuilder messageHeader() {
        return new IEXMessageHeaderDataBuilder();
    }

    public IEXMessageHeaderDataBuilder withMessageCount(final short messageCount) {
        this.messageCount = messageCount;
        return this;
    }

    public IEXMessageHeaderDataBuilder withVersion(final byte version) {
        this.version = version;
        return this;
    }

    public IEXMessageHeaderDataBuilder withReserved(final byte reserved) {
        this.reserved = reserved;
        return this;
    }

    public IEXMessageHeaderDataBuilder withMessageProtocolID(final short messageProtocolID) {
        this.messageProtocolID = messageProtocolID;
        return this;
    }

    public IEXMessageHeaderDataBuilder withChannelID(final int channelID) {
        this.channelID = channelID;
        return this;
    }

    public IEXMessageHeaderDataBuilder withSessionID(final int sessionID) {
        this.sessionID = sessionID;
        return this;
    }

    public IEXMessageHeaderDataBuilder withPayloadLength(final short payloadLength) {
        this.payloadLength = payloadLength;
        return this;
    }

    public IEXMessageHeaderDataBuilder withStreamOffset(final long streamOffset) {
        this.streamOffset = streamOffset;
        return this;
    }

    public IEXMessageHeaderDataBuilder withFirstMessageSequenceNumber(final long firstMessageSequenceNumber) {
        this.firstMessageSequenceNumber = firstMessageSequenceNumber;
        return this;
    }

    public IEXMessageHeaderDataBuilder withSendTime(final long sendTime) {
        this.sendTime = sendTime;
        return this;
    }

    @Override
    public byte[] getBytes() {
        return IEXByteTestUtil.prepareBytes(IEXMessageHeader.LENGTH, version, reserved, messageProtocolID,
                channelID, sessionID, payloadLength, messageCount, streamOffset, firstMessageSequenceNumber,
                sendTime);
    }

    public IEXMessageHeader build() {
        return IEXMessageHeader.createIEXMessageHeader(getBytes());
    }

}
