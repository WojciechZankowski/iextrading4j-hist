package pl.zankowski.iextrading4j.hist.api.message.administrative;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class IEXTradingStatusMessageTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IEXTradingStatusMessage.class)
                .usingGetClass()
                .verify();
    }

}
