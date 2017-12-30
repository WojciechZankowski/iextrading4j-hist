package pl.zankowski.iextrading4j.hist.deep.trading;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.hist.deep.administrative.IEXSecurityEventMessage;

public class IEXPriceLevelUpdateMessageTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IEXPriceLevelUpdateMessage.class)
                .usingGetClass()
                .verify();
    }

}
