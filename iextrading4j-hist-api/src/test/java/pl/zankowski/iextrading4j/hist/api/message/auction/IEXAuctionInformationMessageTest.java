package pl.zankowski.iextrading4j.hist.api.message.auction;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.auction.field.IEXAuctionType;
import pl.zankowski.iextrading4j.hist.api.message.auction.field.IEXSide;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.api.message.auction.builder.IEXAuctionInformationMessageDataBuilder.defaultAuctionMessage;

public class IEXAuctionInformationMessageTest {

    @Test
    public void constructor() {
        final IEXAuctionType auctionType = IEXAuctionType.HALT_AUCTION;
        final long timestamp = 1494855059287436131L;
        final String symbol = "SNAP";
        final int pairedShares = 2;
        final IEXPrice referencePrice = new IEXPrice(1234L);
        final IEXPrice indicativeClearingPrice = new IEXPrice(1234L);
        final int imbalanceShares = 5;
        final IEXSide side = IEXSide.NO_IMBALANCE;
        final byte extensionNumber = (byte) 1;
        final int eventTime = 1234;
        final IEXPrice auctionBookClearingPrice = new IEXPrice(1234L);
        final IEXPrice collarReferencePrice = new IEXPrice(1234L);
        final IEXPrice lowerAuctionCollar = new IEXPrice(1234L);
        final IEXPrice upperAuctionCollar = new IEXPrice(1234L);

        final byte[] bytes = IEXByteTestUtil.prepareBytes(80, IEXMessageType.AUCTION_INFORMATION, auctionType, timestamp,
                symbol, pairedShares, referencePrice, indicativeClearingPrice, imbalanceShares, side, extensionNumber,
                eventTime, auctionBookClearingPrice, collarReferencePrice, lowerAuctionCollar, upperAuctionCollar);
        final IEXAuctionInformationMessage message = IEXAuctionInformationMessage.createIEXMessage(bytes);

        assertThat(message.getMessageType()).isEqualTo(IEXMessageType.AUCTION_INFORMATION);
        assertThat(message.getAuctionType()).isEqualTo(auctionType);
        assertThat(message.getTimestamp()).isEqualTo(timestamp);
        assertThat(message.getSymbol()).isEqualTo(symbol);
        assertThat(message.getPairedShares()).isEqualTo(pairedShares);
        assertThat(message.getReferencePrice()).isEqualTo(referencePrice);
        assertThat(message.getIndicativeClearingPrice()).isEqualTo(indicativeClearingPrice);
        assertThat(message.getImbalanceShares()).isEqualTo(imbalanceShares);
        assertThat(message.getSide()).isEqualTo(side);
        assertThat(message.getExtensionNumber()).isEqualTo(extensionNumber);
        assertThat(message.getEventTime()).isEqualTo(eventTime);
        assertThat(message.getAuctionBookClearingPrice()).isEqualTo(auctionBookClearingPrice);
        assertThat(message.getCollarReferencePrice()).isEqualTo(collarReferencePrice);
        assertThat(message.getLowerAuctionCollar()).isEqualTo(lowerAuctionCollar);
        assertThat(message.getUpperAuctionCollar()).isEqualTo(upperAuctionCollar);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IEXAuctionInformationMessage.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(defaultAuctionMessage())
                .verify();
    }

}
