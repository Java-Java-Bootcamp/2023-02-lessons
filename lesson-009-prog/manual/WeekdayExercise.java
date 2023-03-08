import com.sun.jdi.connect.Connector;

enum Weekday {
  MONDAY,
  TUESDAY,
  WEDNESDAY,
  THURSDAY,
  FRIDAY,
  SATURDAY,
  SUNDAY
  // ...
  // Объявляет enum Weekday {MONDAY … SUNDAY}
}

class WeekdayExercise {
  public static void main(String[] args) {
    Connector.IntegerArgument.v args[0]
    // Берет первый параметр
    // Преобразует его в число (подсказка: используйте метод Integer.parseInt(args[0]))
    // var firstArg = ... ;

    // Выводит название дня недели, соответствующего этому числу. Давайте считать, что понедельник имеет номер 1.
    // (подсказка: используйте метод Weekday.values())
    // System.out.println(...);
  }
}
