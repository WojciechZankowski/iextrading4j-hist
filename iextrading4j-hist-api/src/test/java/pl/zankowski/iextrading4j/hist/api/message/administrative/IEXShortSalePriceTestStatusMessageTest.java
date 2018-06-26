package pl.zankowski.iextrading4j.hist.api.message.administrative;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXDetail;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXShortSalePriceTestStatus;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.api.message.administrative.builder.IEXShortSalePriceTestStatusMessageDataBuilder.defaultShortSaleMessage;

public class IEXShortSalePriceTestStatusMessageTest {

    @Test
    public void constructor() {
        final IEXShortSalePriceTestStatus shortSalePriceTestStatus = IEXShortSalePriceTestStatus.PRICE_TEST_IN_EFFECT;
        final long timestamp = 1494855059287436131L;
        final String symbol = "SNAP";
        final IEXDetail detail = IEXDetail.PRICE_TEST_RESTRICTION_DEACTIVATED;

        final byte[] bytes = IEXByteTestUtil.prepareBytes(IEXShortSalePriceTestStatusMessage.LENGTH,
                IEXMessageType.SHORT_SALE_PRICE_TEST_STATUS, shortSalePriceTestStatus, timestamp, symbol, detail);
        final IEXShortSalePriceTestStatusMessage message = IEXShortSalePriceTestStatusMessage.createIEXMessage(bytes);

        assertThat(message.getMessageType()).isEqualTo(IEXMessageType.SHORT_SALE_PRICE_TEST_STATUS);
        assertThat(message.getShortSalePriceTestStatus()).isEqualTo(shortSalePriceTestStatus);
        assertThat(message.getTimestamp()).isEqualTo(timestamp);
        assertThat(message.getSymbol()).isEqualTo(symbol);
        assertThat(message.getDetail()).isEqualTo(detail);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IEXShortSalePriceTestStatusMessage.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(defaultShortSaleMessage())
                .verify();
    }

}
