package com.structuralpatterns.decorator;

public class Main {
    public static void main(String[] args) {
        DataSource source = new FileDataSource("test.txt");
        source.writeData("this data should be written to the file\n");
        source = new EncryptedDataSourceDecorator(source);
        source = new ReplaceSpacesDecorator(source);
        source.writeData("this is decorator pattern");
        source.readData();
    }
}
