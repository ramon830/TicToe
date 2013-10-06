package com.tictoe;


public class Field implements Cloneable {
    private final int sizeField = 6;
    private final int sizeWin = 4;
    private int[][] fieldArray = new int[sizeField ][sizeField ];
    private boolean win = false;
    private int player = 0;

    public int getSizeWin() {
        return sizeWin;
    }


    public int getPlayer() {
        return player;
    }

    public boolean isWin() {
        return win;
    }

    public int[][] getFieldArray() {
        return fieldArray;
    }

    public void setFieldArray(int i, int j, int c) {
        this.fieldArray[i][j] = c;
    }

    public int getSizeField() {
        return sizeField;
    }

    public void verifityWin() {
        int winX1 = 0;
        int winX2 = 0;
        int winX3 = 0;
        int winX4 = 0;
        for (int i = 0; i < sizeField; i++) {
            for (int j = 0; j < sizeField; j++) {
                for (int k = 0; k < sizeWin; k++) {
                    if ((j+k) < sizeField) {
                        winX1 += fieldArray[i][j + k];
                    }
                         if ((i+k) < sizeField) {
                             winX2 += fieldArray[i + k][j];
                         }
                            if ((i+k) < sizeField && (j+k) < sizeField) {
                                winX3 += fieldArray[i + k][j + k];
                            }
                                if ((i+k) < sizeField && (j + sizeWin -1 - k) < sizeField) {
                                    winX4 += fieldArray[i + k][j + sizeWin -1 - k];
                                }
                }
                        if (winX1 == sizeWin || winX2 == sizeWin || winX3 == sizeWin || winX4 == sizeWin) {
                            player = 1;
                            win = true;
                            return;
                        } else {

                            if (winX1 == (-sizeWin) || winX2 == (-sizeWin) || winX3 == (-sizeWin) || winX4 == (-sizeWin)) {
                                player = -1;
                                win = true;
                                return;
                            } else {
                                winX1 = 0;
                                winX2 = 0;
                                winX3 = 0;
                                winX4 = 0;
                            }
                        }



            }

        }
    }

    public void setFieldArray(int[][] fieldArray) {
        this.fieldArray = fieldArray;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public Field clone() throws CloneNotSupportedException {
        Field field = (Field)super.clone();
        int[][] fieldArray = new int[sizeField ][sizeField ];
        for (int i = 0; i < sizeField; i++) {
            for (int j = 0; j < sizeField; j++) {
                Integer element = this.fieldArray[i][j];
                fieldArray[i][j] = element;
            }
        }

        field.setFieldArray(fieldArray);
        boolean win = this.win;
        field.setWin(win);
        int player = this.player;
        field.setPlayer(player);
        return field;
    }
}
