package pl.zankowski.iextrading4j.hist.api.message.auction.field;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IEXAuctionTypeTest {

    @Test
    public void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXAuctionType value = IEXAuctionType.OPENING_AUCTION;

        final IEXAuctionType result = IEXAuctionType.getAuctionType(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionForUnknownCode() {
        IEXAuctionType.getAuctionType((byte) 0x11);
    }

}
