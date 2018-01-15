package pl.zankowski.iextrading4j.hist.test.message;

import org.junit.Test;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.administrative.IEXShortSalePriceTestStatusMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXDetail;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXShortSalePriceTestStatus;
import pl.zankowski.iextrading4j.hist.test.ExtendedUnitTestBase;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.api.message.administrative.IEXShortSalePriceTestStatusMessage.createIEXMessage;

public class IEXShortSalePriceTestStatusMessageTest extends ExtendedUnitTestBase {

    @Test
    public void testIEXShortSalePriceTestStatusMessage() throws IOException {
        final byte[] packet = loadPacket("IEXShortSalePriceTestStatusMessage.dump");

        final IEXShortSalePriceTestStatusMessage message = createIEXMessage(packet);

        assertThat(message.getMessageType()).isEqualTo(IEXMessageType.SHORT_SALE_PRICE_TEST_STATUS);
        assertThat(message.getShortSalePriceTestStatus()).isEqualTo(IEXShortSalePriceTestStatus.PRICE_TEST_IN_EFFECT);
        assertThat(message.getTimestamp()).isEqualTo(1509797834359025726L);
        assertThat(message.getSymbol()).isEqualTo("ACET");
        assertThat(message.getDetail()).isEqualTo(IEXDetail.DETAIL_NOT_AVAILABLE);
    }

}
