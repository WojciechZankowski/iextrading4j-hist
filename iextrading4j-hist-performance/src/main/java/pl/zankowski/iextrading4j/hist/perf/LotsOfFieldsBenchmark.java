package pl.zankowski.iextrading4j.hist.perf;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static pl.zankowski.iextrading4j.hist.api.message.auction.IEXAuctionInformationMessage.createIEXMessage;

public class LotsOfFieldsBenchmark extends PerformanceTestBase {

    @State(Scope.Benchmark)
    public static class BenchmarkState {

        public byte[] packet;

        @Setup(Level.Trial)
        public void doSetup() throws IOException {
            packet = loadPacket("LotsOfFieldsMessage.dump");
        }

    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public IEXMessage lotsOfFieldsBenchmark(final LotsOfFieldsBenchmark.BenchmarkState benchmarkState) {
        return createIEXMessage(benchmarkState.packet);
    }
}
