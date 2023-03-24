package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("green", "audi");
        Seat seat = new Seat("green");
        car.setSeat(seat);

        File file = new File("car");

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(car);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            Car restoredCar  = (Car) objectInputStream.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String carJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(car);
            System.out.println(carJson);
            Car car1FromJson = objectMapper.readValue(carJson, Car.class);
            System.out.println(car1FromJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
