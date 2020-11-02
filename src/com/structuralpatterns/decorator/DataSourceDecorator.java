package com.structuralpatterns.decorator;

public abstract class DataSourceDecorator implements DataSource{
    DataSource wrapee;

    public DataSourceDecorator(DataSource wrapee) {
        this.wrapee = wrapee;
    }

    @Override
    public void readData() {
        wrapee.readData();
    }

    @Override
    public void writeData(String data) {
        wrapee.writeData(data);
    }
}
