package pl.zankowski.iextrading4j.hist.test;

import org.junit.Test;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessageHeader;
import pl.zankowski.iextrading4j.hist.api.message.trading.IEXTradeMessage;
import pl.zankowski.iextrading4j.hist.api.message.trading.field.IEXSaleConditionFlag;
import pl.zankowski.iextrading4j.hist.tops.IEXTOPSMessageBlock;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TOPS16SegmentTest extends ExtendedUnitTestBase {

    @Test
    public void testTOPS16Segment() throws IOException {
        final byte[] packet = loadPacket("TOPS16Segment.dump");

        final IEXTOPSMessageBlock segment = (IEXTOPSMessageBlock) IEXTOPSMessageBlock.createIEXSegment(packet);

        final IEXMessageHeader messageHeader = segment.getMessageHeader();
        assertThat(messageHeader.getVersion()).isEqualTo((byte) 1);
        assertThat(messageHeader.getChannelID()).isEqualTo(1);
        assertThat(messageHeader.getSessionID()).isEqualTo(1145176064);
        assertThat(messageHeader.getPayloadLength()).isEqualTo((short) 40);
        assertThat(messageHeader.getMessageCount()).isEqualTo((short) 1);
        assertThat(messageHeader.getStreamOffset()).isEqualTo(952260);
        assertThat(messageHeader.getFirstMessageSequenceNumber()).isEqualTo(34343);
        assertThat(messageHeader.getSendTime()).isEqualTo(1509799811104335442L);

        final List<IEXMessage> messages = segment.getMessages();
        final IEXTradeMessage message = (IEXTradeMessage) messages.get(0);
        assertThat(message.getMessageType()).isEqualTo(IEXMessageType.TRADE_REPORT);
        assertThat(message.getSaleConditionFlag()).isEqualTo(IEXSaleConditionFlag.TRADE_IS_NOT_SUBJECT_TO_RULE_611);
        assertThat(message.getTimestamp()).isEqualTo(1509799811101738406L);
        assertThat(message.getSymbol()).isEqualTo("ZXIET");
        assertThat(message.getSize()).isEqualTo(471);
        assertThat(message.getPrice()).isEqualTo(new IEXPrice(999500L));
        assertThat(message.getTradeID()).isEqualTo(3914566);
    }

}
