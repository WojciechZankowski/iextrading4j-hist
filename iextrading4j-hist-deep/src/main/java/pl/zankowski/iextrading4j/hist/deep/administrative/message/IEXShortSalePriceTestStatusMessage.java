package pl.zankowski.iextrading4j.hist.deep.administrative.message;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;
import pl.zankowski.iextrading4j.hist.deep.administrative.field.IEXDetail;
import pl.zankowski.iextrading4j.hist.deep.administrative.field.IEXShortSalePriceTestStatus;

import java.util.Arrays;
import java.util.Objects;

public class IEXShortSalePriceTestStatusMessage extends IEXMessage {

    private final IEXMessageType iexMessageType;
    private final IEXShortSalePriceTestStatus iexShortSalePriceTestStatus;
    private final long timestamp;
    private final String symbol;
    private final IEXDetail iexDetail;

    public IEXShortSalePriceTestStatusMessage(
            final IEXMessageType iexMessageType,
            final IEXShortSalePriceTestStatus iexShortSalePriceTestStatus,
            final long timestamp,
            final String symbol,
            final IEXDetail iexDetail) {
        this.iexMessageType = iexMessageType;
        this.iexShortSalePriceTestStatus = iexShortSalePriceTestStatus;
        this.timestamp = timestamp;
        this.symbol = symbol;
        this.iexDetail = iexDetail;
    }

    public static IEXMessage createIEXMessage(final IEXMessageType iexMessageType, final byte[] bytes) {
        final IEXShortSalePriceTestStatus iexShortSalePriceTestStatus = IEXShortSalePriceTestStatus.getShortSalePriceTestStatus(bytes[1]);
        final long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        final String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));
        final IEXDetail iexDetail = IEXDetail.getDetail(bytes[18]);

        return new IEXShortSalePriceTestStatusMessage(iexMessageType, iexShortSalePriceTestStatus, timestamp, symbol, iexDetail);
    }

    public IEXMessageType getIexMessageType() {
        return iexMessageType;
    }

    public IEXShortSalePriceTestStatus getIexShortSalePriceTestStatus() {
        return iexShortSalePriceTestStatus;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getSymbol() {
        return symbol;
    }

    public IEXDetail getIexDetail() {
        return iexDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IEXShortSalePriceTestStatusMessage that = (IEXShortSalePriceTestStatusMessage) o;
        return timestamp == that.timestamp &&
                iexMessageType == that.iexMessageType &&
                iexShortSalePriceTestStatus == that.iexShortSalePriceTestStatus &&
                Objects.equals(symbol, that.symbol) &&
                iexDetail == that.iexDetail;
    }

    @Override
    public int hashCode() {
        return Objects.hash(iexMessageType, iexShortSalePriceTestStatus, timestamp, symbol, iexDetail);
    }

    @Override
    public String toString() {
        return "IEXShortSalePriceTestStatusMessage{" +
                "iexMessageType=" + iexMessageType +
                ", iexShortSalePriceTestStatus=" + iexShortSalePriceTestStatus +
                ", timestamp=" + timestamp +
                ", symbol='" + symbol + '\'' +
                ", iexDetail=" + iexDetail +
                '}';
    }
}
