package pl.zankowski.iextrading4j.hist.api.util;

import pl.zankowski.iextrading4j.hist.api.IEXByteEnum;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class IEXByteTestUtil {

    public static byte[] convert(final long value) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.putLong(value);
        return buffer.array();
    }

    public static byte[] convert(final short value) {
        ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.putShort(value);
        return buffer.array();
    }

    public static byte[] convert(final int value) {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.putInt(value);
        return buffer.array();
    }

    public static byte[] convert(final String value) {
        return convert(value, 8);
    }

    public static byte[] convert(final String value, final int capacity) {
        ByteBuffer buffer = ByteBuffer.allocate(capacity);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.put(value.getBytes());
        return buffer.array();
    }

    public static byte[] prepareBytes(final int capacity, final Object... objects) {
        final ByteBuffer byteBuffer = ByteBuffer.allocate(capacity);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        for (final Object object : objects) {
            if (object instanceof Long) {
                byteBuffer.put(convert((Long) object));
            } else if (object instanceof Short) {
                byteBuffer.put(convert((Short) object));
            } else if (object instanceof Integer) {
                byteBuffer.put(convert((Integer) object));
            } else if (object instanceof String) {
                byteBuffer.put(convert((String) object));
            } else if (object instanceof IEXByteEnum) {
                byteBuffer.put(((IEXByteEnum) object).getCode());
            } else if (object instanceof IEXPrice) {
                byteBuffer.put(convert(((IEXPrice) object).getNumber()));
            } else if (object instanceof byte[]) {
                byteBuffer.put((byte[]) object);
            } else {
                byteBuffer.put((Byte) object);
            }
        }
        return byteBuffer.array();
    }


}
