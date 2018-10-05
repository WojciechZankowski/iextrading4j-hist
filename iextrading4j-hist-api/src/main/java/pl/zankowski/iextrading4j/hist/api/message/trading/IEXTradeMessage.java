package pl.zankowski.iextrading4j.hist.api.message.trading;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.exception.IEXMessageException;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;

import java.util.Arrays;
import java.util.Objects;

public class IEXTradeMessage extends IEXMessage {

    public static final int TOPS15_LENGTH = 42;
    public static final int TOPS16_LENGTH = 38;

    private final byte saleConditionFlag;
    private final long timestamp;
    private final String symbol;
    private final int size;
    private final IEXPrice price;
    private final long tradeID;

    private IEXTradeMessage(
            final IEXMessageType messageType,
            final byte saleConditionFlag,
            final long timestamp,
            final String symbol,
            final int size,
            final IEXPrice price,
            final long tradeID) {
        super(messageType);
        this.saleConditionFlag = saleConditionFlag;
        this.timestamp = timestamp;
        this.symbol = symbol;
        this.size = size;
        this.price = price;
        this.tradeID = tradeID;
    }

    public static IEXTradeMessage createIEXMessage(final IEXMessageType messageType, final byte[] bytes) {
        final byte saleConditionFlag = bytes[1];
        final long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        final String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));
        final int size = IEXByteConverter.convertBytesToInt(Arrays.copyOfRange(bytes, 18, 22));
        final IEXPrice price = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 22, 30));
        final long tradeID = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 30, 38));

        return new IEXTradeMessage(messageType, saleConditionFlag, timestamp, symbol, size, price, tradeID);
    }

    public boolean isISO() {
        return (saleConditionFlag & 0x80) != 0;
    }

    public boolean isExtendedHoursTrade() {
        return (saleConditionFlag & 0x40) != 0;
    }

    public boolean isOddLotTrade() {
        return (saleConditionFlag & 0x20) != 0;
    }

    public boolean isNotTradeThrough() {
        return (saleConditionFlag & 0x10) != 0;
    }

    public boolean isSinglePriceCrossTrade() {
        return (saleConditionFlag & 0x08) != 0;
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
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        final IEXTradeMessage that = (IEXTradeMessage) o;
        return timestamp == that.timestamp &&
                size == that.size &&
                tradeID == that.tradeID &&
                saleConditionFlag == that.saleConditionFlag &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), saleConditionFlag, timestamp, symbol, size, price, tradeID);
    }

    @Override
    public String toString() {
        return "IEXTradeMessage{" +
                "saleConditionFlag=" + saleConditionFlag +
                ", timestamp=" + timestamp +
                ", symbol='" + symbol + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", tradeID=" + tradeID +
                "} " + super.toString();
    }
}
