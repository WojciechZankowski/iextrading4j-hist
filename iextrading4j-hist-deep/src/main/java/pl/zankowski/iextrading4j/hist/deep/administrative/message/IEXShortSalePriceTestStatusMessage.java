package pl.zankowski.iextrading4j.hist.deep.administrative.message;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;
import pl.zankowski.iextrading4j.hist.deep.administrative.field.IEXDetail;
import pl.zankowski.iextrading4j.hist.deep.administrative.field.IEXShortSalePriceTestStatus;

import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class IEXShortSalePriceTestStatusMessage extends IEXMessage {

    private final IEXMessageType iexMessageType;
    private final IEXShortSalePriceTestStatus iexShortSalePriceTestStatus;
    private final long timestamp;
    private final String symbol;
    private final IEXDetail iexDetail;

    public IEXShortSalePriceTestStatusMessage(IEXMessageType iexMessageType, IEXShortSalePriceTestStatus iexShortSalePriceTestStatus, long timestamp, String symbol, IEXDetail iexDetail) {
        this.iexMessageType = iexMessageType;
        this.iexShortSalePriceTestStatus = iexShortSalePriceTestStatus;
        this.timestamp = timestamp;
        this.symbol = symbol;
        this.iexDetail = iexDetail;
    }

    public static IEXMessage createIEXMessage(IEXMessageType iexMessageType, byte[] bytes) {
        IEXShortSalePriceTestStatus iexShortSalePriceTestStatus = IEXShortSalePriceTestStatus.getShortSalePriceTestStatus(bytes[1]);
        long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));
        IEXDetail iexDetail = IEXDetail.getDetail(bytes[18]);
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
        if (!(o instanceof IEXShortSalePriceTestStatusMessage)) return false;

        IEXShortSalePriceTestStatusMessage that = (IEXShortSalePriceTestStatusMessage) o;

        if (timestamp != that.timestamp) return false;
        if (iexMessageType != that.iexMessageType) return false;
        if (iexShortSalePriceTestStatus != that.iexShortSalePriceTestStatus) return false;
        if (symbol != null ? !symbol.equals(that.symbol) : that.symbol != null) return false;
        return iexDetail == that.iexDetail;
    }

    @Override
    public int hashCode() {
        int result = iexMessageType != null ? iexMessageType.hashCode() : 0;
        result = 31 * result + (iexShortSalePriceTestStatus != null ? iexShortSalePriceTestStatus.hashCode() : 0);
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        result = 31 * result + (iexDetail != null ? iexDetail.hashCode() : 0);
        return result;
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
