package pl.zankowski.iextrading4j.hist.deep.auction.message;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;
import pl.zankowski.iextrading4j.hist.deep.auction.field.IEXAuctionType;
import pl.zankowski.iextrading4j.hist.deep.auction.field.IEXSide;

import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
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
    private final IEXPrice autcionBookClearingPrice;
    private final IEXPrice collarReferencePrice;
    private final IEXPrice lowerAuctionCollar;
    private final IEXPrice upperAuctionCollar;

    public IEXAuctionInformationMessage(IEXMessageType iexMessageType, IEXAuctionType iexAuctionType, long timestamp,
                                        String symbol, int pairedShares, IEXPrice referencePrice, IEXPrice indicativeClearingPrice,
                                        int imbalanceShares, IEXSide iexSide, byte extensionNumber, int eventTime,
                                        IEXPrice autcionBookClearingPrice, IEXPrice collarReferencePrice, IEXPrice lowerAuctionCollar,
                                        IEXPrice upperAuctionCollar) {
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
        this.autcionBookClearingPrice = autcionBookClearingPrice;
        this.collarReferencePrice = collarReferencePrice;
        this.lowerAuctionCollar = lowerAuctionCollar;
        this.upperAuctionCollar = upperAuctionCollar;
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

    public IEXPrice getAutcionBookClearingPrice() {
        return autcionBookClearingPrice;
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
        if (!(o instanceof IEXAuctionInformationMessage)) return false;

        IEXAuctionInformationMessage that = (IEXAuctionInformationMessage) o;

        if (timestamp != that.timestamp) return false;
        if (pairedShares != that.pairedShares) return false;
        if (imbalanceShares != that.imbalanceShares) return false;
        if (extensionNumber != that.extensionNumber) return false;
        if (eventTime != that.eventTime) return false;
        if (iexMessageType != that.iexMessageType) return false;
        if (iexAuctionType != that.iexAuctionType) return false;
        if (symbol != null ? !symbol.equals(that.symbol) : that.symbol != null) return false;
        if (referencePrice != null ? !referencePrice.equals(that.referencePrice) : that.referencePrice != null)
            return false;
        if (indicativeClearingPrice != null ? !indicativeClearingPrice.equals(that.indicativeClearingPrice) : that.indicativeClearingPrice != null)
            return false;
        if (iexSide != that.iexSide) return false;
        if (autcionBookClearingPrice != null ? !autcionBookClearingPrice.equals(that.autcionBookClearingPrice) : that.autcionBookClearingPrice != null)
            return false;
        if (collarReferencePrice != null ? !collarReferencePrice.equals(that.collarReferencePrice) : that.collarReferencePrice != null)
            return false;
        if (lowerAuctionCollar != null ? !lowerAuctionCollar.equals(that.lowerAuctionCollar) : that.lowerAuctionCollar != null)
            return false;
        return upperAuctionCollar != null ? upperAuctionCollar.equals(that.upperAuctionCollar) : that.upperAuctionCollar == null;
    }

    @Override
    public int hashCode() {
        int result = iexMessageType != null ? iexMessageType.hashCode() : 0;
        result = 31 * result + (iexAuctionType != null ? iexAuctionType.hashCode() : 0);
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        result = 31 * result + pairedShares;
        result = 31 * result + (referencePrice != null ? referencePrice.hashCode() : 0);
        result = 31 * result + (indicativeClearingPrice != null ? indicativeClearingPrice.hashCode() : 0);
        result = 31 * result + imbalanceShares;
        result = 31 * result + (iexSide != null ? iexSide.hashCode() : 0);
        result = 31 * result + (int) extensionNumber;
        result = 31 * result + eventTime;
        result = 31 * result + (autcionBookClearingPrice != null ? autcionBookClearingPrice.hashCode() : 0);
        result = 31 * result + (collarReferencePrice != null ? collarReferencePrice.hashCode() : 0);
        result = 31 * result + (lowerAuctionCollar != null ? lowerAuctionCollar.hashCode() : 0);
        result = 31 * result + (upperAuctionCollar != null ? upperAuctionCollar.hashCode() : 0);
        return result;
    }

    public static IEXMessage createIEXMessage(IEXMessageType iexMessageType, byte[] bytes) {
        IEXAuctionType iexAuctionType = IEXAuctionType.getAuctionType(bytes[1]);
        long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));
        int pairedShares = IEXByteConverter.convertBytesToInt(Arrays.copyOfRange(bytes, 18, 22));
        IEXPrice referencePrice = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 22, 30));
        IEXPrice indicativeClearingPrice = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 30, 38));
        int imbalanceShares = IEXByteConverter.convertBytesToInt(Arrays.copyOfRange(bytes, 38, 42));
        IEXSide imbalanceSide = IEXSide.getSide(bytes[42]);
        byte extensionNumber = bytes[43];
        int scheduledAuctionTime = IEXByteConverter.convertBytesToInt(Arrays.copyOfRange(bytes, 44, 48));
        IEXPrice auctionBookClearingPrice = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 48, 56));
        IEXPrice collarReferencePrice = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 56, 64));
        IEXPrice lowerAuctionCollar = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 64, 72));
        IEXPrice upperAuctionCollar = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 72, 80));
        return new IEXAuctionInformationMessage(iexMessageType, iexAuctionType, timestamp, symbol, pairedShares, referencePrice, indicativeClearingPrice,
                imbalanceShares, imbalanceSide, extensionNumber, scheduledAuctionTime, auctionBookClearingPrice, collarReferencePrice,
                lowerAuctionCollar, upperAuctionCollar);
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
                ", autcionBookClearingPrice=" + autcionBookClearingPrice +
                ", collarReferencePrice=" + collarReferencePrice +
                ", lowerAuctionCollar=" + lowerAuctionCollar +
                ", upperAuctionCollar=" + upperAuctionCollar +
                '}';
    }
}
