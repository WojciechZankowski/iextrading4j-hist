package pl.zankowski.iextrading4j.hist.tops;

import org.junit.Test;
import pl.zankowski.iextrading4j.hist.api.message.IEXSegment;
import pl.zankowski.iextrading4j.hist.api.message.builder.IEXMessageHeaderDataBuilder;
import pl.zankowski.iextrading4j.hist.api.message.trading.IEXTradeMessage;
import pl.zankowski.iextrading4j.hist.api.message.trading.builder.IEXTradeMessageDataBuilder;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;
import pl.zankowski.iextrading4j.hist.tops.message.builder.IEXQuoteUpdateMessageDataBuilder;
import pl.zankowski.iextrading4j.hist.tops.trading.IEXQuoteUpdateMessage;

import java.nio.ByteBuffer;

import static org.assertj.core.api.Assertions.assertThat;

public class IEXTOPSMessageBlockTest {

    @Test
    public void shouldSuccessfullyCreateMessageBlockInstance() {
        final IEXMessageHeaderDataBuilder messageHeaderBuilder = IEXMessageHeaderDataBuilder.messageHeader()
                .withMessageCount((short) 2);
        final IEXTradeMessageDataBuilder tradeMessageBuilder = IEXTradeMessageDataBuilder.tradeMessage();
        final IEXQuoteUpdateMessageDataBuilder quoteUpdateMessageBuilder = IEXQuoteUpdateMessageDataBuilder.quoteMessage();

        final byte[] bytes = prepareMessages(messageHeaderBuilder, tradeMessageBuilder, quoteUpdateMessageBuilder);
        final IEXSegment segment = IEXTOPSMessageBlock.createIEXSegment(bytes);

        assertThat(segment.getMessages()).hasSize(2);
        assertThat(segment.getMessageHeader()).isEqualTo(messageHeaderBuilder.build());
        assertThat(segment.getMessages().get(0)).isEqualTo(tradeMessageBuilder.build());
        assertThat(segment.getMessages().get(1)).isEqualTo(quoteUpdateMessageBuilder.build());
    }

    private byte[] prepareMessages(IEXMessageHeaderDataBuilder iexMessageHeaderDataBuilder, IEXTradeMessageDataBuilder iexTradeMessageDataBuilder,
                                   IEXQuoteUpdateMessageDataBuilder iexQuoteUpdateMessageDataBuilder) {
        final ByteBuffer byteBuffer = ByteBuffer.allocate(124);
        byteBuffer.put(iexMessageHeaderDataBuilder.getBytes());
        byteBuffer.put(IEXByteTestUtil.convert((short) IEXTradeMessage.LENGTH));
        byteBuffer.put(iexTradeMessageDataBuilder.getBytes());
        byteBuffer.put(IEXByteTestUtil.convert((short) IEXQuoteUpdateMessage.LENGTH));
        byteBuffer.put(iexQuoteUpdateMessageDataBuilder.getBytes());
        return byteBuffer.array();
    }

}
