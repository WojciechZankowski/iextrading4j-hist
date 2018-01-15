package pl.zankowski.iextrading4j.hist.api.message.administrative;

import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXOperationalHaltStatus;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;

import java.util.Arrays;
import java.util.Objects;

import static pl.zankowski.iextrading4j.hist.api.IEXMessageType.OPERATIONAL_HALT_STATUS;

public class IEXOperationalHaltStatusMessage extends IEXMessage {

    private final IEXOperationalHaltStatus operationalHaltStatus;
    private final long timestamp;
    private final String symbol;

    private IEXOperationalHaltStatusMessage(
            final IEXOperationalHaltStatus operationalHaltStatus,
            final long timestamp,
            final String symbol) {
        super(OPERATIONAL_HALT_STATUS);
        this.operationalHaltStatus = operationalHaltStatus;
        this.timestamp = timestamp;
        this.symbol = symbol;
    }

    public static IEXOperationalHaltStatusMessage createIEXMessage(final byte[] bytes) {
        final IEXOperationalHaltStatus operationalHaltStatus = IEXOperationalHaltStatus.getOperationalHaltStatus(bytes[1]);
        final long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        final String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));

        return new IEXOperationalHaltStatusMessage(operationalHaltStatus, timestamp, symbol);
    }

    public IEXOperationalHaltStatus getOperationalHaltStatus() {
        return operationalHaltStatus;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        final IEXOperationalHaltStatusMessage that = (IEXOperationalHaltStatusMessage) o;
        return timestamp == that.timestamp &&
                operationalHaltStatus == that.operationalHaltStatus &&
                Objects.equals(symbol, that.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), operationalHaltStatus, timestamp, symbol);
    }

    @Override
    public String toString() {
        return "IEXOperationalHaltStatusMessage{" +
                "operationalHaltStatus=" + operationalHaltStatus +
                ", timestamp=" + timestamp +
                ", symbol='" + symbol + '\'' +
                "} " + super.toString();
    }
}
