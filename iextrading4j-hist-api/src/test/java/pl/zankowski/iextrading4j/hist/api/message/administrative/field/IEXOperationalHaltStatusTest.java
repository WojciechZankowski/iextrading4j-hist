package pl.zankowski.iextrading4j.hist.api.message.administrative.field;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IEXOperationalHaltStatusTest {

    @Test
    public void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXOperationalHaltStatus value = IEXOperationalHaltStatus.NOT_OPERATIONAL_HALTED;

        final IEXOperationalHaltStatus result = IEXOperationalHaltStatus.getOperationalHaltStatus(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionForUnknownCode() {
        IEXOperationalHaltStatus.getOperationalHaltStatus((byte) 0x11);
    }

}
