package pl.zankowski.iextrading4j.hist.api.util;

import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class IEXByteConverter {

    public static long convertBytesToLong(final byte[] bytes) {
        final ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return byteBuffer.getLong();
    }

    public static int convertBytesToInt(final byte[] bytes) {
        final ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return byteBuffer.getInt();
    }

    public static short convertBytesToShort(final byte[] bytes) {
        final ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return byteBuffer.getShort();
    }

    public static String convertBytesToString(final byte[] bytes) {
        return new String(bytes).trim();
    }

    public static IEXPrice convertBytesToIEXPrice(final byte[] bytes) {
        return new IEXPrice(convertBytesToLong(bytes));
    }

}
