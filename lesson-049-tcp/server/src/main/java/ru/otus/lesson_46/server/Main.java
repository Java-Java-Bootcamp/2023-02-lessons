package ru.otus.lesson_46.server;

public class Main {
    public static void main(String[] args) {
//        try (PingServer server = new PingServer(8081)) {
        try (MultiThreadServer server = new MultiThreadServer(8081)) {
            server.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
