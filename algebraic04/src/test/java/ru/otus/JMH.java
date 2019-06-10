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
public class JMH {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(JMH.class.getSimpleName()).forks(1).build();
        new Runner(opt).run();
    }

    @Setup
    public void setup() {

    }

    @Benchmark
    public void nod() {

        Nod.nod(123456789000L, 12L);
    }

    @Benchmark
    public void enhNod() {
        Nod.enhNod(123456789000L, 12L);
    }

}
