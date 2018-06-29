package pl.zankowski.iextrading4j.hist.tops.message.builder;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;
import pl.zankowski.iextrading4j.hist.tops.trading.IEXQuoteUpdateMessage;

public class IEXQuoteUpdateMessageDataBuilder {

    private IEXMessageType messageType = IEXMessageType.QUOTE_UPDATE;
    private byte messageFlag = -64;
    private long timestamp = 123456789L;
    private String symbol = "AAPL";
    private int bidSize = 100;
    private IEXPrice bidPrice = new IEXPrice(1234565L);
    private IEXPrice askPrice = new IEXPrice(1234567L);
    private int askSize = 200;

    public static IEXQuoteUpdateMessage defaultQuoteMessage() {
        return quoteMessage().build();
    }

    public static IEXQuoteUpdateMessageDataBuilder quoteMessage() {
        return new IEXQuoteUpdateMessageDataBuilder();
    }

    public IEXQuoteUpdateMessageDataBuilder withFlag(final byte flag) {
        this.messageFlag = flag;
        return this;
    }

    public IEXQuoteUpdateMessageDataBuilder withMessageType(final IEXMessageType messageType) {
        this.messageType = messageType;
        return this;
    }

    public IEXQuoteUpdateMessageDataBuilder withMessageFlag(final byte messageFlag) {
        this.messageFlag = messageFlag;
        return this;
    }

    public IEXQuoteUpdateMessageDataBuilder withTimestamp(final long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public IEXQuoteUpdateMessageDataBuilder withSymbol(final String symbol) {
        this.symbol = symbol;
        return this;
    }

    public IEXQuoteUpdateMessageDataBuilder withBidSize(final int bidSize) {
        this.bidSize = bidSize;
        return this;
    }

    public IEXQuoteUpdateMessageDataBuilder withBidPrice(final IEXPrice bidPrice) {
        this.bidPrice = bidPrice;
        return this;
    }

    public IEXQuoteUpdateMessageDataBuilder withAskPrice(final IEXPrice askPrice) {
        this.askPrice = askPrice;
        return this;
    }

    public IEXQuoteUpdateMessageDataBuilder withAskSize(final int askSize) {
        this.askSize = askSize;
        return this;
    }

    public byte[] getBytes() {
        return IEXByteTestUtil.prepareBytes(IEXQuoteUpdateMessage.LENGTH, messageType.getCode(), messageFlag,
                timestamp, symbol, bidSize, bidPrice.getNumber(), askPrice.getNumber(), askSize);
    }

    public IEXQuoteUpdateMessage build() {
        return IEXQuoteUpdateMessage.createIEXMessage(getBytes());
    }

}
