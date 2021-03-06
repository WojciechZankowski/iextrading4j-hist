package pl.zankowski.iextrading4j.hist.api.message.trading.builder;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.builder.TestDataBuilder;
import pl.zankowski.iextrading4j.hist.api.message.trading.IEXOfficialPriceMessage;
import pl.zankowski.iextrading4j.hist.api.message.trading.field.IEXPriceType;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

public class IEXOfficialPriceMessageDataBuilder implements TestDataBuilder {

    private IEXPriceType priceType = IEXPriceType.IEX_OFFICIAL_CLOSING_PRICE;
    private long timestamp = 1494855059287436131L;
    private String symbol = "SNAP";
    private IEXPrice officialPrice = new IEXPrice(1234L);

    public static IEXOfficialPriceMessage defaultOfficialPriceMessage() {
        return officialPriceMessage().build();
    }

    public static IEXOfficialPriceMessageDataBuilder officialPriceMessage() {
        return new IEXOfficialPriceMessageDataBuilder();
    }

    public IEXOfficialPriceMessageDataBuilder withPriceType(final IEXPriceType priceType) {
        this.priceType = priceType;
        return this;
    }

    public IEXOfficialPriceMessageDataBuilder withTimestamp(final long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public IEXOfficialPriceMessageDataBuilder withSymbol(final String symbol) {
        this.symbol = symbol;
        return this;
    }

    public IEXOfficialPriceMessageDataBuilder withOfficialPrice(final IEXPrice officialPrice) {
        this.officialPrice = officialPrice;
        return this;
    }

    @Override
    public byte[] getBytes() {
        return IEXByteTestUtil.prepareBytes(IEXOfficialPriceMessage.LENGTH, IEXMessageType.OFFICIAL_PRICE_MESSAGE,
                priceType, timestamp, symbol, officialPrice);
    }

    public IEXOfficialPriceMessage build() {
        return IEXOfficialPriceMessage.createIEXMessage(getBytes());
    }
}
