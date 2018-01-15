package pl.zankowski.iextrading4j.hist.test;

import com.google.common.io.ByteStreams;

import java.io.IOException;

public abstract class ExtendedUnitTestBase {

    protected byte[] loadPacket(final String fileName) throws IOException {
        return ByteStreams.toByteArray(ExtendedUnitTestBase.class.getClassLoader().getResourceAsStream(fileName));
    }

}
