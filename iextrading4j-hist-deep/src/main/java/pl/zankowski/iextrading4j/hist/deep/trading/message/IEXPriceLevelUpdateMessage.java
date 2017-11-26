package pl.zankowski.iextrading4j.hist.deep.trading.message;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;
import pl.zankowski.iextrading4j.hist.deep.trading.field.IEXEventFlag;

import java.util.Arrays;
import java.util.Objects;

public class IEXPriceLevelUpdateMessage extends IEXMessage {

    private final IEXMessageType iexMessageType;
    private final IEXEventFlag iexEventFlag;
    private final long timestamp;
    private final String symbol;
    private final int size;
    private final IEXPrice iexPrice;

    public IEXPriceLevelUpdateMessage(
            final IEXMessageType iexMessageType,
            final IEXEventFlag iexEventFlag,
            final long timestamp,
            final String symbol,
            final int size,
            final IEXPrice iexPrice) {
        this.iexMessageType = iexMessageType;
        this.iexEventFlag = iexEventFlag;
        this.timestamp = timestamp;
        this.symbol = symbol;
        this.size = size;
        this.iexPrice = iexPrice;
    }

    public static IEXMessage createIEXMessage(final IEXMessageType iexMessageType, final byte[] bytes) {
        final IEXEventFlag iexEventFlag = IEXEventFlag.getEventFlag(bytes[1]);
        final long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        final String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));
        final int size = IEXByteConverter.convertBytesToInt(Arrays.copyOfRange(bytes, 18, 22));
        final IEXPrice iexPrice = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 22, 30));
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
        if (o == null || getClass() != o.getClass()) return false;
        IEXPriceLevelUpdateMessage that = (IEXPriceLevelUpdateMessage) o;
        return timestamp == that.timestamp &&
                size == that.size &&
                iexMessageType == that.iexMessageType &&
                iexEventFlag == that.iexEventFlag &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(iexPrice, that.iexPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iexMessageType, iexEventFlag, timestamp, symbol, size, iexPrice);
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
