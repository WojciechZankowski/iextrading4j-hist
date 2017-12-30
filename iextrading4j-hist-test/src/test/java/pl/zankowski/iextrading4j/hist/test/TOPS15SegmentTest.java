package pl.zankowski.iextrading4j.hist.test;

import org.junit.Test;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessageHeader;
import pl.zankowski.iextrading4j.hist.tops.IEXTOPSMessageBlock;
import pl.zankowski.iextrading4j.hist.tops.trading.IEXQuoteUpdateMessage;
import pl.zankowski.iextrading4j.hist.tops.trading.field.IEXMessageFlag;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TOPS15SegmentTest extends ExtendedUnitTestBase {

    @Test
    public void testTOPS15Segment() throws IOException {
        final byte[] packet = loadPacket("TOPS15Segment.dump");

        final IEXTOPSMessageBlock segment = (IEXTOPSMessageBlock) IEXTOPSMessageBlock.createIEXSegment(packet);

        final IEXMessageHeader messageHeader = segment.getMessageHeader();
        assertThat(messageHeader.getVersion()).isEqualTo((byte) 1);
        assertThat(messageHeader.getChannelID()).isEqualTo(1);
        assertThat(messageHeader.getSessionID()).isEqualTo(1144717312);
        assertThat(messageHeader.getPayloadLength()).isEqualTo((short) 44);
        assertThat(messageHeader.getMessageCount()).isEqualTo((short) 1);
        assertThat(messageHeader.getStreamOffset()).isEqualTo(371580);
        assertThat(messageHeader.getFirstMessageSequenceNumber()).isEqualTo(8446);
        assertThat(messageHeader.getSendTime()).isEqualTo(1509192000487009269L);

        final List<IEXMessage> messages = segment.getMessages();
        final IEXQuoteUpdateMessage message = (IEXQuoteUpdateMessage) messages.get(0);
        assertThat(message.getMessageType()).isEqualTo(IEXMessageType.QUOTE_UPDATE);
        assertThat(message.getMessageFlag()).isEqualTo(IEXMessageFlag.ACTIVE_OUT_SESSION);
        assertThat(message.getTimestamp()).isEqualTo(1509192000475229769L);
        assertThat(message.getSymbol()).isEqualTo("ZIEXT");
        assertThat(message.getBidSize()).isEqualTo(0);
        assertThat(message.getBidPrice()).isEqualTo(new IEXPrice(0));
        assertThat(message.getAskPrice()).isEqualTo(new IEXPrice(10000L));
        assertThat(message.getAskSize()).isEqualTo(100);
    }

}
