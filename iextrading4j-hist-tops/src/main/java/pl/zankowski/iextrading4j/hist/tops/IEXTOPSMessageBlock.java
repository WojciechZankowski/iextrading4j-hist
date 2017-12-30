package pl.zankowski.iextrading4j.hist.tops;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessageHeader;
import pl.zankowski.iextrading4j.hist.api.message.IEXSegment;
import pl.zankowski.iextrading4j.hist.api.message.administrative.IEXOperationalHaltStatusMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.IEXSecurityDirectoryMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.IEXShortSalePriceTestStatusMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.IEXSystemEventMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.IEXTradingStatusMessage;
import pl.zankowski.iextrading4j.hist.api.message.auction.IEXAuctionInformationMessage;
import pl.zankowski.iextrading4j.hist.api.message.trading.IEXTradeMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;
import pl.zankowski.iextrading4j.hist.api.message.trading.IEXOfficialPriceMessage;
import pl.zankowski.iextrading4j.hist.tops.trading.IEXQuoteUpdateMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IEXTOPSMessageBlock extends IEXSegment {

    private IEXTOPSMessageBlock(final IEXMessageHeader messageHeader, final List<IEXMessage> messages) {
        super(messageHeader, messages);
    }

    public static IEXSegment createIEXSegment(final byte[] packet) {
        final List<IEXMessage> iexMessages = new ArrayList<>();
        int offset = 40;

        final IEXMessageHeader iexMessageHeader = IEXMessageHeader.createIEXMessageHeader(Arrays.copyOfRange(packet, 0, offset));

        for (int i = 0; i < iexMessageHeader.getMessageCount(); i++) {
            short length = IEXByteConverter.convertBytesToShort(Arrays.copyOfRange(packet, offset, offset = offset + 2));
            iexMessages.add(resolveMessage(Arrays.copyOfRange(packet, offset, offset = offset + length)));
        }

        return new IEXTOPSMessageBlock(iexMessageHeader, iexMessages);
    }


    private static IEXMessage resolveMessage(final byte[] bytes) {
        final IEXMessageType messageType = IEXMessageType.getMessageType(bytes[0]);

        switch (messageType) {
            case QUOTE_UPDATE:
                return IEXQuoteUpdateMessage.createIEXMessage(messageType, bytes);
            case TRADE_REPORT:
                return IEXTradeMessage.createIEXMessage(messageType, bytes);
            case TRADE_BREAK:
                return IEXTradeMessage.createIEXMessage(messageType, bytes);
            case OFFICIAL_PRICE_MESSAGE:
                return IEXOfficialPriceMessage.createIEXMessage(messageType, bytes);
            case SYSTEM_EVENT:
                return IEXSystemEventMessage.createIEXMessage(messageType, bytes);
            case SECURITY_DIRECTORY:
                return IEXSecurityDirectoryMessage.createIEXMessage(messageType, bytes);
            case TRADING_STATUS:
                return IEXTradingStatusMessage.createIEXMessage(messageType, bytes);
            case OPERATIONAL_HALT_STATUS:
                return IEXOperationalHaltStatusMessage.createIEXMessage(messageType, bytes);
            case SHORT_SALE_PRICE_TEST_STATUS:
                return IEXShortSalePriceTestStatusMessage.createIEXMessage(messageType, bytes);
            case AUCTION_INFORMATION:
                return IEXAuctionInformationMessage.createIEXMessage(messageType, bytes);
            default:
                throw new IllegalArgumentException("Failed to create IEX Message. Message type not supported: " + messageType);
        }
    }

}
