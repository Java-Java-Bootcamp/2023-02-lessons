package org.example;

import java.io.Serializable;

public class Seat extends CarElement  implements Serializable {
    private String color;;

    public Seat() {
        super();
    }

    public Seat(String color) {
        super("Seat");
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "color='" + color + '\'' +
                '}';
    }
}
