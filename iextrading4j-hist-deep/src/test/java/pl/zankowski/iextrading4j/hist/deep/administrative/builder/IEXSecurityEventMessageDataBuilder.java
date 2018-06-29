package pl.zankowski.iextrading4j.hist.deep.administrative.builder;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.builder.TestDataBuilder;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;
import pl.zankowski.iextrading4j.hist.deep.administrative.IEXSecurityEventMessage;
import pl.zankowski.iextrading4j.hist.deep.administrative.field.IEXSecurityEvent;

public class IEXSecurityEventMessageDataBuilder implements TestDataBuilder {

    private IEXSecurityEvent securityEvent = IEXSecurityEvent.OPENING_PROCESS_COMPLETE;
    private long timestamp = 1494855059287436131L;
    private String symbol = "SNAP";

    public static IEXSecurityEventMessage defaultSecurityEventMessage() {
        return securityEventMessage().build();
    }

    public static IEXSecurityEventMessageDataBuilder securityEventMessage() {
        return new IEXSecurityEventMessageDataBuilder();
    }

    public IEXSecurityEventMessageDataBuilder withSecurityEvent(final IEXSecurityEvent securityEvent) {
        this.securityEvent = securityEvent;
        return this;
    }

    public IEXSecurityEventMessageDataBuilder withTimestamp(final long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public IEXSecurityEventMessageDataBuilder withSymbol(final String symbol) {
        this.symbol = symbol;
        return this;
    }

    @Override
    public byte[] getBytes() {
        return IEXByteTestUtil.prepareBytes(IEXSecurityEventMessage.LENGTH, IEXMessageType.SECURITY_EVENT,
                securityEvent, timestamp, symbol);
    }

    public IEXSecurityEventMessage build() {
        return IEXSecurityEventMessage.createIEXMessage(getBytes());
    }
}
