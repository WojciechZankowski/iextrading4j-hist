package pl.zankowski.iextrading4j.hist.api.util;

import org.junit.Test;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;

import static org.assertj.core.api.Assertions.assertThat;

public class IEXByteConverterTest {

    @Test
    public void shouldSuccessfullyConvertBytesToShort() {
        final short value = 24;
        byte[] bytes = IEXByteTestUtil.convert(value);

        assertThat(IEXByteConverter.convertBytesToShort(bytes)).isEqualTo(value);
    }

    @Test
    public void shouldSuccessfullyConvertBytesToUnsignedShort() {
        final int value = 32817;
        byte[] bytes = IEXByteTestUtil.convertUnsignedShort(value);

        assertThat(IEXByteConverter.convertBytesToUnsignedShort(bytes)).isEqualTo(value);
    }

    @Test
    public void shouldSuccessfullyConvertBytesToInt() {
        final int value = 123456;
        byte[] bytes = IEXByteTestUtil.convert(value);

        assertThat(IEXByteConverter.convertBytesToInt(bytes)).isEqualTo(value);
    }

    @Test
    public void shouldSuccessfullyConvertBytesToLong() {
        final long value = 1234567891L;
        byte[] bytes = IEXByteTestUtil.convert(value);

        assertThat(IEXByteConverter.convertBytesToLong(bytes)).isEqualTo(value);
    }

    @Test
    public void shouldSuccessfullyConvertBytesToIEXPrice() {
        final IEXPrice iexPrice = new IEXPrice(123456789L);
        byte[] bytes = IEXByteTestUtil.convert(iexPrice.getNumber());

        assertThat(IEXByteConverter.convertBytesToIEXPrice(bytes)).isEqualTo(iexPrice);
    }

    @Test
    public void shouldSuccessfullyConvertBytesToString() {
        final String symbol = "AAPL";
        byte[] bytes = IEXByteTestUtil.convert(symbol);

        assertThat(IEXByteConverter.convertBytesToString(bytes)).isEqualTo(symbol);
    }

}
