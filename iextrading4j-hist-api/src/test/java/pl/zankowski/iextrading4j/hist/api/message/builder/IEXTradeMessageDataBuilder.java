package pl.zankowski.iextrading4j.hist.api.message.builder;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.trading.IEXTradeMessage;
import pl.zankowski.iextrading4j.hist.api.message.trading.field.IEXSaleConditionFlag;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

public class IEXTradeMessageDataBuilder implements TestDataBuilder {

    private IEXMessageType messageType = IEXMessageType.TRADE_REPORT;
    private IEXSaleConditionFlag iexSaleConditionFlag = IEXSaleConditionFlag.ODD_LOT_FLAG;
    private long timestamp = 1494855809990928826L;
    private String symbol = "SNAP    ";
    private int size = 100;
    private IEXPrice price = new IEXPrice(196150L);
    private long tradeID = 42981701L;

    public static IEXTradeMessage defaultTradeMessage() {
        return tradeMessage().build();
    }

    public static byte[] tradeMessageBytes() {
        return tradeMessage().getBytes();
    }

    public static IEXTradeMessageDataBuilder tradeMessage() {
        return new IEXTradeMessageDataBuilder();
    }

    @Override
    public byte[] getBytes() {
        return IEXByteTestUtil.prepareBytes(42, messageType.getCode(), iexSaleConditionFlag.getCode(), timestamp, symbol, size,
                price.getNumber(), tradeID);
    }

    public IEXTradeMessage build() {
        return IEXTradeMessage.createIEXMessage(messageType, getBytes());
    }

}
