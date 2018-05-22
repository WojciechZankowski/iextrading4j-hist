package pl.zankowski.iextrading4j.hist.api.message.administrative.builder;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.administrative.IEXOperationalHaltStatusMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXOperationalHaltStatus;
import pl.zankowski.iextrading4j.hist.api.message.builder.TestDataBuilder;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

public class IEXOperationalHaltStatusMessageDataBuilder implements TestDataBuilder {

    private IEXOperationalHaltStatus operationalHaltStatus = IEXOperationalHaltStatus.NOT_OPERATIONAL_HALTED;
    private long timestamp = 1494855059287436131L;
    private String symbol = "SNAP    ";

    public static IEXOperationalHaltStatusMessage defaultHaltStatusMessage() {
        return haltStatusMessage().build();
    }

    public static byte[] haltStatusBytes() {
        return haltStatusMessage().getBytes();
    }

    public static IEXOperationalHaltStatusMessageDataBuilder haltStatusMessage() {
        return new IEXOperationalHaltStatusMessageDataBuilder();
    }

    @Override
    public byte[] getBytes() {
        return IEXByteTestUtil.prepareBytes(18, IEXMessageType.OPERATIONAL_HALT_STATUS,
                operationalHaltStatus, timestamp, symbol);
    }

    public IEXOperationalHaltStatusMessage build() {
        return IEXOperationalHaltStatusMessage.createIEXMessage(getBytes());
    }

}
