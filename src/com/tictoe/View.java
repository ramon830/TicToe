package com.tictoe;


public class View {
    private Field field = new Field();

    public View(Field field) {
        this.field = field;
    }

    public void draw() {
        for (int i = 0; i < field.getSizeField(); i++) {
            for (int j = 0; j < field.getSizeField(); j++) {
                System.out.print("[" + field.getFieldArray()[i][j] + "]");
            }
            System.out.println();
        }
    }
}
