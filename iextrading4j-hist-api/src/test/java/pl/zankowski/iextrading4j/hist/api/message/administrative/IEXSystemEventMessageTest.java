package pl.zankowski.iextrading4j.hist.api.message.administrative;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class IEXSystemEventMessageTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IEXSystemEventMessage.class)
                .usingGetClass()
                .verify();
    }

}
