package pl.zankowski.iextrading4j.hist.api.message.trading.field;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IEXSaleConditionFlagTest {

    @Test
    public void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXSaleConditionFlag value = IEXSaleConditionFlag.NON_INTERMARKET_SWEEP_ORDER;

        final IEXSaleConditionFlag result = IEXSaleConditionFlag.getSaleConditionFlag(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionForUnknownCode() {
        IEXSaleConditionFlag.getSaleConditionFlag((byte) 0x11);
    }

}
