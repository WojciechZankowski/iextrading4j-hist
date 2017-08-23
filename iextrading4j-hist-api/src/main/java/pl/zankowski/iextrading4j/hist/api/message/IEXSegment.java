package pl.zankowski.iextrading4j.hist.api.message;

import java.util.List;

/**
 * @author Wojciech Zankowski
 */
public abstract class IEXSegment {

	private final IEXMessageHeader messageHeader;
	private final List<IEXMessage> messages;

	protected IEXSegment(IEXMessageHeader messageHeader, List<IEXMessage> messages) {
		this.messageHeader = messageHeader;
		this.messages = messages;
	}

	public IEXMessageHeader getMessageHeader() {
		return messageHeader;
	}

	public List<IEXMessage> getMessages() {
		return messages;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (IEXMessage iexMessage : messages) {
			builder.append(iexMessage);
			builder.append("\n");
		}
		return "IEXMessageBlock{\n" +
				messageHeader + "\n" +
				builder.toString() +
				'}';
	}

}
