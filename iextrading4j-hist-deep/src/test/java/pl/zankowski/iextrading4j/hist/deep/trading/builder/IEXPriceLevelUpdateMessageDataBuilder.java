package pl.zankowski.iextrading4j.hist.deep.trading.builder;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.builder.TestDataBuilder;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;
import pl.zankowski.iextrading4j.hist.deep.trading.IEXPriceLevelUpdateMessage;
import pl.zankowski.iextrading4j.hist.deep.trading.field.IEXEventFlag;

public class IEXPriceLevelUpdateMessageDataBuilder implements TestDataBuilder {

    private IEXMessageType messageType = IEXMessageType.PRICE_LEVEL_UPDATE_BUY;
    private IEXEventFlag eventFlag = IEXEventFlag.EVENT_PROCESSING_COMPLETE;
    private long timestamp = 1494855059287436131L;
    private String symbol = "SNAP";
    private int size = 12;
    private IEXPrice price = new IEXPrice(1234L);

    public static IEXPriceLevelUpdateMessage defaultPriceLevelMessage() {
        return priceLevelMessage().build();
    }

    public static IEXPriceLevelUpdateMessageDataBuilder priceLevelMessage() {
        return new IEXPriceLevelUpdateMessageDataBuilder();
    }

    public IEXPriceLevelUpdateMessageDataBuilder withMessageType(final IEXMessageType messageType) {
        this.messageType = messageType;
        return this;
    }

    public IEXPriceLevelUpdateMessageDataBuilder withEventFlag(final IEXEventFlag eventFlag) {
        this.eventFlag = eventFlag;
        return this;
    }

    public IEXPriceLevelUpdateMessageDataBuilder withTimestamp(final long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public IEXPriceLevelUpdateMessageDataBuilder withSymbol(final String symbol) {
        this.symbol = symbol;
        return this;
    }

    public IEXPriceLevelUpdateMessageDataBuilder withSize(final int size) {
        this.size = size;
        return this;
    }

    public IEXPriceLevelUpdateMessageDataBuilder withPrice(final IEXPrice price) {
        this.price = price;
        return this;
    }

    @Override
    public byte[] getBytes() {
        return IEXByteTestUtil.prepareBytes(IEXPriceLevelUpdateMessage.LENGTH, messageType, eventFlag, timestamp,
                symbol, size, price);
    }

    public IEXPriceLevelUpdateMessage build() {
        return IEXPriceLevelUpdateMessage.createIEXMessage(messageType, getBytes());
    }
}
