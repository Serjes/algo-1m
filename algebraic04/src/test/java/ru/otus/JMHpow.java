package ru.otus;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@State(value = Scope.Thread)
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JMHpow {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(JMHpow.class.getSimpleName()).forks(1).build();
        new Runner(opt).run();
    }

    @Setup
    public void setup() {
    }

    @Benchmark
    public void simplePow() {
        Pow.simplePow(13, 11);
    }

    @Benchmark
    public void binaryPow() {
        Pow.binaryPow(13, 11);
    }

    @Benchmark
    public void decompositionPow() {
        Pow.binaryDecompositionPow(13, 11);
    }
}
