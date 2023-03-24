package ru.otus.iostream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomNumbersFileFactory {

  public static File create(String path, int count) throws IOException {

    // todo создать, если нет, и заполнить файл path случайными числами типа int. Кол-во чисел count

    // 1. создать или открыть File
    // 2. Заполнить его случайными числами
    File file = new File(path);
    file.createNewFile();

    OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file, false));
    // заменить на заполнение случайными числами
    // 3.1 Создать Random
    // 3.2 Пройти по циклу от 1 .. count
    // 3.3 Каждое это число записать в файл
    Random random = new Random();

    // вариант rangeof из stream сделать самим
    for (int index = 1; index <= count; index++) {
      writer.write(String.format("%d\n", random.nextInt()));
    }

    writer.close();

    return file;
  }

}
