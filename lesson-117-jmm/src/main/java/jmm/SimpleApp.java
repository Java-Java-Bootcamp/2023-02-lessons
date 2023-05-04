package jmm;

public class SimpleApp {

  private static int value;
  private static User globalUser = new User("Elon");

  public static void main(String[] args) {
    User user = new User();
    user.setName("John");
    int[] numbers = new int[24];
    int localValue = 10;
    someMethod(user, numbers, localValue);
  }

  public static void someMethod(User user, int[] numbers, int value) {
    user.setName("Bill");
    numbers[0] = 24;
    value = 11;
    user = new User("Harry");
    oneMoreMethod(user);
  }

  private static void oneMoreMethod(User passedTwice) {
    double simpleDouble = 12d;
    passedTwice.setName("Maria");
    SimpleApp.value = 110;
  }

  private static class User {

    private String name;

    public User(String name) {
      this.name = name;
    }

    public User() {
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

  }

}
