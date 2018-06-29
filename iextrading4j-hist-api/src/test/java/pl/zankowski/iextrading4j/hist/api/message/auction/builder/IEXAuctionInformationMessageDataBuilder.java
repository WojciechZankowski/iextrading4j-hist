package pl.zankowski.iextrading4j.hist.api.message.auction.builder;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.auction.IEXAuctionInformationMessage;
import pl.zankowski.iextrading4j.hist.api.message.auction.field.IEXAuctionType;
import pl.zankowski.iextrading4j.hist.api.message.auction.field.IEXSide;
import pl.zankowski.iextrading4j.hist.api.message.builder.TestDataBuilder;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

public class IEXAuctionInformationMessageDataBuilder implements TestDataBuilder {

    private IEXAuctionType auctionType = IEXAuctionType.HALT_AUCTION;
    private long timestamp = 1494855059287436131L;
    private String symbol = "SNAP";
    private int pairedShares = 2;
    private IEXPrice referencePrice = new IEXPrice(1234L);
    private IEXPrice indicativeClearingPrice = new IEXPrice(1234L);
    private int imbalanceShares = 5;
    private IEXSide side = IEXSide.NO_IMBALANCE;
    private byte extensionNumber = (byte) 1;
    private int eventTime = 1234;
    private IEXPrice auctionBookClearingPrice = new IEXPrice(1234L);
    private IEXPrice collarReferencePrice = new IEXPrice(1234L);
    private IEXPrice lowerAuctionCollar = new IEXPrice(1234L);
    private IEXPrice upperAuctionCollar = new IEXPrice(1234L);

    public static IEXAuctionInformationMessage defaultAuctionMessage() {
        return auctionMessage().build();
    }

    public static IEXAuctionInformationMessageDataBuilder auctionMessage() {
        return new IEXAuctionInformationMessageDataBuilder();
    }

    public IEXAuctionInformationMessageDataBuilder withAuctionType(final IEXAuctionType auctionType) {
        this.auctionType = auctionType;
        return this;
    }

    public IEXAuctionInformationMessageDataBuilder withTimestamp(final long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public IEXAuctionInformationMessageDataBuilder withSymbol(final String symbol) {
        this.symbol = symbol;
        return this;
    }

    public IEXAuctionInformationMessageDataBuilder withPairedShares(final int pairedShares) {
        this.pairedShares = pairedShares;
        return this;
    }

    public IEXAuctionInformationMessageDataBuilder withReferencePrice(final IEXPrice referencePrice) {
        this.referencePrice = referencePrice;
        return this;
    }

    public IEXAuctionInformationMessageDataBuilder withIndicativeClearingPrice(final IEXPrice indicativeClearingPrice) {
        this.indicativeClearingPrice = indicativeClearingPrice;
        return this;
    }

    public IEXAuctionInformationMessageDataBuilder withImbalanceShares(final int imbalanceShares) {
        this.imbalanceShares = imbalanceShares;
        return this;
    }

    public IEXAuctionInformationMessageDataBuilder withSide(final IEXSide side) {
        this.side = side;
        return this;
    }

    public IEXAuctionInformationMessageDataBuilder withExtensionNumber(final byte extensionNumber) {
        this.extensionNumber = extensionNumber;
        return this;
    }

    public IEXAuctionInformationMessageDataBuilder withEventTime(final int eventTime) {
        this.eventTime = eventTime;
        return this;
    }

    public IEXAuctionInformationMessageDataBuilder withAuctionBookClearingPrice(final IEXPrice auctionBookClearingPrice) {
        this.auctionBookClearingPrice = auctionBookClearingPrice;
        return this;
    }

    public IEXAuctionInformationMessageDataBuilder withCollarReferencePrice(final IEXPrice collarReferencePrice) {
        this.collarReferencePrice = collarReferencePrice;
        return this;
    }

    public IEXAuctionInformationMessageDataBuilder withLowerAuctionCollar(final IEXPrice lowerAuctionCollar) {
        this.lowerAuctionCollar = lowerAuctionCollar;
        return this;
    }

    public IEXAuctionInformationMessageDataBuilder withUpperAuctionCollar(final IEXPrice upperAuctionCollar) {
        this.upperAuctionCollar = upperAuctionCollar;
        return this;
    }

    @Override
    public byte[] getBytes() {
        return IEXByteTestUtil.prepareBytes(IEXAuctionInformationMessage.LENGTH, IEXMessageType.AUCTION_INFORMATION,
                auctionType, timestamp, symbol, pairedShares, referencePrice, indicativeClearingPrice, imbalanceShares,
                side, extensionNumber, eventTime, auctionBookClearingPrice, collarReferencePrice, lowerAuctionCollar,
                upperAuctionCollar);
    }

    public IEXAuctionInformationMessage build() {
        return IEXAuctionInformationMessage.createIEXMessage(getBytes());
    }
}
