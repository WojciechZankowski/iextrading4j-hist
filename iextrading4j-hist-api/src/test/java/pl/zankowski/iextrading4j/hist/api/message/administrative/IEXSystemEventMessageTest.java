package pl.zankowski.iextrading4j.hist.api.message.administrative;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXSystemEvent;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.api.message.administrative.builder.IEXSystemEventMessageDataBuilder.defaultSystemEventMessage;

public class IEXSystemEventMessageTest {

    @Test
    public void constructor() {
        final IEXSystemEvent systemEvent = IEXSystemEvent.MESSAGES_START;
        final long timestamp = 1494855059287436131L;

        final byte[] bytes = IEXByteTestUtil.prepareBytes(IEXSystemEventMessage.LENGTH, IEXMessageType.SYSTEM_EVENT,
                systemEvent, timestamp);
        final IEXSystemEventMessage message = IEXSystemEventMessage.createIEXMessage(bytes);

        assertThat(message.getMessageType()).isEqualTo(IEXMessageType.SYSTEM_EVENT);
        assertThat(message.getSystemEvent()).isEqualTo(systemEvent);
        assertThat(message.getTimestamp()).isEqualTo(timestamp);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IEXSystemEventMessage.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(defaultSystemEventMessage())
                .verify();
    }

}
