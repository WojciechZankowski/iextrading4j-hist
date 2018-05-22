package pl.zankowski.iextrading4j.hist.api.message.trading;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.trading.field.IEXPriceType;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.api.message.trading.builder.IEXOfficialPriceMessageDataBuilder.defaultOfficialPriceMessage;

public class IEXOfficialPriceMessageTest {

    @Test
    public void constructor() {
        final IEXPriceType priceType = IEXPriceType.IEX_OFFICIAL_CLOSING_PRICE;
        final long timestamp = 1494855059287436131L;
        final String symbol = "SNAP";
        final IEXPrice officialPrice = new IEXPrice(1234L);

        final byte[] bytes = IEXByteTestUtil.prepareBytes(26, IEXMessageType.OFFICIAL_PRICE_MESSAGE, priceType, timestamp,
                symbol, officialPrice);
        final IEXOfficialPriceMessage message = IEXOfficialPriceMessage.createIEXMessage(bytes);

        assertThat(message.getMessageType()).isEqualTo(IEXMessageType.OFFICIAL_PRICE_MESSAGE);
        assertThat(message.getPriceType()).isEqualTo(priceType);
        assertThat(message.getTimestamp()).isEqualTo(timestamp);
        assertThat(message.getSymbol()).isEqualTo(symbol);
        assertThat(message.getOfficialPrice()).isEqualTo(officialPrice);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IEXOfficialPriceMessage.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(defaultOfficialPriceMessage())
                .verify();
    }

}
