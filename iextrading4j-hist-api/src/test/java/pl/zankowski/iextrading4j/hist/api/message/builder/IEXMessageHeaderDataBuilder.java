package pl.zankowski.iextrading4j.hist.api.message.builder;

import pl.zankowski.iextrading4j.hist.api.message.IEXMessageHeader;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

public class IEXMessageHeaderDataBuilder {

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

    public static byte[] messageHeaderBytes() {
        return messageHeader().getBytes();
    }

    public static IEXMessageHeaderDataBuilder messageHeader() {
        return new IEXMessageHeaderDataBuilder();
    }

    public IEXMessageHeaderDataBuilder withMessageCount(short messageCount) {
        this.messageCount = messageCount;
        return this;
    }

    public byte[] getBytes() {
        return IEXByteTestUtil.prepareBytes(40, version, reserved, messageProtocolID, channelID, sessionID,
                payloadLength, messageCount, streamOffset, firstMessageSequenceNumber, sendTime);
    }

    public IEXMessageHeader build() {
        return IEXMessageHeader.createIEXMessageHeader(getBytes());
    }

}
