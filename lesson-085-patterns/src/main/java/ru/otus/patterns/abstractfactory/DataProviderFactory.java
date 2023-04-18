package ru.otus.patterns.abstractfactory;

import ru.otus.patterns.reader.DataReader;
import ru.otus.patterns.writer.DataWriter;

public interface DataProviderFactory {

    DataReader createReader();

    DataWriter createWriter();

}
