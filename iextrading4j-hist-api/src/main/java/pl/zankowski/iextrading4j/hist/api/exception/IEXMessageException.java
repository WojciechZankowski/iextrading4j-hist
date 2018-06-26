package pl.zankowski.iextrading4j.hist.api.exception;

import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;

public class IEXMessageException extends RuntimeException {

    public IEXMessageException(final String message) {
        super(message);
    }

    public IEXMessageException(final Class<? extends IEXMessage> clazz, final int length) {
        super("Failed to parse message. " + clazz.getSimpleName() + " requires " + length + " bytes.");
    }
}
