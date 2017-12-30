package pl.zankowski.iextrading4j.hist.api.message;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.api.message.builder.IEXMessageHeaderDataBuilder.defaultMessageHeader;
import static pl.zankowski.iextrading4j.hist.api.message.builder.IEXTradeMessageDataBuilder.defaultTradeMessage;

public class IEXSegmentTest {

    @Test
    public void shouldSuccessfullyCreateSegmentInstance() {
        IEXMessageHeader iexMessageHeader = defaultMessageHeader();
        List<IEXMessage> iexMessageList = asList(defaultTradeMessage(), defaultTradeMessage());

        IEXSegment iexSegment = new TestIEXSegment(iexMessageHeader, iexMessageList);

        assertThat(iexSegment.getMessageHeader()).isEqualTo(iexMessageHeader);
        assertThat(iexSegment.getMessages()).isEqualTo(iexMessageList);
    }

    @Test
    public void shouldTwoInstancesWithSameValuesBeEqual() {
        IEXMessageHeader iexMessageHeader = defaultMessageHeader();
        List<IEXMessage> iexMessageList = asList(defaultTradeMessage(), defaultTradeMessage());

        IEXSegment iexSegment_1 = new TestIEXSegment(iexMessageHeader, iexMessageList);
        IEXSegment iexSegment_2 = new TestIEXSegment(iexMessageHeader, iexMessageList);

        assertThat(iexSegment_1).isEqualTo(iexSegment_2);
        assertThat(iexSegment_1.hashCode()).isEqualTo(iexSegment_2.hashCode());
    }

    private class TestIEXSegment extends IEXSegment {

        public TestIEXSegment(IEXMessageHeader messageHeader, List<IEXMessage> messages) {
            super(messageHeader, messages);
        }

    }

}
