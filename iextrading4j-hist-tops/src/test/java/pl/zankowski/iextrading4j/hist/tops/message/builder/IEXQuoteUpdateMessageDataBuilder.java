package pl.zankowski.iextrading4j.hist.tops.message.builder;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;
import pl.zankowski.iextrading4j.hist.tops.trading.field.IEXMessageFlag;
import pl.zankowski.iextrading4j.hist.tops.trading.IEXQuoteUpdateMessage;

public class IEXQuoteUpdateMessageDataBuilder {

    private IEXMessageType messageType = IEXMessageType.QUOTE_UPDATE;
    private IEXMessageFlag messageFlag = IEXMessageFlag.ACTIVE_IN_SESSION;
    private long timestamp = 123456789L;
    private String symbol = "AAPL";
    private int bidSize = 100;
    private IEXPrice bidPrice = new IEXPrice(1234565L);
    private IEXPrice askPrice = new IEXPrice(1234567L);
    private int askSize = 200;

    public static IEXQuoteUpdateMessage defaultQuoteMessage() {
        return quoteMessage().build();
    }

    public static byte[] quoteMessageBytes() {
        return quoteMessage().getBytes();
    }

    public static IEXQuoteUpdateMessageDataBuilder quoteMessage() {
        return new IEXQuoteUpdateMessageDataBuilder();
    }

    public byte[] getBytes() {
        return IEXByteTestUtil.prepareBytes(42, messageType.getCode(), messageFlag.getFlag(),
                timestamp, symbol, bidSize, bidPrice.getNumber(), askPrice.getNumber(), askSize);
    }

    public IEXQuoteUpdateMessage build() {
        return IEXQuoteUpdateMessage.createIEXMessage(getBytes());
    }

}
