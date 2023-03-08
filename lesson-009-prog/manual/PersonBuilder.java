class Person {
	int id;
	String name;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
}

public class PersonBuilder {
	private static Person buildPerson(int id, String name) {
		return new Person(id, name);
	}

	public static void main(String[] args) {
		final int x = 456;
		final int y = 789;
		System.out.println(x * y);
	}
}