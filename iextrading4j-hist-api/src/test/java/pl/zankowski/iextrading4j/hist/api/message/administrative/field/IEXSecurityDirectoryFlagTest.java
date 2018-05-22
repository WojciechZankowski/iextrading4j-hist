package pl.zankowski.iextrading4j.hist.api.message.administrative.field;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IEXSecurityDirectoryFlagTest {

    @Test
    public void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXSecurityDirectoryFlag value = IEXSecurityDirectoryFlag.SYMBOL_IS_TEST;

        final IEXSecurityDirectoryFlag result = IEXSecurityDirectoryFlag.getSecurityDirectoryFlag(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionForUnknownCode() {
        IEXSecurityDirectoryFlag.getSecurityDirectoryFlag((byte) 0x11);
    }

}
