package pl.zankowski.iextrading4j.hist.api.message.administrative.field;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IEXLULDTierTest {

    @Test
    public void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXLULDTier value = IEXLULDTier.NOT_APPLICABLE;

        final IEXLULDTier result = IEXLULDTier.getLULDTier(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionForUnknownCode() {
        IEXLULDTier.getLULDTier((byte) 0x11);
    }

}
