package pl.zankowski.iextrading4j.hist.api.message.trading;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.api.message.trading.builder.IEXTradeMessageDataBuilder.defaultTradeMessage;

public class IEXTradeMessageTest {

    @Test
    public void constructor() {
        final IEXMessageType messageType = IEXMessageType.TRADE_REPORT;
        final byte saleConditionFlag = -64;
        final long timestamp = 1494855059287436131L;
        final String symbol = "SNAP";
        final int size = 3;
        final IEXPrice price = new IEXPrice(1234L);
        final long tradeID = 12345L;

        final byte[] bytes = IEXByteTestUtil.prepareBytes(IEXTradeMessage.TOPS16_LENGTH, messageType, saleConditionFlag,
                timestamp, symbol, size, price, tradeID);
        final IEXTradeMessage message = IEXTradeMessage.createIEXMessage(messageType, bytes);

        assertThat(message.getMessageType()).isEqualTo(messageType);
        assertThat(message.getTimestamp()).isEqualTo(timestamp);
        assertThat(message.getSymbol()).isEqualTo(symbol);
        assertThat(message.getSize()).isEqualTo(size);
        assertThat(message.getPrice()).isEqualTo(price);
        assertThat(message.getTradeID()).isEqualTo(tradeID);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IEXTradeMessage.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(defaultTradeMessage())
                .verify();
    }

}
