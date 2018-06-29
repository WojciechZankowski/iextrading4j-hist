package pl.zankowski.iextrading4j.hist.api.message.trading;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Ignore;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.api.message.trading.builder.IEXTradeMessageDataBuilder.defaultTradeMessage;
import static pl.zankowski.iextrading4j.hist.api.message.trading.builder.IEXTradeMessageDataBuilder.tradeMessage;

public class IEXTradeMessageTest {

    @Ignore
    @Test
    public void constructor() {
        final IEXMessageType messageType = IEXMessageType.TRADE_REPORT;
        final byte saleConditionFlag = -64;
        final long timestamp = 1494855059287436131L;
        final String symbol = "SNAP";
        final int size = 3;
        final IEXPrice price = new IEXPrice(1234L);
        final long tradeID = 12345L;

        final byte[] bytes = IEXByteTestUtil.prepareBytes(IEXTradeMessage.LENGTH, messageType, saleConditionFlag,
                timestamp, symbol, size, price, tradeID);
        final IEXTradeMessage message = IEXTradeMessage.createIEXMessage(messageType, bytes);

        assertThat(message.getMessageType()).isEqualTo(messageType);
        assertThat(message.isISO()).isTrue();
        assertThat(message.isExtendedHoursTrade()).isFalse();
        assertThat(message.isOddLotTrade()).isFalse();
        assertThat(message.isNotTradeThrough()).isFalse();
        assertThat(message.isSinglePriceCrossTrade()).isFalse();
        assertThat(message.getTimestamp()).isEqualTo(timestamp);
        assertThat(message.getSymbol()).isEqualTo(symbol);
        assertThat(message.getSize()).isEqualTo(size);
        assertThat(message.getPrice()).isEqualTo(price);
        assertThat(message.getTradeID()).isEqualTo(tradeID);
    }

    @Ignore
    @Test
    public void testIsExtendedHoursTrade() {
        final IEXTradeMessage message = tradeMessage()
                .withFlag((byte) -96)
                .build();

        assertThat(message.isISO()).isFalse();
        assertThat(message.isExtendedHoursTrade()).isTrue();
        assertThat(message.isOddLotTrade()).isFalse();
        assertThat(message.isNotTradeThrough()).isFalse();
        assertThat(message.isSinglePriceCrossTrade()).isFalse();
    }

    @Ignore
    @Test
    public void testIsOddLot() {
        final IEXTradeMessage message = tradeMessage()
                .withFlag((byte) -112)
                .build();

        assertThat(message.isISO()).isFalse();
        assertThat(message.isExtendedHoursTrade()).isFalse();
        assertThat(message.isOddLotTrade()).isTrue();
        assertThat(message.isNotTradeThrough()).isFalse();
        assertThat(message.isSinglePriceCrossTrade()).isFalse();
    }

    @Ignore
    @Test
    public void testIsNotTradeThrough() {
        final IEXTradeMessage message = tradeMessage()
                .withFlag((byte) -120)
                .build();

        assertThat(message.isISO()).isFalse();
        assertThat(message.isExtendedHoursTrade()).isFalse();
        assertThat(message.isOddLotTrade()).isFalse();
        assertThat(message.isNotTradeThrough()).isTrue();
        assertThat(message.isSinglePriceCrossTrade()).isFalse();
    }

    @Ignore
    @Test
    public void testIsSinglePriceCrossTrade() {
        final IEXTradeMessage message = tradeMessage()
                .withFlag((byte) -124)
                .build();

        assertThat(message.isISO()).isFalse();
        assertThat(message.isExtendedHoursTrade()).isFalse();
        assertThat(message.isOddLotTrade()).isFalse();
        assertThat(message.isNotTradeThrough()).isFalse();
        assertThat(message.isSinglePriceCrossTrade()).isTrue();
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
