package org.example;

public class Main {
    public static void main(String[] args) {
        ArrayList list  = new ArrayList();
        list.add("world");
        list.add(0, "Hello");
        System.out.println(list.size());
        System.out.println(list.get(1));
        System.out.println(list.get("Hello"));
        list.remove(0);
        System.out.println(list.size());
        System.out.println(list.get(0));
        list.remove("world");
        System.out.println(list.size());
    }
}
