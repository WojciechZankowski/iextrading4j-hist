package pl.zankowski.iextrading4j.hist.api.util;

import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @author Wojciech Zankowski
 */
public class IEXByteConverter {

    public static long convertBytesToLong(byte[] bytes) {
        final ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return byteBuffer.getLong();
    }

    public static int convertBytesToInt(byte[] bytes) {
        final ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return byteBuffer.getInt();
    }

    public static short convertBytesToShort(byte[] bytes) {
        final ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return byteBuffer.getShort();
    }

    public static String convertBytesToString(byte[] bytes) {
        return new String(bytes).trim();
    }

    public static IEXPrice convertBytesToIEXPrice(byte[] bytes) {
        int value = convertBytesToInt(bytes);
        String number = String.format("%08d", value);
        return new IEXPrice(
                Integer.parseInt(number.substring(0, number.length() - 4)),
                Integer.parseInt(number.substring(number.length() - 4, number.length()))
        );
    }

}
