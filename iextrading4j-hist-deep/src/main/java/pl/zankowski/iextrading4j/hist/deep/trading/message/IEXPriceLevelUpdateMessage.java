package pl.zankowski.iextrading4j.hist.deep.trading.message;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;
import pl.zankowski.iextrading4j.hist.deep.trading.field.IEXEventFlag;

import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class IEXPriceLevelUpdateMessage extends IEXMessage {

    private final IEXMessageType iexMessageType;
    private final IEXEventFlag iexEventFlag;
    private final long timestamp;
    private final String symbol;
    private final int size;
    private final IEXPrice iexPrice;

    public IEXPriceLevelUpdateMessage(IEXMessageType iexMessageType, IEXEventFlag iexEventFlag, long timestamp, String symbol, int size, IEXPrice iexPrice) {
        this.iexMessageType = iexMessageType;
        this.iexEventFlag = iexEventFlag;
        this.timestamp = timestamp;
        this.symbol = symbol;
        this.size = size;
        this.iexPrice = iexPrice;
    }

    public static IEXMessage createIEXMessage(IEXMessageType iexMessageType, byte[] bytes) {
        IEXEventFlag iexEventFlag = IEXEventFlag.getEventFlag(bytes[1]);
        long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));
        int size = IEXByteConverter.convertBytesToInt(Arrays.copyOfRange(bytes, 18, 22));
        IEXPrice iexPrice = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 22, 30));
        return new IEXPriceLevelUpdateMessage(iexMessageType, iexEventFlag, timestamp, symbol, size, iexPrice);
    }

    public IEXMessageType getIexMessageType() {
        return iexMessageType;
    }

    public IEXEventFlag getIexEventFlag() {
        return iexEventFlag;
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

    public IEXPrice getIexPrice() {
        return iexPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IEXPriceLevelUpdateMessage)) return false;

        IEXPriceLevelUpdateMessage that = (IEXPriceLevelUpdateMessage) o;

        if (timestamp != that.timestamp) return false;
        if (size != that.size) return false;
        if (iexMessageType != that.iexMessageType) return false;
        if (iexEventFlag != that.iexEventFlag) return false;
        if (symbol != null ? !symbol.equals(that.symbol) : that.symbol != null) return false;
        return iexPrice != null ? iexPrice.equals(that.iexPrice) : that.iexPrice == null;
    }

    @Override
    public int hashCode() {
        int result = iexMessageType != null ? iexMessageType.hashCode() : 0;
        result = 31 * result + (iexEventFlag != null ? iexEventFlag.hashCode() : 0);
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        result = 31 * result + size;
        result = 31 * result + (iexPrice != null ? iexPrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "IEXPriceLevelUpdateMessage{" +
                "iexMessageType=" + iexMessageType +
                ", iexEventFlag=" + iexEventFlag +
                ", timestamp=" + timestamp +
                ", symbol='" + symbol + '\'' +
                ", size=" + size +
                ", iexPrice=" + iexPrice +
                '}';
    }
}
