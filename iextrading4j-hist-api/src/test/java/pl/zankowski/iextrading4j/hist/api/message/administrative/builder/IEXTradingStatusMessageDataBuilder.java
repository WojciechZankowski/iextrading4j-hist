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

    public IEXTradingStatusMessageDataBuilder withTradingStatus(final IEXTradingStatus tradingStatus) {
        this.tradingStatus = tradingStatus;
        return this;
    }

    public IEXTradingStatusMessageDataBuilder withTimestamp(final long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public IEXTradingStatusMessageDataBuilder withSymbol(final String symbol) {
        this.symbol = symbol;
        return this;
    }

    public IEXTradingStatusMessageDataBuilder withReason(final String reason) {
        this.reason = reason;
        return this;
    }

    @Override
    public byte[] getBytes() {
        return IEXByteTestUtil.prepareBytes(IEXTradingStatusMessage.LENGTH, IEXMessageType.TRADING_STATUS,
                tradingStatus, timestamp, symbol, IEXByteTestUtil.convert(reason, 4));
    }

    public IEXTradingStatusMessage build() {
        return IEXTradingStatusMessage.createIEXMessage(getBytes());
    }
}
