package pl.zankowski.iextrading4j.hist.samples;

import org.pcap4j.core.NotOpenException;
import org.pcap4j.core.PacketListener;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.Packet;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.message.IEXSegment;
import pl.zankowski.iextrading4j.hist.deep.IEXDEEPMessageBlock;

import java.util.List;

public class DEEPSample {

    public static void main(String[] args) throws PcapNativeException, InterruptedException, NotOpenException {
        final DEEPSample deepSample = new DEEPSample();
        deepSample.readDEEPsample();
    }

    private void readDEEPsample() throws PcapNativeException, InterruptedException, NotOpenException {
        final PcapHandle handle = Pcaps.openOffline("path_to_pcap", PcapHandle.TimestampPrecision.MICRO);

        handle.loop(-1, new PacketListener() {
            @Override
            public void gotPacket(final Packet packet) {
                final byte[] data = packet.getPayload().getPayload().getPayload().getRawData();
                final IEXSegment block = IEXDEEPMessageBlock.createIEXSegment(data);
                System.out.println(block);
            }
        });

        handle.close();
    }

}
