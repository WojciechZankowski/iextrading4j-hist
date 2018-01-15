package pl.zankowski.iextrading4j.hist.test.message;

import org.junit.Test;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.deep.trading.IEXPriceLevelUpdateMessage;
import pl.zankowski.iextrading4j.hist.deep.trading.field.IEXEventFlag;
import pl.zankowski.iextrading4j.hist.test.ExtendedUnitTestBase;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.deep.trading.IEXPriceLevelUpdateMessage.createIEXMessage;

public class IEXPriceLevelUpdateMessageTest extends ExtendedUnitTestBase {

    @Test
    public void testIEXPriceLevelUpdateMessage() throws IOException {
        final byte[] packet = loadPacket("IEXPriceLevelUpdateMessage.dump");

        final IEXPriceLevelUpdateMessage message = createIEXMessage(IEXMessageType.PRICE_LEVEL_UPDATE_BUY, packet);

        assertThat(message.getMessageType()).isEqualTo(IEXMessageType.PRICE_LEVEL_UPDATE_BUY);
        assertThat(message.getEventFlag()).isEqualTo(IEXEventFlag.EVENT_PROCESSING_COMPLETE);
        assertThat(message.getTimestamp()).isEqualTo(1509799810232574926L);
        assertThat(message.getSymbol()).isEqualTo("ZXIET");
        assertThat(message.getSize()).isEqualTo(5431);
        assertThat(message.getPrice()).isEqualTo(new IEXPrice(999100));
    }

}
