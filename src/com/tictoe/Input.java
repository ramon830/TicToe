package com.tictoe;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    private Field field = new Field();
    private Scanner in = new Scanner(System.in);
    private ArrayList<Field> list = new ArrayList<Field>();
    public Input(Field field) {
        this.field = field;
        list.add(new Field());
    }

    private Field coordinates(String s) {
        int number;
        if (s.equals("X")) {
           number = 1;
        } else {
            number = -1;
        }
        while (true) {
            System.out.println("Input coordinates " + s);
                String s1 = in.nextLine();
                String s2 = in.nextLine();
                if (checkString(s1) && checkString(s2)) {

                    int i = Integer.parseInt(s1);
                    int j = Integer.parseInt(s2);
                    if (i >= field.getSizeField() || j >= field.getSizeField() ||
                            field.getFieldArray()[i][j] == number || field.getFieldArray()[i][j] == -number) {
                        System.out.println("Error input coordinates " + s);
                    } else {
                        field.setFieldArray(i, j, number);
                        break;
                    }
                } else {
                    System.out.println("Error input coordinates " + s);
                }

        }
        return field;
    }

    private static boolean checkString(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void inputCoordinates() {
        View view = new View();
        view.draw(field);

        while (true) {


            for (int i = 0; i < 2; i++) {
                String s;
                if (i == 0) {
                    s = "X";
                } else {
                    s = "O";
                }
                field = this.coordinates(s);
                Field clone;
                try{

                    clone = field.clone();
                    list.add(clone);
                } catch (Exception e) {
                    System.out.println(e);
                }

                view.draw(field);
                System.out.println("Turn the tide y\\n");
                String tide = in.nextLine();
                if (tide.equals("y")) {

                    list.remove(list.size() - 1);

                    field = list.get(list.size() - 1);
                    this.history();

                    i--;
                }
                field.verifityWin();

                if (field.isWin()) {
                    break;
                }

            }

            if (field.getPlayer() == 1) {
                System.out.println("Won X");
                in.close();
                break;
            }
            if (field.getPlayer() == -1) {
                System.out.println("Won O");
                in.close();
                break;
            }
        }
    }

    public void history() {
        View view = new View();
        for (Field field: list) {
            System.out.println("--------------");
                view.draw(field);
        }
    }
}
