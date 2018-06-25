package pl.zankowski.iextrading4j.hist.tops;

import org.junit.Test;
import pl.zankowski.iextrading4j.hist.api.message.IEXSegment;
import pl.zankowski.iextrading4j.hist.api.message.builder.IEXMessageHeaderDataBuilder;
import pl.zankowski.iextrading4j.hist.api.message.trading.builder.IEXTradeMessageDataBuilder;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;
import pl.zankowski.iextrading4j.hist.tops.message.builder.IEXQuoteUpdateMessageDataBuilder;

import java.nio.ByteBuffer;

import static org.assertj.core.api.Assertions.assertThat;

public class IEXTOPSMessageBlockTest {

    @Test
    public void shouldSuccessfullyCreateMessageBlockInstance() {
        IEXMessageHeaderDataBuilder iexMessageHeaderDataBuilder = IEXMessageHeaderDataBuilder.messageHeader()
                .withMessageCount((short) 2);
        IEXTradeMessageDataBuilder iexTradeMessageDataBuilder = IEXTradeMessageDataBuilder.tradeMessage();
        IEXQuoteUpdateMessageDataBuilder iexQuoteUpdateMessageDataBuilder = IEXQuoteUpdateMessageDataBuilder.quoteMessage();

        byte[] bytes = prepareMessages(iexMessageHeaderDataBuilder, iexTradeMessageDataBuilder, iexQuoteUpdateMessageDataBuilder);
        IEXSegment iexSegment = IEXTOPSMessageBlock.createIEXSegment(bytes);

        assertThat(iexSegment.getMessages()).hasSize(2);
        assertThat(iexSegment.getMessageHeader()).isEqualTo(iexMessageHeaderDataBuilder.build());
        assertThat(iexSegment.getMessages().get(0)).isEqualTo(iexTradeMessageDataBuilder.build());
        assertThat(iexSegment.getMessages().get(1)).isEqualTo(iexQuoteUpdateMessageDataBuilder.build());
    }

    private byte[] prepareMessages(IEXMessageHeaderDataBuilder iexMessageHeaderDataBuilder, IEXTradeMessageDataBuilder iexTradeMessageDataBuilder,
                                   IEXQuoteUpdateMessageDataBuilder iexQuoteUpdateMessageDataBuilder) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
        byteBuffer.put(iexMessageHeaderDataBuilder.getBytes());
        byteBuffer.put(IEXByteTestUtil.convert((short) 38));
        byteBuffer.put(iexTradeMessageDataBuilder.getBytes());
        byteBuffer.put(IEXByteTestUtil.convert((short) 42));
        byteBuffer.put(iexQuoteUpdateMessageDataBuilder.getBytes());
        return byteBuffer.array();
    }

}
