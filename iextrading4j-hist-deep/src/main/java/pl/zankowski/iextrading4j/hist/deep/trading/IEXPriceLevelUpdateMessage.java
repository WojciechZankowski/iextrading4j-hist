package pl.zankowski.iextrading4j.hist.deep.trading;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;
import pl.zankowski.iextrading4j.hist.deep.trading.field.IEXEventFlag;

import java.util.Arrays;
import java.util.Objects;

public class IEXPriceLevelUpdateMessage extends IEXMessage {

    private final IEXEventFlag eventFlag;
    private final long timestamp;
    private final String symbol;
    private final int size;
    private final IEXPrice price;

    private IEXPriceLevelUpdateMessage(
            final IEXMessageType messageType,
            final IEXEventFlag eventFlag,
            final long timestamp,
            final String symbol,
            final int size,
            final IEXPrice price) {
        super(messageType);
        this.eventFlag = eventFlag;
        this.timestamp = timestamp;
        this.symbol = symbol;
        this.size = size;
        this.price = price;
    }

    public static IEXMessage createIEXMessage(final IEXMessageType messageType, final byte[] bytes) {
        final IEXEventFlag eventFlag = IEXEventFlag.getEventFlag(bytes[1]);
        final long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        final String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));
        final int size = IEXByteConverter.convertBytesToInt(Arrays.copyOfRange(bytes, 18, 22));
        final IEXPrice price = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 22, 30));

        return new IEXPriceLevelUpdateMessage(messageType, eventFlag, timestamp, symbol, size, price);
    }

    public IEXEventFlag getEventFlag() {
        return eventFlag;
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        final IEXPriceLevelUpdateMessage that = (IEXPriceLevelUpdateMessage) o;
        return timestamp == that.timestamp &&
                size == that.size &&
                eventFlag == that.eventFlag &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), eventFlag, timestamp, symbol, size, price);
    }

    @Override
    public String toString() {
        return "IEXPriceLevelUpdateMessage{" +
                "eventFlag=" + eventFlag +
                ", timestamp=" + timestamp +
                ", symbol='" + symbol + '\'' +
                ", size=" + size +
                ", price=" + price +
                "} " + super.toString();
    }
}
