package pl.zankowski.iextrading4j.hist.api.message;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.field.IEXSaleConditionFlag;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;

import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class IEXTradeMessage extends IEXMessage {

    private final IEXMessageType iexMessageType;
    private final IEXSaleConditionFlag iexSaleConditionFlag;
    private final long timestamp;
    private final String symbol;
    private final int size;
    private final IEXPrice price;
    private final long tradeID;

    public IEXTradeMessage(IEXMessageType iexMessageType, IEXSaleConditionFlag iexSaleConditionFlag, long timestamp,
                           String symbol, int size, IEXPrice price, long tradeID) {
        this.iexMessageType = iexMessageType;
        this.iexSaleConditionFlag = iexSaleConditionFlag;
        this.timestamp = timestamp;
        this.symbol = symbol;
        this.size = size;
        this.price = price;
        this.tradeID = tradeID;
    }

    public static IEXTradeMessage createIEXMessage(IEXMessageType messageType, byte[] bytes) {
        IEXSaleConditionFlag iexSaleConditionFlag = IEXSaleConditionFlag.getSaleConditionFlag(bytes[1]);
        long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));
        int size = IEXByteConverter.convertBytesToInt(Arrays.copyOfRange(bytes, 18, 22));
        IEXPrice price = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 22, 30));
        long tradeID = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 30, 38));

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
        if (!(o instanceof IEXTradeMessage)) return false;

        IEXTradeMessage that = (IEXTradeMessage) o;

        if (timestamp != that.timestamp) return false;
        if (size != that.size) return false;
        if (tradeID != that.tradeID) return false;
        if (iexMessageType != that.iexMessageType) return false;
        if (iexSaleConditionFlag != that.iexSaleConditionFlag) return false;
        if (symbol != null ? !symbol.equals(that.symbol) : that.symbol != null) return false;
        return price != null ? price.equals(that.price) : that.price == null;
    }

    @Override
    public int hashCode() {
        int result = iexMessageType != null ? iexMessageType.hashCode() : 0;
        result = 31 * result + (iexSaleConditionFlag != null ? iexSaleConditionFlag.hashCode() : 0);
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        result = 31 * result + size;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (int) (tradeID ^ (tradeID >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "pl.zankowski.iextrading4j.hist.api.message.IEXTradeMessage{" +
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
