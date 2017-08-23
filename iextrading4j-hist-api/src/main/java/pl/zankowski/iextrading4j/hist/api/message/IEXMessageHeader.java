package pl.zankowski.iextrading4j.hist.api.message;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;

import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class IEXMessageHeader {

	private final byte version;
	private final short messageProtocolID;
	private final int channelID;
	private final int sessionID;
	private final short payloadLength;
	private final short messageCount;
	private final long streamOffset;
	private final long firstMessageSequenceNumber;
	private final long sendTime;

	public IEXMessageHeader(byte version, short messageProtocolID, int channelID, int sessionID, short payloadLength, short messageCount, long streamOffset, long firstMessageSequenceNumber, long sendTime) {
		this.version = version;
		this.messageProtocolID = messageProtocolID;
		this.channelID = channelID;
		this.sessionID = sessionID;
		this.payloadLength = payloadLength;
		this.messageCount = messageCount;
		this.streamOffset = streamOffset;
		this.firstMessageSequenceNumber = firstMessageSequenceNumber;
		this.sendTime = sendTime;
	}

	public byte getVersion() {
		return version;
	}

	public short getMessageProtocolID() {
		return messageProtocolID;
	}

	public int getChannelID() {
		return channelID;
	}

	public int getSessionID() {
		return sessionID;
	}

	public short getPayloadLength() {
		return payloadLength;
	}

	public short getMessageCount() {
		return messageCount;
	}

	public long getStreamOffset() {
		return streamOffset;
	}

	public long getFirstMessageSequenceNumber() {
		return firstMessageSequenceNumber;
	}

	public long getSendTime() {
		return sendTime;
	}

	public static IEXMessageHeader createIEXMessageHeader(byte[] bytes) {
		if (bytes.length != 40) {
			throw new IllegalArgumentException("IEX TOPS Message Header has to has 40 bytes.");
		}

		byte version = bytes[0];
		short msgProtocolID = IEXByteConverter.convertBytesToShort(Arrays.copyOfRange(bytes, 2, 4));
		int channelID = IEXByteConverter.convertBytesToInt(Arrays.copyOfRange(bytes, 4, 8));
		int sessionID = IEXByteConverter.convertBytesToInt(Arrays.copyOfRange(bytes, 8, 12));
		short payloadLength = IEXByteConverter.convertBytesToShort(Arrays.copyOfRange(bytes, 12, 14));
		short messageCount = IEXByteConverter.convertBytesToShort(Arrays.copyOfRange(bytes, 14, 16));
		long streamOffset = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 16, 24));
		long firstMessageSequenceNumber = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 24, 32));
		long sendTime = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 32, 40));

		return new IEXMessageHeader(version, msgProtocolID, channelID, sessionID, payloadLength, messageCount,
				streamOffset, firstMessageSequenceNumber, sendTime);
	}

	@Override
	public String toString() {
		return "IEXMessageHeader{" +
				"version=" + version +
				", messageProtocolID=" + messageProtocolID +
				", channelID=" + channelID +
				", sessionID=" + sessionID +
				", payloadLength=" + payloadLength +
				", messageCount=" + messageCount +
				", streamOffset=" + streamOffset +
				", firstMessageSequenceNumber=" + firstMessageSequenceNumber +
				", sendTime=" + sendTime +
				'}';
	}

}
