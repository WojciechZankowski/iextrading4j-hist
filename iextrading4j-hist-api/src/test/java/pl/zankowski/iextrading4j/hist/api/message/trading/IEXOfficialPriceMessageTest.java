package pl.zankowski.iextrading4j.hist.api.message.trading;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class IEXOfficialPriceMessageTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IEXOfficialPriceMessage.class)
                .usingGetClass()
                .verify();
    }

}
