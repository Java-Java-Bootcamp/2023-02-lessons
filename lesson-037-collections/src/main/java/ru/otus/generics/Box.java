package ru.otus.generics;

public class Box<T> {
	private T object;

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}
}
