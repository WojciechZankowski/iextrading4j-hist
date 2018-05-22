package pl.zankowski.iextrading4j.hist.api.message.administrative.field;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IEXDetailTest {

    @Test
    public void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXDetail value = IEXDetail.NO_PRICE_TEST;

        final IEXDetail result = IEXDetail.getDetail(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionForUnknownCode() {
        IEXDetail.getDetail((byte) 0x11);
    }

}
