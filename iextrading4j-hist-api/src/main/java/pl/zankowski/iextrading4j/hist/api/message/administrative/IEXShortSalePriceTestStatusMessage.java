package pl.zankowski.iextrading4j.hist.api.message.administrative;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXDetail;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXShortSalePriceTestStatus;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;

import java.util.Arrays;
import java.util.Objects;

public class IEXShortSalePriceTestStatusMessage extends IEXMessage {

    private final IEXShortSalePriceTestStatus shortSalePriceTestStatus;
    private final long timestamp;
    private final String symbol;
    private final IEXDetail detail;

    private IEXShortSalePriceTestStatusMessage(
            final IEXMessageType messageType,
            final IEXShortSalePriceTestStatus shortSalePriceTestStatus,
            final long timestamp,
            final String symbol,
            final IEXDetail detail) {
        super(messageType);
        this.shortSalePriceTestStatus = shortSalePriceTestStatus;
        this.timestamp = timestamp;
        this.symbol = symbol;
        this.detail = detail;
    }

    public static IEXMessage createIEXMessage(final IEXMessageType messageType, final byte[] bytes) {
        final IEXShortSalePriceTestStatus shortSalePriceTestStatus = IEXShortSalePriceTestStatus.getShortSalePriceTestStatus(bytes[1]);
        final long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        final String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));
        final IEXDetail detail = IEXDetail.getDetail(bytes[18]);

        return new IEXShortSalePriceTestStatusMessage(messageType, shortSalePriceTestStatus, timestamp, symbol, detail);
    }

    public IEXShortSalePriceTestStatus getShortSalePriceTestStatus() {
        return shortSalePriceTestStatus;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getSymbol() {
        return symbol;
    }

    public IEXDetail getDetail() {
        return detail;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        final IEXShortSalePriceTestStatusMessage that = (IEXShortSalePriceTestStatusMessage) o;
        return timestamp == that.timestamp &&
                shortSalePriceTestStatus == that.shortSalePriceTestStatus &&
                Objects.equals(symbol, that.symbol) &&
                detail == that.detail;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shortSalePriceTestStatus, timestamp, symbol, detail);
    }

    @Override
    public String toString() {
        return "IEXShortSalePriceTestStatusMessage{" +
                "shortSalePriceTestStatus=" + shortSalePriceTestStatus +
                ", timestamp=" + timestamp +
                ", symbol='" + symbol + '\'' +
                ", detail=" + detail +
                "} " + super.toString();
    }
}
