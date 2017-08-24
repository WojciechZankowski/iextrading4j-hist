package pl.zankowski.iextrading4j.hist.samples;

import io.pkts.Pcap;
import io.pkts.packet.Packet;
import io.pkts.protocol.Protocol;
import pl.zankowski.iextrading4j.hist.api.message.IEXSegment;
import pl.zankowski.iextrading4j.hist.deep.IEXDEEPMessageBlock;

import java.io.IOException;

/**
 * @author Wojciech Zankowski
 */
public class DEEPSample {

    public static void main(String[] args) throws IOException {
        DEEPSample deepSample = new DEEPSample();
        deepSample.readDEEPsample();
    }

    private void readDEEPsample() throws IOException {
        final Pcap pcap = Pcap.openStream("path_to_pcap_file");

        pcap.loop(this::onPacketRead);
    }

    private boolean onPacketRead(final Packet packet) throws IOException {
        if (packet.hasProtocol(Protocol.UDP)) {
            IEXSegment block = IEXDEEPMessageBlock.createIEXSegment(packet.getPacket(Protocol.UDP).getPayload().getArray());
            System.out.println(block);
        }
        return true;
    }

}
