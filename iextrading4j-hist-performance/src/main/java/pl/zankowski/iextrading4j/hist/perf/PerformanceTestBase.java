package pl.zankowski.iextrading4j.hist.perf;

import com.google.common.io.ByteStreams;

import java.io.IOException;

public class PerformanceTestBase {

    protected static byte[] loadPacket(final String fileName) throws IOException {
        return ByteStreams.toByteArray(PerformanceTestBase.class.getClassLoader().getResourceAsStream(fileName));
    }


}
