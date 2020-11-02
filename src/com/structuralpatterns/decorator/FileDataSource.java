package com.structuralpatterns.decorator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDataSource implements DataSource {
    String filename;

    public FileDataSource(String filename) {
        this.filename = filename;
    }

    @Override
    public void readData() {
        try {
            File file = new File(filename);

            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            while ((st = br.readLine()) != null)
                System.out.println(st);
        }
        catch(Exception e) {
            System.out.println("Exception occurred");
        }
    }

    @Override
    public void writeData(String data) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            BufferedWriter bwriter = new BufferedWriter(writer);
            bwriter.write(data);
            bwriter.close();
            writer.close();
            System.out.println("succesfully wrote to the file");
        } catch(IOException e) {
            System.out.println("error occurred");
            e.printStackTrace();
        }
    }
}