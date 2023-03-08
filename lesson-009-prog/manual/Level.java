public enum Level {
	HIGH,
	MIDDLE,
	LOW
}

class Main {
	public static void main(String ... args) {
		Level x = Level.HIGH;
		System.out.println(x == Level.LOW);

		x = null;
		x = Level.MIDDLE;
		System.out.println(x);

		x = Level.valueOf("LOW");
		System.out.println(x);
		System.out.println(x.ordinal());

		x = Level.values()[0];
		System.out.println(x);
	}
}