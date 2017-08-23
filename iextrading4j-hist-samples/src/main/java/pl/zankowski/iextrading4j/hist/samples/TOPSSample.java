package pl.zankowski.iextrading4j.hist.samples;

import io.pkts.Pcap;
import io.pkts.packet.Packet;
import io.pkts.protocol.Protocol;
import pl.zankowski.iextrading4j.hist.api.message.IEXSegment;
import pl.zankowski.iextrading4j.hist.tops.IEXTOPSMessageBlock;

import java.io.IOException;

/**
 * @author Wojciech Zankowski
 */
public class TOPSSample {

    public static void main(String[] args) throws IOException {
        TOPSSample topsSample = new TOPSSample();
        topsSample.readTOPSsample();
    }

    private void readTOPSsample() throws IOException {
        final Pcap pcap = Pcap.openStream("path_to_pcap_file");

        pcap.loop(this::onPacketRead);
    }

    private boolean onPacketRead(final Packet packet) throws IOException {
        if (packet.hasProtocol(Protocol.UDP)) {
            IEXSegment block = IEXTOPSMessageBlock.createIEXSegment(packet.getPacket(Protocol.UDP).getPayload().getArray());
            System.out.println(block);
        }
        return true;
    }

}
