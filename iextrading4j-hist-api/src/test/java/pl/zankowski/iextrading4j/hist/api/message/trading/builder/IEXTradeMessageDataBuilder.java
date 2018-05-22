package pl.zankowski.iextrading4j.hist.api.message.trading.builder;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.builder.TestDataBuilder;
import pl.zankowski.iextrading4j.hist.api.message.trading.IEXTradeMessage;
import pl.zankowski.iextrading4j.hist.api.message.trading.field.IEXSaleConditionFlag;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

public class IEXTradeMessageDataBuilder implements TestDataBuilder {

    private IEXMessageType messageType = IEXMessageType.TRADE_REPORT;
    private IEXSaleConditionFlag saleConditionFlag = IEXSaleConditionFlag.INTERMARKET_SWEEP_FLAG;
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

    @Override
    public byte[] getBytes() {
        return IEXByteTestUtil.prepareBytes(38, messageType, saleConditionFlag, timestamp, symbol,
                size, price, tradeID);
    }

    public IEXTradeMessage build() {
        return IEXTradeMessage.createIEXMessage(messageType, getBytes());
    }
}
