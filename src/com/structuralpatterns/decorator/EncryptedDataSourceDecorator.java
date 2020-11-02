package com.structuralpatterns.decorator;

public class EncryptedDataSourceDecorator extends DataSourceDecorator{
    public EncryptedDataSourceDecorator(DataSource wrapee) {
        super(wrapee);
    }

    public void writeData(String data) {
        // do encryption
        String encryptedString = encrypt(data);
        wrapee.writeData(encryptedString);
    }

    public String encrypt(String s) {
        char[] chars = s.toCharArray();
        for (int i=0; i<chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                char firstChar = Character.isUpperCase(chars[i]) ? 'A': 'a';
                int pos = chars[i] - firstChar;
                pos += 2;
                pos %= 26;
                chars[i] = (char)(firstChar + pos);
            }
        }
        return String.valueOf(chars);
    }
}
