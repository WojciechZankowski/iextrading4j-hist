package pl.zankowski.iextrading4j.hist.api.message.trading.builder;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.builder.TestDataBuilder;
import pl.zankowski.iextrading4j.hist.api.message.trading.IEXTradeMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

public class IEXTradeMessageDataBuilder implements TestDataBuilder {

    private IEXMessageType messageType = IEXMessageType.TRADE_REPORT;
    private byte saleConditionFlag = (byte) -112;
    private long timestamp = 1494855059287436131L;
    private String symbol = "SNAP";
    private int size = 3;
    private IEXPrice price = new IEXPrice(1234L);
    private long tradeID = 12345L;

    public static IEXTradeMessage defaultTradeMessage() {
        return tradeMessage().build();
    }

    public static IEXTradeMessageDataBuilder tradeMessage() {
        return new IEXTradeMessageDataBuilder();
    }

    public IEXTradeMessageDataBuilder withFlag(final byte flag) {
        this.saleConditionFlag = flag;
        return this;
    }

    public IEXTradeMessageDataBuilder withMessageType(final IEXMessageType messageType) {
        this.messageType = messageType;
        return this;
    }

    public IEXTradeMessageDataBuilder withSaleConditionFlag(final byte saleConditionFlag) {
        this.saleConditionFlag = saleConditionFlag;
        return this;
    }

    public IEXTradeMessageDataBuilder withTimestamp(final long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public IEXTradeMessageDataBuilder withSymbol(final String symbol) {
        this.symbol = symbol;
        return this;
    }

    public IEXTradeMessageDataBuilder withSize(final int size) {
        this.size = size;
        return this;
    }

    public IEXTradeMessageDataBuilder withPrice(final IEXPrice price) {
        this.price = price;
        return this;
    }

    public IEXTradeMessageDataBuilder withTradeID(final long tradeID) {
        this.tradeID = tradeID;
        return this;
    }

    @Override
    public byte[] getBytes() {
        return IEXByteTestUtil.prepareBytes(IEXTradeMessage.LENGTH, messageType, saleConditionFlag, timestamp, symbol,
                size, price, tradeID);
    }

    public IEXTradeMessage build() {
        return IEXTradeMessage.createIEXMessage(messageType, getBytes());
    }
}
