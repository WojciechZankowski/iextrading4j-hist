package pl.zankowski.iextrading4j.hist.api.message.administrative;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class IEXOperationalHaltStatusMessageTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IEXOperationalHaltStatusMessage.class)
                .usingGetClass()
                .verify();
    }

}
