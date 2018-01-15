package pl.zankowski.iextrading4j.hist.api.util;

import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;

public class IEXByteConverter {

    private IEXByteConverter() {
    }

    public static long convertBytesToLong(final byte[] bytes) {
        return (long) (0xff & bytes[7]) << 56 |
                (long) (0xff & bytes[6]) << 48 |
                (long) (0xff & bytes[5]) << 40 |
                (long) (0xff & bytes[4]) << 32 |
                (long) (0xff & bytes[3]) << 24 |
                (long) (0xff & bytes[2]) << 16 |
                (long) (0xff & bytes[1]) << 8 |
                (long) (0xff & bytes[0]) << 0;
    }

    public static int convertBytesToInt(final byte[] bytes) {
        return ((0xff & bytes[3]) << 24 |
                (0xff & bytes[2]) << 16 |
                (0xff & bytes[1]) << 8 |
                (0xff & bytes[0]) << 0
        );
    }

    public static short convertBytesToShort(final byte[] bytes) {
        return (short) ((0xff & bytes[1]) << 8
                | (0xff & bytes[0]) << 0);
    }

    public static String convertBytesToString(final byte[] bytes) {
        return new String(bytes).trim();
    }

    public static IEXPrice convertBytesToIEXPrice(final byte[] bytes) {
        return new IEXPrice(convertBytesToLong(bytes));
    }

}
