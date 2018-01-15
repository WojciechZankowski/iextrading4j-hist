package pl.zankowski.iextrading4j.hist.test.message;

import org.junit.Test;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.auction.IEXAuctionInformationMessage;
import pl.zankowski.iextrading4j.hist.api.message.auction.field.IEXSide;
import pl.zankowski.iextrading4j.hist.test.ExtendedUnitTestBase;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.api.message.auction.IEXAuctionInformationMessage.createIEXMessage;

public class IEXAuctionInformationMessageTest extends ExtendedUnitTestBase {

    @Test
    public void testIEXAuctionInformationMessage() throws IOException {
        final byte[] packet = loadPacket("IEXAuctionInformationMessage.dump");

        final IEXAuctionInformationMessage message = createIEXMessage(packet);

        assertThat(message.getMessageType()).isEqualTo(IEXMessageType.AUCTION_INFORMATION);
        assertThat(message.getTimestamp()).isEqualTo(1509799500155613925L);
        assertThat(message.getSymbol()).isEqualTo("ZXIET");
        assertThat(message.getPairedShares()).isEqualTo(0);
        assertThat(message.getReferencePrice()).isEqualTo(new IEXPrice(1000000));
        assertThat(message.getIndicativeClearingPrice()).isEqualTo(new IEXPrice(1000000));
        assertThat(message.getImbalanceShares()).isEqualTo(0);
        assertThat(message.getSide()).isEqualTo(IEXSide.NO_IMBALANCE);
        assertThat(message.getExtensionNumber()).isEqualTo((byte) 0);
        assertThat(message.getEventTime()).isEqualTo(1509799800);
        assertThat(message.getAuctionBookClearingPrice()).isEqualTo(new IEXPrice(1000000));
        assertThat(message.getCollarReferencePrice()).isEqualTo(new IEXPrice(0));
        assertThat(message.getLowerAuctionCollar()).isEqualTo(new IEXPrice(0));
        assertThat(message.getUpperAuctionCollar()).isEqualTo(new IEXPrice(0));
    }

}
