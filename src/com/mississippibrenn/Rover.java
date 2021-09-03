package com.mississippibrenn;

import java.sql.SQLOutput;
import java.util.*;
import java.lang.Math;

// N = 0
// E = 1
// S = 2
// W = 3
//Plateau:5 5
//        Rover1 Landing:1 2 N
//        Rover1 Instructions:LMLMLMLMM
//        Rover2 Landing:3 3 E
//        Rover2 Instructions:MMRMMRMRRM


public class Rover {

    //top level class function
    String roverNewLocation(String landing, String instructions, String grid){
        String[] strArray = {landing, instructions};

        int[] startingArray = landingLocation(landing);
        int[][] marsMap = matrixGrid(grid);

        String location = roveTheRover(marsMap, startingArray, instructions);

        return location;

    }


    String roveTheRover(int[][] marsMap, int[] startingArray, String instructions){
        int firstx = marsMap.length;
        int firsty = marsMap[0].length;

        //convert x to conform to instructions
        int x = marsMap.length - startingArray[0];
        int y = startingArray[1];
        int facing = startingArray[2];
        instructions = parseInstructions(instructions);
        char[] charArray = instructions.toCharArray();


        for(int i = 0; i < instructions.length(); i++){

            System.out.println(charArray[i]);
            //rove the rover
            if(charArray[1] == 'M') {

                int[] currLocation = nextMove(x, y, facing);
                x = currLocation[0];
                y = currLocation[1];
            }else{
            //rotate the rover facing

                facing = rotateRover(facing, charArray[i]);
            }

        }

        //verify input is within the map, rovers can share coordinates
        if( x < marsMap.length && y < marsMap[0].length){
            System.out.println("here");
            if( x >= 0 && y >= 0 ){
                //convert x back
                System.out.println(x);
                x = Math.abs(x - marsMap.length);
                return("Rover1: " + x + " "+ y + " " + facingToString(facing) );
            }
        }


        return ("Your rover was outside of the bounds of measured Mars.  "+ "Measured Mars is only " + firstx + " by " + firsty +"."
                + "\n" + "Your rover went to "+ "X coordinate: " + x + ", Y coordinate: " + y);

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

    int[] nextMove(int x, int y, int facing){
         int[] newArray = new int[]{x, y, facing};

        switch(facing){
            case 0 :
                y--;
                break;
            case 1:
                x++;
                break;
            case 2:
                y++;
                break;
            case 3:
                x--;
                break;
            default:
                break;
        }
        newArray[0] = x;
        newArray[1] = y;
        return newArray;


    }

    String parseInstructions(String instructions){
        String[] splitbyColon =  instructions.split(":");
        return splitbyColon[1];


    }

    int[] landingLocation(String landing){
        int[] myStartingArray = new int[3];


        try{

            String[] splitbyColon =  landing.split(":");
            String[] splitbySpace = splitbyColon[1].split(" ");

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

    String  facingToString(int facing){

        switch(facing){
            case 0:
                return "N";
            case 1:
                return "E";
            case 2:
                return "S";
            case 3:
                return "W";
            default:
                break;
        }
        return "";
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
