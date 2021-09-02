package com.mississippibrenn;

import java.util.*;
import java.lang.Math;

// N = 0
// E = 1
// S = 2
// W = 3



public class Rover {

    String[] roverNewLocation(String landing, String instructions, String grid){
        String[] strArray = {landing, instructions};

        int[] startingArray = landingLocation(landing);
        int[][] marsMap = matrixGrid(grid);

        return strArray;

    }


    void roveTheRover(int[][] marsMap, int[] startingArray, String instructions){

        int x = marsMap.length - startingArray[0];
        int y = startingArray[1];
        int facing = startingArray[2];



        for(int i = 0; i < instructions.length(); i++){
            char[] charArray = instructions.toCharArray();

            if(charArray[1] == 'M') {
                int[] currLocation = nextMove(x, y, facing);
                x = currLocation[0];
                y = currLocation[1];
            }else{
                facing = rotateRover(facing, charArray[i]);
            }
        }

        //convert x back
        x = Math.abs(x - marsMap.length);

        //convert instructions to 00 0-5

        // The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0.
        /*
        [[00000x]  mmap [5 5]  actual [0, 5]
         [000000]
         [000000]
         [0M0000]
         [x00000]  mmap [0 0]  actual [length, 0]  only need to amend the first value of the array
         ]
         */

        // when to do matrix conversion? Once at the start and once at the end - otherwise it's annoying and do it every time

        // 1 2 facing 111
        // convert to actual
        // [1 2]  length-1   2  [4 2]
        // LMLMLMLMM
        // convert to mmap
        // [|length - 1 | 2]
        // face 333
        //

    }

    int rotateRover(int facing, Character turning){

        if(turning == 'L'){
            facing = facing == 0 ? 3 : facing-1;
        }else if(turning == 'R'){
            facing = (facing + 1)% 4;
        }else{
            System.out.println("Your data must contains only not L or R");

        }
        return facing;
    }

    int[] nextMove(int x, int y, int direction){
         int[] newArry = new int[]{x, y, direction};
         return newArry;


    }

    int[] landingLocation(String landing){
        int[] myStartingArray = new int[2];

        try{
            String[] splitbyColon =  landing.split(":");
            String[] splitbySpace = splitbyColon[0].split(" ");

            if(splitbySpace.length == 3){
                myStartingArray[0] = Integer.parseInt(splitbySpace[0]);
                myStartingArray[1] = Integer.parseInt(splitbySpace[1]);
                myStartingArray[2] = parseDirection(splitbySpace[2]);

                return myStartingArray;
            }

        }catch(Exception e){

            throw new java.lang.Error("Landing Location data not in correct format. Please follow this format: Landing:1 2 N");

        }
      return myStartingArray;

    }

    int parseDirection(String direction){

        switch(direction){
            case "N":
                return 0;
            case "E":
                return 1;
            case "S":
                return 2;
            case "W":
                return 3;
            default:
                throw new java.lang.Error("this is not in correct format");
        }


    }


    int[][] matrixGrid(String grid){
        int[] myIntArray = new int[2];
        int[][]emptyMatrix = new int[1][1];


        try{
               String[] splitbyColon =  grid.split(":");
               String[] splitbySpace = splitbyColon[1].split(" ");

               if(splitbySpace.length == 2){
                   myIntArray[0] = Integer.parseInt(splitbySpace[0]);
                   myIntArray[1] = Integer.parseInt(splitbySpace[1]);
                   int[][]  myMatrix = new int[myIntArray[0]][myIntArray[1]];
                   return myMatrix;
               }

        }catch(Exception e){

            System.out.println("Plateau data not in correct format. Please follow this format: Plateau:5 5");

        }

        return emptyMatrix;

    }
}
