package ru.otus.iostream;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoriesFilesPrinter {

  private String path1;
  private String path2;

  public DirectoriesFilesPrinter(String path1, String path2) {
    this.path1 = path1;
    this.path2 = path2;
  }

  public void print() {
    List<String> names1 = getFileNames(path1);
    List<String> names2 = getFileNames(path2);

    for (String name : names1) {
      if (names2.contains(name)) {
        System.out.println(name);
      }
    }
  }

  private List<String> getFileNames(String path) {
    List<String> names = new ArrayList<>();
    File directory = new File(path);
    for (File file : directory.listFiles()) {
      names.add(file.getName());
    }

    return names;
  }

}
