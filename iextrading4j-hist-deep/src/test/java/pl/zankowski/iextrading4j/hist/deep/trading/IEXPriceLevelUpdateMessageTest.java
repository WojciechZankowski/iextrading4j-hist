package pl.zankowski.iextrading4j.hist.deep.trading;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;
import pl.zankowski.iextrading4j.hist.deep.trading.field.IEXEventFlag;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.deep.trading.builder.IEXPriceLevelUpdateMessageDataBuilder.defaultPriceLevelMessage;

public class IEXPriceLevelUpdateMessageTest {

    @Test
    public void constructor() {
        final IEXMessageType messageType = IEXMessageType.PRICE_LEVEL_UPDATE_BUY;
        final IEXEventFlag eventFlag = IEXEventFlag.EVENT_PROCESSING_COMPLETE;
        final long timestamp = 1494855059287436131L;
        final String symbol = "SNAP";
        final int size = 12;
        final IEXPrice price = new IEXPrice(1234L);

        final byte[] bytes = IEXByteTestUtil.prepareBytes(30, messageType, eventFlag, timestamp, symbol,
                size, price);
        final IEXPriceLevelUpdateMessage message = IEXPriceLevelUpdateMessage.createIEXMessage(messageType, bytes);

        assertThat(message.getMessageType()).isEqualTo(messageType);
        assertThat(message.getEventFlag()).isEqualTo(eventFlag);
        assertThat(message.getTimestamp()).isEqualTo(timestamp);
        assertThat(message.getSymbol()).isEqualTo(symbol);
        assertThat(message.getSize()).isEqualTo(size);
        assertThat(message.getPrice()).isEqualTo(price);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IEXPriceLevelUpdateMessage.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(defaultPriceLevelMessage())
                .verify();
    }

}
