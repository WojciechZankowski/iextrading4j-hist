package pl.zankowski.iextrading4j.hist.api.message.administrative.builder;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.administrative.IEXTradingStatusMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXTradingStatus;
import pl.zankowski.iextrading4j.hist.api.message.builder.TestDataBuilder;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

public class IEXTradingStatusMessageDataBuilder implements TestDataBuilder {

    private IEXTradingStatus tradingStatus = IEXTradingStatus.TRADING_HALTED;
    private long timestamp = 1494855059287436131L;
    private String symbol = "SNAP";
    private String reason = "O";

    public static IEXTradingStatusMessage defaultTradingStatusMessage() {
        return tradingStatusMessage().build();
    }

    public static IEXTradingStatusMessageDataBuilder tradingStatusMessage() {
        return new IEXTradingStatusMessageDataBuilder();
    }

    @Override
    public byte[] getBytes() {
        return IEXByteTestUtil.prepareBytes(22, IEXMessageType.TRADING_STATUS, tradingStatus,
                timestamp, symbol, IEXByteTestUtil.convert(reason, 4));
    }

    public IEXTradingStatusMessage build() {
        return IEXTradingStatusMessage.createIEXMessage(getBytes());
    }
}
