package pl.zankowski.iextrading4j.hist.api.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @author Wojciech Zankowski
 */
public class IEXByteTestUtil {

    public static byte[] convert(long value) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.putLong(value);
        return buffer.array();
    }

    public static byte[] convert(short value) {
        ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.putShort(value);
        return buffer.array();
    }

    public static byte[] convert(int value) {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.putInt(value);
        return buffer.array();
    }

    public static byte[] convert(String value) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.put(value.getBytes());
        return buffer.array();
    }

    public static byte[] prepareBytes(int capacity, Object... objects) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(capacity);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        for (Object object : objects) {
            if (object instanceof Long) {
                byteBuffer.put(convert((Long) object));
            } else if (object instanceof Short) {
                byteBuffer.put(convert((Short) object));
            } else if (object instanceof Integer) {
                byteBuffer.put(convert((Integer) object));
            } else if (object instanceof String) {
                byteBuffer.put(convert((String) object));
            } else {
                byteBuffer.put((Byte) object);
            }
        }
        return byteBuffer.array();
    }



}
