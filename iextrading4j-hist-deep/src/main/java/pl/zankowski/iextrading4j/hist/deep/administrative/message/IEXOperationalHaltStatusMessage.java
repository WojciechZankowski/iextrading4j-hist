package pl.zankowski.iextrading4j.hist.deep.administrative.message;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;
import pl.zankowski.iextrading4j.hist.deep.administrative.field.IEXOperationalHaltStatus;

import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class IEXOperationalHaltStatusMessage extends IEXMessage {

    private final IEXMessageType iexMessageType;
    private final IEXOperationalHaltStatus iexOperationalHaltStatus;
    private final long timestamp;
    private final String symbol;

    public IEXOperationalHaltStatusMessage(IEXMessageType iexMessageType, IEXOperationalHaltStatus iexOperationalHaltStatus, long timestamp, String symbol) {
        this.iexMessageType = iexMessageType;
        this.iexOperationalHaltStatus = iexOperationalHaltStatus;
        this.timestamp = timestamp;
        this.symbol = symbol;
    }

    public static IEXMessage createIEXMessage(IEXMessageType iexMessageType, byte[] bytes) {
        IEXOperationalHaltStatus iexOperationalHaltStatus = IEXOperationalHaltStatus.getOperationalHaltStatus(bytes[1]);
        long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));
        return new IEXOperationalHaltStatusMessage(iexMessageType, iexOperationalHaltStatus, timestamp, symbol);
    }

    public IEXMessageType getIexMessageType() {
        return iexMessageType;
    }

    public IEXOperationalHaltStatus getIexOperationalHaltStatus() {
        return iexOperationalHaltStatus;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IEXOperationalHaltStatusMessage)) return false;

        IEXOperationalHaltStatusMessage that = (IEXOperationalHaltStatusMessage) o;

        if (timestamp != that.timestamp) return false;
        if (iexMessageType != that.iexMessageType) return false;
        if (iexOperationalHaltStatus != that.iexOperationalHaltStatus) return false;
        return symbol != null ? symbol.equals(that.symbol) : that.symbol == null;
    }

    @Override
    public int hashCode() {
        int result = iexMessageType != null ? iexMessageType.hashCode() : 0;
        result = 31 * result + (iexOperationalHaltStatus != null ? iexOperationalHaltStatus.hashCode() : 0);
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "IEXOperationalHaltStatusMessage{" +
                "iexMessageType=" + iexMessageType +
                ", iexOperationalHaltStatus=" + iexOperationalHaltStatus +
                ", timestamp=" + timestamp +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
