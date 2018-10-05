package pl.zankowski.iextrading4j.hist.api.message.trading;

import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.message.trading.field.IEXPriceType;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;

import java.util.Arrays;
import java.util.Objects;

import static pl.zankowski.iextrading4j.hist.api.IEXMessageType.OFFICIAL_PRICE_MESSAGE;

public class IEXOfficialPriceMessage extends IEXMessage {

    public static final int LENGTH = 26;

    private final IEXPriceType priceType;
    private final long timestamp;
    private final String symbol;
    private final IEXPrice officialPrice;

    private IEXOfficialPriceMessage(
            final IEXPriceType priceType,
            final long timestamp,
            final String symbol,
            final IEXPrice officialPrice) {
        super(OFFICIAL_PRICE_MESSAGE);
        this.priceType = priceType;
        this.timestamp = timestamp;
        this.symbol = symbol;
        this.officialPrice = officialPrice;
    }

    public static IEXOfficialPriceMessage createIEXMessage(final byte[] bytes) {
        final IEXPriceType priceType = IEXPriceType.getPriceType(bytes[1]);
        final long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        final String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));
        final IEXPrice price = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 18, 26));

        return new IEXOfficialPriceMessage(priceType, timestamp, symbol, price);
    }

    public IEXPriceType getPriceType() {
        return priceType;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getSymbol() {
        return symbol;
    }

    public IEXPrice getOfficialPrice() {
        return officialPrice;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        final IEXOfficialPriceMessage that = (IEXOfficialPriceMessage) o;
        return timestamp == that.timestamp &&
                priceType == that.priceType &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(officialPrice, that.officialPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), priceType, timestamp, symbol, officialPrice);
    }

    @Override
    public String toString() {
        return "IEXOfficialPriceMessage{" +
                "priceType=" + priceType +
                ", timestamp=" + timestamp +
                ", symbol='" + symbol + '\'' +
                ", officialPrice=" + officialPrice +
                "} " + super.toString();
    }
}
