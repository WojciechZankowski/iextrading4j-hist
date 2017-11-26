package pl.zankowski.iextrading4j.hist.deep.administrative.message;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;
import pl.zankowski.iextrading4j.hist.deep.administrative.field.IEXOperationalHaltStatus;

import java.util.Arrays;
import java.util.Objects;

public class IEXOperationalHaltStatusMessage extends IEXMessage {

    private final IEXMessageType iexMessageType;
    private final IEXOperationalHaltStatus iexOperationalHaltStatus;
    private final long timestamp;
    private final String symbol;

    public IEXOperationalHaltStatusMessage(
            final IEXMessageType iexMessageType,
            final IEXOperationalHaltStatus iexOperationalHaltStatus,
            final long timestamp,
            final String symbol) {
        this.iexMessageType = iexMessageType;
        this.iexOperationalHaltStatus = iexOperationalHaltStatus;
        this.timestamp = timestamp;
        this.symbol = symbol;
    }

    public static IEXMessage createIEXMessage(IEXMessageType iexMessageType, byte[] bytes) {
        final IEXOperationalHaltStatus iexOperationalHaltStatus = IEXOperationalHaltStatus.getOperationalHaltStatus(bytes[1]);
        final long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        final String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));
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
        if (o == null || getClass() != o.getClass()) return false;
        IEXOperationalHaltStatusMessage that = (IEXOperationalHaltStatusMessage) o;
        return timestamp == that.timestamp &&
                iexMessageType == that.iexMessageType &&
                iexOperationalHaltStatus == that.iexOperationalHaltStatus &&
                Objects.equals(symbol, that.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iexMessageType, iexOperationalHaltStatus, timestamp, symbol);
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
