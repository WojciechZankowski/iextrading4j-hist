package pl.zankowski.iextrading4j.hist.tops.message;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;
import pl.zankowski.iextrading4j.hist.tops.field.IEXMessageFlag;

import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class IEXQuoteUpdateMessage extends IEXMessage {

	private final IEXMessageType messageType;
	private final IEXMessageFlag messageFlag;
	private final long timestamp;
	private final String symbol;
	private final int bidSize;
	private final IEXPrice bidPrice;
	private final IEXPrice askPrice;
	private final int askSize;

	private IEXQuoteUpdateMessage(IEXMessageType messageType, IEXMessageFlag messageFlag, long timestamp,
								  String symbol, int bidSize, IEXPrice bidPrice, IEXPrice askPrice, int askSize) {
		this.messageType = messageType;
		this.messageFlag = messageFlag;
		this.timestamp = timestamp;
		this.symbol = symbol;
		this.bidSize = bidSize;
		this.bidPrice = bidPrice;
		this.askPrice = askPrice;
		this.askSize = askSize;
	}

	public IEXMessageType getMessageType() {
		return messageType;
	}

	public IEXMessageFlag getMessageFlag() {
		return messageFlag;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public String getSymbol() {
		return symbol;
	}

	public int getBidSize() {
		return bidSize;
	}

	public IEXPrice getBidPrice() {
		return bidPrice;
	}

	public IEXPrice getAskPrice() {
		return askPrice;
	}

	public int getAskSize() {
		return askSize;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof IEXQuoteUpdateMessage)) return false;

		IEXQuoteUpdateMessage that = (IEXQuoteUpdateMessage) o;

		if (timestamp != that.timestamp) return false;
		if (bidSize != that.bidSize) return false;
		if (askSize != that.askSize) return false;
		if (messageType != that.messageType) return false;
		if (messageFlag != that.messageFlag) return false;
		if (symbol != null ? !symbol.equals(that.symbol) : that.symbol != null) return false;
		if (bidPrice != null ? !bidPrice.equals(that.bidPrice) : that.bidPrice != null) return false;
		return askPrice != null ? askPrice.equals(that.askPrice) : that.askPrice == null;
	}

	@Override
	public int hashCode() {
		int result = messageType != null ? messageType.hashCode() : 0;
		result = 31 * result + (messageFlag != null ? messageFlag.hashCode() : 0);
		result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
		result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
		result = 31 * result + bidSize;
		result = 31 * result + (bidPrice != null ? bidPrice.hashCode() : 0);
		result = 31 * result + (askPrice != null ? askPrice.hashCode() : 0);
		result = 31 * result + askSize;
		return result;
	}

	public static IEXQuoteUpdateMessage createIEXMessage(IEXMessageType messageType, byte[] bytes) {
		IEXMessageFlag messageFlag = IEXMessageFlag.getMessageFromFlag(bytes[1]);
		long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
		String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));
		int bidSize = IEXByteConverter.convertBytesToInt(Arrays.copyOfRange(bytes, 18, 22));
		IEXPrice bidPrice = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 22, 30));
		IEXPrice askPrice = IEXByteConverter.convertBytesToIEXPrice(Arrays.copyOfRange(bytes, 30, 38));
		int askSize = IEXByteConverter.convertBytesToInt(Arrays.copyOfRange(bytes, 38, 42));

		return new IEXQuoteUpdateMessage(messageType, messageFlag, timestamp, symbol, bidSize, bidPrice,
				askPrice, askSize);
	}

	@Override
	public String toString() {
		return "IEXQuoteUpdateMessage{" +
				"messageType=" + messageType +
				", messageFlag=" + messageFlag +
				", timestamp=" + timestamp +
				", symbol='" + symbol + '\'' +
				", bidSize=" + bidSize +
				", bidPrice=" + bidPrice +
				", askPrice=" + askPrice +
				", askSize=" + askSize +
				'}';
	}

}
