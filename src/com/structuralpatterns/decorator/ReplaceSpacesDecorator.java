package com.structuralpatterns.decorator;

public class ReplaceSpacesDecorator extends DataSourceDecorator{

    public ReplaceSpacesDecorator(DataSource wrapee) {
        super(wrapee);
    }

    public void writeData(String data) {
        data = data.replace(' ', '-');
        wrapee.writeData(data);
    }

}
