package pl.zankowski.iextrading4j.hist.api.message.trading;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class IEXTradeMessageTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IEXTradeMessage.class)
                .usingGetClass()
                .verify();
    }

}
