package pl.zankowski.iextrading4j.hist.api.message.administrative;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Ignore;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXLULDTier;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.api.message.administrative.builder.IEXSecurityDirectoryMessageDataBuilder.defaultDirectoryMessage;
import static pl.zankowski.iextrading4j.hist.api.message.administrative.builder.IEXSecurityDirectoryMessageDataBuilder.directoryMessage;

public class IEXSecurityDirectoryMessageTest {

    @Test
    public void constructor() {
        final byte securityDirectoryFlag = (byte) -64;
        final long timestamp = 1494855059287436131L;
        final String symbol = "SNAP";
        final int roundLotSize = 10;
        final IEXPrice adjustedPOCPrice = new IEXPrice(1234L);
        final IEXLULDTier luldTier = IEXLULDTier.TIER_1_NMS;

        final byte[] bytes = IEXByteTestUtil.prepareBytes(IEXSecurityDirectoryMessage.LENGTH,
                IEXMessageType.SECURITY_DIRECTORY, securityDirectoryFlag, timestamp, symbol, roundLotSize,
                adjustedPOCPrice, luldTier);
        final IEXSecurityDirectoryMessage message = IEXSecurityDirectoryMessage.createIEXMessage(bytes);

        assertThat(message.getMessageType()).isEqualTo(IEXMessageType.SECURITY_DIRECTORY);
        assertThat(message.getTimestamp()).isEqualTo(timestamp);
        assertThat(message.getSymbol()).isEqualTo(symbol);
        assertThat(message.getRoundLotSize()).isEqualTo(roundLotSize);
        assertThat(message.getAdjustedPOCPrice()).isEqualTo(adjustedPOCPrice);
        assertThat(message.getLuldTier()).isEqualTo(luldTier);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IEXSecurityDirectoryMessage.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(defaultDirectoryMessage())
                .verify();
    }



}
