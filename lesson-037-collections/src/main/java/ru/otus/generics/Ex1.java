package ru.otus.generics;

class BoxOld {
	private Object object;

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
}


class Ex1 {
	public static void main(String[] args) {
		var b0 = new BoxOld();
		b0.setObject(42);
		b0.setObject("xx"); // не ошибка
		System.out.println(((Integer)b0.getObject()).doubleValue());


		var b = new Box<Integer>();
		b.setObject(42);
		// b.setObject("xx");
		System.out.println(b.getObject().doubleValue());
	}
}
