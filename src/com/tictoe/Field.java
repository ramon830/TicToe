package com.tictoe;


public class Field {
    private final int sizeField = 20;
    private char[][] fieldArray = new char[sizeField ][sizeField ];

    public char[][] getFieldArray() {
        return fieldArray;
    }

    public void setFieldArray(char[][] fieldArray) {
        this.fieldArray = fieldArray;
    }

    public int getSizeField() {
        return sizeField;
    }
}
