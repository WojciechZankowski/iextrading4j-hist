package pl.zankowski.iextrading4j.hist.tops.message;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Ignore;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;
import pl.zankowski.iextrading4j.hist.tops.trading.IEXQuoteUpdateMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.tops.message.builder.IEXQuoteUpdateMessageDataBuilder.defaultQuoteMessage;
import static pl.zankowski.iextrading4j.hist.tops.message.builder.IEXQuoteUpdateMessageDataBuilder.quoteMessage;

public class IEXQuoteUpdateMessageTest {

    @Ignore
    @Test
    public void shouldSuccessfullyCreateQuoteUpdateInstance() {
        final IEXMessageType messageType = IEXMessageType.QUOTE_UPDATE;
        final byte messageFlag = -64;
        final long timestamp = 123456789L;
        final String symbol = "AAPL";
        final int bidSize = 100;
        final IEXPrice bidPrice = new IEXPrice(1234565L);
        final IEXPrice askPrice = new IEXPrice(1234567L);
        final int askSize = 200;

        final byte[] data = IEXByteTestUtil.prepareBytes(42, messageType.getCode(), messageFlag,
                timestamp, symbol, bidSize, bidPrice.getNumber(), askPrice.getNumber(), askSize);
        final IEXQuoteUpdateMessage iexQuoteUpdateMessage = IEXQuoteUpdateMessage.createIEXMessage(data);

        assertThat(iexQuoteUpdateMessage.getMessageType()).isEqualTo(messageType);
        assertThat(iexQuoteUpdateMessage.isHalted()).isTrue();
        assertThat(iexQuoteUpdateMessage.isPrePostMarketSession()).isFalse();
        assertThat(iexQuoteUpdateMessage.getTimestamp()).isEqualTo(timestamp);
        assertThat(iexQuoteUpdateMessage.getSymbol()).isEqualTo(symbol);
        assertThat(iexQuoteUpdateMessage.getBidSize()).isEqualTo(bidSize);
        assertThat(iexQuoteUpdateMessage.getBidPrice()).isEqualTo(bidPrice);
        assertThat(iexQuoteUpdateMessage.getAskPrice()).isEqualTo(askPrice);
        assertThat(iexQuoteUpdateMessage.getAskSize()).isEqualTo(askSize);
    }

    @Ignore
    @Test
    public void testIsPrePostMarketSession() {
        final IEXQuoteUpdateMessage iexQuoteUpdateMessage = quoteMessage()
                .withFlag((byte) -96)
                .build();

        assertThat(iexQuoteUpdateMessage.isHalted()).isFalse();
        assertThat(iexQuoteUpdateMessage.isPrePostMarketSession()).isTrue();
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IEXQuoteUpdateMessage.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(defaultQuoteMessage())
                .verify();
    }

}
