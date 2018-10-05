package pl.zankowski.iextrading4j.hist.api.message;

import org.junit.Test;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.api.message.builder.IEXMessageHeaderDataBuilder.defaultMessageHeader;

public class IEXMessageHeaderTest {

    @Test
    public void shouldSuccessfullyCreateMessageHeader() {
        final byte version = 1;
        final byte reserved = 1;
        final IEXMessageProtocol messageProtocolId = IEXMessageProtocol.TOPS_1_5;
        final int channelID = 1;
        final int sessionID = 1133838336;
        final short payloadLength = 44;
        final short messageCount = 1;
        final long streamOffset = 5076984;
        final long firstMessageSequenceNumber = 115387;
        final long sendTime = 1494855059287436131L;

        final byte[] messageProtocolBytes = IEXByteTestUtil.convertUnsignedShort(messageProtocolId.getCode());
        final byte[] data = IEXByteTestUtil.prepareBytes(IEXMessageHeader.LENGTH, version, reserved, messageProtocolBytes,
                channelID, sessionID, payloadLength, messageCount, streamOffset, firstMessageSequenceNumber, sendTime);
        final IEXMessageHeader iexMessageHeader = IEXMessageHeader.createIEXMessageHeader(data);

        assertThat(iexMessageHeader.getVersion()).isEqualTo(version);
        assertThat(iexMessageHeader.getMessageProtocolID()).isEqualTo(messageProtocolId);
        assertThat(iexMessageHeader.getChannelID()).isEqualTo(channelID);
        assertThat(iexMessageHeader.getSessionID()).isEqualTo(sessionID);
        assertThat(iexMessageHeader.getPayloadLength()).isEqualTo(payloadLength);
        assertThat(iexMessageHeader.getMessageCount()).isEqualTo(messageCount);
        assertThat(iexMessageHeader.getStreamOffset()).isEqualTo(streamOffset);
        assertThat(iexMessageHeader.getFirstMessageSequenceNumber()).isEqualTo(firstMessageSequenceNumber);
        assertThat(iexMessageHeader.getSendTime()).isEqualTo(sendTime);
    }

    @Test
    public void shouldTwoInstancesWithSameValuesBeEqual() {
        final IEXMessageHeader iexMessageHeader_1 = defaultMessageHeader();
        final IEXMessageHeader iexMessageHeader_2 = defaultMessageHeader();

        assertThat(iexMessageHeader_1).isEqualTo(iexMessageHeader_2);
        assertThat(iexMessageHeader_1.hashCode()).isEqualTo(iexMessageHeader_2.hashCode());
    }

}
