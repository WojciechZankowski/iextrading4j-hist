package pl.zankowski.iextrading4j.hist.tops.message;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;
import pl.zankowski.iextrading4j.hist.tops.trading.field.IEXMessageFlag;
import pl.zankowski.iextrading4j.hist.tops.trading.IEXQuoteUpdateMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.tops.message.builder.IEXQuoteUpdateMessageDataBuilder.defaultQuoteMessage;

public class IEXQuoteUpdateMessageTest {

    @Test
    public void shouldSuccessfullyCreateQuoteUpdateInstance() {
        final IEXMessageType messageType = IEXMessageType.QUOTE_UPDATE;
        final IEXMessageFlag messageFlag = IEXMessageFlag.ACTIVE_IN_SESSION;
        final long timestamp = 123456789L;
        final String symbol = "AAPL";
        final int bidSize = 100;
        final IEXPrice bidPrice = new IEXPrice(1234565L);
        final IEXPrice askPrice = new IEXPrice(1234567L);
        final int askSize = 200;

        byte[] data = IEXByteTestUtil.prepareBytes(42, messageType.getCode(), messageFlag.getFlag(),
                timestamp, symbol, bidSize, bidPrice.getNumber(), askPrice.getNumber(), askSize);
        IEXQuoteUpdateMessage iexQuoteUpdateMessage = IEXQuoteUpdateMessage.createIEXMessage(data);

        assertThat(iexQuoteUpdateMessage.getMessageType()).isEqualTo(messageType);
        assertThat(iexQuoteUpdateMessage.getMessageFlag()).isEqualTo(messageFlag);
        assertThat(iexQuoteUpdateMessage.getTimestamp()).isEqualTo(timestamp);
        assertThat(iexQuoteUpdateMessage.getSymbol()).isEqualTo(symbol);
        assertThat(iexQuoteUpdateMessage.getBidSize()).isEqualTo(bidSize);
        assertThat(iexQuoteUpdateMessage.getBidPrice()).isEqualTo(bidPrice);
        assertThat(iexQuoteUpdateMessage.getAskPrice()).isEqualTo(askPrice);
        assertThat(iexQuoteUpdateMessage.getAskSize()).isEqualTo(askSize);
    }

    @Test
    public void shouldTwoInstancesWithSameValuesBeEqual() {
        IEXQuoteUpdateMessage iexQuoteUpdateMessage_1 = defaultQuoteMessage();
        IEXQuoteUpdateMessage iexQuoteUpdateMessage_2 = defaultQuoteMessage();

        assertThat(iexQuoteUpdateMessage_1).isEqualTo(iexQuoteUpdateMessage_2);
        assertThat(iexQuoteUpdateMessage_1.hashCode()).isEqualTo(iexQuoteUpdateMessage_2.hashCode());
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IEXQuoteUpdateMessage.class)
                .usingGetClass()
                .verify();
    }

}
