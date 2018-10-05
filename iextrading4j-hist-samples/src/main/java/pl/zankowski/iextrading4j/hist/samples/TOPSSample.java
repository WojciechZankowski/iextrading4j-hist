package pl.zankowski.iextrading4j.hist.samples;

import org.pcap4j.core.NotOpenException;
import org.pcap4j.core.PacketListener;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.Packet;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.IEXSegment;
import pl.zankowski.iextrading4j.hist.tops.IEXTOPSMessageBlock;

public class TOPSSample {

    public static void main(String[] args) throws PcapNativeException, InterruptedException, NotOpenException {
        final TOPSSample topsSample = new TOPSSample();
        topsSample.readTOPSsample();
    }

    private void readTOPSsample() throws PcapNativeException, InterruptedException, NotOpenException {
        final PcapHandle handle = Pcaps.openOffline("C:\\Users\\wojci\\Desktop\\LODY\\20181002_IEXTP1_TOPS1.6.pcap", PcapHandle.TimestampPrecision.NANO);

        handle.loop(-1, new PacketListener() {
            @Override
            public void gotPacket(final Packet packet) {
                final byte[] data = packet.getPayload().getPayload().getPayload().getRawData();
                final IEXSegment block = IEXTOPSMessageBlock.createIEXSegment(data);
                System.out.println(block);
            }
        });

        handle.close();
    }

}
