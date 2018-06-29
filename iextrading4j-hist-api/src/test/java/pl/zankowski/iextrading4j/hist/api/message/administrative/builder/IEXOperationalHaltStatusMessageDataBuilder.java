package pl.zankowski.iextrading4j.hist.api.message.administrative.builder;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.administrative.IEXOperationalHaltStatusMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXOperationalHaltStatus;
import pl.zankowski.iextrading4j.hist.api.message.builder.TestDataBuilder;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

public class IEXOperationalHaltStatusMessageDataBuilder implements TestDataBuilder {

    private IEXOperationalHaltStatus status = IEXOperationalHaltStatus.NOT_OPERATIONAL_HALTED;
    private long timestamp = 1494855059287436131L;
    private String symbol = "SNAP";

    public static IEXOperationalHaltStatusMessage defaultHaltStatusMessage() {
        return haltStatusMessage().build();
    }

    public static IEXOperationalHaltStatusMessageDataBuilder haltStatusMessage() {
        return new IEXOperationalHaltStatusMessageDataBuilder();
    }

    public IEXOperationalHaltStatusMessageDataBuilder withStatus(final IEXOperationalHaltStatus status) {
        this.status = status;
        return this;
    }

    public IEXOperationalHaltStatusMessageDataBuilder withTimestamp(final long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public IEXOperationalHaltStatusMessageDataBuilder withSymbol(final String symbol) {
        this.symbol = symbol;
        return this;
    }

    @Override
    public byte[] getBytes() {
        return IEXByteTestUtil.prepareBytes(IEXOperationalHaltStatusMessage.LENGTH, IEXMessageType.OPERATIONAL_HALT_STATUS,
                status, timestamp, symbol);
    }

    public IEXOperationalHaltStatusMessage build() {
        return IEXOperationalHaltStatusMessage.createIEXMessage(getBytes());
    }

}
