package pl.zankowski.iextrading4j.hist.deep.administrative;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;
import pl.zankowski.iextrading4j.hist.deep.administrative.field.IEXSecurityEvent;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.deep.administrative.builder.IEXSecurityEventMessageDataBuilder.defaultSecurityEventMessage;

public class IEXSecurityEventMessageTest {

    @Test
    public void constructor() {
        final IEXSecurityEvent securityEvent = IEXSecurityEvent.OPENING_PROCESS_COMPLETE;
        final long timestamp = 1494855059287436131L;
        final String symbol = "SNAP";

        final byte[] bytes = IEXByteTestUtil.prepareBytes(IEXSecurityEventMessage.LENGTH,
                IEXMessageType.SECURITY_EVENT, securityEvent, timestamp, symbol);
        final IEXSecurityEventMessage message = IEXSecurityEventMessage.createIEXMessage(bytes);

        assertThat(message.getMessageType()).isEqualTo(IEXMessageType.SECURITY_EVENT);
        assertThat(message.getSecurityEvent()).isEqualTo(securityEvent);
        assertThat(message.getTimestamp()).isEqualTo(timestamp);
        assertThat(message.getSymbol()).isEqualTo(symbol);
        assertThat(message.getSymbol()).isEqualTo(symbol);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IEXSecurityEventMessage.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(defaultSecurityEventMessage())
                .verify();
    }

}
