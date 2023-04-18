package ru.otus.patterns.abstractfactory;

import ru.otus.patterns.reader.ConsoleDataReader;
import ru.otus.patterns.reader.DataReader;
import ru.otus.patterns.writer.ConsoleDataWriter;
import ru.otus.patterns.writer.DataWriter;

public class ConsoleDataProviderFactory implements DataProviderFactory {

    @Override
    public DataReader createReader() {
        return new ConsoleDataReader();
    }

    @Override
    public DataWriter createWriter() {
        return new ConsoleDataWriter();
    }
}
