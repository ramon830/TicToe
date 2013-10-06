package com.tictoe;


public class Main {

    public static void main(String[] args) {

        Field field = new Field();
        Input input = new Input(field);
        input.inputCoordinates();
        input.history();

    }


}
