package io;

import java.io.*;

public class FileReadExample {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        FileReadExample.class.getClassLoader().getResourceAsStream("test.txt")
                )
        );

        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
    }
}
