package pl.zankowski.iextrading4j.hist.deep;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessageHeader;
import pl.zankowski.iextrading4j.hist.api.message.IEXSegment;
import pl.zankowski.iextrading4j.hist.api.message.IEXTradeMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;
import pl.zankowski.iextrading4j.hist.deep.administrative.message.IEXOperationalHaltStatusMessage;
import pl.zankowski.iextrading4j.hist.deep.administrative.message.IEXSecurityDirectoryMessage;
import pl.zankowski.iextrading4j.hist.deep.administrative.message.IEXSecurityEventMessage;
import pl.zankowski.iextrading4j.hist.deep.administrative.message.IEXShortSalePriceTestStatusMessage;
import pl.zankowski.iextrading4j.hist.deep.administrative.message.IEXSystemEventMessage;
import pl.zankowski.iextrading4j.hist.deep.administrative.message.IEXTradingStatusMessage;
import pl.zankowski.iextrading4j.hist.deep.auction.message.IEXAuctionInformationMessage;
import pl.zankowski.iextrading4j.hist.deep.trading.message.IEXPriceLevelUpdateMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wojciech Zankowski
 */
public class IEXDEEPMessageBlock extends IEXSegment {

    public IEXDEEPMessageBlock(IEXMessageHeader messageHeader, List<IEXMessage> messages) {
        super(messageHeader, messages);
    }

    public static IEXSegment createIEXSegment(byte[] packet) {
        List<IEXMessage> iexMessages = new ArrayList<>();
        int offset = 40;

        IEXMessageHeader iexMessageHeader = IEXMessageHeader.createIEXMessageHeader(Arrays.copyOfRange(packet, 0, offset));

        for (int i = 0; i < iexMessageHeader.getMessageCount(); i++) {
            short length = IEXByteConverter.convertBytesToShort(Arrays.copyOfRange(packet, offset, offset = offset + 2));
            iexMessages.add(resolveMessage(Arrays.copyOfRange(packet, offset, offset = offset + length)));
        }

        return new IEXDEEPMessageBlock(iexMessageHeader, iexMessages);
    }


    private static IEXMessage resolveMessage(byte[] bytes) {
        IEXMessageType messageType = IEXMessageType.getMessageType((char) bytes[0]);

        switch (messageType) {
            case TRADE_REPORT:
                return IEXTradeMessage.createIEXMessage(messageType, bytes);
            case TRADE_BREAK:
                return IEXTradeMessage.createIEXMessage(messageType, bytes);
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
            case SECURITY_EVENT:
                return IEXSecurityEventMessage.createIEXMessage(messageType, bytes);
            case PRICE_LEVEL_UPDATE_BUY:
                return IEXPriceLevelUpdateMessage.createIEXMessage(messageType, bytes);
            case PRICE_LEVEL_UPDATE_SELL:
                return IEXPriceLevelUpdateMessage.createIEXMessage(messageType, bytes);
            case AUCTION_INFORMATION:
                return IEXAuctionInformationMessage.createIEXMessage(messageType, bytes);
            default:
                return new IEXMessage();
        }
    }

}
