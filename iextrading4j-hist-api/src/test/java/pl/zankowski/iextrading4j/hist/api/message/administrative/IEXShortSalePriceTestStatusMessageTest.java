package pl.zankowski.iextrading4j.hist.api.message.administrative;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class IEXShortSalePriceTestStatusMessageTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IEXShortSalePriceTestStatusMessage.class)
                .usingGetClass()
                .verify();
    }

}
