package ru.otus;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.infra.Blackhole;

public class BenchmarkRunner {
  @Benchmark
  @Fork(value = 1)
  @BenchmarkMode(Mode.AverageTime)
  public void bubbleSort(Blackhole blackhole) {
    int[] data = {9, 7, 6, 15, 17, 5, 10, 11};
    BubbleSort.bubbleSort(data);

    blackhole.consume(data);
  }

  @Benchmark
  @Fork(value = 1)
  @BenchmarkMode(Mode.AverageTime)
  public void selectionSort(Blackhole blackhole) {
    int[] data = {9, 7, 6, 15, 17, 5, 10, 11};
    SelectionSort.selectionSort(data);

    blackhole.consume(data);
  }

  @Benchmark
  @Fork(value = 1)
  @BenchmarkMode(Mode.AverageTime)
  public void insertionSort(Blackhole blackhole) {
    int[] data = {9, 7, 6, 15, 17, 5, 10, 11};
    InsertionSort.sort(data);

    blackhole.consume(data);
  }


  public static void main(String[] args) throws Exception {
    org.openjdk.jmh.Main.main(args);
  }
}
