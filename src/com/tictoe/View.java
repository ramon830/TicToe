package com.tictoe;


public class View {

    public void draw(Field field) {

        for (int i = 0; i < field.getSizeField(); i++) {

            for (int j = 0; j < field.getSizeField(); j++) {
                char c = 0;
                if (field.getFieldArray()[i][j] == 1) {
                    c = 'X';
                }
                if (field.getFieldArray()[i][j] == -1) {
                    c = '0';
                }
                if (field.getFieldArray()[i][j] == 0) {
                    c = ' ';
                }
                System.out.print("[" + c + "]");
            }
            System.out.println();
        }

    }
}
