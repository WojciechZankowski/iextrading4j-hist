package pl.zankowski.iextrading4j.hist.deep.administrative;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class IEXSecurityEventMessageTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IEXSecurityEventMessage.class)
                .usingGetClass()
                .verify();
    }

}
