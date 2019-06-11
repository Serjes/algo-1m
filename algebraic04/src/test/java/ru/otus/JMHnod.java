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
public class JMHnod {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(JMHnod.class.getSimpleName()).forks(1).build();
        new Runner(opt).run();
    }

    @Setup
    public void setup() {

    }

    @Benchmark
    public void gcd() {

        Nod.gcd(123456789000L, 12L);
    }

    @Benchmark
    public void enhancedGcd() {
        Nod.enhancedGcd(123456789000L, 12L);
    }

}
