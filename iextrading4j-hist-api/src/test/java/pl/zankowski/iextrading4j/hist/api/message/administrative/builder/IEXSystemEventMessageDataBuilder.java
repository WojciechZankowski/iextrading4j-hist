package pl.zankowski.iextrading4j.hist.api.message.administrative.builder;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.administrative.IEXSystemEventMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXSystemEvent;
import pl.zankowski.iextrading4j.hist.api.message.builder.TestDataBuilder;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

public class IEXSystemEventMessageDataBuilder implements TestDataBuilder {

    private IEXSystemEvent systemEvent = IEXSystemEvent.MESSAGES_START;
    private long timestamp = 1494855059287436131L;

    public static IEXSystemEventMessage defaultSystemEventMessage() {
        return systemEventMessage().build();
    }

    public static IEXSystemEventMessageDataBuilder systemEventMessage() {
        return new IEXSystemEventMessageDataBuilder();
    }

    public IEXSystemEventMessageDataBuilder withSystemEvent(final IEXSystemEvent systemEvent) {
        this.systemEvent = systemEvent;
        return this;
    }

    public IEXSystemEventMessageDataBuilder withTimestamp(final long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    @Override
    public byte[] getBytes() {
        return IEXByteTestUtil.prepareBytes(IEXSystemEventMessage.LENGTH, IEXMessageType.SYSTEM_EVENT, systemEvent,
                timestamp);
    }

    public IEXSystemEventMessage build() {
        return IEXSystemEventMessage.createIEXMessage(getBytes());
    }
}
