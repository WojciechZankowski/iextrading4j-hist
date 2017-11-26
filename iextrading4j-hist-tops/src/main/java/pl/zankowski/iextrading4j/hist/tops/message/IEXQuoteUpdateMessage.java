package pl.zankowski.iextrading4j.hist.tops.message;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;
import pl.zankowski.iextrading4j.hist.tops.field.IEXMessageFlag;

import java.util.Arrays;
import java.util.Objects;

public class IEXQuoteUpdateMessage extends IEXMessage {

    private final IEXMessageType messageType;
    private final IEXMessageFlag messageFlag;
    private final long timestamp;
    private final String symbol;
    private final int bidSize;
    private final IEXPrice bidPrice;
    private final IEXPrice askPrice;
    private final int askSize;

    private IEXQuoteUpdateMessage(
            final IEXMessageType messageType,
            final IEXMessageFlag messageFlag,
            final long timestamp,
            final String symbol,
            final int bidSize,
            final IEXPrice bidPrice,
            final IEXPrice askPrice,
            final int askSize) {
        this.messageType = messageType;
        this.messageFlag = messageFlag;
        this.timestamp = timestamp;
        this.symbol = symbol;
        this.bidSize = bidSize;
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
        this.askSize = askSize;
    }

    public static IEXQuoteUpdateMessage createIEXMessage(final IEXMessageType messageType, final byte[] bytes) {
        final IEXMessageFlag messageFlag = IEXMessageFlag.getMessageFromFlag(bytes[1]);
        final long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        final String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));
        final int bidSize = IEXByteConverter.convertBytesToInt(Arrays.copyOfRange(bytes, 18, 22));
        final IEXPrice bidPrice = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 22, 30));
        final IEXPrice askPrice = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 30, 38));
        final int askSize = IEXByteConverter.convertBytesToInt(Arrays.copyOfRange(bytes, 38, 42));

        return new IEXQuoteUpdateMessage(messageType, messageFlag, timestamp, symbol, bidSize, bidPrice,
                askPrice, askSize);
    }

    public IEXMessageType getMessageType() {
        return messageType;
    }

    public IEXMessageFlag getMessageFlag() {
        return messageFlag;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getBidSize() {
        return bidSize;
    }

    public IEXPrice getBidPrice() {
        return bidPrice;
    }

    public IEXPrice getAskPrice() {
        return askPrice;
    }

    public int getAskSize() {
        return askSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IEXQuoteUpdateMessage that = (IEXQuoteUpdateMessage) o;
        return timestamp == that.timestamp &&
                bidSize == that.bidSize &&
                askSize == that.askSize &&
                messageType == that.messageType &&
                messageFlag == that.messageFlag &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(bidPrice, that.bidPrice) &&
                Objects.equals(askPrice, that.askPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageType, messageFlag, timestamp, symbol, bidSize,
                bidPrice, askPrice, askSize);
    }

    @Override
    public String toString() {
        return "IEXQuoteUpdateMessage{" +
                "messageType=" + messageType +
                ", messageFlag=" + messageFlag +
                ", timestamp=" + timestamp +
                ", symbol='" + symbol + '\'' +
                ", bidSize=" + bidSize +
                ", bidPrice=" + bidPrice +
                ", askPrice=" + askPrice +
                ", askSize=" + askSize +
                '}';
    }
}
