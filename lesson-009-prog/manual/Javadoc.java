class Javadoc {

	public static void main(String[] args) {
		func(1);
		otherFunc(2);
	}

	/**
	 * Это метод, он что-то делает
	 * @param x это параметр
	 */
	private static void func(int x) {

	}

	/* ЭТО НЕ JAVADOC
	 * Это метод, он что-то делает
	 * @param x это параметр
	 */
	private static void otherFunc(int x) {
		func(1);
	}
}