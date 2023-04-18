package ru.otus.patterns.abstractfactory;

import ru.otus.patterns.reader.DataReader;
import ru.otus.patterns.reader.FileDataReader;
import ru.otus.patterns.writer.DataWriter;
import ru.otus.patterns.writer.FileDataWriter;

public class FileDataProviderFactory implements DataProviderFactory {

    @Override
    public DataReader createReader() {
        return new FileDataReader();
    }

    @Override
    public DataWriter createWriter() {
        return new FileDataWriter();
    }
}
