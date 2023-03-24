package ru.otus.iostream;

import java.io.File;
import java.io.IOException;

public class App {

  public static void main(String[] args) throws IOException {

    // use cases

    DirectoriesFilesPrinter printer = new DirectoriesFilesPrinter("./path1", "./path2");
    printer.print();
//
    File file = RandomNumbersFileFactory.create("./test.txt", 1000);
//    FilePrinter.print(file);
//
//    File evenFile = EvenNumberFileFactory.create(file, "./even.txt");
//    FilePrinter.print(evenFile);


  }
}
