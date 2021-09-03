package com.mississippibrenn;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Rover rover1 = new Rover();

        System.out.println(rover1.roverNewLocation("Landing:1 2 N", "Instructions:LL", "Plateau:5 5"));


//        int[][] array = rover1.matrixGrid("Plateau:5 5");
//
//        int[] landing = rover1.nextMove(2, 4, 2);
//        System.out.println(landing[0]);
//        System.out.println(landing[1]);
//        System.out.println(landing[2]);

    }

}


