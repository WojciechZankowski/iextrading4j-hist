package pl.zankowski.iextrading4j.hist.samples;

import org.pcap4j.core.NotOpenException;
import org.pcap4j.core.PacketListener;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.Packet;
import pl.zankowski.iextrading4j.hist.api.message.IEXSegment;
import pl.zankowski.iextrading4j.hist.tops.IEXTOPSMessageBlock;

/**
 * @author Wojciech Zankowski
 */
public class TOPSSample {

    public static void main(String[] args) throws PcapNativeException, InterruptedException, NotOpenException {
        TOPSSample topsSample = new TOPSSample();
        topsSample.readTOPSsample();
    }

    private void readTOPSsample() throws PcapNativeException, InterruptedException, NotOpenException {
        PcapHandle handle;
        try {
            handle = Pcaps.openOffline("path_to_pcap", PcapHandle.TimestampPrecision.NANO);
        } catch (PcapNativeException e) {
            handle = Pcaps.openOffline("path_to_pcap");
        }

        handle.loop(-1, new PacketListener() {
            @Override
            public void gotPacket(Packet packet) {
                byte[] data = packet.getPayload().getPayload().getPayload().getRawData();
                IEXSegment block = IEXTOPSMessageBlock.createIEXSegment(data);
                System.out.println(block);
            }
        });


        handle.close();
    }

}
