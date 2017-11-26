package pl.zankowski.iextrading4j.hist.deep.auction.message;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;
import pl.zankowski.iextrading4j.hist.deep.auction.field.IEXAuctionType;
import pl.zankowski.iextrading4j.hist.deep.auction.field.IEXSide;

import java.util.Arrays;
import java.util.Objects;

public class IEXAuctionInformationMessage extends IEXMessage {

    private final IEXMessageType iexMessageType;
    private final IEXAuctionType iexAuctionType;
    private final long timestamp;
    private final String symbol;
    private final int pairedShares;
    private final IEXPrice referencePrice;
    private final IEXPrice indicativeClearingPrice;
    private final int imbalanceShares;
    private final IEXSide iexSide;
    private final byte extensionNumber;
    private final int eventTime;
    private final IEXPrice auctionBookClearingPrice;
    private final IEXPrice collarReferencePrice;
    private final IEXPrice lowerAuctionCollar;
    private final IEXPrice upperAuctionCollar;

    public IEXAuctionInformationMessage(
            final IEXMessageType iexMessageType,
            final IEXAuctionType iexAuctionType,
            final long timestamp,
            final String symbol,
            final int pairedShares,
            final IEXPrice referencePrice,
            final IEXPrice indicativeClearingPrice,
            final int imbalanceShares,
            final IEXSide iexSide,
            final byte extensionNumber,
            final int eventTime,
            final IEXPrice auctionBookClearingPrice,
            final IEXPrice collarReferencePrice,
            final IEXPrice lowerAuctionCollar,
            final IEXPrice upperAuctionCollar) {
        this.iexMessageType = iexMessageType;
        this.iexAuctionType = iexAuctionType;
        this.timestamp = timestamp;
        this.symbol = symbol;
        this.pairedShares = pairedShares;
        this.referencePrice = referencePrice;
        this.indicativeClearingPrice = indicativeClearingPrice;
        this.imbalanceShares = imbalanceShares;
        this.iexSide = iexSide;
        this.extensionNumber = extensionNumber;
        this.eventTime = eventTime;
        this.auctionBookClearingPrice = auctionBookClearingPrice;
        this.collarReferencePrice = collarReferencePrice;
        this.lowerAuctionCollar = lowerAuctionCollar;
        this.upperAuctionCollar = upperAuctionCollar;
    }

    public static IEXMessage createIEXMessage(final IEXMessageType iexMessageType, final byte[] bytes) {
        final IEXAuctionType iexAuctionType = IEXAuctionType.getAuctionType(bytes[1]);
        final long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        final String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));
        final int pairedShares = IEXByteConverter.convertBytesToInt(Arrays.copyOfRange(bytes, 18, 22));
        final IEXPrice referencePrice = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 22, 30));
        final IEXPrice indicativeClearingPrice = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 30, 38));
        final int imbalanceShares = IEXByteConverter.convertBytesToInt(Arrays.copyOfRange(bytes, 38, 42));
        final IEXSide imbalanceSide = IEXSide.getSide(bytes[42]);
        final byte extensionNumber = bytes[43];
        final int scheduledAuctionTime = IEXByteConverter.convertBytesToInt(Arrays.copyOfRange(bytes, 44, 48));
        final IEXPrice auctionBookClearingPrice = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 48, 56));
        final IEXPrice collarReferencePrice = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 56, 64));
        final IEXPrice lowerAuctionCollar = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 64, 72));
        final IEXPrice upperAuctionCollar = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 72, 80));
        return new IEXAuctionInformationMessage(iexMessageType, iexAuctionType, timestamp, symbol, pairedShares, referencePrice, indicativeClearingPrice,
                imbalanceShares, imbalanceSide, extensionNumber, scheduledAuctionTime, auctionBookClearingPrice, collarReferencePrice,
                lowerAuctionCollar, upperAuctionCollar);
    }

    public IEXMessageType getIexMessageType() {
        return iexMessageType;
    }

    public IEXAuctionType getIexAuctionType() {
        return iexAuctionType;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getPairedShares() {
        return pairedShares;
    }

    public IEXPrice getReferencePrice() {
        return referencePrice;
    }

    public IEXPrice getIndicativeClearingPrice() {
        return indicativeClearingPrice;
    }

    public int getImbalanceShares() {
        return imbalanceShares;
    }

    public IEXSide getIexSide() {
        return iexSide;
    }

    public byte getExtensionNumber() {
        return extensionNumber;
    }

    public int getEventTime() {
        return eventTime;
    }

    public IEXPrice getAuctionBookClearingPrice() {
        return auctionBookClearingPrice;
    }

    public IEXPrice getCollarReferencePrice() {
        return collarReferencePrice;
    }

    public IEXPrice getLowerAuctionCollar() {
        return lowerAuctionCollar;
    }

    public IEXPrice getUpperAuctionCollar() {
        return upperAuctionCollar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IEXAuctionInformationMessage that = (IEXAuctionInformationMessage) o;
        return timestamp == that.timestamp &&
                pairedShares == that.pairedShares &&
                imbalanceShares == that.imbalanceShares &&
                extensionNumber == that.extensionNumber &&
                eventTime == that.eventTime &&
                iexMessageType == that.iexMessageType &&
                iexAuctionType == that.iexAuctionType &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(referencePrice, that.referencePrice) &&
                Objects.equals(indicativeClearingPrice, that.indicativeClearingPrice) &&
                iexSide == that.iexSide &&
                Objects.equals(auctionBookClearingPrice, that.auctionBookClearingPrice) &&
                Objects.equals(collarReferencePrice, that.collarReferencePrice) &&
                Objects.equals(lowerAuctionCollar, that.lowerAuctionCollar) &&
                Objects.equals(upperAuctionCollar, that.upperAuctionCollar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iexMessageType, iexAuctionType, timestamp, symbol, pairedShares,
                referencePrice, indicativeClearingPrice, imbalanceShares, iexSide, extensionNumber,
                eventTime, auctionBookClearingPrice, collarReferencePrice, lowerAuctionCollar,
                upperAuctionCollar);
    }

    @Override
    public String toString() {
        return "IEXAuctionInformationMessage{" +
                "iexMessageType=" + iexMessageType +
                ", iexAuctionType=" + iexAuctionType +
                ", timestamp=" + timestamp +
                ", symbol='" + symbol + '\'' +
                ", pairedShares=" + pairedShares +
                ", referencePrice=" + referencePrice +
                ", indicativeClearingPrice=" + indicativeClearingPrice +
                ", imbalanceShares=" + imbalanceShares +
                ", iexSide=" + iexSide +
                ", extensionNumber=" + extensionNumber +
                ", eventTime=" + eventTime +
                ", auctionBookClearingPrice=" + auctionBookClearingPrice +
                ", collarReferencePrice=" + collarReferencePrice +
                ", lowerAuctionCollar=" + lowerAuctionCollar +
                ", upperAuctionCollar=" + upperAuctionCollar +
                '}';
    }
}
