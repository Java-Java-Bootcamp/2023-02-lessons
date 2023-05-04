package jmm;

public class EvenNumbersCalculator {

  // shared
  private int count;

  public static void main(String[] args) throws InterruptedException {
    var calculator = new EvenNumbersCalculator();

    var t1 = new Thread(() -> {
      for (int index = 1; index <= 50_000; index++) {
        calculator.checkAndCount(index);
      }
    });

    var t2 = new Thread(() -> {
      for (int index = 50_001; index <= 100_000; index++) {
        calculator.checkAndCount(index);
      }
    });

    t1.start();
    t2.start();

    t1.join();
    t2.join();
    //50000
    System.out.println(calculator.getCount());
    //40443
    //37883
    //44467
  }

  public static void calculateSync() {
    var calculator = new EvenNumbersCalculator();
    for (int index = 1; index <= 100_000; index++) {
      calculator.checkAndCount(index);
    }

    //50_000
    System.out.println(calculator.getCount());
  }

  public static void calculateSingleThread() throws InterruptedException {
    var calculator = new EvenNumbersCalculator();

    var t = new Thread(() -> {
      for (int index = 1; index <= 100_000; index++) {
        calculator.checkAndCount(index);
      }
    });
    t.start();
    //50_000
    System.out.println(calculator.getCount());
    System.out.println(calculator.getCount());
    t.join();
    System.out.println(calculator.getCount());
  }

  public static void calculateMultiThread() throws InterruptedException {

    var calculator = new EvenNumbersCalculator();

    var t1 = new Thread(() -> {
      for (int index = 1; index <= 50_000; index++) {
        calculator.checkAndCount(index);
      }
    });

    var t2 = new Thread(() -> {
      for (int index = 50_001; index <= 100_000; index++) {
        calculator.checkAndCount(index);
      }
    });

    t1.start();
    t2.start();

    t1.join();
    t2.join();
    //50000
    System.out.println(calculator.getCount());
  }

  public void checkAndCount(int number) {
    if (number % 2 == 0) {
      synchronized (this) {
        count += 1;
      }
    }
  }

  public int getCount() {
    return count;
  }
}
