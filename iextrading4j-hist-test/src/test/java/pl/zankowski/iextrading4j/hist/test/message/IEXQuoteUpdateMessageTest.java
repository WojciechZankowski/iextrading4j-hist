package pl.zankowski.iextrading4j.hist.test.message;

import org.junit.Test;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.test.ExtendedUnitTestBase;
import pl.zankowski.iextrading4j.hist.tops.trading.IEXQuoteUpdateMessage;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.tops.trading.IEXQuoteUpdateMessage.createIEXMessage;

public class IEXQuoteUpdateMessageTest extends ExtendedUnitTestBase {

    @Test
    public void testIEXQuoteUpdateMessage() throws IOException {
        final byte[] packet = loadPacket("IEXQuoteUpdateMessage.dump");

        final IEXQuoteUpdateMessage message = createIEXMessage(packet);

        assertThat(message.getMessageType()).isEqualTo(IEXMessageType.QUOTE_UPDATE);
        assertThat(message.getTimestamp()).isEqualTo(1509795046074879944L);
        assertThat(message.getSymbol()).isEqualTo("A");
        assertThat(message.getBidSize()).isEqualTo(0);
        assertThat(message.getBidPrice()).isEqualTo(new IEXPrice(0));
        assertThat(message.getAskPrice()).isEqualTo(new IEXPrice(0));
        assertThat(message.getAskSize()).isEqualTo(0);
    }

}
