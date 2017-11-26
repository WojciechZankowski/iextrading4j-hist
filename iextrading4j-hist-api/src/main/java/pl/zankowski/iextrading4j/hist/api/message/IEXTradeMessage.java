package pl.zankowski.iextrading4j.hist.api.message;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.field.IEXSaleConditionFlag;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;

import java.util.Arrays;
import java.util.Objects;

public class IEXTradeMessage extends IEXMessage {

    private final IEXMessageType iexMessageType;
    private final IEXSaleConditionFlag iexSaleConditionFlag;
    private final long timestamp;
    private final String symbol;
    private final int size;
    private final IEXPrice price;
    private final long tradeID;

    public IEXTradeMessage(
            final IEXMessageType iexMessageType,
            final IEXSaleConditionFlag iexSaleConditionFlag,
            final long timestamp,
            final String symbol,
            final int size,
            final IEXPrice price,
            final long tradeID) {
        this.iexMessageType = iexMessageType;
        this.iexSaleConditionFlag = iexSaleConditionFlag;
        this.timestamp = timestamp;
        this.symbol = symbol;
        this.size = size;
        this.price = price;
        this.tradeID = tradeID;
    }

    public static IEXTradeMessage createIEXMessage(final IEXMessageType messageType, final byte[] bytes) {
        final IEXSaleConditionFlag iexSaleConditionFlag = IEXSaleConditionFlag.getSaleConditionFlag(bytes[1]);
        final long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        final String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));
        final int size = IEXByteConverter.convertBytesToInt(Arrays.copyOfRange(bytes, 18, 22));
        final IEXPrice price = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 22, 30));
        final long tradeID = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 30, 38));

        return new IEXTradeMessage(messageType, iexSaleConditionFlag, timestamp, symbol, size, price, tradeID);
    }

    public IEXMessageType getIexMessageType() {
        return iexMessageType;
    }

    public IEXSaleConditionFlag getIexSaleConditionFlag() {
        return iexSaleConditionFlag;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getSize() {
        return size;
    }

    public IEXPrice getPrice() {
        return price;
    }

    public long getTradeID() {
        return tradeID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IEXTradeMessage that = (IEXTradeMessage) o;
        return timestamp == that.timestamp &&
                size == that.size &&
                tradeID == that.tradeID &&
                iexMessageType == that.iexMessageType &&
                iexSaleConditionFlag == that.iexSaleConditionFlag &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iexMessageType, iexSaleConditionFlag, timestamp, symbol, size, price, tradeID);
    }

    @Override
    public String toString() {
        return "IEXTradeMessage{" +
                "iexMessageType=" + iexMessageType +
                ", iexSaleConditionFlag=" + iexSaleConditionFlag +
                ", timestamp=" + timestamp +
                ", symbol='" + symbol + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", tradeID=" + tradeID +
                '}';
    }
}
