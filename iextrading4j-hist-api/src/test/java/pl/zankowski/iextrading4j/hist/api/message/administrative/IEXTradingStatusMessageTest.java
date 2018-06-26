package pl.zankowski.iextrading4j.hist.api.message.administrative;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXTradingStatus;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.api.message.administrative.builder.IEXTradingStatusMessageDataBuilder.defaultTradingStatusMessage;

public class IEXTradingStatusMessageTest {

    @Test
    public void constructor() {
        final IEXTradingStatus tradingStatus = IEXTradingStatus.TRADING_HALTED;
        final long timestamp = 1494855059287436131L;
        final String symbol = "SNAP";
        final String reason = "O";

        final byte[] bytes = IEXByteTestUtil.prepareBytes(IEXTradingStatusMessage.LENGTH,
                IEXMessageType.TRADING_STATUS, tradingStatus, timestamp, symbol,
                IEXByteTestUtil.convert(reason, 4));
        final IEXTradingStatusMessage message = IEXTradingStatusMessage.createIEXMessage(bytes);

        assertThat(message.getTradingStatus()).isEqualTo(tradingStatus);
        assertThat(message.getTimestamp()).isEqualTo(timestamp);
        assertThat(message.getSymbol()).isEqualTo(symbol);
        assertThat(message.getReason()).isEqualTo(reason);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IEXTradingStatusMessage.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(defaultTradingStatusMessage())
                .verify();
    }

}
